package com.bitmoji;

public interface TypeHandler {



    public static Integer parseInt(Object node) {
        if (node instanceof BitmojiPT.PTNode) {
            return parseInt(((BitmojiPT.PTNode) node).evaluate());
        }
        if (node instanceof Integer) {
            return ((Integer) node);
        } else if (node instanceof Double) {
            return ((Number) node).intValue();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static Double parseDouble(Object node) {
        if (node instanceof BitmojiPT.PTNode) {
            return parseDouble(((BitmojiPT.PTNode) node).evaluate());
        }
        if (node instanceof Integer) {
            return ((Number) node).doubleValue();
        } else if (node instanceof Double) {
            return ((Double) node);
        } else {
            throw new IllegalArgumentException();
        }
    }

}
