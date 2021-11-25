package BASIC_Interpreter.Variables.Datatypes;

public class BASICString {
    public String value;
    public BASICString(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
