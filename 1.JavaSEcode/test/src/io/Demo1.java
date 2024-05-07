package io;

import java.io.File;
import java.io.IOException;

public class Demo1 {
    public static void main(String[] args) throws IOException {
        File f = new File("./text.txt");
        System.out.println(f.getParent());
        System.out.println(f.getName());
        System.out.println(f.getPath());//相对路径
        System.out.println(f.getAbsolutePath());//绝对路径
        System.out.println(f.getCanonicalPath());//针对绝对路径进行简化
    }




}
