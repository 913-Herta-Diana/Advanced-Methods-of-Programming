package model.expressions;

import exceptions.MyException;
import model.adt.MyIDictionary;
import model.types.IType;
import model.values.IValue;

public class ValueExp implements IExp{
    IValue value;
    public ValueExp(IValue value) {
        this.value=value;
    }
    @Override
    public IValue eval(MyIDictionary<String,IValue> tbl) throws MyException
    {return value;}

    @Override
    public IExp deepCopy() {
        return new ValueExp(value.deepCopy());
    }

    @Override
    public String toString(){
        return value.toString();
    }


}
