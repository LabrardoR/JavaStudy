package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Demo6 {
    public static void main(String[] args) throws FileNotFoundException {
        try(OutputStream outputStream = new FileOutputStream("c:/Users/headhead/Desktop/school/test.txt",true)){
            String s = "我是headhead";
            outputStream.write(s.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
