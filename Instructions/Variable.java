package BASIC_Interpreter.Instructions;

import BASIC_Interpreter.Variables.*;

public class Variable {
    private static String methods[] = {
        "dim",
    };

    public static boolean has(String name) {
        name = name.toLowerCase();
        for (String string : methods) {
            if(string.equals(name))
                return true;
        }
        return false;
    }

    public static int runInstrustion(String input) {
        String head = input.split(" ", 2)[0].toLowerCase();
        try {
            switch (head) {
                case "dim":
                    if(!dim(input.split(" ", 2)[1]))
                        return -2;
                    break;
                default:
                    if(input.split(" ", 3)[1].equals("=")){
                        if(Storage.storeValue(input.split(" ", 3)[0], input.split(" ", 3)[2]))
                            break;
                        else{
                            System.out.println("Syntax error!");
                        }
                    }else{
                        System.out.println("Invalid instruction!");
                    }

                    return -2;
            }
        } catch (Exception e) {
            System.out.println("Not enough options!");
            return -2;
        }
        
        return 0;
    }

    private static boolean dim(String optionString) {
        String[] options = optionString.split(" ");
        
        // Check options syntax
        if(
            options.length == 3 &&
            options[1].toLowerCase().equals("as")
        ){
            return Storage.newVar(options[2], options[0]);

        }else{
            System.out.println("Syntax error!");
            return false;
        }

        // return true;
    }
}
