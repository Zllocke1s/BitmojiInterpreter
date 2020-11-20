package com.bitmoji;

public interface TypeHandler {

    static Integer parseInt(Object node) {
        if (node instanceof BitmojiPT.PTNode) {
            return parseInt(((BitmojiPT.PTNode) node).evaluate());
        }
        if (node instanceof Integer) {
            return ((Integer) node);
        } else if (node instanceof Double) {
            return ((Number) node).intValue();
        } else if (node instanceof String) {
            return Integer.parseInt((String) node);
        } else {
            throw new IllegalArgumentException();
        }
    }

    static Double parseDouble(Object node) {
        if (node instanceof BitmojiPT.PTNode) {
            return parseDouble(((BitmojiPT.PTNode) node).evaluate());
        }
        if (node instanceof Integer) {
            return ((Number) node).doubleValue();
        } else if (node instanceof Double) {
            return ((Double) node);
        } else if (node instanceof String) {
            return Double.parseDouble((String) node);
        } else {
            throw new IllegalArgumentException();
        }
    }

    static Boolean parseBoolean(Object node) {
        if (node instanceof BitmojiPT.PTNode) {
            return parseBoolean(((BitmojiPT.PTNode) node).evaluate());
        }
        if (node instanceof Boolean) {
            return ((Boolean) node);
        } else if (node instanceof String) {
            return Boolean.parseBoolean((String) node);
        } else {
            throw new IllegalArgumentException();
        }
    }

    static String parseString(Object node) {
        if (node instanceof BitmojiPT.PTNode) {
            return parseString(((BitmojiPT.PTNode) node).evaluate());
        }
        if (node instanceof Integer) {
            return ((Integer) node).toString();
        } else if (node instanceof Double) {
            return ((Double) node).toString();
        } else if (node instanceof String) {
            return ((String) node);
        } else if (node instanceof Boolean) {
            // TODO: If we add boolean literals, outputting their emojis would be done here.
            return ((Boolean) node).toString();
        } else {
            throw new IllegalArgumentException();
        }
    }

    static Object evaluate(Object node) {
        if (node instanceof BitmojiPT.PTNode) {
            return evaluate(((BitmojiPT.PTNode) node).evaluate());
        }
        return node;
    }
}
