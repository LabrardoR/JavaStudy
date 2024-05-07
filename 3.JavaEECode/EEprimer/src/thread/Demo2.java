package thread;

//继承Thread，重写run
class ThreadDemo2 extends Thread{
    @Override
    public void run(){

        while(true){
            System.out.println(Thread.currentThread().getName()+"正在执行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new ThreadDemo2();
        t1.start();
        while(true){
            System.out.println(Thread.currentThread().getName()+"正在执行");
            Thread.sleep(1000);
        }

    }
}
