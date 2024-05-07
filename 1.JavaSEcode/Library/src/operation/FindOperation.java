package operation;

import book.BookList;

import java.util.Objects;
import java.util.Scanner;

public class FindOperation implements IOperation{

    @Override
    public void work(BookList bookList) {
        System.out.println("查找图书！");
        System.out.print("请输入要查找的图书->");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        for (int i = 0; i < bookList.getUsedSize(); i++) {
            if(Objects.equals(name, bookList.getBook(i).getName())){
                System.out.println("找到这本书了，信息如下：");
                System.out.println(bookList.getBook(i));
                return;
            }
        }
        System.out.println("未查询到这本书！");
    }
}
