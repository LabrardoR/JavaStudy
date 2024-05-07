package thread;

public class demo9thread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始：" + System.currentTimeMillis());
        Thread.sleep(1000);
        System.out.println("结束：" + System.currentTimeMillis());

    }
}
