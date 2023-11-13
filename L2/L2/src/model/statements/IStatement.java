package model.statements;

import exceptions.MyException;
import model.PrgState;

public interface IStatement {
    PrgState execute(PrgState state) throws MyException;
    IStatement deepCopy();

}
