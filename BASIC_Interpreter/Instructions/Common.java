package BASIC_Interpreter.Instructions;

import java.util.Scanner;

public class Common {
    private static Scanner sc = new Scanner(System.in);
    
    public static int runInstrustion(String[] input) {

        try {
            switch (input[0].strip().toLowerCase()) {
                case "cls":
                    cls();
                    break;
                case "print":
                    print(input[1]);
                    break;
                case "sleep":
                    sleep();
                    break;
                case "end":
                    return -1;
                
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

    private static void print(String outString){
        System.out.println(outString);
    }

    private static void sleep() {
        sc.nextLine();
    }
}
