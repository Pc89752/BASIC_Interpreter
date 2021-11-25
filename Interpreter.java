package BASIC_Interpreter;

import BASIC_Interpreter.Instructions.Common;
import BASIC_Interpreter.Instructions.Variable;
import BASIC_Interpreter.Variables.Storage;

public class Interpreter {
    public static int interprete(String input) {
        // Documentation
        if(input.charAt(0) == '\''){
            return 0;
        }

        // Run
        String[] inputArray = input.strip().split(" ", 2);
        if (Storage.has(inputArray[0])){
            return Variable.runInstrustion(input);
        } else if (Common.has(inputArray[0])) {
            return Common.runInstrustion(input);
        } else if (Variable.has(inputArray[0])) {
            return Variable.runInstrustion(input);
        }

        return -2;
    }
}
