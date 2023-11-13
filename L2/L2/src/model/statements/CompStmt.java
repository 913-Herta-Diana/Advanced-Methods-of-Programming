package model.statements;

import exceptions.MyException;
import model.PrgState;
import model.adt.MyIStack;

public class CompStmt implements IStatement{

    IStatement first;
    IStatement second;
    public CompStmt(IStatement fs,IStatement sn) {this.first=fs; this.second=sn;}

    @Override
    public String toString(){
        return "("+first.toString()+";"+second.toString()+")";
    }
   @Override
    public PrgState execute(PrgState state) throws MyException{
        MyIStack<IStatement> stk=state.getExeStack();
       stk.push(second);
       stk.push(first);
       return state;
    }

    @Override
    public IStatement deepCopy() {
        return new CompStmt(first.deepCopy(), second.deepCopy());
    }
}
