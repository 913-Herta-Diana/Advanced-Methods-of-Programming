package model.types;
import model.values.IValue;
public interface IType {
    boolean equals(Object another);
    IValue getDefaultValue();
    IType deepCopy();

}
