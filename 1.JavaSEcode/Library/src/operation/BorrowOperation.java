package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class BorrowOperation implements IOperation{

    @Override
    public void work(BookList bookList) {
        System.out.print("请输入要借的书：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            Book book = bookList.getBook(i);
            if(name.equals(book.getName())){
                if(book.isBorrowed()){
                    System.out.println("你要借的书已经被借走了！下次再借");
                    break;
                }
                System.out.print("你要借的书是：");
                System.out.println(book);
                book.setBorrowed(true);
                System.out.println("借阅完成！");
                break;
            }
        }
    }
}
