package io;

import java.io.File;
import java.util.Scanner;

//重要面试题！！！！！！！！！！！！！！！！

public class Demo8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 1.先让用户输入一个要扫描的目录
        System.out.println("请输入要扫描的路径：");
        String path = scanner.next();
        File rootPath = new File(path);
        if(!rootPath.isDirectory()){
            System.out.println("您输入的扫描路径有误！");
            return;
        }
        // 2. 让用户输入一个要查询的关键词
        System.out.println("请输入要删除文件的关键词：");
        String word = scanner.next();
        // 3. 可以进行递归扫描了
        scanDir(rootPath,word);
    }


    private static void scanDir(File rootPath, String word){
        // 1. 先列出 rootPath 中所有的文件和目录
        File[] files = rootPath.listFiles();
        if(files == null){
            // 当前目录为 null，就可以直接返回了
            return;
        }
        // 2. 遍历这里的每个元素，针对不同类型做出不同的处理
        for(File f : files){
            // 加个日志，方便观察当前递归的执行过程
            System.out.println("当前扫描的文件：" + f.getAbsolutePath());
            if(f.isFile()){
                //普通文件检查文件是否要删除，并执行删除动作
                checkDelete(f,word);

            } else{
                // 目录，递归的再去判断子目录里包含的内容
              scanDir(f, word);
            }
        }

    }

    private static void checkDelete(File f, String word){
        if(!f.getName().contains(word)){
            // 不必删除
            return;
        }
        // 需要删除
        System.out.println("当前文件为：" + f.getAbsolutePath()+ ",请确认是否要删除（Y/N）");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        if(choice.equals("Y") || choice.equals("y")){
            //真正执行操作
            f.delete();
            System.out.println("删除完毕");
        }else{
            System.out.println("取消删除");
        }
    }

}
