package com.bitmoji;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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

    public class AssignNode extends StatementNode
    {
        private ReferenceNode node;
        private Object expression;

        public AssignNode(ReferenceNode name, Object expression) {
            this.node = name;
            this.expression = expression;
        }

        @Override
        public Object evaluate() {
            String name = node.name;
            Object index = node.index;
            if(index!=null)
            {
                ReferenceArrNode arrayNode = new ReferenceArrNode(name, index);
                arrayNode.setValue(this.expression);

            }
            else {
                ReferenceVarNode referenceNode = new ReferenceVarNode(name);
                referenceNode.setValue(this.expression);
            }
            return null;
        }
    }

    public abstract class ReferenceNode implements PTNode
    {
        protected String name;
        protected Object index;

        public abstract void setValue(Object expression);

        public abstract Object evaluate();
    }

    public class ReferenceVarNode extends ReferenceNode
    {

        ReferenceVarNode(String name) {
            this.name = name;
        }

        @Override
        public void setValue(Object expression) {
            globalSymbolTable.assignValue(name, TypeHandler.evaluate(expression));
        }

        @Override
        public Object evaluate() {
            return globalSymbolTable.getValue(name);
        }
    }

    public class ReferenceArrNode extends ReferenceNode
    {

        public ReferenceArrNode(String gName, Object gIndex)
        {
            name = gName;
            index = gIndex;
        }

        @Override
        public void setValue(Object expression) {
            if(globalSymbolTable.hasName(name))
            {
                HashMap<Object, Object>map = (HashMap<Object, Object>)globalSymbolTable.getValue(name);
                if(map.containsKey(TypeHandler.evaluate(index)))
                {
                    map.replace(TypeHandler.evaluate(index), TypeHandler.evaluate(expression));
                }
                else
                {
                    map.put(TypeHandler.evaluate(index), TypeHandler.evaluate(expression));
                }
                globalSymbolTable.assignValue(name, map);
            }
            else
            {
                HashMap<Object, Object> newMap = new HashMap<>();
                newMap.put(TypeHandler.evaluate(index), TypeHandler.evaluate(expression));
                globalSymbolTable.assignValue(name, newMap);
            }

        }

        @Override
        public Object evaluate() {
            return ((HashMap<Object, Object>)(globalSymbolTable.getValue(name))).get(TypeHandler.evaluate(index));
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

        private Number arithmeticEval() {
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
                    default -> null;
                };
                if (result != null) {
                    if (TypeHandler.evaluate(left) instanceof Integer && TypeHandler.evaluate(right) instanceof Integer) {
                        return ((Number) result).intValue();
                    }
                    return (Double) result;
                } else {
                    return null;
                }
            } catch (IllegalArgumentException ex) {
                return null;
            }
        }

        private Boolean conditionalEval() {
            //perform the operation
            Double left_value;
            Double right_value;
            try {
                left_value = TypeHandler.parseDouble(left);
                right_value = TypeHandler.parseDouble(right);
                Boolean result = switch (operator) {
                    case "==" -> left_value.equals(right_value);
                    case "!=" -> !left_value.equals(right_value);
                    case ">" -> left_value > right_value;
                    case ">=" -> left_value >= right_value;
                    case "<" -> left_value < right_value;
                    case "<=" -> left_value <= right_value;
                    default -> null;
                };
                return result;
            } catch (IllegalArgumentException ex) {
                return null;
            }
        }

        // TODO: Add concat eval for string '+' operator (Needs to run first and must check type)

        @Override
        public Object evaluate() {
            Boolean condition = conditionalEval();
            if (condition != null) {
                return condition;
            }
            Number result = arithmeticEval();
            if (result != null) {
                return result;
            } else {
                parser.yyerror("Type error");
                System.exit(1);
            }
            return null;
        }
    }

    public class OutputNode extends StatementNode
    {
        private Object node;
        private Boolean newline;

        public OutputNode(Object node, Boolean newline) {
            this.node = node;
            this.newline = newline;
        }

        @Override
        public Object evaluate() {
            if (newline) {
                System.out.println(TypeHandler.parseString(node));
            } else {
                System.out.print(TypeHandler.parseString(node));
            }
            return null;
        }
    }

    public class InputNode extends StatementNode
    {
        private ReferenceNode node;

        public InputNode(ReferenceNode node) {
            this.node = node;
        }

        @Override
        public Object evaluate() {
            node.setValue((new Scanner(System.in)).nextLine());
            return null;
        }
    }

    public class GroupNode implements PTNode
    {
        Object expression;

        public GroupNode(Object expression) {
            this.expression = expression;
        }

        @Override
        public Object evaluate() {
            return (TypeHandler.evaluate(expression));
        }
    }

    public class WhileLoopNode extends StatementNode
    {
        Object condition;
        StatementListNode statements;

        public WhileLoopNode(Object condition, StatementListNode statements) {
            this.condition = condition;
            this.statements = statements;
        }

        @Override
        public Object evaluate() {
            try {
                while (TypeHandler.parseBoolean(condition)) {
                    statements.evaluate();
                }
            } catch (IllegalArgumentException ex) {
                parser.yyerror("Not a valid boolean expression");
                System.exit(1);
            }
            return null;
        }
    }

    public class IfConditionNode extends StatementNode
    {
        Object condition;
        StatementListNode statements;

        public IfConditionNode(Object condition, StatementListNode statements) {
            this.condition = condition;
            this.statements = statements;
        }

        public boolean conditionEval() {
            return TypeHandler.parseBoolean(condition);
        }

        @Override
        public Object evaluate() {
            try {
                if (TypeHandler.parseBoolean(condition)) {
                    statements.evaluate();

                    return true;
                }
                else
                {
                    return false;
                }
            } catch (IllegalArgumentException ex) {
                parser.yyerror("Not a valid boolean expression");
                System.exit(1);
            }
            return null;
        }
    }
}
