package io;

import java.io.*;

//c:/Users/headhead/Desktop/school/test.txt
public class Demo4 {
    public static void main(String[] args) throws IOException {
        //Reader reader = new FileReader("c:/Users/headhead/Desktop/school/test.txt");
//       while(true){
//        int c = reader.read();
//       if(c == -1)break;
//           char ch = (char)c;
//           System.out.println(ch);
//       }
//        try{
//            char[] cbuf = new char[3];
//            int id = 0;
//            while(true){
//
//                int n = reader.read(cbuf);
//                if(n == -1){
//                    break;
//                }
//                id = n;
//                System.out.println("n = "+ id);
//                for(int i = 0; i < id; i++){
//                    System.out.print(cbuf[i]);
//                }
//            }
//        } finally {
//            //释放文件描述符
//            //PCB内容：pid，内存指针，文件描述符表，...
//            //一个进程每次打开一个文件，就要在这个表里分配一个元素
//            //如果只打卡文件不关闭文件，就会让表里的元素越来越多，直到把这个表占满，后续再打开这个文件就会出错了
//            //文件资源泄露 非常类似内存泄露
//            reader.close();
//        }

        //只有实现了Closeable接口才能这么写

        //在结束的时候会自动执行close
        try(Reader reader = new FileReader("c:/Users/headhead/Desktop/school/test.txt");){
            while(true){
                char[] cbuf = new char[3];
                int n = reader.read(cbuf);
                if(n == -1){
                    break;
                }
                for(int i = 0; i < n; i++){
                    System.out.print(cbuf);
                }
            }
        }


    }
}
