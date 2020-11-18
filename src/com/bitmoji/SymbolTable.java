package com.bitmoji;

public class SymbolTable implements BitmojiParseTree.PTNode
{
    //the map of objects
    private java.util.Map<String, Object> map;

    //creates an empty symbol table
    public SymbolTable() {
        //create the map for storing the symbols
        map = new java.util.HashMap<String, Object>();
    }


    //assigns a value to the symbol table, overwriting the previous value
    //if it was present
    public void assignValue(String name, Object value) {
        if(hasName(name)) {
            map.replace(name, value);
        } else {
            map.put(name, value);
        }
    }


    //gets the current value of the symbol
    public Object getValue(String name) {
        if(hasName(name)) {
            return map.get(name);
        }

        return null;
    }


    //returns true if the symbol is defined
    public boolean hasName(String name) {
        return map.containsKey(name);
    }


    //returns the set of symbols
    java.util.Set<String> getSymbols() {
        return map.keySet();
    }


    //test the symbol table
    public static void main(String [] args) {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        SymbolTable table = new SymbolTable();
        int choice;
        double v;
        String name="";

        do {
            //display the menu
            System.out.println("1.) Assign");
            System.out.println("2.) Lookup");
            System.out.println("3.) Quit");
            System.out.print("Choice? ");
            choice = scan.nextInt();

            if(choice != 3) {
                System.out.println("Name? ");
                name = scan.next();
            }

            if(choice == 1) {
                System.out.print("Value? ");
                v = scan.nextDouble();
                table.assignValue(name, v);
            } else if(choice ==2) {
                if(table.hasName(name)) {
                    System.out.println(table.getValue(name));
                } else {
                    System.out.println("Undefined");
                }
            }
        } while(choice != 3);
        scan.close();

        //print out the symbol table
        System.out.println("Symbol Table");
        for(String s : table.getSymbols()){
            System.out.printf("%s\t\t%s\n", s, table.getValue(s).toString());
        }
    }

    @Override
    public Object evaluate() {
        return this;
    }
}