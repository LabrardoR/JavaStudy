package DS;

//<T>当前类是一个泛型类，
class MyArray<T>{
    public Object[] array = new Object[10];

    public void setValue(int pos, Object val){
        array[pos] = val;
    }

    public T getValue(int pos){
        return (T) array[pos];
    }
}


class TestGeneric<T extends Number>{
    
}
public class test {
    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 100;

        Integer a1 = 400;
        Integer b1 = 400;
        MyArray<Integer> myArray = new MyArray<>();
    }
}
