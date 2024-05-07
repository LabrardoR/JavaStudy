package thread;

import java.util.concurrent.CountDownLatch;

public class demo16 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for(int i = 0; i < 8; i++){
            int id = i;
            Thread t = new Thread(()->{
                System.out.println("thread" + id);//变量捕获
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                countDownLatch.countDown();//通知说当前的任务执行完毕了
            });
            t.start();
        }
        System.out.println("正在执行任务");
        countDownLatch.await();
        System.out.println("所有任务都完成了");
    }
}
