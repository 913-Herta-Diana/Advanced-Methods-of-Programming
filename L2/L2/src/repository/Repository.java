package repository;

import model.PrgState;

import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepository{
    List<PrgState> programStateList;
    public Repository(){
        programStateList = new ArrayList<>();
    }
    @Override
    public PrgState getCurrPrgState(){
        try {
            return programStateList.get(0);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException){
            return null;
        }
        }
    @Override
    public String toString(){
        return "Repository{" +
                "programStateList=" + programStateList +
                '}';
    }
    @Override
    public void add(PrgState programState) {
        programStateList.add(programState);
    }
}
