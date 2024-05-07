package thread;


//实现Runnable，重写run，使用匿名内部类
public class Demo5 {
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
        }
    };
    Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true) {
                System.out.println(Thread.currentThread().getName() + "正在执行");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    });


    t.start();



}
