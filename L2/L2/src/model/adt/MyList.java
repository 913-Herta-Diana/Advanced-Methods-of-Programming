package model.adt;

import java.util.ArrayList;
import java.util.List;

public class MyList<T> implements MyIList<T> {
    private List<T> items;

    public MyList()
    {
        items = new ArrayList<>();
    }

    @Override
    public void add(T itemToAdd) {
        items.add(itemToAdd);
    }

    @Override
    public String toString() {
        return "MyList{" +
                "items=" + items +
                '}';
    }
}