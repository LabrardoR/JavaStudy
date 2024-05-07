package io;

import java.io.File;
import java.util.Arrays;

public class Demo3 {
    public static void main(String[] args) {
//       File f = new File("c:/");
//       String[] file = f.list();
//        System.out.println(Arrays.toString(file));
    File f = new File("c:/java109/aaa/bbb/ccc/ddd");
    boolean ret = f.mkdirs();

    }

}
