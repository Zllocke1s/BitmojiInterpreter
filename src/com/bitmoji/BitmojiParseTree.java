package com.bitmoji;

import java.util.ArrayList;

public class BitmojiParseTree {

    private Bitmoji parser;
    private SymbolTable globalSymbolTable;

    public BitmojiParseTree(Bitmoji parser) {
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
        private ReferenceNode referenceNode;
        private PTNode expression;

        public AssignNode(ReferenceNode referenceNode, PTNode expression) {
            this.referenceNode = referenceNode;
            this.expression = expression;
        }

        @Override
        public Object evaluate() {
            this.referenceNode.setValue(expression);
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
        private PTNode left;
        private PTNode right;
        private String operator;

        public BinaryOperatorNode(PTNode left, PTNode right, String operator) {
            this.left = left;
            this.right = right;
            this.operator = operator;
        }

        @Override
        public Object evaluate() {
            //perform the operation
            Object left_eval = left.evaluate();
            Object right_eval = right.evaluate();
            Double left_val = ((Number) left_eval).doubleValue();
            Double right_val = ((Number) right_eval).doubleValue();

            Double result = (double) 0;

            switch (operator) {
                case "-":
                    result = left_val - right_val;
                    break;
                case "+":
                    result = left_val + right_val;
                    break;
                case "*":
                    result = left_val * right_val;
                    break;
                case "/":
                    result = left_val / right_val;
                    break;
                case "**":
                    result =  Math.pow(left_val, right_val);
                    break;
            }
            if (left_eval instanceof BMInteger && right_eval instanceof BMInteger) {
                return result.intValue();
            }
            return result;
        }
    }

    public class BMInteger implements PTNode
    {
        private Integer number;

        public BMInteger(Integer number) {
            this.number = number;
        }

        @Override
        public Object evaluate() {
            return number;
        }
    }

    public class BMReal implements PTNode
    {
        private Double number;

        public BMReal(Double number) {
            this.number = number;
        }

        @Override
        public Object evaluate() {
            return number;
        }
    }
}
