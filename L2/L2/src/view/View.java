package view;

import controller.Controller;
import exceptions.MyException;
import model.PrgState;
import model.adt.*;
import model.expressions.ArithExp;
import model.expressions.LogicExp;
import model.expressions.VarExp;
import model.statements.*;
import model.types.BoolType;
import model.types.IntType;
import model.expressions.ValueExp;
import model.values.BoolValue;
import model.values.IValue;
import model.values.IntValue;
import repository.IRepository;
import repository.Repository;

import java.util.Scanner;

public class View {
    private IStatement ex1= new CompStmt(new VarDeclStmt(new IntType(),"v"),
            new CompStmt(new AssignStmt("v", new ValueExp(new IntValue(2))),
                    new PrintStmt(new LogicExp(new ValueExp(new BoolValue(true)),new ValueExp(new BoolValue(false)),2))));
    //1-plus, 2-minus, 3-star, 4-divide
    private IStatement ex2= new CompStmt(new VarDeclStmt( new IntType(),"a"),
            new CompStmt(new VarDeclStmt( new IntType(), "b"),
                    new CompStmt(new AssignStmt("a", new ArithExp(new ValueExp(new IntValue(2)),
                            new ArithExp(new ValueExp(new IntValue(3)), new ValueExp(new IntValue(5)),3),1)),
                            new CompStmt(new AssignStmt("b", new ArithExp(new VarExp("a"),
                                    new ValueExp(new IntValue(1)), 1)), new PrintStmt(new VarExp("b"))))));

    private IStatement ex3= new CompStmt(new VarDeclStmt(new BoolType(),"a"), new CompStmt(new VarDeclStmt( new IntType(),"v"),
            new CompStmt(new AssignStmt("a", new ValueExp(new BoolValue(true))), new CompStmt(new IfStmt(new VarExp("a"),
                    new AssignStmt("v", new ValueExp(new IntValue(2))), new AssignStmt("v", new ValueExp(new IntValue(3)))), new PrintStmt(new VarExp("v"))))));

    private IStatement ex5= new CompStmt(new NopStmt(), new CompStmt(new VarDeclStmt( new IntType(),"x"),
            new CompStmt(new AssignStmt("x", new ArithExp(new ValueExp(new IntValue(5)), new ValueExp(new IntValue(0)), 4)),
                    new PrintStmt(new VarExp("x")))));

    private void printMenu()
    {
        System.out.println("- - - - - - - - - - - - -\n"+"0) exit");
        System.out.println("1) "+ ex1);
        System.out.println("2) "+ex2);
        System.out.println("3) "+ex3);
        System.out.println("5) "+ex5+"\n- - - - - - - - - - - - -\n");
    }

    private void executeEx(IStatement stm)
    {
//        System.out.println("- - - - - - - - - - - - -\n"+stm+"\n- - - - - - - - - - - - -\n");
        MyIStack<IStatement> stk = new MyStack<>();
        MyIDictionary<String, IValue> symtbl = new MyDictionary<>();
        MyIList<IValue> out = new MyList<>();
        PrgState crtPrgState = new PrgState(stk, symtbl, out, stm);

        IRepository repo = new Repository();
        repo.add(crtPrgState);
        Controller controller = new Controller(repo);

        try{
            controller.allStep();
        }
        catch (MyException ex)
        {
            System.out.println(ex.getMessage()+"\n");
        }
    }

    public void run()
    {
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            this.printMenu();
            System.out.print("> ");
            int option = scanner.nextInt();

            switch (option)
            {
                case 0:
                    return;
                case 1:
                    this.executeEx(ex1);
                    break;
                case 2:
                    this.executeEx(ex2);
                    break;
                case 3:
                    this.executeEx(ex3);
                    break;
                case 5:
                    this.executeEx(ex5);
                default:
                    System.out.println("This option does not exist\n");
            }
}
}

}