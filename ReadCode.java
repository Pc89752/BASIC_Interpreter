package BASIC_Interpreter;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

import java.util.Scanner;

import java.util.Map;
import java.util.Map.Entry;

import BASIC_Interpreter.Variables.Storage;

import java.util.HashMap;

import java.util.ArrayList;
import java.util.List;

public class ReadCode {
    private static Scanner sc = new Scanner(System.in);
    
    public static void readFile() {
        BufferedReader br;
        Map<Integer, String> BASICMap = new HashMap<>();

        try {
            // Get file
            System.out.print("BASIC file path:");
            br = new BufferedReader(new FileReader(new File(sc.nextLine())));

            // Read file
            while (br.ready()){
                String line = br.readLine();
                String[] lineArray = line.split(" ", 2);
                BASICMap.put(Integer.valueOf(lineArray[0]), lineArray[1]);
            }
        } catch (Exception e) {
            System.out.println("Invalid file path");
            return;
        }
        
        // Run code, retrun:
        // -1: stop, others: goto
        List<Entry<Integer, String>> BASICList = new ArrayList<>(BASICMap.entrySet());
        BASICList.sort(Entry.comparingByKey());
        int entryPoint = 10;
        while (entryPoint != -1) {
            entryPoint = readLine(BASICList, entryPoint);
        }
        Storage.clear();
    }

    private static int readLine(List<Entry<Integer, String>> BASICList, int entryPoint) {
        boolean entryed = false;
        for (Entry<Integer, String> entry : BASICList) {
            // Find line
            if(entry.getKey() < entryPoint)
                continue;
            else if(!entryed && entry.getKey() > entryPoint){
                System.out.println(
                    "Cannot find line: "+ entryPoint+ " !\n"+
                    "Program interrupted.");
                return -1;
            }
            entryed = true;
            

            // Run
            int feedBack;
            feedBack = Interpreter.interprete(entry.getValue());
            switch (feedBack) {
                case 0:
                    break;
                case -2:
                    System.out.println(
                        "Error at line: "+ entry.getKey()+ " !\n"+
                        "Program interrupted."
                    );
                    return -1;
                default:
                    return feedBack;
            }
        }
        System.err.println("Error!");
        System.exit(1);
        return -1;
    }
}
