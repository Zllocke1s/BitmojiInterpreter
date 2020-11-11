// Output created by jacc on Fri Oct 23 10:12:23 CDT 2020


class Looplang implements LooplangTokens {
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
                case 34:
                    switch (yytok) {
                        case ARRAY:
                            yyn = 10;
                            continue;
                        case ID:
                            yyn = 11;
                            continue;
                        case IN:
                            yyn = 12;
                            continue;
                        case OUT:
                            yyn = 13;
                            continue;
                        case WHILE:
                            yyn = 14;
                            continue;
                    }
                    yyn = 71;
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 35:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 68;
                            continue;
                    }
                    yyn = 71;
                    continue;

                case 2:
                    yyst[yysp] = 2;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 36:
                    yyn = yys2();
                    continue;

                case 3:
                    yyst[yysp] = 3;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 37:
                    yyn = yys3();
                    continue;

                case 4:
                    yyst[yysp] = 4;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 38:
                    yyn = yys4();
                    continue;

                case 5:
                    yyst[yysp] = 5;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 39:
                    yyn = yys5();
                    continue;

                case 6:
                    yyst[yysp] = 6;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 40:
                    switch (yytok) {
                        case ASSIGN:
                            yyn = 15;
                            continue;
                    }
                    yyn = 71;
                    continue;

                case 7:
                    yyst[yysp] = 7;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 41:
                    yyn = yys7();
                    continue;

                case 8:
                    yyst[yysp] = 8;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 42:
                    yyn = yys8();
                    continue;

                case 9:
                    yyst[yysp] = 9;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 43:
                    yyn = yys9();
                    continue;

                case 10:
                    yyst[yysp] = 10;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 44:
                    switch (yytok) {
                        case LBRACKET:
                            yyn = 17;
                            continue;
                    }
                    yyn = 71;
                    continue;

                case 11:
                    yyst[yysp] = 11;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 45:
                    switch (yytok) {
                        case LBRACKET:
                            yyn = 18;
                            continue;
                    }
                    yyn = 71;
                    continue;

                case 12:
                    yyst[yysp] = 12;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 46:
                    switch (yytok) {
                        case ID:
                            yyn = 11;
                            continue;
                    }
                    yyn = 71;
                    continue;

                case 13:
                    yyst[yysp] = 13;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 47:
                    switch (yytok) {
                        case ID:
                            yyn = 11;
                            continue;
                    }
                    yyn = 71;
                    continue;

                case 14:
                    yyst[yysp] = 14;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 48:
                    switch (yytok) {
                        case ID:
                            yyn = 11;
                            continue;
                    }
                    yyn = 71;
                    continue;

                case 15:
                    yyst[yysp] = 15;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 49:
                    switch (yytok) {
                        case ID:
                            yyn = 11;
                            continue;
                        case LITERAL:
                            yyn = 24;
                            continue;
                    }
                    yyn = 71;
                    continue;

                case 16:
                    yyst[yysp] = 16;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 50:
                    yyn = yys16();
                    continue;

                case 17:
                    yyst[yysp] = 17;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 51:
                    switch (yytok) {
                        case LITERAL:
                            yyn = 25;
                            continue;
                    }
                    yyn = 71;
                    continue;

                case 18:
                    yyst[yysp] = 18;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 52:
                    switch (yytok) {
                        case ID:
                            yyn = 11;
                            continue;
                        case LITERAL:
                            yyn = 24;
                            continue;
                    }
                    yyn = 71;
                    continue;

                case 19:
                    yyst[yysp] = 19;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 53:
                    yyn = yys19();
                    continue;

                case 20:
                    yyst[yysp] = 20;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 54:
                    yyn = yys20();
                    continue;

                case 21:
                    yyst[yysp] = 21;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 55:
                    switch (yytok) {
                        case ARRAY:
                            yyn = 10;
                            continue;
                        case ID:
                            yyn = 11;
                            continue;
                        case IN:
                            yyn = 12;
                            continue;
                        case OUT:
                            yyn = 13;
                            continue;
                        case WHILE:
                            yyn = 14;
                            continue;
                    }
                    yyn = 71;
                    continue;

                case 22:
                    yyst[yysp] = 22;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 56:
                    yyn = yys22();
                    continue;

                case 23:
                    yyst[yysp] = 23;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 57:
                    switch (yytok) {
                        case ASSIGN:
                        case LITERAL:
                        case error:
                        case LBRACKET:
                            yyn = 71;
                            continue;
                    }
                    yyn = yyr13();
                    continue;

                case 24:
                    yyst[yysp] = 24;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 58:
                    switch (yytok) {
                        case ASSIGN:
                        case LITERAL:
                        case error:
                        case LBRACKET:
                            yyn = 71;
                            continue;
                    }
                    yyn = yyr12();
                    continue;

                case 25:
                    yyst[yysp] = 25;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 59:
                    switch (yytok) {
                        case RBRACKET:
                            yyn = 29;
                            continue;
                    }
                    yyn = 71;
                    continue;

                case 26:
                    yyst[yysp] = 26;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 60:
                    switch (yytok) {
                        case MINUS:
                            yyn = 28;
                            continue;
                        case RBRACKET:
                            yyn = 30;
                            continue;
                    }
                    yyn = 71;
                    continue;

                case 27:
                    yyst[yysp] = 27;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 61:
                    yyn = yys27();
                    continue;

                case 28:
                    yyst[yysp] = 28;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 62:
                    switch (yytok) {
                        case ID:
                            yyn = 11;
                            continue;
                        case LITERAL:
                            yyn = 24;
                            continue;
                    }
                    yyn = 71;
                    continue;

                case 29:
                    yyst[yysp] = 29;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 63:
                    switch (yytok) {
                        case ID:
                            yyn = 33;
                            continue;
                    }
                    yyn = 71;
                    continue;

                case 30:
                    yyst[yysp] = 30;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 64:
                    switch (yytok) {
                        case LITERAL:
                        case LBRACKET:
                        case error:
                            yyn = 71;
                            continue;
                    }
                    yyn = yyr17();
                    continue;

                case 31:
                    yyst[yysp] = 31;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 65:
                    yyn = yys31();
                    continue;

                case 32:
                    yyst[yysp] = 32;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 66:
                    switch (yytok) {
                        case ASSIGN:
                        case LITERAL:
                        case error:
                        case LBRACKET:
                            yyn = 71;
                            continue;
                    }
                    yyn = yyr11();
                    continue;

                case 33:
                    yyst[yysp] = 33;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 67:
                    yyn = yys33();
                    continue;

                case 68:
                    return true;
                case 69:
                    yyerror("stack overflow");
                case 70:
                    return false;
                case 71:
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

    private int yys2() {
        switch (yytok) {
            case RBRACKET:
            case MINUS:
            case LBRACKET:
            case error:
            case ASSIGN:
            case LITERAL:
                return 71;
        }
        return yyr5();
    }

    private int yys3() {
        switch (yytok) {
            case RBRACKET:
            case MINUS:
            case LBRACKET:
            case error:
            case ASSIGN:
            case LITERAL:
                return 71;
        }
        return yyr7();
    }

    private int yys4() {
        switch (yytok) {
            case RBRACKET:
            case MINUS:
            case LBRACKET:
            case error:
            case ASSIGN:
            case LITERAL:
                return 71;
        }
        return yyr8();
    }

    private int yys5() {
        switch (yytok) {
            case RBRACKET:
            case MINUS:
            case LBRACKET:
            case error:
            case ASSIGN:
            case LITERAL:
                return 71;
        }
        return yyr4();
    }

    private int yys7() {
        switch (yytok) {
            case RBRACKET:
            case MINUS:
            case LBRACKET:
            case error:
            case ASSIGN:
            case LITERAL:
                return 71;
        }
        return yyr2();
    }

    private int yys8() {
        switch (yytok) {
            case ARRAY:
                return 10;
            case ID:
                return 11;
            case IN:
                return 12;
            case OUT:
                return 13;
            case WHILE:
                return 14;
            case ENDINPUT:
                return yyr1();
        }
        return 71;
    }

    private int yys9() {
        switch (yytok) {
            case RBRACKET:
            case MINUS:
            case LBRACKET:
            case error:
            case ASSIGN:
            case LITERAL:
                return 71;
        }
        return yyr6();
    }

    private int yys16() {
        switch (yytok) {
            case RBRACKET:
            case MINUS:
            case LBRACKET:
            case error:
            case ASSIGN:
            case LITERAL:
                return 71;
        }
        return yyr3();
    }

    private int yys19() {
        switch (yytok) {
            case RBRACKET:
            case MINUS:
            case LBRACKET:
            case error:
            case ASSIGN:
            case LITERAL:
                return 71;
        }
        return yyr15();
    }

    private int yys20() {
        switch (yytok) {
            case RBRACKET:
            case MINUS:
            case LBRACKET:
            case error:
            case ASSIGN:
            case LITERAL:
                return 71;
        }
        return yyr16();
    }

    private int yys22() {
        switch (yytok) {
            case LITERAL:
            case LBRACKET:
            case RBRACKET:
            case error:
            case ASSIGN:
                return 71;
            case MINUS:
                return 28;
        }
        return yyr10();
    }

    private int yys27() {
        switch (yytok) {
            case ARRAY:
                return 10;
            case ID:
                return 11;
            case IN:
                return 12;
            case OUT:
                return 13;
            case WHILE:
                return 14;
            case END:
                return 31;
        }
        return 71;
    }

    private int yys31() {
        switch (yytok) {
            case RBRACKET:
            case MINUS:
            case LBRACKET:
            case error:
            case ASSIGN:
            case LITERAL:
                return 71;
        }
        return yyr14();
    }

    private int yys33() {
        switch (yytok) {
            case RBRACKET:
            case MINUS:
            case LBRACKET:
            case error:
            case ASSIGN:
            case LITERAL:
                return 71;
        }
        return yyr9();
    }

    private int yyr1() { // program : stmnt_list
        { 
             program = tree.new 
               ProgramNode((LooplangParseTree.StatementListNode)yysv[yysp-1]); 
          }
        yysv[yysp-=1] = yyrv;
        return 1;
    }

    private int yyr10() { // assignment : ref ASSIGN expr
        {
              yyrv = tree.new AssignNode((LooplangParseTree.RefNode)yysv[yysp-3], 
                                       (LooplangParseTree.ParseNode)yysv[yysp-1]);
            }
        yysv[yysp-=3] = yyrv;
        return 2;
    }

    private int yyr11() { // expr : expr MINUS expr
        {
        yyrv = tree.new BinOpNode((LooplangParseTree.ParseNode)yysv[yysp-3],  
                                "-", 
                                (LooplangParseTree.ParseNode)yysv[yysp-1]);
      }
        yysv[yysp-=3] = yyrv;
        return yypexpr();
    }

    private int yyr12() { // expr : LITERAL
        { 
        yyrv = tree.new LiteralNode((Integer)yysv[yysp-1]); 
      }
        yysv[yysp-=1] = yyrv;
        return yypexpr();
    }

    private int yyr13() { // expr : ref
        yysp -= 1;
        return yypexpr();
    }

    private int yypexpr() {
        switch (yyst[yysp-1]) {
            case 18: return 26;
            case 15: return 22;
            default: return 32;
        }
    }

    private int yyr15() { // input : IN ref
        { 
         yyrv = tree.new InputNode((LooplangParseTree.RefNode) yysv[yysp-1]); 
       }
        yysv[yysp-=2] = yyrv;
        return 3;
    }

    private int yyr16() { // output : OUT ref
        { 
          yyrv = tree.new OutputNode((LooplangParseTree.RefNode) yysv[yysp-1]); 
        }
        yysv[yysp-=2] = yyrv;
        return 4;
    }

    private int yyr9() { // array_decl : ARRAY LBRACKET LITERAL RBRACKET ID
        {
              yyrv = tree.new ArrayDeclNode(yysv[yysp-1].toString(), (Integer) yysv[yysp-3]);
            }
        yysv[yysp-=5] = yyrv;
        return 5;
    }

    private int yyr17() { // ref : ID LBRACKET expr RBRACKET
        { 
       yyrv = tree.new RefNode(yysv[yysp-4].toString(), (LooplangParseTree.ParseNode) yysv[yysp-2]); 
     }
        yysv[yysp-=4] = yyrv;
        switch (yyst[yysp-1]) {
            case 28: return 23;
            case 18: return 23;
            case 15: return 23;
            case 14: return 21;
            case 13: return 20;
            case 12: return 19;
            default: return 6;
        }
    }

    private int yyr4() { // statement : array_decl
        yysp -= 1;
        return yypstatement();
    }

    private int yyr5() { // statement : assignment
        yysp -= 1;
        return yypstatement();
    }

    private int yyr6() { // statement : while
        yysp -= 1;
        return yypstatement();
    }

    private int yyr7() { // statement : input
        yysp -= 1;
        return yypstatement();
    }

    private int yyr8() { // statement : output
        yysp -= 1;
        return yypstatement();
    }

    private int yypstatement() {
        switch (yyst[yysp-1]) {
            case 21: return 7;
            case 0: return 7;
            default: return 16;
        }
    }

    private int yyr2() { // stmnt_list : statement
        { 
               yyrv = tree.new StatementListNode(
                  (LooplangParseTree.StatementNode) yysv[yysp-1]
               ); 
             }
        yysv[yysp-=1] = yyrv;
        return yypstmnt_list();
    }

    private int yyr3() { // stmnt_list : stmnt_list statement
        { 
                ((LooplangParseTree.StatementListNode)yysv[yysp-2]).add(
                     (LooplangParseTree.StatementNode) yysv[yysp-1]
                );
                yyrv=yysv[yysp-2];
              }
        yysv[yysp-=2] = yyrv;
        return yypstmnt_list();
    }

    private int yypstmnt_list() {
        switch (yyst[yysp-1]) {
            case 0: return 8;
            default: return 27;
        }
    }

    private int yyr14() { // while : WHILE ref stmnt_list END
        {
         yyrv = tree.new WhileNode((LooplangParseTree.RefNode) yysv[yysp-3], 
                                 (LooplangParseTree.StatementListNode)yysv[yysp-2]);
       }
        yysv[yysp-=4] = yyrv;
        return 9;
    }

    protected String[] yyerrmsgs = {
    };


//////////////////////////////////////////
// Extra Code
//////////////////////////////////////////

    private LooplangLexer lexer;
    private int token;
    private Object yylvalue;
    private LooplangParseTree tree;
    private LooplangParseTree.ProgramNode program;

    public int yynext() {
        lexer.next();
        token = lexer.getToken();
        yylvalue = lexer.getValue();

        return token;
    }

    public void yyerror(String msg) {
        lexer.printError("ERROR: " + msg);
    }

    public Looplang(java.io.InputStream in) {
        lexer = new LooplangLexer(in); 
        tree = new LooplangParseTree(this);
    }


    public LooplangParseTree.ProgramNode getProgram() {
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
            Looplang parser = new Looplang(new java.io.FileInputStream(filename));
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
