import java.util.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

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
      if(AdjacencyMatrix.containsKey(vertex)){
          return AdjacencyMatrix.get(vertex).values();
      }
      return new ArrayList<>();
    }

    @Override
    public Collection<Edge<T, T2>> edgesTo(Vertex<T> vertex) {
        if(AdjacencyMatrix.containsKey(vertex)){
            return AdjacencyMatrix.get(vertex).values();
        }
        return new ArrayList<>();
    }

    @Override
    public Vertex<T> findVertex(T value) {
        for(Vertex<T> SearchVertex:allVertexes){
            if(SearchVertex.getValue().equals(value)){
                return SearchVertex;
            }
        }
        return null;
    }

    @Override
    public Edge<T, T2> findEdge(T from_value, T to_value) {
        for(Vertex<T> NeedVertex:allVertexes){
            if(NeedVertex.getValue().equals(from_value)){
                return edgesFrom(NeedVertex).stream().filter((g) -> g.getTo().getValue().equals(to_value)).findFirst().orElse(null);
            }
        }
        return null;
    }

    @Override
    public boolean hasEdge(Vertex<T> v, Vertex<T> u) {
        return AdjacencyMatrix.containsKey(v)&&AdjacencyMatrix.get(v).containsKey(u);
    }

    @Override
    public List<Edge<T, T2>> isAcyclic() {
        if(allVertexes.isEmpty()){
            return null;
        }
        List<Edge<T,T2>> ans;
        HashSet<Vertex<T>> way = new HashSet<>();
        while(way.size()<allVertexes.size()){
            Stack<Vertex<T>> stack = new Stack<>();
            Vertex<T> first = allVertexes.stream().filter((vertex) -> !way.contains(vertex)).findFirst().orElse(null);
            stack.add(first);
            ans =
        }
        return ans;
    }
}
