package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class DelOperation implements IOperation{

    @Override
    public void work(BookList bookList) {
        System.out.println("请输入要删除的图书：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int currentSize = bookList.getUsedSize();
        for(int i = 0; i < currentSize; i++){
            Book book = bookList.getBook(i);
            if(name.equals(book.getName())){
                for(int j = i + 1; j < currentSize; j++){
                    book = bookList.getBook(j);
                    bookList.setBook( j -1 ,book);
                }
                bookList.setBook(j,null);
                bookList.setUsedSize(currentSize - 1);
                break;
            }
        }
    }
}
