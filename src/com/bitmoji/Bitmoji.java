// Output created by jacc on Tue Nov 17 23:07:41 CST 2020

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
                case 93:
                    switch (yytok) {
                        case START_PROGRAM:
                            yyn = 2;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 1:
                    yyst[yysp] = 1;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 94:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = 186;
                            continue;
                    }
                    yyn = 189;
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
                case 95:
                    yyn = yys2();
                    continue;

                case 3:
                    yyst[yysp] = 3;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 96:
                    yyn = yys3();
                    continue;

                case 4:
                    yyst[yysp] = 4;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 97:
                    yyn = yys4();
                    continue;

                case 5:
                    yyst[yysp] = 5;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 98:
                    yyn = yys5();
                    continue;

                case 6:
                    yyst[yysp] = 6;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 99:
                    yyn = yys6();
                    continue;

                case 7:
                    yyst[yysp] = 7;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 100:
                    yyn = yys7();
                    continue;

                case 8:
                    yyst[yysp] = 8;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 101:
                    yyn = yys8();
                    continue;

                case 9:
                    yyst[yysp] = 9;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 102:
                    yyn = yys9();
                    continue;

                case 10:
                    yyst[yysp] = 10;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 103:
                    yyn = yys10();
                    continue;

                case 11:
                    yyst[yysp] = 11;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 104:
                    yyn = yys11();
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
                case 105:
                    switch (yytok) {
                        case ID:
                            yyn = 20;
                            continue;
                    }
                    yyn = 189;
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
                case 106:
                    switch (yytok) {
                        case ASSIGN:
                            yyn = 21;
                            continue;
                        case LEFT_PARENTHESIS:
                            yyn = 22;
                            continue;
                    }
                    yyn = 189;
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
                case 107:
                    switch (yytok) {
                        case LEFT_PARENTHESIS:
                            yyn = 23;
                            continue;
                    }
                    yyn = 189;
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
                case 108:
                    switch (yytok) {
                        case ID:
                            yyn = 25;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 16:
                    yyst[yysp] = 16;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 109:
                    switch (yytok) {
                        case ID:
                            yyn = 32;
                            continue;
                        case INT_LITERAL:
                            yyn = 33;
                            continue;
                        case LEFT_PARENTHESIS:
                            yyn = 34;
                            continue;
                        case REAL_LITERAL:
                            yyn = 35;
                            continue;
                        case STRING_LITERAL:
                            yyn = 36;
                            continue;
                    }
                    yyn = 189;
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
                case 110:
                    switch (yytok) {
                        case ID:
                            yyn = 32;
                            continue;
                        case INT_LITERAL:
                            yyn = 33;
                            continue;
                        case LEFT_PARENTHESIS:
                            yyn = 34;
                            continue;
                        case REAL_LITERAL:
                            yyn = 35;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 18:
                    yyst[yysp] = 18;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 111:
                    yyn = yys18();
                    continue;

                case 19:
                    yyst[yysp] = 19;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 112:
                    switch (yytok) {
                        case ENDINPUT:
                            yyn = yyr1();
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 20:
                    yyst[yysp] = 20;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 113:
                    switch (yytok) {
                        case LEFT_PARENTHESIS:
                            yyn = 40;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 21:
                    yyst[yysp] = 21;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 114:
                    switch (yytok) {
                        case ID:
                            yyn = 32;
                            continue;
                        case INT_LITERAL:
                            yyn = 33;
                            continue;
                        case LEFT_PARENTHESIS:
                            yyn = 34;
                            continue;
                        case REAL_LITERAL:
                            yyn = 35;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 22:
                    yyst[yysp] = 22;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 115:
                    switch (yytok) {
                        case ID:
                            yyn = 25;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 23:
                    yyst[yysp] = 23;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 116:
                    switch (yytok) {
                        case ID:
                            yyn = 32;
                            continue;
                        case INT_LITERAL:
                            yyn = 33;
                            continue;
                        case LEFT_PARENTHESIS:
                            yyn = 34;
                            continue;
                        case REAL_LITERAL:
                            yyn = 35;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 24:
                    yyst[yysp] = 24;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 117:
                    yyn = yys24();
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
                case 118:
                    yyn = yys25();
                    continue;

                case 26:
                    yyst[yysp] = 26;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 119:
                    yyn = yys26();
                    continue;

                case 27:
                    yyst[yysp] = 27;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 120:
                    yyn = yys27();
                    continue;

                case 28:
                    yyst[yysp] = 28;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 121:
                    yyn = yys28();
                    continue;

                case 29:
                    yyst[yysp] = 29;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 122:
                    yyn = yys29();
                    continue;

                case 30:
                    yyst[yysp] = 30;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 123:
                    yyn = yys30();
                    continue;

                case 31:
                    yyst[yysp] = 31;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 124:
                    yyn = yys31();
                    continue;

                case 32:
                    yyst[yysp] = 32;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 125:
                    yyn = yys32();
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
                case 126:
                    yyn = yys33();
                    continue;

                case 34:
                    yyst[yysp] = 34;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 127:
                    switch (yytok) {
                        case ID:
                            yyn = 32;
                            continue;
                        case INT_LITERAL:
                            yyn = 33;
                            continue;
                        case LEFT_PARENTHESIS:
                            yyn = 34;
                            continue;
                        case REAL_LITERAL:
                            yyn = 35;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 35:
                    yyst[yysp] = 35;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 128:
                    yyn = yys35();
                    continue;

                case 36:
                    yyst[yysp] = 36;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 129:
                    yyn = yys36();
                    continue;

                case 37:
                    yyst[yysp] = 37;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 130:
                    yyn = yys37();
                    continue;

                case 38:
                    yyst[yysp] = 38;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 131:
                    yyn = yys38();
                    continue;

                case 39:
                    yyst[yysp] = 39;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 132:
                    yyn = yys39();
                    continue;

                case 40:
                    yyst[yysp] = 40;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 133:
                    switch (yytok) {
                        case ID:
                            yyn = 60;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 41:
                    yyst[yysp] = 41;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 134:
                    yyn = yys41();
                    continue;

                case 42:
                    yyst[yysp] = 42;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 135:
                    switch (yytok) {
                        case PARAMETER_COMMA:
                        case RIGHT_PARENTHESIS:
                            yyn = yyr44();
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 43:
                    yyst[yysp] = 43;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 136:
                    switch (yytok) {
                        case PARAMETER_COMMA:
                            yyn = 61;
                            continue;
                        case RIGHT_PARENTHESIS:
                            yyn = 62;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 44:
                    yyst[yysp] = 44;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 137:
                    switch (yytok) {
                        case EQUALS:
                            yyn = 53;
                            continue;
                        case NOT_EQUALS:
                            yyn = 54;
                            continue;
                        case RIGHT_PARENTHESIS:
                            yyn = 63;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 45:
                    yyst[yysp] = 45;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 138:
                    switch (yytok) {
                        case ID:
                            yyn = 32;
                            continue;
                        case INT_LITERAL:
                            yyn = 33;
                            continue;
                        case LEFT_PARENTHESIS:
                            yyn = 34;
                            continue;
                        case REAL_LITERAL:
                            yyn = 35;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 46:
                    yyst[yysp] = 46;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 139:
                    switch (yytok) {
                        case ID:
                            yyn = 25;
                            continue;
                        case INT_LITERAL:
                            yyn = 33;
                            continue;
                        case LEFT_PARENTHESIS:
                            yyn = 34;
                            continue;
                        case REAL_LITERAL:
                            yyn = 35;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 47:
                    yyst[yysp] = 47;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 140:
                    switch (yytok) {
                        case ID:
                            yyn = 25;
                            continue;
                        case INT_LITERAL:
                            yyn = 33;
                            continue;
                        case LEFT_PARENTHESIS:
                            yyn = 34;
                            continue;
                        case REAL_LITERAL:
                            yyn = 35;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 48:
                    yyst[yysp] = 48;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 141:
                    switch (yytok) {
                        case ID:
                            yyn = 25;
                            continue;
                        case INT_LITERAL:
                            yyn = 33;
                            continue;
                        case LEFT_PARENTHESIS:
                            yyn = 34;
                            continue;
                        case REAL_LITERAL:
                            yyn = 35;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 49:
                    yyst[yysp] = 49;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 142:
                    switch (yytok) {
                        case ID:
                            yyn = 25;
                            continue;
                        case INT_LITERAL:
                            yyn = 33;
                            continue;
                        case LEFT_PARENTHESIS:
                            yyn = 34;
                            continue;
                        case REAL_LITERAL:
                            yyn = 35;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 50:
                    yyst[yysp] = 50;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 143:
                    switch (yytok) {
                        case ID:
                            yyn = 25;
                            continue;
                        case INT_LITERAL:
                            yyn = 33;
                            continue;
                        case LEFT_PARENTHESIS:
                            yyn = 34;
                            continue;
                        case REAL_LITERAL:
                            yyn = 35;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 51:
                    yyst[yysp] = 51;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 144:
                    switch (yytok) {
                        case ADD:
                            yyn = 46;
                            continue;
                        case SUBTRACT:
                            yyn = 47;
                            continue;
                        case RIGHT_PARENTHESIS:
                            yyn = 70;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 52:
                    yyst[yysp] = 52;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 145:
                    yyn = yys52();
                    continue;

                case 53:
                    yyst[yysp] = 53;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 146:
                    switch (yytok) {
                        case ID:
                            yyn = 32;
                            continue;
                        case INT_LITERAL:
                            yyn = 33;
                            continue;
                        case LEFT_PARENTHESIS:
                            yyn = 34;
                            continue;
                        case REAL_LITERAL:
                            yyn = 35;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 54:
                    yyst[yysp] = 54;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 147:
                    switch (yytok) {
                        case ID:
                            yyn = 32;
                            continue;
                        case INT_LITERAL:
                            yyn = 33;
                            continue;
                        case LEFT_PARENTHESIS:
                            yyn = 34;
                            continue;
                        case REAL_LITERAL:
                            yyn = 35;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 55:
                    yyst[yysp] = 55;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 148:
                    switch (yytok) {
                        case ID:
                            yyn = 32;
                            continue;
                        case INT_LITERAL:
                            yyn = 33;
                            continue;
                        case LEFT_PARENTHESIS:
                            yyn = 34;
                            continue;
                        case REAL_LITERAL:
                            yyn = 35;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 56:
                    yyst[yysp] = 56;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 149:
                    switch (yytok) {
                        case ID:
                            yyn = 32;
                            continue;
                        case INT_LITERAL:
                            yyn = 33;
                            continue;
                        case LEFT_PARENTHESIS:
                            yyn = 34;
                            continue;
                        case REAL_LITERAL:
                            yyn = 35;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 57:
                    yyst[yysp] = 57;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 150:
                    switch (yytok) {
                        case ID:
                            yyn = 32;
                            continue;
                        case INT_LITERAL:
                            yyn = 33;
                            continue;
                        case LEFT_PARENTHESIS:
                            yyn = 34;
                            continue;
                        case REAL_LITERAL:
                            yyn = 35;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 58:
                    yyst[yysp] = 58;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 151:
                    switch (yytok) {
                        case ID:
                            yyn = 32;
                            continue;
                        case INT_LITERAL:
                            yyn = 33;
                            continue;
                        case LEFT_PARENTHESIS:
                            yyn = 34;
                            continue;
                        case REAL_LITERAL:
                            yyn = 35;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 59:
                    yyst[yysp] = 59;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 152:
                    switch (yytok) {
                        case PARAMETER_COMMA:
                            yyn = 78;
                            continue;
                        case RIGHT_PARENTHESIS:
                            yyn = 79;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 60:
                    yyst[yysp] = 60;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 153:
                    switch (yytok) {
                        case PARAMETER_COMMA:
                        case RIGHT_PARENTHESIS:
                            yyn = yyr47();
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 61:
                    yyst[yysp] = 61;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 154:
                    switch (yytok) {
                        case ID:
                            yyn = 25;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 62:
                    yyst[yysp] = 62;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 155:
                    yyn = yys62();
                    continue;

                case 63:
                    yyst[yysp] = 63;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 156:
                    switch (yytok) {
                        case START_THEN:
                            yyn = 81;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 64:
                    yyst[yysp] = 64;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 157:
                    switch (yytok) {
                        case ADD:
                            yyn = 46;
                            continue;
                        case SUBTRACT:
                            yyn = 47;
                            continue;
                        case RIGHT_BRACKET:
                            yyn = 82;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 65:
                    yyst[yysp] = 65;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 158:
                    yyn = yys65();
                    continue;

                case 66:
                    yyst[yysp] = 66;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 159:
                    yyn = yys66();
                    continue;

                case 67:
                    yyst[yysp] = 67;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 160:
                    yyn = yys67();
                    continue;

                case 68:
                    yyst[yysp] = 68;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 161:
                    yyn = yys68();
                    continue;

                case 69:
                    yyst[yysp] = 69;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 162:
                    yyn = yys69();
                    continue;

                case 70:
                    yyst[yysp] = 70;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 163:
                    yyn = yys70();
                    continue;

                case 71:
                    yyst[yysp] = 71;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 164:
                    yyn = yys71();
                    continue;

                case 72:
                    yyst[yysp] = 72;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 165:
                    yyn = yys72();
                    continue;

                case 73:
                    yyst[yysp] = 73;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 166:
                    yyn = yys73();
                    continue;

                case 74:
                    yyst[yysp] = 74;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 167:
                    yyn = yys74();
                    continue;

                case 75:
                    yyst[yysp] = 75;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 168:
                    yyn = yys75();
                    continue;

                case 76:
                    yyst[yysp] = 76;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 169:
                    yyn = yys76();
                    continue;

                case 77:
                    yyst[yysp] = 77;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 170:
                    yyn = yys77();
                    continue;

                case 78:
                    yyst[yysp] = 78;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 171:
                    switch (yytok) {
                        case ID:
                            yyn = 83;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 79:
                    yyst[yysp] = 79;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 172:
                    switch (yytok) {
                        case START_FUNCTION_STATEMENTS:
                            yyn = 84;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 80:
                    yyst[yysp] = 80;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 173:
                    switch (yytok) {
                        case PARAMETER_COMMA:
                        case RIGHT_PARENTHESIS:
                            yyn = yyr43();
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 81:
                    yyst[yysp] = 81;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 174:
                    yyn = yys81();
                    continue;

                case 82:
                    yyst[yysp] = 82;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 175:
                    yyn = yys82();
                    continue;

                case 83:
                    yyst[yysp] = 83;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 176:
                    switch (yytok) {
                        case PARAMETER_COMMA:
                        case RIGHT_PARENTHESIS:
                            yyn = yyr46();
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 84:
                    yyst[yysp] = 84;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 177:
                    yyn = yys84();
                    continue;

                case 85:
                    yyst[yysp] = 85;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 178:
                    yyn = yys85();
                    continue;

                case 86:
                    yyst[yysp] = 86;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 179:
                    yyn = yys86();
                    continue;

                case 87:
                    yyst[yysp] = 87;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 180:
                    yyn = yys87();
                    continue;

                case 88:
                    yyst[yysp] = 88;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 181:
                    switch (yytok) {
                        case LEFT_PARENTHESIS:
                            yyn = 89;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 89:
                    yyst[yysp] = 89;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 182:
                    switch (yytok) {
                        case ID:
                            yyn = 32;
                            continue;
                        case INT_LITERAL:
                            yyn = 33;
                            continue;
                        case LEFT_PARENTHESIS:
                            yyn = 34;
                            continue;
                        case REAL_LITERAL:
                            yyn = 35;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 90:
                    yyst[yysp] = 90;
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 183:
                    switch (yytok) {
                        case ADD:
                            yyn = 46;
                            continue;
                        case SUBTRACT:
                            yyn = 47;
                            continue;
                        case RIGHT_PARENTHESIS:
                            yyn = 91;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 91:
                    yyst[yysp] = 91;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 184:
                    switch (yytok) {
                        case END_FUNCTION_STATEMENTS:
                            yyn = 92;
                            continue;
                    }
                    yyn = 189;
                    continue;

                case 92:
                    yyst[yysp] = 92;
                    yysv[yysp] = (lexer.getValue()
                                 );
                    yytok = (yynext()
                            );
                    if (++yysp>=yyst.length) {
                        yyexpand();
                    }
                case 185:
                    yyn = yys92();
                    continue;

                case 186:
                    return true;
                case 187:
                    yyerror("stack overflow");
                case 188:
                    return false;
                case 189:
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
            case FUNCTION_DEF:
                return 12;
            case ID:
                return 13;
            case IF:
                return 14;
            case INPUT:
                return 15;
            case OUTPUT:
                return 16;
            case START_WHILE:
                return 17;
        }
        return 189;
    }

    private int yys3() {
        switch (yytok) {
            case RETURN:
            case OUTPUT:
            case FUNCTION_DEF:
            case END_WHILE:
            case START_WHILE:
            case INPUT:
            case END_THEN:
            case IF:
            case ID:
            case END_PROGRAM:
                return yyr4();
        }
        return 189;
    }

    private int yys4() {
        switch (yytok) {
            case RETURN:
            case OUTPUT:
            case FUNCTION_DEF:
            case END_WHILE:
            case START_WHILE:
            case INPUT:
            case END_THEN:
            case IF:
            case ID:
            case END_PROGRAM:
                return yyr9();
        }
        return 189;
    }

    private int yys5() {
        switch (yytok) {
            case RETURN:
            case OUTPUT:
            case FUNCTION_DEF:
            case END_WHILE:
            case START_WHILE:
            case INPUT:
            case END_THEN:
            case IF:
            case ID:
            case END_PROGRAM:
                return yyr10();
        }
        return 189;
    }

    private int yys6() {
        switch (yytok) {
            case RETURN:
            case OUTPUT:
            case FUNCTION_DEF:
            case END_WHILE:
            case START_WHILE:
            case INPUT:
            case END_THEN:
            case IF:
            case ID:
            case END_PROGRAM:
                return yyr8();
        }
        return 189;
    }

    private int yys7() {
        switch (yytok) {
            case RETURN:
            case OUTPUT:
            case FUNCTION_DEF:
            case END_WHILE:
            case START_WHILE:
            case INPUT:
            case END_THEN:
            case IF:
            case ID:
            case END_PROGRAM:
                return yyr6();
        }
        return 189;
    }

    private int yys8() {
        switch (yytok) {
            case RETURN:
            case OUTPUT:
            case FUNCTION_DEF:
            case END_WHILE:
            case START_WHILE:
            case INPUT:
            case END_THEN:
            case IF:
            case ID:
            case END_PROGRAM:
                return yyr7();
        }
        return 189;
    }

    private int yys9() {
        switch (yytok) {
            case RETURN:
            case OUTPUT:
            case FUNCTION_DEF:
            case END_WHILE:
            case START_WHILE:
            case INPUT:
            case END_THEN:
            case IF:
            case ID:
            case END_PROGRAM:
                return yyr3();
        }
        return 189;
    }

    private int yys10() {
        switch (yytok) {
            case FUNCTION_DEF:
                return 12;
            case ID:
                return 13;
            case IF:
                return 14;
            case INPUT:
                return 15;
            case OUTPUT:
                return 16;
            case START_WHILE:
                return 17;
            case END_PROGRAM:
                return 19;
        }
        return 189;
    }

    private int yys11() {
        switch (yytok) {
            case RETURN:
            case OUTPUT:
            case FUNCTION_DEF:
            case END_WHILE:
            case START_WHILE:
            case INPUT:
            case END_THEN:
            case IF:
            case ID:
            case END_PROGRAM:
                return yyr5();
        }
        return 189;
    }

    private int yys18() {
        switch (yytok) {
            case RETURN:
            case OUTPUT:
            case FUNCTION_DEF:
            case END_WHILE:
            case START_WHILE:
            case INPUT:
            case END_THEN:
            case IF:
            case ID:
            case END_PROGRAM:
                return yyr2();
        }
        return 189;
    }

    private int yys24() {
        switch (yytok) {
            case RETURN:
            case OUTPUT:
            case FUNCTION_DEF:
            case END_WHILE:
            case START_WHILE:
            case INPUT:
            case END_THEN:
            case IF:
            case ID:
            case END_PROGRAM:
                return yyr31();
        }
        return 189;
    }

    private int yys25() {
        switch (yytok) {
            case INTEGER_DECL:
            case ELIF:
            case START_PROGRAM:
            case REAL_DECL:
            case ELSE:
            case START_FUNCTION_STATEMENTS:
            case STRING_LITERAL:
            case START_THEN:
            case REAL_LITERAL:
            case ARRAY_DECL:
            case END_FUNCTION_STATEMENTS:
            case ASSIGN:
            case ENDINPUT:
            case LEFT_PARENTHESIS:
            case error:
            case INT_LITERAL:
            case STRING_DECL:
                return 189;
            case LEFT_BRACKET:
                return 45;
        }
        return yyr12();
    }

    private int yys26() {
        switch (yytok) {
            case REAL_DECL:
            case LEFT_BRACKET:
            case START_PROGRAM:
            case REAL_LITERAL:
            case ELSE:
            case LEFT_PARENTHESIS:
            case STRING_LITERAL:
            case START_THEN:
            case START_FUNCTION_STATEMENTS:
            case ARRAY_DECL:
            case PARAMETER_COMMA:
            case ASSIGN:
            case END_FUNCTION_STATEMENTS:
            case ENDINPUT:
            case error:
            case INT_LITERAL:
            case STRING_DECL:
            case INTEGER_DECL:
            case ELIF:
                return 189;
        }
        return yyr24();
    }

    private int yys27() {
        switch (yytok) {
            case ADD:
                return 46;
            case SUBTRACT:
                return 47;
            case RETURN:
            case OUTPUT:
            case FUNCTION_DEF:
            case END_WHILE:
            case START_WHILE:
            case INPUT:
            case END_THEN:
            case IF:
            case ID:
            case END_PROGRAM:
                return yyr32();
        }
        return 189;
    }

    private int yys28() {
        switch (yytok) {
            case REAL_DECL:
            case LEFT_BRACKET:
            case START_PROGRAM:
            case REAL_LITERAL:
            case LEFT_PARENTHESIS:
            case ENDINPUT:
            case STRING_LITERAL:
            case START_THEN:
            case START_FUNCTION_STATEMENTS:
            case ARRAY_DECL:
            case ELSE:
            case PARAMETER_COMMA:
            case END_FUNCTION_STATEMENTS:
            case ASSIGN:
            case error:
            case INT_LITERAL:
            case STRING_DECL:
            case INTEGER_DECL:
            case ELIF:
                return 189;
            case EXPONENT:
                return 48;
        }
        return yyr22();
    }

    private int yys29() {
        switch (yytok) {
            case GREATER_THAN_OR_EQUAL:
            case GREATER_THAN:
            case OUTPUT:
            case NOT_EQUALS:
            case FUNCTION_DEF:
            case LESS_THAN_OR_EQUAL:
            case LESS_THAN:
            case RETURN:
            case EQUALS:
            case SUBTRACT:
            case END_WHILE:
            case START_WHILE:
            case INPUT:
            case END_THEN:
            case IF:
            case RIGHT_PARENTHESIS:
            case RIGHT_BRACKET:
            case ID:
            case END_PROGRAM:
            case ADD:
                return yyr19();
        }
        return 189;
    }

    private int yys30() {
        switch (yytok) {
            case REAL_DECL:
            case LEFT_BRACKET:
            case START_PROGRAM:
            case REAL_LITERAL:
            case ELSE:
            case LEFT_PARENTHESIS:
            case STRING_LITERAL:
            case START_THEN:
            case START_FUNCTION_STATEMENTS:
            case ARRAY_DECL:
            case PARAMETER_COMMA:
            case ASSIGN:
            case END_FUNCTION_STATEMENTS:
            case ENDINPUT:
            case error:
            case INT_LITERAL:
            case STRING_DECL:
            case INTEGER_DECL:
            case ELIF:
                return 189;
        }
        return yyr26();
    }

    private int yys31() {
        switch (yytok) {
            case DIVIDE:
                return 49;
            case MULTIPLY:
                return 50;
            case GREATER_THAN_OR_EQUAL:
            case GREATER_THAN:
            case OUTPUT:
            case NOT_EQUALS:
            case FUNCTION_DEF:
            case LESS_THAN_OR_EQUAL:
            case LESS_THAN:
            case RETURN:
            case EQUALS:
            case SUBTRACT:
            case END_WHILE:
            case START_WHILE:
            case INPUT:
            case END_THEN:
            case IF:
            case RIGHT_PARENTHESIS:
            case RIGHT_BRACKET:
            case ID:
            case END_PROGRAM:
            case ADD:
                return yyr18();
        }
        return 189;
    }

    private int yys32() {
        switch (yytok) {
            case INTEGER_DECL:
            case START_FUNCTION_STATEMENTS:
            case START_PROGRAM:
            case ELIF:
            case ELSE:
            case ARRAY_DECL:
            case STRING_LITERAL:
            case START_THEN:
            case REAL_LITERAL:
            case REAL_DECL:
            case PARAMETER_COMMA:
            case ASSIGN:
            case END_FUNCTION_STATEMENTS:
            case ENDINPUT:
            case error:
            case INT_LITERAL:
            case STRING_DECL:
                return 189;
            case LEFT_PARENTHESIS:
                return 22;
            case LEFT_BRACKET:
                return 45;
        }
        return yyr12();
    }

    private int yys33() {
        switch (yytok) {
            case REAL_DECL:
            case LEFT_BRACKET:
            case START_PROGRAM:
            case REAL_LITERAL:
            case ELSE:
            case LEFT_PARENTHESIS:
            case STRING_LITERAL:
            case START_THEN:
            case START_FUNCTION_STATEMENTS:
            case ARRAY_DECL:
            case PARAMETER_COMMA:
            case ASSIGN:
            case END_FUNCTION_STATEMENTS:
            case ENDINPUT:
            case error:
            case INT_LITERAL:
            case STRING_DECL:
            case INTEGER_DECL:
            case ELIF:
                return 189;
        }
        return yyr28();
    }

    private int yys35() {
        switch (yytok) {
            case REAL_DECL:
            case LEFT_BRACKET:
            case START_PROGRAM:
            case REAL_LITERAL:
            case ELSE:
            case LEFT_PARENTHESIS:
            case STRING_LITERAL:
            case START_THEN:
            case START_FUNCTION_STATEMENTS:
            case ARRAY_DECL:
            case PARAMETER_COMMA:
            case ASSIGN:
            case END_FUNCTION_STATEMENTS:
            case ENDINPUT:
            case error:
            case INT_LITERAL:
            case STRING_DECL:
            case INTEGER_DECL:
            case ELIF:
                return 189;
        }
        return yyr27();
    }

    private int yys36() {
        switch (yytok) {
            case RETURN:
            case OUTPUT:
            case FUNCTION_DEF:
            case END_WHILE:
            case START_WHILE:
            case INPUT:
            case END_THEN:
            case IF:
            case ID:
            case END_PROGRAM:
                return yyr33();
        }
        return 189;
    }

    private int yys37() {
        switch (yytok) {
            case FUNCTION_DEF:
                return 12;
            case ID:
                return 13;
            case IF:
                return 14;
            case INPUT:
                return 15;
            case OUTPUT:
                return 16;
            case START_WHILE:
                return 17;
            case EQUALS:
                return 53;
            case NOT_EQUALS:
                return 54;
        }
        return 189;
    }

    private int yys38() {
        switch (yytok) {
            case ADD:
                return 46;
            case SUBTRACT:
                return 47;
            case GREATER_THAN_OR_EQUAL:
            case GREATER_THAN:
            case OUTPUT:
            case NOT_EQUALS:
            case FUNCTION_DEF:
            case LESS_THAN_OR_EQUAL:
            case LESS_THAN:
            case EQUALS:
            case START_WHILE:
            case INPUT:
            case IF:
            case RIGHT_PARENTHESIS:
            case ID:
                return yyr55();
        }
        return 189;
    }

    private int yys39() {
        switch (yytok) {
            case GREATER_THAN:
                return 55;
            case GREATER_THAN_OR_EQUAL:
                return 56;
            case LESS_THAN:
                return 57;
            case LESS_THAN_OR_EQUAL:
                return 58;
            case OUTPUT:
            case NOT_EQUALS:
            case FUNCTION_DEF:
            case EQUALS:
            case START_WHILE:
            case INPUT:
            case IF:
            case RIGHT_PARENTHESIS:
            case ID:
                return yyr50();
        }
        return 189;
    }

    private int yys41() {
        switch (yytok) {
            case ADD:
                return 46;
            case SUBTRACT:
                return 47;
            case RETURN:
            case OUTPUT:
            case FUNCTION_DEF:
            case END_WHILE:
            case START_WHILE:
            case INPUT:
            case END_THEN:
            case IF:
            case ID:
            case END_PROGRAM:
                return yyr29();
        }
        return 189;
    }

    private int yys52() {
        switch (yytok) {
            case FUNCTION_DEF:
                return 12;
            case ID:
                return 13;
            case IF:
                return 14;
            case INPUT:
                return 15;
            case OUTPUT:
                return 16;
            case START_WHILE:
                return 17;
            case END_WHILE:
                return 71;
        }
        return 189;
    }

    private int yys62() {
        switch (yytok) {
            case GREATER_THAN_OR_EQUAL:
            case GREATER_THAN:
            case OUTPUT:
            case NOT_EQUALS:
            case FUNCTION_DEF:
            case LESS_THAN_OR_EQUAL:
            case LESS_THAN:
            case RETURN:
            case EQUALS:
            case SUBTRACT:
            case END_WHILE:
            case START_WHILE:
            case INPUT:
            case END_THEN:
            case IF:
            case RIGHT_PARENTHESIS:
            case RIGHT_BRACKET:
            case ID:
            case END_PROGRAM:
            case ADD:
                return yyr42();
        }
        return 189;
    }

    private int yys65() {
        switch (yytok) {
            case DIVIDE:
                return 49;
            case MULTIPLY:
                return 50;
            case GREATER_THAN_OR_EQUAL:
            case GREATER_THAN:
            case OUTPUT:
            case NOT_EQUALS:
            case FUNCTION_DEF:
            case LESS_THAN_OR_EQUAL:
            case LESS_THAN:
            case RETURN:
            case EQUALS:
            case SUBTRACT:
            case END_WHILE:
            case START_WHILE:
            case INPUT:
            case END_THEN:
            case IF:
            case RIGHT_PARENTHESIS:
            case RIGHT_BRACKET:
            case ID:
            case END_PROGRAM:
            case ADD:
                return yyr16();
        }
        return 189;
    }

    private int yys66() {
        switch (yytok) {
            case DIVIDE:
                return 49;
            case MULTIPLY:
                return 50;
            case GREATER_THAN_OR_EQUAL:
            case GREATER_THAN:
            case OUTPUT:
            case NOT_EQUALS:
            case FUNCTION_DEF:
            case LESS_THAN_OR_EQUAL:
            case LESS_THAN:
            case RETURN:
            case EQUALS:
            case SUBTRACT:
            case END_WHILE:
            case START_WHILE:
            case INPUT:
            case END_THEN:
            case IF:
            case RIGHT_PARENTHESIS:
            case RIGHT_BRACKET:
            case ID:
            case END_PROGRAM:
            case ADD:
                return yyr17();
        }
        return 189;
    }

    private int yys67() {
        switch (yytok) {
            case REAL_DECL:
            case LEFT_BRACKET:
            case START_PROGRAM:
            case REAL_LITERAL:
            case ELSE:
            case LEFT_PARENTHESIS:
            case STRING_LITERAL:
            case START_THEN:
            case START_FUNCTION_STATEMENTS:
            case ARRAY_DECL:
            case PARAMETER_COMMA:
            case ASSIGN:
            case END_FUNCTION_STATEMENTS:
            case ENDINPUT:
            case error:
            case INT_LITERAL:
            case STRING_DECL:
            case INTEGER_DECL:
            case ELIF:
                return 189;
        }
        return yyr23();
    }

    private int yys68() {
        switch (yytok) {
            case REAL_DECL:
            case LEFT_BRACKET:
            case START_PROGRAM:
            case REAL_LITERAL:
            case LEFT_PARENTHESIS:
            case ENDINPUT:
            case STRING_LITERAL:
            case START_THEN:
            case START_FUNCTION_STATEMENTS:
            case ARRAY_DECL:
            case ELSE:
            case PARAMETER_COMMA:
            case END_FUNCTION_STATEMENTS:
            case ASSIGN:
            case error:
            case INT_LITERAL:
            case STRING_DECL:
            case INTEGER_DECL:
            case ELIF:
                return 189;
            case EXPONENT:
                return 48;
        }
        return yyr21();
    }

    private int yys69() {
        switch (yytok) {
            case REAL_DECL:
            case LEFT_BRACKET:
            case START_PROGRAM:
            case REAL_LITERAL:
            case LEFT_PARENTHESIS:
            case ENDINPUT:
            case STRING_LITERAL:
            case START_THEN:
            case START_FUNCTION_STATEMENTS:
            case ARRAY_DECL:
            case ELSE:
            case PARAMETER_COMMA:
            case END_FUNCTION_STATEMENTS:
            case ASSIGN:
            case error:
            case INT_LITERAL:
            case STRING_DECL:
            case INTEGER_DECL:
            case ELIF:
                return 189;
            case EXPONENT:
                return 48;
        }
        return yyr20();
    }

    private int yys70() {
        switch (yytok) {
            case REAL_DECL:
            case LEFT_BRACKET:
            case START_PROGRAM:
            case REAL_LITERAL:
            case ELSE:
            case LEFT_PARENTHESIS:
            case STRING_LITERAL:
            case START_THEN:
            case START_FUNCTION_STATEMENTS:
            case ARRAY_DECL:
            case PARAMETER_COMMA:
            case ASSIGN:
            case END_FUNCTION_STATEMENTS:
            case ENDINPUT:
            case error:
            case INT_LITERAL:
            case STRING_DECL:
            case INTEGER_DECL:
            case ELIF:
                return 189;
        }
        return yyr25();
    }

    private int yys71() {
        switch (yytok) {
            case RETURN:
            case OUTPUT:
            case FUNCTION_DEF:
            case END_WHILE:
            case START_WHILE:
            case INPUT:
            case END_THEN:
            case IF:
            case ID:
            case END_PROGRAM:
                return yyr30();
        }
        return 189;
    }

    private int yys72() {
        switch (yytok) {
            case GREATER_THAN:
                return 55;
            case GREATER_THAN_OR_EQUAL:
                return 56;
            case LESS_THAN:
                return 57;
            case LESS_THAN_OR_EQUAL:
                return 58;
            case OUTPUT:
            case NOT_EQUALS:
            case FUNCTION_DEF:
            case EQUALS:
            case START_WHILE:
            case INPUT:
            case IF:
            case RIGHT_PARENTHESIS:
            case ID:
                return yyr48();
        }
        return 189;
    }

    private int yys73() {
        switch (yytok) {
            case GREATER_THAN:
                return 55;
            case GREATER_THAN_OR_EQUAL:
                return 56;
            case LESS_THAN:
                return 57;
            case LESS_THAN_OR_EQUAL:
                return 58;
            case OUTPUT:
            case NOT_EQUALS:
            case FUNCTION_DEF:
            case EQUALS:
            case START_WHILE:
            case INPUT:
            case IF:
            case RIGHT_PARENTHESIS:
            case ID:
                return yyr49();
        }
        return 189;
    }

    private int yys74() {
        switch (yytok) {
            case ADD:
                return 46;
            case SUBTRACT:
                return 47;
            case GREATER_THAN_OR_EQUAL:
            case GREATER_THAN:
            case OUTPUT:
            case NOT_EQUALS:
            case FUNCTION_DEF:
            case LESS_THAN_OR_EQUAL:
            case LESS_THAN:
            case EQUALS:
            case START_WHILE:
            case INPUT:
            case IF:
            case RIGHT_PARENTHESIS:
            case ID:
                return yyr51();
        }
        return 189;
    }

    private int yys75() {
        switch (yytok) {
            case ADD:
                return 46;
            case SUBTRACT:
                return 47;
            case GREATER_THAN_OR_EQUAL:
            case GREATER_THAN:
            case OUTPUT:
            case NOT_EQUALS:
            case FUNCTION_DEF:
            case LESS_THAN_OR_EQUAL:
            case LESS_THAN:
            case EQUALS:
            case START_WHILE:
            case INPUT:
            case IF:
            case RIGHT_PARENTHESIS:
            case ID:
                return yyr52();
        }
        return 189;
    }

    private int yys76() {
        switch (yytok) {
            case ADD:
                return 46;
            case SUBTRACT:
                return 47;
            case GREATER_THAN_OR_EQUAL:
            case GREATER_THAN:
            case OUTPUT:
            case NOT_EQUALS:
            case FUNCTION_DEF:
            case LESS_THAN_OR_EQUAL:
            case LESS_THAN:
            case EQUALS:
            case START_WHILE:
            case INPUT:
            case IF:
            case RIGHT_PARENTHESIS:
            case ID:
                return yyr53();
        }
        return 189;
    }

    private int yys77() {
        switch (yytok) {
            case ADD:
                return 46;
            case SUBTRACT:
                return 47;
            case GREATER_THAN_OR_EQUAL:
            case GREATER_THAN:
            case OUTPUT:
            case NOT_EQUALS:
            case FUNCTION_DEF:
            case LESS_THAN_OR_EQUAL:
            case LESS_THAN:
            case EQUALS:
            case START_WHILE:
            case INPUT:
            case IF:
            case RIGHT_PARENTHESIS:
            case ID:
                return yyr54();
        }
        return 189;
    }

    private int yys81() {
        switch (yytok) {
            case FUNCTION_DEF:
                return 12;
            case ID:
                return 13;
            case IF:
                return 14;
            case INPUT:
                return 15;
            case OUTPUT:
                return 16;
            case START_WHILE:
                return 17;
        }
        return 189;
    }

    private int yys82() {
        switch (yytok) {
            case REAL_DECL:
            case ELIF:
            case START_PROGRAM:
            case REAL_LITERAL:
            case ELSE:
            case LEFT_BRACKET:
            case STRING_LITERAL:
            case START_THEN:
            case START_FUNCTION_STATEMENTS:
            case ARRAY_DECL:
            case END_FUNCTION_STATEMENTS:
            case ASSIGN:
            case ENDINPUT:
            case LEFT_PARENTHESIS:
            case error:
            case INT_LITERAL:
            case STRING_DECL:
            case INTEGER_DECL:
                return 189;
        }
        return yyr11();
    }

    private int yys84() {
        switch (yytok) {
            case FUNCTION_DEF:
                return 12;
            case ID:
                return 13;
            case IF:
                return 14;
            case INPUT:
                return 15;
            case OUTPUT:
                return 16;
            case START_WHILE:
                return 17;
        }
        return 189;
    }

    private int yys85() {
        switch (yytok) {
            case FUNCTION_DEF:
                return 12;
            case ID:
                return 13;
            case IF:
                return 14;
            case INPUT:
                return 15;
            case OUTPUT:
                return 16;
            case START_WHILE:
                return 17;
            case END_THEN:
                return 87;
        }
        return 189;
    }

    private int yys86() {
        switch (yytok) {
            case FUNCTION_DEF:
                return 12;
            case ID:
                return 13;
            case IF:
                return 14;
            case INPUT:
                return 15;
            case OUTPUT:
                return 16;
            case START_WHILE:
                return 17;
            case RETURN:
                return 88;
        }
        return 189;
    }

    private int yys87() {
        switch (yytok) {
            case RETURN:
            case OUTPUT:
            case FUNCTION_DEF:
            case END_WHILE:
            case START_WHILE:
            case INPUT:
            case END_THEN:
            case IF:
            case ID:
            case END_PROGRAM:
                return yyr38();
        }
        return 189;
    }

    private int yys92() {
        switch (yytok) {
            case RETURN:
            case OUTPUT:
            case FUNCTION_DEF:
            case END_WHILE:
            case START_WHILE:
            case INPUT:
            case END_THEN:
            case IF:
            case ID:
            case END_PROGRAM:
                return yyr45();
        }
        return 189;
    }

    private int yyr1() { // program : START_PROGRAM stmnt_list END_PROGRAM
        {

                        }
        yysv[yysp-=3] = yyrv;
        return 1;
    }

    private int yyr29() { // assignment : ID ASSIGN expr
        yysp -= 3;
        return 3;
    }

    private int yyr48() { // equality : equality EQUALS relational
        yysp -= 3;
        return yypequality();
    }

    private int yyr49() { // equality : equality NOT_EQUALS relational
        yysp -= 3;
        return yypequality();
    }

    private int yyr50() { // equality : relational
        yysp -= 1;
        return yypequality();
    }

    private int yypequality() {
        switch (yyst[yysp-1]) {
            case 17: return 37;
            default: return 44;
        }
    }

    private int yyr25() { // exp : LEFT_PARENTHESIS expr RIGHT_PARENTHESIS
        yysp -= 3;
        return yypexp();
    }

    private int yyr26() { // exp : ref
        yysp -= 1;
        return yypexp();
    }

    private int yyr27() { // exp : REAL_LITERAL
        yysp -= 1;
        return yypexp();
    }

    private int yyr28() { // exp : INT_LITERAL
        yysp -= 1;
        return yypexp();
    }

    private int yypexp() {
        switch (yyst[yysp-1]) {
            case 48: return 67;
            default: return 26;
        }
    }

    private int yyr16() { // expr : expr ADD term
        yysp -= 3;
        return yypexpr();
    }

    private int yyr17() { // expr : expr SUBTRACT term
        yysp -= 3;
        return yypexpr();
    }

    private int yyr18() { // expr : term
        yysp -= 1;
        return yypexpr();
    }

    private int yyr19() { // expr : function_call
        yysp -= 1;
        return yypexpr();
    }

    private int yypexpr() {
        switch (yyst[yysp-1]) {
            case 89: return 90;
            case 58: return 77;
            case 57: return 76;
            case 56: return 75;
            case 55: return 74;
            case 45: return 64;
            case 34: return 51;
            case 21: return 41;
            case 16: return 27;
            default: return 38;
        }
    }

    private int yyr23() { // factor : factor EXPONENT exp
        yysp -= 3;
        return yypfactor();
    }

    private int yyr24() { // factor : exp
        yysp -= 1;
        return yypfactor();
    }

    private int yypfactor() {
        switch (yyst[yysp-1]) {
            case 50: return 69;
            case 49: return 68;
            default: return 28;
        }
    }

    private int yyr42() { // function_call : ID LEFT_PARENTHESIS ref_list RIGHT_PARENTHESIS
        yysp -= 4;
        switch (yyst[yysp-1]) {
            case 86: return 4;
            case 85: return 4;
            case 84: return 4;
            case 81: return 4;
            case 52: return 4;
            case 37: return 4;
            case 10: return 4;
            case 2: return 4;
            default: return 29;
        }
    }

    private int yyr45() { // function_def : FUNCTION_DEF ID LEFT_PARENTHESIS parameter_list RIGHT_PARENTHESIS START_FUNCTION_STATEMENTS stmnt_list RETURN LEFT_PARENTHESIS expr RIGHT_PARENTHESIS END_FUNCTION_STATEMENTS
        yysp -= 12;
        return 5;
    }

    private int yyr38() { // if_statement : IF LEFT_PARENTHESIS equality RIGHT_PARENTHESIS START_THEN stmnt_list END_THEN
        yysp -= 7;
        return 6;
    }

    private int yyr31() { // input : INPUT ref
        yysp -= 2;
        return 7;
    }

    private int yyr32() { // output : OUTPUT expr
        yysp -= 2;
        return 8;
    }

    private int yyr33() { // output : OUTPUT STRING_LITERAL
        yysp -= 2;
        return 8;
    }

    private int yyr46() { // parameter_list : parameter_list PARAMETER_COMMA ID
        yysp -= 3;
        return 59;
    }

    private int yyr47() { // parameter_list : ID
        yysp -= 1;
        return 59;
    }

    private int yyr11() { // ref : ID LEFT_BRACKET expr RIGHT_BRACKET
        yysp -= 4;
        return yypref();
    }

    private int yyr12() { // ref : ID
        yysp -= 1;
        return yypref();
    }

    private int yypref() {
        switch (yyst[yysp-1]) {
            case 61: return 80;
            case 22: return 42;
            case 15: return 24;
            default: return 30;
        }
    }

    private int yyr43() { // ref_list : ref_list PARAMETER_COMMA ref
        yysp -= 3;
        return 43;
    }

    private int yyr44() { // ref_list : ref
        yysp -= 1;
        return 43;
    }

    private int yyr51() { // relational : relational GREATER_THAN expr
        yysp -= 3;
        return yyprelational();
    }

    private int yyr52() { // relational : relational GREATER_THAN_OR_EQUAL expr
        yysp -= 3;
        return yyprelational();
    }

    private int yyr53() { // relational : relational LESS_THAN expr
        yysp -= 3;
        return yyprelational();
    }

    private int yyr54() { // relational : relational LESS_THAN_OR_EQUAL expr
        yysp -= 3;
        return yyprelational();
    }

    private int yyr55() { // relational : expr
        yysp -= 1;
        return yyprelational();
    }

    private int yyprelational() {
        switch (yyst[yysp-1]) {
            case 54: return 73;
            case 53: return 72;
            default: return 39;
        }
    }

    private int yyr4() { // statement : assignment
        yysp -= 1;
        return yypstatement();
    }

    private int yyr5() { // statement : while_statement
        yysp -= 1;
        return yypstatement();
    }

    private int yyr6() { // statement : input
        yysp -= 1;
        return yypstatement();
    }

    private int yyr7() { // statement : output
        yysp -= 1;
        return yypstatement();
    }

    private int yyr8() { // statement : if_statement
        yysp -= 1;
        return yypstatement();
    }

    private int yyr9() { // statement : function_call
        yysp -= 1;
        return yypstatement();
    }

    private int yyr10() { // statement : function_def
        yysp -= 1;
        return yypstatement();
    }

    private int yypstatement() {
        switch (yyst[yysp-1]) {
            case 84: return 9;
            case 81: return 9;
            case 37: return 9;
            case 2: return 9;
            default: return 18;
        }
    }

    private int yyr2() { // stmnt_list : stmnt_list statement
        yysp -= 2;
        return yypstmnt_list();
    }

    private int yyr3() { // stmnt_list : statement
        yysp -= 1;
        return yypstmnt_list();
    }

    private int yypstmnt_list() {
        switch (yyst[yysp-1]) {
            case 81: return 85;
            case 37: return 52;
            case 2: return 10;
            default: return 86;
        }
    }

    private int yyr20() { // term : term MULTIPLY factor
        yysp -= 3;
        return yypterm();
    }

    private int yyr21() { // term : term DIVIDE factor
        yysp -= 3;
        return yypterm();
    }

    private int yyr22() { // term : factor
        yysp -= 1;
        return yypterm();
    }

    private int yypterm() {
        switch (yyst[yysp-1]) {
            case 47: return 66;
            case 46: return 65;
            default: return 31;
        }
    }

    private int yyr30() { // while_statement : START_WHILE equality stmnt_list END_WHILE
        yysp -= 4;
        return 11;
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
