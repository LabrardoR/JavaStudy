package thread;

import java.util.concurrent.Semaphore;

public class demo15 {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(4);
        semaphore.acquire();
        System.out.println("P操作");
        semaphore.acquire();
        System.out.println("P操作");
        semaphore.acquire();
        System.out.println("P操作");
        semaphore.acquire();
        System.out.println("P操作");
        semaphore.acquire();
        System.out.println("P操作");
    }
}
