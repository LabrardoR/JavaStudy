package user;

import operation.IOperation;
import book.*;
public abstract class User {
    protected String name;
    protected IOperation[] iOPerations;
    public User(String name) {
        this.name = name;
    }
    public abstract int menu();
    public void doOperation(int choice, BookList bookList){
        iOPerations[choice].work(bookList);
    }

}
