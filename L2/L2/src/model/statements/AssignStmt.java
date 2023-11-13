package model.statements;

import exceptions.MyException;
import model.expressions.IExp;
import model.PrgState;
import model.adt.MyIDictionary;
import model.adt.MyIStack;
import model.types.IType;
import model.values.IValue;

import java.util.Formatter;

public class AssignStmt implements IStatement{
    String id;
    IExp exp;
    public AssignStmt(String id, IExp exp){
        this.id= id;
        this.exp=exp;
    }
    @Override
    public String toString(){return id+"="+exp.toString();}
    @Override
    public PrgState execute(PrgState state) throws MyException{
        MyIDictionary<String, IValue> symbTbl=state.getSymTable();
        if(symbTbl.isDefined(id)){
            IValue val = exp.eval(symbTbl);
            IType typeId = (symbTbl.lookUp(id).getType());
            if (val.getType().equals(typeId))
                symbTbl.update(id, val);
            else
                throw new MyException("Declared type of variable " + id + " and type of the assigned expression do not match!!");
        }
        else
            throw new MyException("The used variable "+id+" was not delcareed before");
        return state;
        }

    @Override
    public IStatement deepCopy() {
        return new AssignStmt(new String(id), exp.deepCopy());
    }
}


