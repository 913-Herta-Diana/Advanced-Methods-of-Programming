package model.expressions;

import exceptions.MyException;
import model.adt.MyIDictionary;
import model.types.BoolType;
import model.types.IType;
import model.values.BoolValue;
import model.values.IValue;

public class LogicExp implements IExp{
    IExp e1;
    IExp e2;
    int op;
    public LogicExp(IExp e1, IExp e2, int op){

        this.e1=e1;
        this.e2=e2;
        this.op=op;
    }
    @Override
    public IValue eval(MyIDictionary<String,IValue>tbl) throws MyException{
        IValue v1,v2;
        v1=e1.eval(tbl);
        if(v1.getType().equals(new BoolType())){
            v2=e2.eval(tbl);
            if(v2.getType().equals(new BoolType())){
                BoolValue b1=(BoolValue)v1;
                BoolValue b2=(BoolValue)v2;
                boolean n1,n2;
                n1=b1.getVal();
                n2=b2.getVal();
                if(op==1) return new BoolValue(n1 && n2);
                else if(op==2) return new BoolValue(n1 || n2);
                else
                    throw new MyException("Invalid operator!!");
            }
            else
                throw new MyException("Second operator is not boolean!!");
        }
        else
            throw new MyException("First operand is not a boolean!!");
    }

    @Override
    public IExp deepCopy() {
        return new LogicExp(e1.deepCopy(),e2.deepCopy(),op);
    }

    @Override
    public String toString() {
        String new_op="";
        if(op==1) new_op="AND";
        if(op==2) new_op="OR";
        return e1.toString() + " " + new_op + " " + e2.toString();}
}
