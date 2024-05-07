package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Demo5 {
    public static void main(String[] args) {
        try(InputStream inputStream = new FileInputStream("c:/Users/headhead/Desktop/school/test.txt")){
            byte[] buffer = new byte[1024];
            int n = inputStream.read(buffer);
            System.out.println("n = " + n);
            for (int i = 0; i < n; i++) {
                System.out.println(buffer[i]);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
