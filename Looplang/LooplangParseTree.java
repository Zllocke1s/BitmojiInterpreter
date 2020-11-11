import java.util.ArrayList;
import java.util.Scanner;

public class LooplangParseTree
{
    //symbol table for the parse tree
    private SymbolTable sym;

    //reference to the parser (mainly for error messages)
    private Looplang parser;

    //Construct a parse tree 
    public LooplangParseTree(Looplang parser)
    {
        sym = new SymbolTable();
        this.parser = parser;
    }


    //////////////////////////////////////////
    // Parse Tree Inner Classes
    //////////////////////////////////////////

    //Interface of Parse nodes
    public interface ParseNode 
    {
        public void print(String prefix);
        public Object evaluate();
        public String generate();
    }

    //abstract class for statements
    public abstract class StatementNode implements ParseNode{
        //this space left inentionally blank
    }


    //Statement List
    public class StatementListNode implements ParseNode
    {
        private ArrayList<StatementNode> statements;

        //create an empty statement list
        public StatementListNode() {
	    System.out.println("New construction of: " + this.getClass().toString());                    
            statements = new ArrayList<StatementNode>();
        }


        //create a statement list with one statement
        public StatementListNode(StatementNode statement) {
            this();

            add(statement);
        }


        //add a statement to the list
        public void add(StatementNode statement) {
            statements.add(statement);
        }


        //print the statement list
        public void print(String prefix) {
            for(StatementNode s : statements) {
                s.print("  "+prefix);
            }
        }


        //evaluate the statement list
        public Object evaluate() {
            for(StatementNode s : statements) {
                s.evaluate();
            }

            //statement lists have no return value
            return null;
        }


        //generate C code for the statements
        public String generate() {
            StringBuilder sb = new StringBuilder();

            for(StatementNode s : statements) {
                sb.append(s.generate());
                sb.append("\n");
            }
            return sb.toString();
        }
    }


    //Program node
    public class ProgramNode implements ParseNode
    {
        private StatementListNode slist;


        //create the program
        public ProgramNode(StatementListNode slist) {
	    System.out.println("New construction of: " + this.getClass().toString());                    
            this.slist=slist;
        }


        //evaluate the program 
        public Object evaluate() {
            slist.evaluate();

            return null;
        }


        //print the program
        public void print(String prefix) {
            slist.print(prefix);
        }


        //generate the program code
        public String generate() {
            StringBuilder sb = new StringBuilder();

            //include and main 
            sb.append("#include<stdio.h>\n");
            sb.append("int main()\n{\n");

            //declarations
            sb.append("int _i;\n");
            for(String name : sym.getSymbols()) {
                sb.append("int "+name+"[");
                sb.append(((int[])sym.getValue(name)).length);
                sb.append("];");
            }

            //the code
            sb.append(slist.generate());

            //the ending
            sb.append("return 0;\n}\n");

            return sb.toString();
        }    
    }


    //Array Declaration 
    public class ArrayDeclNode extends StatementNode
    {
        private String name;
        private Integer size;

        //create the array declaration
        public ArrayDeclNode(String name, Integer size) {
            System.out.println("New construction of: " + this.getClass().toString());                    
            this.name = name;
            this.size = size;

            //check for double declaration 
            if(sym.hasName(name)) {
                parser.yyerror("ERROR: Redeclaration of '"+name+"'");
                System.exit(-1);
            }

            //make a place holder in the symbol table
            sym.assignValue(name, new int [size]);
        }


        public void print(String prefix) {
            System.out.printf("%s%s[%d]\n", prefix, name, size);
        }


        public Object evaluate() {
            sym.assignValue(name, new int [size]);
            return null;
        }


        public String generate() {
            StringBuilder sb = new StringBuilder();

            //produce C-code to initialize the array
            sb.append("for(_i=0; _i<"+size+"; _i++) {\n");
            sb.append(String.format("    %s[_i]=0;\n", name));
            sb.append("}\n");

            return sb.toString();
        }
    }


    //While Loop Node
    public class WhileNode extends StatementNode
    {
        private RefNode condition;
        private StatementListNode body;

        //create a new while node
        public WhileNode(RefNode condition, StatementListNode body) {
            this.condition = condition;
            System.out.println("New construction of: " + this.getClass().toString());                    
            this.body = body;
        }


        //print the while loop out
        public void print(String prefix) {
            body.print(prefix+"    ");
            System.out.print(prefix+"while");
            condition.print(prefix+"  ");
        }


        public Object evaluate() {
            //run the body until the condition is false
            while((Integer)condition.evaluate() != 0) {
                body.evaluate();
            }
            return null;
        }


        public String generate() {
            StringBuilder sb = new StringBuilder();

            //generate the while loop
            sb.append("while((");
            sb.append(condition.generate());
            sb.append(") != 0) {\n");
            sb.append(body.generate());
            sb.append("}\n");

            return sb.toString();
        }
    }


    //Input Node
    public class InputNode extends StatementNode
    {
        private RefNode ref;

        //create a new input node
        public InputNode(RefNode ref) {
            System.out.println("New construction of: " + this.getClass().toString());                    
            this.ref = ref;
        }


        public void print(String prefix) {
            ref.print(prefix+"  ");
            System.out.println(prefix + "in");
        }


        public Object evaluate() {
            //read the next integer
            Scanner scan = new Scanner(System.in);
            ref.set(scan.nextInt());
            return null;
        }


        public String generate() {
            StringBuilder sb = new StringBuilder();

            sb.append("scanf(\"%d\", &");
            sb.append(ref.generate());
            sb.append(");\n");

            return sb.toString();
        }
    }


    //Output Node
    public class OutputNode extends StatementNode
    {
        private RefNode ref;

        //create a new input node
        public OutputNode(RefNode ref) {
            System.out.println("New construction of: " + this.getClass().toString());                    
            this.ref = ref;
        }


        public void print(String prefix) {
            ref.print(prefix+"  ");
            System.out.println(prefix + "out");
        }


        public Object evaluate() {
            System.out.println(ref.evaluate());
            return null;
        }


        public String generate() {
            StringBuilder sb = new StringBuilder();

            sb.append("printf(\"%d\\n\", ");
            sb.append(ref.generate());
            sb.append(");\n");

            return sb.toString();
        }
    }


    //assignment operation
    public class AssignNode extends StatementNode
    {
        RefNode v;  //the variable
        ParseNode expr;  //the expression

        //create an assignment node
        public AssignNode(RefNode v, ParseNode expr) {
            System.out.println("New construction of: " + this.getClass().toString());                    
            this.v =  v;
            this.expr = expr;
        }


        //evaluate the assignment node
        public Object evaluate() {
            //get the rhs
            Object rhs = expr.evaluate();

            //assign the value
            v.set((Integer) rhs);

            //the result
            return rhs;
        }


        //print out the assignment
        public void print(String prefix) {
            expr.print(prefix+"  ");
            System.out.println(prefix+"=");
            v.print(prefix+"  ");
        }


        public String generate() {
            StringBuilder sb = new StringBuilder();

            sb.append(v.generate());
            sb.append("=");
            sb.append(expr.generate());
            sb.append(";\n");
            return sb.toString();
        }
    }


    //Binary Operator Node
    public class BinOpNode implements ParseNode
    {
        protected ParseNode left;
        protected String op;
        protected ParseNode right;

        //construct the binary operator node
        public BinOpNode(ParseNode left, String op, ParseNode right) {
            this.left =  left;
            System.out.println("New construction of: " + this.getClass().toString());                    
            this.op = op;
            this.right = right;
        }

        public void print(String prefix) {
            right.print("  "+prefix);
            System.out.println(prefix + op);
            left.print("  " + prefix);
        }

        public Object evaluate() {
            Integer lval;
            Integer rval;

            //evaluate the operands
            lval = (Integer) left.evaluate();
            rval = (Integer) right.evaluate();

            //perform the operation
            switch(op) 
            {
                case "-":
                    return lval-rval;
            }

            //undefined, just return 0
            return Integer.valueOf(0);
        }


        public String generate() {
            StringBuilder sb = new StringBuilder();

            sb.append("(");
            sb.append(left.generate());
            sb.append(op);
            sb.append(right.generate());
            sb.append(")");

            return sb.toString();
        }
    }


   //represents a variable on the parse tree
   public class RefNode implements ParseNode
   {
        String name;
        ParseNode expr;

        //create the variable
        public RefNode(String name, ParseNode expr) {
            System.out.println("New construction of: " + this.getClass().toString());                    
            this.name = name;
            this.expr = expr;

            //check symbols
            if(!sym.hasName(name)) {
                parser.yyerror("ERROR: Undefined Reference " + name);
                System.exit(-1);
            }
        }

        //set the variable's value
        public void set(Integer value) {
            ((int[])sym.getValue(name))[(Integer) expr.evaluate()-1] = value;
        }

        //evaluate the varaible
        public Object evaluate() {
            //run the assignment (correcting for 1-based arrays)
            return ((int[]) sym.getValue(name))[(Integer) expr.evaluate()-1];
        }


        //print the variable
        public void print(String prefix) {
            expr.print(prefix+"  ");
            System.out.println(prefix + name);
        }


        public String generate() {
            StringBuilder sb = new StringBuilder();

            //generate the reference in C (correct for 1-based arrays)
            sb.append(name);
            sb.append("[(");
            sb.append(expr.generate());
            sb.append(")-1]");
            return sb.toString();
        }
    }




    //integer literal node
    public class LiteralNode implements ParseNode
    {
        Integer val;

        //create the literal
        public LiteralNode(Integer val) {
            System.out.println("New construction of: " + this.getClass().toString());                    
            this.val = val;
        }


        //evaluate the literal
        public Object evaluate()
        {
            return val;
        }


        //print the literal
        public void print(String prefix) {
            System.out.println(prefix + val.toString());
        }


        public String generate() {
            return val.toString();
        }
    }

}