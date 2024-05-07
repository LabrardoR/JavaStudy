package SEstudy;

interface Shape{
    void test();
    void test2();
    //接口当中不能有被实现的方法，两个方法除外：static修饰的方法和default修饰的方法
    //接口当中的抽象方法默认都是public abstract修饰的
    //接口当中的成员变量默认都是public static final修饰的

    int a = 0;
}
class haha implements Shape{
    public void test(){

    }
    public void test2(){

    }
}
public class Demo3 {

}
