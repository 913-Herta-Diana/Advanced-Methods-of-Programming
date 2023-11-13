package repository;

import exceptions.MyException;
import model.PrgState;

import java.util.List;

public interface IRepository {
    PrgState getCurrPrgState();
    void add(PrgState programState);
}
