package com.bitmoji;

import java.util.*;

public class BitmojiPT {

    private Bitmoji parser;
    private LinkedList<SymbolTable> scopes;

    public BitmojiPT(Bitmoji parser) {
        this.parser = parser;
        scopes = new LinkedList<>();
        scopes.addLast(new SymbolTable());
    }

    public SymbolTable symbolTable() {
        return scopes.peekLast();
    }

    public SymbolTable globalSymbolTable() {
        return scopes.peekFirst();
    }

    public void addSymbolTable(SymbolTable st) {
        scopes.addLast(st);
    }

    public void removeSymbolTable() {
        scopes.removeLast();
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
            symbolTable().assignValue(name, TypeHandler.evaluate(expression));
        }

        @Override
        public Object evaluate() {
            return symbolTable().getValue(name);
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
            if (symbolTable().hasName(name)) {
                HashMap<Object, Object> map = (HashMap<Object, Object>) symbolTable().getValue(name);
                if (map.containsKey(TypeHandler.evaluate(index))) {
                    map.replace(TypeHandler.evaluate(index), TypeHandler.evaluate(expression));
                } else {
                    map.put(TypeHandler.evaluate(index), TypeHandler.evaluate(expression));
                }
                symbolTable().assignValue(name, map);
            }
            else {
                HashMap<Object, Object> newMap = new HashMap<>();
                newMap.put(TypeHandler.evaluate(index), TypeHandler.evaluate(expression));
                symbolTable().assignValue(name, newMap);
            }
        }

        @Override
        public Object evaluate() {
            return ((HashMap<Object, Object>) (symbolTable().getValue(name))).get(TypeHandler.evaluate(index));
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

        private String stringEval() {
            try {
                String s = ((String) left).concat((String) right);
                return s;
            }
            catch (Exception ex) {
                return null;
            }
        }

        @Override
        public Object evaluate() {
            Boolean condition = conditionalEval();
            if (condition != null) {
                return condition;
            }
            Number result = arithmeticEval();
            if (result != null) {
                return result;
            }
            String word = stringEval();
            if(word != null) {
                return word;
            } else {
                parser.yyerror("Cannot perform " + operator + " between " + TypeHandler.evaluate(left) + " and " + TypeHandler.evaluate(right));
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
                parser.yyerror(TypeHandler.evaluate(condition) + " not a valid boolean expression");
                System.exit(1);
            }
            return null;
        }
    }

    public class CastNode implements PTNode {
        protected Object value;

        public CastNode(Object value) {
            this.value = value;
        }

        @Override
        public Object evaluate() {
            return null;
        }
    }

    public class IntegerCastNode extends CastNode
    {
        public IntegerCastNode(Object value) {
            super(value);
        }

        @Override
        public Object evaluate() {
            return TypeHandler.parseInt(value);
        }
    }

    public class RealCastNode extends CastNode
    {
        public RealCastNode(Object value) {
            super(value);
        }

        @Override
        public Object evaluate() {
            return TypeHandler.parseDouble(value);
        }
    }

    public class StringCastNode extends CastNode
    {
        public StringCastNode(Object value) {
            super(value);
        }

        @Override
        public Object evaluate() {
            return TypeHandler.parseString(value);
        }
    }


    public class ConditionalBlockNode extends StatementNode
    {
        ArrayList<ConditionalNode> list;

        public ConditionalBlockNode()
        {
            list = new ArrayList<>();
        }

        public ConditionalBlockNode(Object condition, StatementListNode statements) {
            list = new ArrayList<>();
            list.add(new ConditionalNode(condition, statements));
        }

        public void addToList(ConditionalNode node) {
            list.add(node);
        }

        public void addToList(ElifBlockNode elseIfs)
        {
            ArrayList<ConditionalNode> elseIfStatements = elseIfs.getStatements();
            list.addAll(elseIfStatements);
        }

        @Override
        public Object evaluate() {
            for (ConditionalNode condition : list) {
                if((Boolean)condition.evaluate())
                {
                    break;
                }
            }
            return null;
        }
    }

    public class ElifBlockNode extends StatementNode
    {

        ArrayList<ConditionalNode> elseIfStatements;

        public ElifBlockNode(ConditionalNode elseIfStatement) {
            this.elseIfStatements = new ArrayList<>();
            elseIfStatements.add(elseIfStatement);
        }

        public void addToList(ConditionalNode newStatement) {
            elseIfStatements.add(newStatement);
        }

        public ArrayList<ConditionalNode> getStatements() {
            return elseIfStatements;
        }

        @Override
        public Object evaluate() {
            return null;
        }
    }



    public class ConditionalNode extends StatementNode
    {
        Object condition;
        StatementListNode statements;

        public ConditionalNode(Object condition, StatementListNode statements) {
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
                else {
                    return false;
                }
            } catch (IllegalArgumentException ex) {
                parser.yyerror(TypeHandler.evaluate(condition) + " not a valid boolean expression");
                System.exit(1);
            }
            return null;
        }
    }

    public class ParameterListNode implements PTNode
    {
        private ArrayList<String> parameters;

        public ParameterListNode() {
            this.parameters = new ArrayList<>();
        }

        public ParameterListNode(String parameter) {
            this();
            parameters.add(parameter);
        }

        public void add(String parameterName) {
            parameters.add(parameterName);
        }

        public ArrayList<String> getParameters() {
            return parameters;
        }

        @Override
        public Object evaluate() {
            return null;
        }
    }

    public class FunctionDefinitionNode extends StatementNode
    {
        private ParameterListNode parameterList;
        private String name;
        private StatementListNode statements;
        private Object returnExpression;

        public FunctionDefinitionNode(String name, ParameterListNode parameterList, StatementListNode statements, Object returnExpression) {
            this.name = name;
            this.parameterList = parameterList;
            this.statements = statements;
            this.returnExpression = returnExpression;
        }

        public StatementListNode getStatements() {
            return statements;
        }

        public ArrayList<String> getParameterNames() {
            return parameterList.getParameters();
        }

        public Object getReturnExpression() {
            return returnExpression;
        }

        @Override
        public Object evaluate() {
            globalSymbolTable().assignValue(name, this);
            return null;
        }
    }

    public class FunctionCallNode implements PTNode
    {
        ArrayList<Object> arguments;
        String name;

        public FunctionCallNode(String name, ArrayList<Object> arguments) {
            this.name = name;
            this.arguments = arguments;
        }

        @Override
        public Object evaluate() {
            FunctionDefinitionNode fd = (FunctionDefinitionNode) globalSymbolTable().getValue(name);
            ArrayList<String> parameterNames = fd.getParameterNames();
            if (arguments.size() != parameterNames.size()) {
                parser.yyerror("Parameter argument mismatch: " + arguments.size() + " arguments given " + parameterNames.size() + " expected.");
                System.exit(1);
            }
            SymbolTable st = new SymbolTable();
            for (int i = 0; i < arguments.size(); i++) {
                st.assignValue(parameterNames.get(i), TypeHandler.evaluate(arguments.get(i)));
            }
            addSymbolTable(st);
            fd.getStatements().evaluate();
            Object returnExpression = TypeHandler.evaluate(fd.getReturnExpression());
            removeSymbolTable();
            return returnExpression;
        }
    }
}
