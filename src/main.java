import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
public class main {


    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        AdjacencyMatrixGraph matrixGraph= new AdjacencyMatrixGraph();
        while(in.hasNext()){
            String line=in.nextLine();
            String[] word = line.split(" ");
                switch (word[0]){
                    case "ADD_VERTEX":
                        matrixGraph.addVertex(word[1]);
                        break;
                    case "REMOVE_VERTEX":
                        matrixGraph.removeVertex(matrixGraph.findVertex(word[1]));
                        break;
                    case "ADD_EDGE":
                        matrixGraph.addEdge(matrixGraph.findVertex(word[1]), matrixGraph.findVertex(word[2]), word[3]);
                        break;
                    case "REMOVE_EDGE":
                        matrixGraph.removeEdge(matrixGraph.findEdge(word[1],word[2]));
                        break;
                    case "HAS_EDGE":
                        if(matrixGraph.hasEdge(matrixGraph.findVertex(word[1]),matrixGraph.findVertex(word[2]))){
                            System.out.println("TRUE");
                        } else {
                            System.out.println("FALSE");
                        }
                        break;

                }

        }
    }
}
