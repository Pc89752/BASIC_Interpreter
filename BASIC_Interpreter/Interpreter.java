package BASIC_Interpreter;

import BASIC_Interpreter.Instructions.Common;

public class Interpreter {
    public static int interprete(String input) {
        String[] inputArray = input.split("\"");

        return Common.runInstrustion(inputArray);
    }
}
