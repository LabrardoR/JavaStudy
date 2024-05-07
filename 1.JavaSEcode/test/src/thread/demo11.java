package thread;

import java.util.Timer;
import java.util.TimerTask;

public class demo11 {
    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
             System.out.println("执行定时器的任务");
            }
        },2000);

        System.out.println("程序启动！");
    }
}
