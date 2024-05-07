package thread;

import java.util.concurrent.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ArrayBlockingQueue;


class MyThreadPool{
    //任务队列
    private BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(1000);
    //通过这个方法，把任务添加到队列中
    public void submit(Runnable runnable) throws InterruptedException {
        queue.put(runnable);
    }
    public MyThreadPool(int n){
        for(int i = 0; i < n; i++){
            Thread t = new Thread(()->{
                try {
                    Runnable runnable = queue.take();
                    runnable.run();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            t.start();
        }
    }


}

public class demo13 {
    public static void main(String[] args) throws InterruptedException {
        //ExecutorService service = Executors.newCachedThreadPool();
        MyThreadPool myThreadPool = new MyThreadPool(4);
        for(int i = 0; i < 1000; i++){
            int id = i;
            myThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行任务"+ id);
                }
            });
        }
    }
}
