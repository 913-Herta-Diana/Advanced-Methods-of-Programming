package model.types;

import model.values.BoolValue;
import model.values.IValue;
import model.values.IntValue;

public class BoolType implements IType {
    public boolean equals(Object another){
        if(another instanceof BoolType)
            return true;
        else return false;
    }
    public String toString(){ return "bool";}
    @Override
    public IType deepCopy(){
        return new BoolType();
    }
    @Override
    public IValue getDefaultValue(){
        return new BoolValue(false);
    }
}


