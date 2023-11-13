package model.statements;

import exceptions.MyException;
import model.PrgState;

public class NopStmt implements IStatement{
    public NopStmt(){};
    @Override
    public String toString(){
     return "nop";
    }
    public PrgState execute(PrgState state) throws MyException{
        return null;
    }

    @Override
    public IStatement deepCopy() {
        return new NopStmt();
    }
}
