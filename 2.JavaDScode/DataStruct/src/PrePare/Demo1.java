package PrePare;

class Alg<T extends Comparable<T>>{
    public T findMaxValue(T[] array){
        T max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max.compareTo(array[i]) < 0){
                max = array[i];
            }
        }
        return max;
    }

}

class Alg2{
    public<T extends Comparable<T>> T findMaxValue(T[] array){
        T max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max.compareTo(array[i]) < 0){
                max = array[i];
            }
        }
        return max;
    }
}

class Person implements Comparable<Person>{
    int age;
    String name;


    @Override
    public int compareTo(Person o) {
        return age - o.age;
    }
}

public class Demo1 {
    public static void main(String[] args) {
        Alg<Person> alg = new Alg<>();

        Alg2 alg2 = new Alg2();
        Integer[] arr = {1,2,3,4,1,2,1,2,23,9};

        Integer ans = alg2.findMaxValue(arr);
        System.out.println(ans);
    }
}
