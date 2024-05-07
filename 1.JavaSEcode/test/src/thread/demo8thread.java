package thread;

public class demo8thread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() ->{
            for(int i = 0; i < 5; i++){
                System.out.println("t 线程工作中");
                try{
                    Thread.sleep(1000);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }

        });
        t.start();

        //让主线程来等待t线程执行结束
        //一旦调用join，主线程就会触发阻塞，此时t 线程就可以趁机完成后续工作
        //一直阻塞到t执行完毕了，join才会解除阻塞，才能继续执行
        System.out.println("join 阻塞开始");
        t.join();
        System.out.println("join 阻塞结束");

    }
}
