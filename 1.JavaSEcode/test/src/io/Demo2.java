package io;

import java.io.File;
import java.io.IOException;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\headhead\\Desktop\\school\\test\\test.txt");
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());

        boolean ret = file.createNewFile();
        System.out.println("ret = " + ret);

        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());


    }

}
