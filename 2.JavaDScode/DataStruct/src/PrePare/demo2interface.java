package PrePare;

public interface demo2interface {

    public void hello();
    public default void bye(){
        System.out.println("bye bye!");
    }
}
