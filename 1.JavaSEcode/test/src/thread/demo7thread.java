package thread;

public class demo7thread {
    private static boolean isQuit = false;
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            while(!isQuit){
                System.out.println("线程工作中");
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                e.printStackTrace();
                }
            }
            System.out.println("work done");
        });

        t.start();
        Thread.sleep(5000);
        isQuit = true;
        System.out.println("设置isQuit为true");
    }
}
