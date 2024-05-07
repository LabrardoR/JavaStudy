package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class AddOperation implements IOperation{

    @Override
    public void work(BookList bookList) {
        System.out.println("添加一本书！");
        System.out.print("要添加的书名:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.print("书的作者:");
        String author = scanner.next();
        System.out.print("书的类型：");
        String type = scanner.next();
        System.out.print("书的价格:");
        int price = scanner.nextInt();
        Book newBook = new Book(name,author,price,type);
        //检查书架中有没有这本书
        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            Book book = bookList.getBook(i);
            if(book.getName().equals(newBook.getName())){
                System.out.println("该书已经存在！添加失败！");
                return;//不执行下面了
            }
        }
        if(currentSize == bookList.getBooks().length){
            System.out.println("书架满了，添加失败！");
        }
        else {
            bookList.setBook(currentSize,newBook);
            currentSize++;
            bookList.setUsedSize(currentSize);
        }

    }
}
