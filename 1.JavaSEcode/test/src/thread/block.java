package thread;

//实现阻塞队列
class MyBlockingQueue{
    Object locker = new Object();
    private volatile int size;
    //指向头元素的位置
    private volatile int head;
    //指向尾元素的下一个位置
    private volatile int tail;
    //采用环形队列来实现
    private final String[] data;
    MyBlockingQueue() {
        this.data = new String[1000];
    }
    MyBlockingQueue(int capacity){
        this.data = new String[capacity];
    }
    public void put(String elem) throws InterruptedException {
        synchronized (locker){
            while(size == data.length){
                locker.wait();//阻塞队列已满，应该等待
            }
            data[tail] = elem;
            tail++;
            if(tail == data.length)tail = 0;
            size++;
            locker.notify();
        }
    }
    public String take() throws InterruptedException {
        synchronized(locker){
            if(size == 0)//阻塞队列为空，应该等待
            {
                locker.wait();
            }
            String elem = data[head];
            head++;
            if(head == data.length)head = 0;
            size--;
            locker.notify();
            return elem;
        }
    }

}

public class block{
    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue queue = new MyBlockingQueue(10);
        //生产者
        Thread t1 = new Thread(()->{
            int num = 1;
            while(true){
                try {
                    //Thread.sleep(1000);
                    System.out.println("生产元素" + num);
                    queue.put(num + "");

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                num++;
            }
        });
        //消费者
        Thread t2 = new Thread(()->{
            while(true){
                try {
                    Thread.sleep(1000);
                    String result = queue.take();
                    System.out.println("消费元素" + result);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();

    }
}