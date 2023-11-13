package controller;

import exceptions.MyException;
import model.PrgState;
import model.adt.MyIStack;
import model.statements.IStatement;
import repository.IRepository;

import java.util.List;

public class Controller {
    IRepository repo;
    public Controller(IRepository repo){
        this.repo=repo;
    }
    PrgState oneStep(PrgState state) throws MyException{
        MyIStack<IStatement> stk=state.getExeStack();
        if(stk.isEmpty()) throw new MyException("Program State Stack is EMPTY");
        IStatement currStmt=stk.pop();
        return currStmt.execute(state);
    }
    public void allStep() throws  MyException{
        PrgState prg = repo.getCurrPrgState();
        System.out.println(prg);
        while(!prg.getExeStack().isEmpty()) {
            oneStep(prg);

            System.out.println(prg);
        }
    }
}
