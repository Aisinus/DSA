public class Edge<T,T2> {
    private final Vertex<T> from, to;
    private final T2 weight;
    public Edge(Vertex<T> from, Vertex<T> to, T2 weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public Vertex<T> getFrom() {
        return from;
    }

    public Vertex<T> getTo() {
        return to;
    }

    public T2 getWeight() {
        return weight;
    }
}
