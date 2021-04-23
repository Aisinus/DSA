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
    public List<Vertex<T>> isAcyclic() {
        Stack<Vertex<T>> way=new Stack<>();
        Vertex<T> current = allVertexes.get(0);
        way.add(current);
        return AcyclicCheck(current,way, new ArrayList<>());
    }

    public List<Vertex<T>> AcyclicCheck(Vertex<T> current,Stack<Vertex<T>> way, List<Vertex<T>> visited){
        visited.add(current);
        Collection<Edge<T,T2>> possibleEdges = edgesFrom(current);
        //Cycle check
        for(Edge<T,T2> psEdge : possibleEdges){
            if(way.contains(psEdge.getTo())){
                return way.stream()
                        .dropWhile((v) -> v != psEdge.getTo())
                        .collect(Collectors.toList());
            }
        }
        //Search way
        for(Edge<T,T2> psEdge:possibleEdges){
            Vertex<T> nextVertex=psEdge.getTo();
            if (visited.contains(nextVertex)) continue;
            way.add(nextVertex);
           List<Vertex<T>> result =AcyclicCheck(nextVertex, way,visited);
           if(result==null) continue;
           return result;
        }
        return null;
    }
}
