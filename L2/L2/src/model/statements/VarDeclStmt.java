package model.statements;

import exceptions.MyException;
import model.PrgState;
import model.adt.MyIDictionary;
import model.types.IType;
import model.types.IntType;
import model.values.IValue;
import model.values.IntValue;

public class VarDeclStmt implements IStatement{
    String name;
    IType type;
    public VarDeclStmt(IType type, String name){
        this.type=type;
        this.name=name;
    }
    @Override
    public PrgState execute(PrgState state) throws MyException{

        MyIDictionary<String, IValue> symbTbl= state.getSymTable();
        if(symbTbl.isDefined(name))
            throw new MyException("Variable "+ name + "is already declared!");
        else
            symbTbl.put(name, type.getDefaultValue());

        return state;
        }


    @Override
    public String toString() {
        return "(" + type.toString()+ " "+ name + ")"
;    }

    @Override
    public IStatement deepCopy() {
        return new VarDeclStmt(type.deepCopy(),new String(name));
    }
}
