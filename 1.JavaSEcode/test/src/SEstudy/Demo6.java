package SEstudy;


class OuterClass{
    public int data1 = 1;
    public static int data2 = 2;
    public int data3 = 3;
    public int data4 = 111;
    class InnerClass{
        public int data4 = 4;
        public final int data5 = 5;

        public void test(){
            System.out.println(data1);
            System.out.println(data2);
            System.out.println(data4);
        }
    }

    public void test(){
        System.out.println(data1);
        System.out.println(data2);
        System.out.println(data4);
    }
}

public class Demo6 {
    public static void main(String[] args) {
//        OuterClass outerClass = new OuterClass();
//      outerClass.test();

    Boolean wss;






    }
}
