package model.values;

import model.types.IType;

import java.lang.reflect.Type;

public interface IValue {
        IType getType();
        IValue deepCopy();
}
