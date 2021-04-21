import java.util.ArrayList;
import java.util.Collection;
import java.util.ArrayList;
import java.util.HashMap;
public class AdjacencyMatrixGraph<T,T2> implements Graph<T, T2> {
    private final ArrayList<Vertex<T>> allVertexes = new ArrayList<>();
    private final HashMap<Vertex<T>, HashMap<Vertex<T>, Edge<T,T2>>> AdjacencyMatrix = new HashMap<>();

    @Override
    public Vertex<T> addVertex(T value) {
        Vertex<T> newvertex = new Vertex<>(value);
        allVertexes.add(newvertex);
        return newvertex;
    }

    @Override
    public void removeVertex(Vertex<T> vertex) {
        allVertexes.remove(vertex);
        if(AdjacencyMatrix.containsKey(vertex)){
            for(Vertex<T> vertex2: AdjacencyMatrix.get(vertex).keySet()){
                AdjacencyMatrix.get(vertex).remove(vertex);
            }
            AdjacencyMatrix.remove(vertex);
        }
        return;
    }

    @Override
    public Edge<T, T2> addEdge(Vertex<T> from, Vertex<T> to, T2 weight) {
        Edge<T,T2> newEdge = new Edge<>(from,to,weight);
        if(!AdjacencyMatrix.containsKey(from)){
            AdjacencyMatrix.put(from, new HashMap<>());
        }
        AdjacencyMatrix.get(from).put(to, newEdge);
        return newEdge;
    }

    @Override
    public void removeEdge(Edge<T, T2> edge) {
    Vertex<T> from = edge.getFrom();
    Vertex<T> to = edge.getTo();
    AdjacencyMatrix.get(from).remove(to);
        if(AdjacencyMatrix.get(from).isEmpty()){
            AdjacencyMatrix.remove(from);
        }
    }

    @Override
    public Collection<Edge<T, T2>> edgesFrom(Vertex<T> vertex) {
        return null;
    }

    @Override
    public Collection<Edge<T, T2>> edgesTo(Vertex<T> vertex) {
        return null;
    }

    @Override
    public Vertex<T> findVertex(T value) {
        return null;
    }

    @Override
    public Edge<T, T2> findEdge(T from_value, T to_value) {
        return null;
    }

    @Override
    public boolean hasEdge(Vertex<T> V, Vertex<T> u) {
        return false;
    }
}
