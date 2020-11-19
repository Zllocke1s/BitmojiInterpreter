package com.bitmoji;

import java.util.ArrayList;

public class BitmojiPT {

    private Bitmoji parser;
    private SymbolTable globalSymbolTable;

    public BitmojiPT(Bitmoji parser) {
        this.parser = parser;
        globalSymbolTable = new SymbolTable();
    }

    public interface PTNode {
        public Object evaluate();
    }

    public abstract class StatementNode implements PTNode {
        // Nothing to see here!
    }

    public class StatementListNode implements PTNode {
        private ArrayList<StatementNode> statements;

        public StatementListNode() {
            statements = new ArrayList<>();
        }

        public StatementListNode(StatementNode statement) {
            this();
            statements.add(statement);
        }

        public boolean add(StatementNode statement) {
            return statements.add(statement);
        }

        @Override
        public Object evaluate() {
            // execute each statement
            for (StatementNode statement : statements) {
                statement.evaluate();
            }
            return null;
        }
    }

    public class ProgramNode implements PTNode {
        private final StatementListNode statementList;

        public ProgramNode(StatementListNode statementList) {
            this.statementList = statementList;
        }

        public Object evaluate() {
            statementList.evaluate();
            return null;
        }
    }

    public class AssignNode extends StatementNode
    {
        private String name;
        private PTNode expression;

        public AssignNode(String name, PTNode expression) {
            this.name = name;
            this.expression = expression;
        }

        @Override
        public Object evaluate() {
            ReferenceNode referenceNode = new ReferenceNode(name);
            referenceNode.setValue(expression);
            return null;
        }
    }

    public class ReferenceNode implements PTNode
    {
        private String name;

        ReferenceNode(String name) {
            this.name = name;
        }

        public void setValue(PTNode expression) {
            globalSymbolTable.assignValue(name, expression.evaluate());
        }

        @Override
        public Object evaluate() {
            return globalSymbolTable.getValue(name);
        }
    }

    public class BinaryOperatorNode implements PTNode
    {
        private Object left;
        private Object right;
        private String operator;

        public BinaryOperatorNode(Object left, Object right, String operator) {
            this.left = left;
            this.right = right;
            this.operator = operator;
        }

        @Override
        public Object evaluate() {
            //perform the operation
            Double left_value;
            Double right_value;
            try {
                left_value = TypeHandler.parseDouble(left);
                right_value = TypeHandler.parseDouble(right);
                Double result = switch (operator) {
                    case "-" -> left_value - right_value;
                    case "+" -> left_value + right_value;
                    case "*" -> left_value * right_value;
                    case "/" -> left_value / right_value;
                    case "**" -> Math.pow(left_value, right_value);
                    default -> (double) 0;
                };
                if (left instanceof Integer && right instanceof Integer) {
                    return ((Number) result).intValue();
                }
                return (Double) result;
            } catch (IllegalArgumentException ex) {
                parser.yyerror("Invalid type for binary operation.");
                System.exit(1);
            }
            return null;
        }
    }
}
