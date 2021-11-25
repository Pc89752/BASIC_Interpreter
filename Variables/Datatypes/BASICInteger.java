package BASIC_Interpreter.Variables.Datatypes;

public class BASICInteger {
    public Integer value;

    public BASICInteger(Integer value){
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
