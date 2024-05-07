package operation;

import book.BookList;

import java.util.Scanner;

public class ReturnOperation implements IOperation{

    @Override
    public void work(BookList bookList) {
        System.out.println("请输入你要归还的图书：");
        Scanner scanner = new Scanner(System.in);
        String name =  scanner.next();
        int currentSize = bookList.getUsedSize();
        for(int i = 0; i < currentSize; i++){
            if(name.equals(bookList.getBook(i).getName())){
                bookList.getBook(i).setBorrowed(false);
                System.out.println("归还成功");
                break;
            }
        }
    }
}
