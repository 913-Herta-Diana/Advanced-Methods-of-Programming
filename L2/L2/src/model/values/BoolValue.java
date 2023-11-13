package model.values;

import model.types.BoolType;
import model.types.IType;
import model.types.IntType;

public class BoolValue implements IValue{
    boolean val;
    public BoolValue(boolean v){this.val=v;}
    public boolean getVal(){return this.val;}

    public String toString(){return String.valueOf(this.val);}
    @Override
    public IType getType(){return new BoolType();}
    @Override
    public IValue deepCopy(){
        return new BoolValue(val);
    }

}
