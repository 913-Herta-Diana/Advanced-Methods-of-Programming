package model.statements;

import exceptions.MyException;
import model.adt.MyIStack;
import model.expressions.IExp;
import model.PrgState;
import model.types.IType;
import model.values.IValue;
import model.adt.MyIDictionary;
import model.adt.MyIList;


public class PrintStmt implements IStatement {
    IExp exp;

    public PrintStmt() {
    }

    public PrintStmt(IExp exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "print(" + exp.toString() + ")";
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIStack<IStatement> stk = state.getExeStack();
        MyIDictionary<String, IValue> symTable = state.getSymTable();
        MyIList<IValue> out = state.getOut();
        IValue val = exp.eval(symTable);
        out.add(val);
        return null;
    }

    @Override
    public IStatement deepCopy() {
        return new PrintStmt(exp.deepCopy());
    }
}
