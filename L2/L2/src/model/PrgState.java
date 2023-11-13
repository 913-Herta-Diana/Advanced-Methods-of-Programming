package model;

import model.adt.MyIDictionary;
import model.adt.MyIList;
import model.adt.MyIStack;
import model.statements.IStatement;
import model.values.IValue;

public class PrgState {
    MyIStack<IStatement> exeStack;
    MyIDictionary<String, IValue> symTable;
    MyIList<IValue> out;
    public void setOut(MyIList<IValue> out) {
        this.out = out;
    }

    public void setSymTable(MyIDictionary<String, IValue> symTable) {
        this.symTable = symTable;
    }

    public void setExeStack(MyIStack<IStatement> exeStack) {
        this.exeStack = exeStack;
    }

    IStatement originalProgram;

    public PrgState(MyIStack<IStatement> stk, MyIDictionary<String,IValue> symbtbl, MyIList<IValue> ot, IStatement prg){
        exeStack=stk;
        symTable=symbtbl;
        out=ot;
        originalProgram=prg.deepCopy();
        stk.push(prg);
    }


    public MyIStack<IStatement> getExeStack() {
        return exeStack;
    }

    public MyIDictionary<String, IValue> getSymTable() {
        return symTable;
    }

    public MyIList<IValue> getOut() {
        return out;
    }



    @Override
    public String toString() {
        return "PrgState{" +
                "exeStack=" + exeStack +
                ", symTable=" + symTable +
                ", out=" + out +
                '}';
    }
}
