package BASIC_Interpreter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            ReadCode.readFile();
            System.out.print("Continue? (Y):");
        } while (sc.nextLine().toLowerCase().equals("y"));
        sc.close();
    }
}
