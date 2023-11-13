package model.expressions;

import exceptions.MyException;
import model.adt.MyIDictionary;
import model.types.IntType;
import model.values.IValue;
import model.values.IntValue;

public class ArithExp implements IExp {
    IExp e1;
    IExp e2;
    int op;

    public ArithExp(IExp e1, IExp e2, int op) {
        this.e1 = e1;
        this.e2 = e2;
        this.op = op;
    }


    @Override
    public IValue eval(MyIDictionary<String, IValue> tbl) throws MyException {
        IValue v1, v2;
        v1 = e1.eval(tbl);

        if (v1.getType().equals(new IntType())) {
            v2 = e2.eval(tbl);
            if (v2.getType().equals(new IntType())) {
                IntValue i1 = (IntValue) v1;
                IntValue i2 = (IntValue) v2;
                int n1, n2;
                n1 = i1.getVal();
                n2 = i2.getVal();
                if (this.op == 1) return new IntValue(n1 + n2);
                else if (this.op == 2) return new IntValue(n1 - n2);
                else if (this.op == 3) return new IntValue(n1 * n2);
                else if (this.op == 4)
                    if (n2 == 0)
                        throw new MyException("Division by 0 not allowed!");
                    else return new IntValue(n1 / n2);
                else
                    throw new MyException("Invalid operation!!");

            }
            else throw new MyException("Second operand not an integer!");
        }
        else throw new MyException("First operand not an integer!");
    }

    @Override
    public IExp deepCopy() {
        return new ArithExp(e1.deepCopy(),e2.deepCopy(),op);
    }

    @Override
    public String toString() {
        String new_op="";
        if (this.op == 1) new_op="+";
        else if (this.op == 2)  new_op="-";
        else if (this.op == 3)  new_op="*";
        else if (this.op == 4)  new_op="/";
        return e1 + new_op + e2;

    }
}
