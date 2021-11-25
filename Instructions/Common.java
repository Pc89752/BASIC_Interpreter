package BASIC_Interpreter.Instructions;

import java.util.Scanner;

import BASIC_Interpreter.Variables.Storage;

public class Common {
    private static Scanner sc = new Scanner(System.in);
    private static String methods[] = {
        "cls",
        "end",
        "input",
        "print",
        "sleep",
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
                case "cls":
                    cls();
                    break;
                case "end":
                    return -1;
                case "input":
                    return input(input.split(" ", 2)[1]) ? 0 : -2;
                case "print":
                    if(input.split(" ", 2).length < 2){
                        System.out.println();
                        break;
                    }
                    else
                        return print(input.split(" ", 2)[1]) ? 0 : -2;
                case "sleep":
                    sleep();
                    break;
                default:
                    System.out.println("Invalid instruction!");
                    return -2;
            }
        } catch (Exception e) {
            System.out.println("Not enough options!");
            return -2;
        }
        
        return 0;
    }

    private static void cls() {
        try {
            System.out.print("\033[H\033[2J");  
            System.out.flush();
        } catch (Exception e) {
            e.printStackTrace();  
        }
    }

    private static boolean input(String inString) {
        String[] options = inString.strip().split((","));
        String prompt = options[0].strip();
        String varName = options[1].strip();
        print(prompt);

        try {
            Storage.storeValue(varName, sc.nextLine());
        } catch (Exception e) {
            System.out.println("Error!");
            return false;
        }

        return true;
    }

    private static boolean print(String outString){
        String[] parts = outString.strip().split(";");
        for (String string : parts) {
            string = string.strip();
            // Variable
            if(string.indexOf("\"") == -1){
                if(!Storage.print(string))
                    return false;
            }
            // Raw string
            else
                System.out.print(string.replace("\"", ""));
        }

        return true;
    }

    private static void sleep() {
        sc.nextLine();
    }
}
