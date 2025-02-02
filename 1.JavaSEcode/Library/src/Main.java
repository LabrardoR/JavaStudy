import book.BookList;
import user.AdminUser;
import user.NormalUser;
import user.User;

import java.util.Scanner;

public class Main {

    public static User login(){
        System.out.println("请输入你的姓名：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.print("请输入你的身份：1.管理员  2.普通用户-->");
        int choice = scanner.nextInt();

        //向上转型
        if(choice == 1){
            //管理员
            return new AdminUser(name);
        }
        else{
            //普通用户
            return new NormalUser(name);
        }
    }

    public static void main(String[] args) {
        BookList bookList = new BookList();
        User user = login();
        while(true) {
            int choice = user.menu();

            System.out.println("choice " + choice);
            //根据choice的选择来决定调用的是哪个方法
            if(choice == 0){
                System.out.println("欢迎下次使用，再见！");
                break;
            }

            user.doOperation(choice,bookList);


        }

    }
}
