package com.bitmoji;

public interface TypeHandler {

    public static boolean isBMInteger(Object node) {
        return (node instanceof BitmojiPT.BMInteger);
    }

    public static Integer parseInt(Object node) {
        if (node instanceof BitmojiPT.BMReal) {
            return ((Number) ((BitmojiPT.BMReal) node).evaluate()).intValue();
        } else if (node instanceof BitmojiPT.BMInteger) {
            return (Integer) ((BitmojiPT.BMInteger) node).evaluate();
        } else if (node instanceof Integer) {
            return ((Integer) node);
        } else if (node instanceof Double) {
            return ((Number) node).intValue();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static Double parseDouble(Object node) {
        if (node instanceof BitmojiPT.BMReal) {
            return (Double) ((BitmojiPT.BMReal) node).evaluate();
        } else if (node instanceof BitmojiPT.BMInteger) {
            return ((Number) ((BitmojiPT.BMInteger) node).evaluate()).doubleValue();
        } else if (node instanceof Integer) {
            return ((Number) node).doubleValue();
        } else if (node instanceof Double) {
            return ((Double) node);
        } else {
            throw new IllegalArgumentException();
        }
    }

}
