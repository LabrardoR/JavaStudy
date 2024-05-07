package thread;

import java.util.PriorityQueue;

//定时器的实现
//及其复杂！！！！！

class MyTimerTask implements Comparable<MyTimerTask>{
    //要执行的任务
    private final Runnable runnable;
    //要有一个执行任务的时间
    private final long time;
    MyTimerTask(Runnable runnable, long delay){
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + delay;//绝对时间
    }
    long getTime(){
        return time;
    }
    Runnable getRunnable(){
        return runnable;
    }
    @Override
    public int compareTo(MyTimerTask o) {
        //队首元素是最小时间的值
        return (int) (this.time - o.time);
    }
}
class MyTimer{
    //使用一个数据结构保存所有要安排的任务
    private PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();
    private Object locker = new Object();
    public void schedule(Runnable runnable, long delay){
        synchronized (locker) {
            queue.offer(new MyTimerTask(runnable, delay));
            locker.notify();
        }
    }

    //搞个扫描线程
    public MyTimer(){
        Thread t = new Thread(()->{
            //扫描线程，需要不停扫描队首元素，检查是否到了执行时间
            while(true){
                synchronized (locker){
                        try {
                            //尽量不要使用if进行唤醒条件
                            while(queue.isEmpty()) {
                                //使用wait进行等待
                                //这里的wait需要其他线程唤醒
                                //添加了新的任务就应该唤醒
                                locker.wait();
                            }
                            MyTimerTask task = queue.peek();//取队首元素
                            //比较看一下当前的队首元素是否可以执行了
                            long curTime = System.currentTimeMillis();
                            if(curTime >= task.getTime()){
                                //当前时间达到了任务时间
                                task.getRunnable().run();
                                //执行后删除
                                queue.poll();
                            }
                            else{
                                locker.wait(task.getTime() - curTime);
                                //为什么不用sleep：wait更好，可能在等待过程中，主线程调用schedule添加一个新的任务，
                                //恰好新的任务比刚才最早的任务还早，使用notify唤醒这里的wait，让循环再执行一遍，重新拿到队首元素，更新wait中的等待时间
                            }
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                }
            }
        });
        t.start();
    }

}
public class demo12 {
    public static void main(String[] args) {
        MyTimer timer = new MyTimer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("3000");
            }
        },3000);
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("2000");
            }
        },2000);
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("1000");
            }
        },1000);
    }
}
