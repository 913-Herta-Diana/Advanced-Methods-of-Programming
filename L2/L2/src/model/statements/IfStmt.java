package model.statements;

import exceptions.MyException;
import model.PrgState;
import model.adt.MyIDictionary;
import model.adt.MyIStack;
import model.expressions.IExp;
import model.types.BoolType;
import model.values.IValue;

public class IfStmt implements IStatement{
    private IExp expression;
    private IStatement thenSt;
    private IStatement elseS;

    public PrgState execute(PrgState state) throws MyException{
        MyIStack<IStatement> stk=state.getExeStack();
        MyIDictionary<String, IValue> symTable = state.getSymTable();
        IValue val=expression.eval(symTable);
        BoolType trueValue= new BoolType();
        if(val.getType().equals(trueValue))
            stk.push(thenSt);
        else
            stk.push(elseS);
        return state;
    }
    public IfStmt(IExp e, IStatement st, IStatement el) {
        expression=e;
        this.thenSt=st;
        this.elseS=el;
    }


    @Override
    public IStatement deepCopy() {
        return new IfStmt(expression.deepCopy(), thenSt.deepCopy(), elseS.deepCopy());
    }
    @Override
    public String toString() {
        return "IF(" + expression.toString() +
                ") THEN(" + thenSt.toString() +
                ") ELSE(" + elseS.toString() +
                "))";
    }
}
