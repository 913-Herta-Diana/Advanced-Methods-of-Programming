package model.types;

import model.values.IValue;
import model.values.IntValue;

public class IntType implements IType {

    public IntType() {};
    public boolean equals(Object another){
        if(another instanceof IntType)
            return true;
        else
            return false;
    }
    public String toString() {return "int";}
    @Override
    public IType deepCopy(){
        return new IntType();
    }
    @Override
    public IValue getDefaultValue(){
        return new IntValue(0);
    }
}
