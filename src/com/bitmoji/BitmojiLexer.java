package com.bitmoji;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

public class BitmojiLexer implements BitmojiTokens
{
    //constructor
    public BitmojiLexer(final InputStream in) {
        line = "";
        lineNo = 0;
        colNo = 0;
        currentChar = ' ';
        scan = new Scanner(in);
    }

    // input status
    private String line;
    private int lineNo;
    private int colNo;
    private char currentChar;
    private final Scanner scan;

    // get the next character
    private void nextChar() {
        colNo++;
        while (colNo > line.length()) {
            if (!scan.hasNext()) {
                colNo--;
                currentChar = (char) 0;
                return;
            }

            line = scan.nextLine() + "\n";
            colNo = 1;
            lineNo++;
        }

        currentChar = line.charAt(colNo - 1);
    }

    // report current line number
    public int getLineNumber() {
        return lineNo;
    }

    // report current column number
    public int getColumnNumber() {
        return colNo;
    }

    // return the current line
    public String getLine() {
        return line;
    }

    // print an error message
    public void printError(final String msg) {
        final String lineMsg = "Line " + getLineNumber() + " Column " + getColumnNumber();
        System.err.println(msg);
        System.out.printf("%s: %s", lineMsg, getLine());
        System.out.printf(" %" + lineMsg.length() + "s %" + getColumnNumber() + "s\n", "", "^");
        System.out.println();
    }

    // Lexer Status
    int token;
    Object value;

    public int getToken() {
        return token;
    }

    public Object getValue() {
        return value;
    }

    private boolean bitmojiKeyword() {
        final Map<String, Integer> bitmojiSymbols = new HashMap<>();
        Set<Character> uniqueChars = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        String quotes = "\uD83D\uDD77"; // String Quotes
        bitmojiSymbols.put("\uD83C\uDF83", START_PROGRAM); // Start of Program
        bitmojiSymbols.put("☣", END_PROGRAM); // End of Program
        bitmojiSymbols.put("\uD83C\uDF54", EQUALS); // ==
        bitmojiSymbols.put("\uD83D\uDD25", NOT_EQUALS); // !=
        bitmojiSymbols.put("\uD83C\uDF7A", LESS_THAN); // <
        bitmojiSymbols.put("\uD83C\uDF7B", LESS_THAN_OR_EQUAL); // <=
        bitmojiSymbols.put("\uD83E\uDD42", GREATER_THAN_OR_EQUAL); // >=
        bitmojiSymbols.put("\uD83E\uDD43", GREATER_THAN); // >
        bitmojiSymbols.put("♻", START_WHILE);// Start of while
        bitmojiSymbols.put("\uD83D\uDED1", END_WHILE); // End of while
        bitmojiSymbols.put("\uD83C\uDF84", ADD); // Add
        bitmojiSymbols.put("\uD83D\uDC00", SUBTRACT); // Subtract
        bitmojiSymbols.put("\uD83E\uDD3A", MULTIPLY); // Multiply
        bitmojiSymbols.put("\uD83D\uDC69\u200D\uD83D\uDC66", DIVIDE); // Divide
        bitmojiSymbols.put("\uD83D\uDEB8", ASSIGN); // Assign
        bitmojiSymbols.put("\uD83E\uDD1C", LEFT_BRACKET); // Left Bracket
        bitmojiSymbols.put("\uD83E\uDD1B", RIGHT_BRACKET);// Right Bracket
        bitmojiSymbols.put("⛪", EXPONENT); // Exponent
        bitmojiSymbols.put("\uD83D\uDC40", IF); // if
        bitmojiSymbols.put("\uD83E\uDD13", ELIF); // elif
        bitmojiSymbols.put("\uD83D\uDE21", ELSE); // else
        bitmojiSymbols.put("\uD83C\uDF88", FUNCTION_DEF); // Start of function definition
        bitmojiSymbols.put("➡", OUTPUT); // Output
        bitmojiSymbols.put("⬅", INPUT); // Input
        bitmojiSymbols.put("\uD83C\uDF1C", LEFT_PARENTHESIS); // Left parenthesis
        bitmojiSymbols.put("\uD83C\uDF1B", RIGHT_PARENTHESIS); // Right parenthesis
        bitmojiSymbols.put("\uD83D\uDC0E", START_FUNCTION_STATEMENTS); // Start function statements
        bitmojiSymbols.put("\uD83D\uDE02", END_FUNCTION_STATEMENTS); // End function statements
        bitmojiSymbols.put("\uD83D\uDC0A", PARAMETER_COMMA); // Parameter comma
        bitmojiSymbols.put("\uD83D\uDC7D", RETURN); // Return
        bitmojiSymbols.put("\uD83D\uDC76", START_THEN); // Start then
        bitmojiSymbols.put("\uD83E\uDDD3", END_THEN); // End then
        bitmojiSymbols.put("\uD83D\uDC4C", NEWLINE);

        for (String symbol : bitmojiSymbols.keySet()) {
            for (Character c : symbol.toCharArray()) {
                uniqueChars.add(c);
            }
        }
        while (uniqueChars.contains(currentChar) || quotes.contains(String.valueOf(currentChar))) {
            sb.append(currentChar);
            nextChar();
        }
        value = sb.toString();
        if (bitmojiSymbols.containsKey(value)) {
            token = bitmojiSymbols.get(value);
            return true;
        } else if (value.equals(quotes)) {
            sb = new StringBuilder();
            int indexOfQuotes;
            do {
                if (currentChar == 0) {
                    printError("String not ended with " + quotes);
                    return false;
                }
                sb.append(currentChar);
                nextChar();
                indexOfQuotes = sb.indexOf(quotes);
            } while (indexOfQuotes == -1);
            sb.delete(indexOfQuotes, sb.length());
            value = sb.toString();
            token = STRING_LITERAL;
            return true;
        } else if (value.equals(quotes + quotes)) {
            value = "";
            token = STRING_LITERAL;
        }
        return false;
    }

    //matches an id
    private void idWord() {
        StringBuilder sb = new StringBuilder();
        while (Character.isLetter(currentChar)) {
            sb.append(currentChar);
            nextChar();
        }
        if (sb.length() > 0) {
            token = ID;
            value = sb.toString();
        }
    }

    //matches literals
    private void literal() {
        StringBuilder sb = new StringBuilder();
        //grab the whole number part
        while(Character.isDigit(currentChar)){
            sb.append(currentChar);
            nextChar();
        }
        //grab the fractional part (if there is one)
        if(currentChar == '.') {
            sb.append('.');
            nextChar();
            while(Character.isDigit(currentChar)) {
                sb.append(currentChar);
                nextChar();
            }
            token = REAL_LITERAL;
            value = Double.valueOf(sb.toString());
            return;
        }
        token = INT_LITERAL;
        value = Integer.valueOf(sb.toString());
    }

    // load the next token
    public void next() {
        // the keyword tokens

        final int[] ct = {};

        // skip whitespace
        while (Character.isWhitespace(currentChar)) {
            nextChar();
        }

        // detect end of the file
        if (currentChar == 0) {
            token = ENDINPUT;
            value = null;
            return;
        }

        // assume there is an error
        token = error;
        value = String.valueOf(currentChar);

        // match strings
        if (Character.isLetter(currentChar)) {
            idWord();
        } else if (Character.isDigit(currentChar)) {
            literal();
        } else if (!bitmojiKeyword()) {
            currentChar = ' ';
        }
    }

    // convert the current token to a string
    public String toString() {
        String [] label = new String[error+1];
        label[ENDINPUT] = "ENDINPUT";
        label[ADD] = "ADD";
        label[ASSIGN] = "ASSIGN";
        label[DIVIDE] = "DIVIDE";
        label[ELIF] = "ELIF";
        label[ELSE] = "ELSE";
        label[END_FUNCTION_STATEMENTS] = "END_FUNCTION_STATEMENTS";
        label[END_PROGRAM] = "END_PROGRAM";
        label[END_THEN] = "END_THEN";
        label[END_WHILE] = "END_WHILE";
        label[EQUALS] = "EQUALS";
        label[EXPONENT] = "EXPONENT";
        label[FUNCTION_DEF] = "FUNCTION_DEF";
        label[GREATER_THAN] = "GREATER_THAN";
        label[GREATER_THAN_OR_EQUAL] = "GREATER_THAN_OR_EQUAL";
        label[ID] = "ID";
        label[IF] = "IF";
        label[INPUT] = "INPUT";
        label[INT_LITERAL] = "INTEGER_LITERAL";
        label[LEFT_BRACKET] = "LEFT_BRACKET";
        label[LEFT_PARENTHESIS] = "LEFT_PARENTHESIS";
        label[LESS_THAN] = "LESS_THAN";
        label[LESS_THAN_OR_EQUAL] = "LESS_THAN_OR_EQUAL";
        label[MULTIPLY] = "MULTIPLY";
        label[NOT_EQUALS] = "NOT_EQUALS";
        label[OUTPUT] = "OUTPUT";
        label[PARAMETER_COMMA] = "PARAMETER_COMMA";
        label[REAL_LITERAL] = "REAL_LITERAL";
        label[RETURN] = "RETURN";
        label[RIGHT_BRACKET] = "RIGHT_BRACKET";
        label[RIGHT_PARENTHESIS] = "RIGHT_PARENTHESIS";
        label[START_FUNCTION_STATEMENTS] = "START_FUNCTION_STATEMENTS";
        label[START_PROGRAM] = "START_PROGRAM";
        label[START_THEN] = "START_THEN";
        label[START_WHILE] = "START_WHILE";
        label[STRING_LITERAL] = "STRING_LITERAL";
        label[SUBTRACT] = "SUBTRACT";
        label[NEWLINE] = "NEWLINE";
        label[error] = "error";

        return label[token] + ": " + value;
    }

    // test the lexer
    public static void main(final String[] args) throws FileNotFoundException {
        final FileInputStream fileStream = new FileInputStream(args[0].toString());
        final BitmojiLexer lexer = new BitmojiLexer(fileStream);
        do {
            lexer.next();
            if (lexer.getToken() == BitmojiLexer.error) {
                lexer.printError("Invalid Token");
            } else {
                System.out.println(lexer);
            }
        } while (lexer.getToken() != BitmojiLexer.ENDINPUT);
    }
}
