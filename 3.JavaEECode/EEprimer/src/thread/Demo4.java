package thread;

//继承Thread，重写run，使用匿名内部类
public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        Thread t =new Thread(){
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
        };

        t.start();
        while(true){
            System.out.println(Thread.currentThread().getName()+"正在执行");
            Thread.sleep(1000);
        }
    }
}
