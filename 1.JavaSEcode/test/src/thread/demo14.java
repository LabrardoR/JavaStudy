package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class Person{
    public String name;
    public int age;

    public Person(String name,int age){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return (STR."\{name} \{age}");
    }
}
public class demo14 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Runnable runnable = () -> {
            System.out.println("Running...");
        };

        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for(int i = 0; i <= 1000; i++){
                    sum += i;
                }
                return sum;
            }

        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread t = new Thread(futureTask);
        t.start();
        System.out.println(futureTask.get());
    }


}
