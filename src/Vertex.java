public class Vertex<T> {
   private final T value;

    Vertex(T value){this.value=value;}

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "value=" + value +
                '}';
    }
}