package thread;
class Singleton {
    //饿汉模式：
    //private static Singleton instance = new Singleton();

    //懒汉模式：
    private static volatile Singleton instance = null;

    //通过这个方法来获取到刚才的实例
    //后续如果想使用这个类的实例，都通过getInstance方法来获取
    public static Singleton getInstance(){
        //懒汉模式

        //判断是否需要加锁
        if(instance == null) {
            synchronized (Singleton.class) {
                //判断是否需要new对象
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

    //把构造方法设置成私有，此时类外面的其他代码就无法new出这个类的对象了
     private Singleton(){}

}

public class single{
    Object locker = new Object();
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
    }

}




