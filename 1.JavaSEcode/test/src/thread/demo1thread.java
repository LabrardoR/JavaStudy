package thread;

//Thread 是java标准库内置的类
//Thread 在java.long这个包下,不需要包含头文件,直接使用即可

//继承Thread，重写run
class MyThread extends Thread{
    @Override
    public void run() {//重写,多态最核心的部分
        // 这个方法就是线程的入口方法
        while(true){
            System.out.println("hello thread");
            try {
                Thread.sleep(1000);//静态方法(类方法)
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void test(){
        System.out.println("hello");
    }
}

public class demo1thread {
    //每个线程都是一个独立的执行流,每个线程都可以执行一系列的逻辑(代码)
    public static void main(String[] args) throws InterruptedException {
        //MyThread myThread = new MyThread();
        // myThread.run();
        Thread t = new MyThread();
        t.start();//start则是真正调用了系统api,在系统中创建出线程,再让线程调用run
        //t.run();//不会创建新线程,只有一个主线程,这个主线程里面只能依次执行
        while(true){
            System.out.println("hello main");
            Thread.sleep(1000);
        }
    }

}
