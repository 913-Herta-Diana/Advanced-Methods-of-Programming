package model.expressions;

import exceptions.MyException;
import model.adt.MyIDictionary;
import model.types.IType;
import model.values.IValue;

public class VarExp implements IExp{
    private String id;
    public VarExp() {};
    public VarExp(String id){
        this.id=id;
    }
    @Override
    public IValue eval(MyIDictionary<String,IValue> tbl) throws MyException {
      return tbl.lookUp(id);
    }

    @Override
    public IExp deepCopy() {
        return new VarExp(new String(id));
    }

    @Override
    public String toString() {return id;}
    public String getId() {return this.id;}


}
