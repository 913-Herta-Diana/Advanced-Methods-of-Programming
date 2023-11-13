package exceptions;

public class VariableNotDefinedException extends Exception{
    public VariableNotDefinedException(String errorMessage){
        super(errorMessage);
    }
}

