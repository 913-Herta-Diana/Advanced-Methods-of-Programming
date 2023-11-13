package model.values;

import model.types.IType;
import model.types.IntType;

public class IntValue implements IValue{
    int val;
    public IntValue() {};
    public IntValue(int v){this.val=v;}
    public int getVal(){return this.val;}

    public String toString(){return String.valueOf(this.val);}
    @Override
    public IType getType(){return new IntType();}
    @Override
    public IValue deepCopy(){
        return new IntValue(val);
    }
}
