import java.io.InputStream;
import java.util.Scanner;

public class LooplangLexer implements LooplangTokens
{
    //constructor
    public LooplangLexer(final InputStream in) {
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

    // lexer pattern matching functions
    private boolean kwIdentMatch() {
        if (Character.isLetterOrDigit(currentChar)) {
            return true;
        }

        return false;
    }

    // matches keywords and identifiers
    private void kwIdent(final String[] kw, final int[] token) {
        final StringBuilder sb = new StringBuilder();

        // accumulate a string of
        while (kwIdentMatch()) {
            sb.append(currentChar);
            nextChar();
        }
        final String value = sb.toString();

        // see if the accumulated string matches a keyword
        for (int i = 0; i < kw.length; i++) {
            if (kw[i].equals(value)) {
                this.token = token[i];
                this.value = null;
                return;
            }
        }

        // must be an identifier!
        this.token = ID;
        this.value = value;
    }

    // matches a single character token
    // Returns true on match
    private boolean singleMatch(final char[] c, final int[] token) {
        for (int i = 0; i < c.length; i++) {
            if (c[i] == currentChar) {
                this.token = token[i];
                this.value = null;
                return true;
            }
        }

        return false;
    }

    // matches integers
    private void literal() {
        final StringBuilder sb = new StringBuilder();

        while (Character.isDigit(currentChar)) {
            sb.append(currentChar);
            nextChar();
        }

        token = LITERAL;
        value = Integer.valueOf(sb.toString());
    }

    // load the next token
    public void next() {
        // the keyword tokens
        final String[] kw = { "array", "while", "end", "in", "out" };
        final int[] kwt = { ARRAY, WHILE, END, IN, OUT };
        final char[] c = { '[', ']', '-' };
        final int[] ct = { LBRACKET, RBRACKET, MINUS };

        // skip whitespace
        while (Character.isWhitespace(currentChar)) {
            nextChar();
        }

        // detect end of the file
        if (currentChar == 0) {
            token = ENDINPUT;
            return;
        }

        // assume there is an error
        token = error;
        value = String.valueOf(currentChar);

        // match strings
        if (Character.isDigit(currentChar)) {
            // match an integer
            literal();
        } else if (kwIdentMatch()) {
            // match keyword or literal
            kwIdent(kw, kwt);
        } else if (singleMatch(c, ct)) {
            nextChar();
        } else if (currentChar == ':') {
            nextChar();
            if (currentChar == '=') {
                token = ASSIGN;
                value = null;
            }
            nextChar();
        } else {
            // mark the invalid character for skipping
            currentChar = ' ';
        }

        return;
    }

    // convert the current token to a string
    public String toString() {
        final String[] label = { "ENDINPUT", "ARRAY", "ASSIGN", "END", 
                                 "ID", "IN", "LBRACKET", "LITERAL", "MINUS",
                                 "OUT", "RBRACKET", "WHILE", "error" };

        return label[token] + ": " + value;
    }

    // test the lexer
    public static void main(final String[] args) {
        final LooplangLexer lexer = new LooplangLexer(System.in);

        do {
            if(lexer.getToken() == LooplangLexer.error) {
                lexer.printError("Invalid Token");
            } else {
                System.out.println(lexer);
            }
        } while(lexer.getToken() != LooplangLexer.ENDINPUT);
    }
}
