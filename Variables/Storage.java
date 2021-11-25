package BASIC_Interpreter.Variables;

import java.util.HashMap;
import java.util.Map;

import BASIC_Interpreter.Variables.Datatypes.BASICInteger;
import BASIC_Interpreter.Variables.Datatypes.BASICString;

public class Storage {
    private static Map<String, String> varNames = new HashMap<>();
    private static Map<String, BASICInteger> integers = new HashMap<>();
    private static Map<String, BASICString> strings = new HashMap<>();

    public static boolean has(String name) {
        if (varNames.get(name) != null)
            return true;
        return false;
    }

    public static boolean print(String name) {
        String outString;
        switch (varNames.get(name)) {
            case "integer":
                outString = integers.get(name).toString();
                break;
            case "string":
                outString = strings.get(name).toString();
                break;
            default:
                System.out.println("Unknown variable!");
                return false;
        }

        System.out.print(outString);
        return true;
    }

    public static boolean storeValue(String name, String value) {
        String datatype = varNames.get(name);
        switch (datatype) {
            case "integer":
                if(!isInteger(value))
                    return false;
                integers.get(name).value = Integer.valueOf(value);
                break;
            case "string":
                strings.get(name).value = value;
                break;
            default:
                System.err.println("Unknown Error!");
                return false;
        }
        return true;
    }

    public static boolean newVar(String datatype, String name) {
        // Check if the name is used
        if(has(name)) {
            System.err.println("Variable duplicated!");
            return false;
        }


        // New variable
        datatype = datatype.toLowerCase();
        switch (datatype) {
            case "integer":
                integers.put(name, new BASICInteger(null));
                break;
            case "string":
                strings.put(name, new BASICString(null));
                break;
            default:
                System.out.println("Invalid datatype!");
                return false;
        }
        varNames.put(name, datatype);
        return true;
    }

    public static void clear() {
        varNames.clear();
        integers.clear();
        strings.clear();
    }

    private static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
