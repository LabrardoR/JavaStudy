package SEstudy;

import java.util.Objects;

class Money implements Cloneable{
    double m = 19.9;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
//Cloneable：空接口
class Person implements Cloneable{
      private String name;
      private int age;

      public Money money = new Money();
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person temp = (Person)super.clone();
        temp.money = (Money)this.money.clone();
        return temp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(money, person.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, money);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class Demo5 {
    public static void main(String[] args) throws CloneNotSupportedException{
        Person p1 = new Person("head",15);
        p1.money.m = 19.9;
         Person p2 = (Person)p1.clone();
        //Person p3 = p1;

        //System.out.println(p3.toString());

        String head1 = new String("haha");
        String head2 = new String("haha");
        System.out.println(head1==head2);
        System.out.println(head1.equals(head2));

    }

}
