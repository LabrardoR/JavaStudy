package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Demo7 {
    public static void main(String[] args)  {
        try(InputStream inputStream = new FileInputStream("c:/Users/headhead/Desktop/school/test.txt")){
            Scanner scanner = new Scanner(inputStream);
            String s = scanner.next();
            System.out.println(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
