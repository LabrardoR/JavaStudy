package thread;

import java.util.Random;

class ThreadDemo1 extends Thread{
    @Override
    public void run() {
        Random random = new Random();
        while(true){
            //打印线程名称
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo1 t1 = new ThreadDemo1();
        ThreadDemo1 t2 = new ThreadDemo1();
        ThreadDemo1 t3 = new ThreadDemo1();
        t1.start();
        t2.start();
        t3.start();

        Random random = new Random();
        while(true){
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(random.nextInt(1000));
        }

    }
}
