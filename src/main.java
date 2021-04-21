import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class main {
    public static void main(String args[]){

        AdjacencyMatrixGraph kek = new AdjacencyMatrixGraph();
        kek.addVertex("A");
        kek.addVertex("B");
        kek.addEdge(kek.findVertex("A"),kek.findVertex("B"),3);
       System.out.println( kek.hasEdge(kek.findVertex("A"),kek.findVertex("B")));
        System.out.println(kek.hasEdge(kek.findVertex("B"),kek.findVertex("A")));
        kek.removeEdge((kek.findEdge("A","B")));
        System.out.println(kek.hasEdge(kek.findVertex("A"), kek.findVertex("B")));
    }
}
