// Output created by jacc on Mon Nov 16 13:12:40 CST 2020

package com.bitmoji;

class Bitmoji implements BitmojiTokens {
    private int yyss = 100;
    private int yytok;
    private int yysp = 0;
    private int[] yyst;
    protected int yyerrno = (-1);
    private Object[] yysv;
    private Object yyrv;

    public boolean parse() {
        int yyn = 0;
        yysp = 0;
        yyst = new int[yyss];
        yysv = new Object[yyss];
        yytok = (lexer.getToken()
                 );
    loop:
        for (;;) {
            switch (yyn) {
                case 0:
                    yyst[yysp] = 0;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 3:
                    switch (yytok) {
                        case START_PROGRAM:
                            yyn = 2;
                            continue;
                    }
                    yyn = 9;
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 4:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 6;
                            continue;
                    }
                    yyn = 9;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 5:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 9;
                    continue;

                case 6:
                    return true;
                case 7:
                    yyerror("stack overflow");
                case 8:
                    return false;
                case 9:
                    yyerror("syntax error");
                    return false;
            }
        }
    }

    protected void yyexpand() {
        int[] newyyst = new int[2*yyst.length];
        Object[] newyysv = new Object[2*yyst.length];
        for (int i=0; i<yyst.length; i++) {
            newyyst[i] = yyst[i];
            newyysv[i] = yysv[i];
        }
        yyst = newyyst;
        yysv = newyysv;
    }

    private int yyr1() { // program : START_PROGRAM
        {

                        }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    protected String[] yyerrmsgs = {
    };


//////////////////////////////////////////
// Extra Code
//////////////////////////////////////////

    private BitmojiLexer lexer;
    private int token;
    private Object yylvalue;
    private BitmojiParseTree tree;
    private BitmojiParseTree.ProgramNode program;

    public int yynext() {
        lexer.next();
        token = lexer.getToken();
        yylvalue = lexer.getValue();

        return token;
    }

    public void yyerror(String msg) {
        lexer.printError("ERROR: " + msg);
    }

    public Bitmoji(java.io.InputStream in) {
        lexer = new BitmojiLexer(in);
        tree = new BitmojiParseTree(this);
    }


    public BitmojiParseTree.ProgramNode getProgram() {
        return program;
    }


    public static void main(String [] args) {
        boolean interpret = true;
        boolean printTree = false;
        boolean compile = false;
        String filename="";

        //process command line
        for(int i=0; i<args.length; i++) {
            if(args[i].equals("-c")) {
                interpret = false;
                compile = true;
            } else if(args[i].equals("-t")) {
                printTree = true;
            } else {
                filename = args[i];
            }
        }

        try {
            Bitmoji parser = new Bitmoji(new java.io.FileInputStream(filename));
            parser.yynext();
            parser.parse();
 
            //print the tree
            if(printTree) {
                parser.getProgram().print("");
            }

            //interpret the code
            if(interpret) {
                parser.getProgram().evaluate();
            }

            //compile the code to c
            if(compile) {
                java.io.FileOutputStream file = new java.io.FileOutputStream(filename.split("\\.")[0] + ".c");
                file.write(parser.getProgram().generate().getBytes());
                file.close();
            }

        } catch(java.io.FileNotFoundException e) {
            System.err.println("Could not open file.");
        } catch(java.io.IOException e) {
            System.err.println("File Write Error");
        }
    }

}
