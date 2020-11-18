package com.bitmoji;

public class BitmojiParseTree {

    //used for error reporting
    private BitmojiParser parser;

    //symbol table
    private SymbolTable sym;

    public interface PTNode {
        public Object evaluate();
    }


}
