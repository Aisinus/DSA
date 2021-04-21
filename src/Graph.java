import java.util.Collection;

public interface Graph<T,T2> {
    public Vertex<T> addVertex(T value);
    public void removeVertex(Vertex<T> vertex);
    public Edge<T,T2> addEdge(Vertex<T> from, Vertex<T> to, T2 weight);
    public void removeEdge(Edge<T,T2> edge);
    public Collection<Edge<T,T2>> edgesFrom(Vertex<T> vertex);
    public Collection<Edge<T,T2>> edgesTo(Vertex<T> vertex);
    public Vertex<T> findVertex(T value);
    public Edge<T,T2> findEdge(T from_value, T to_value);
    public boolean hasEdge(Vertex<T> v, Vertex<T> u);
}
