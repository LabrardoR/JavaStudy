package thread;

//实现Runnable，重写run
class ThreadDemo3 implements Runnable{
    @Override
    public void run() {
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
public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        //Thread t1 = new ThreadDemo3();
        Thread t2 = new Thread(new ThreadDemo3());
        //t1.start();
        t2.start();
        while(true){
            System.out.println(Thread.currentThread().getName()+"正在执行");
            Thread.sleep(1000);
        }
    }
}

