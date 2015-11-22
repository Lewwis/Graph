package mx.kiteso.Graph;

import mx.kiteso.Graph.algorithms.Graph;
import mx.kiteso.Graph.model.Node;



import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        Graph grafo = new Graph();
        List<Node> nodos = grafo.JsonNodes();

        for(int i = 0; i < nodos.size(); i++) {
            System.out.println(i + " " + nodos.get(i).getId() + " " + nodos.get(i).getLatitude() + ", " + nodos.get(i).getLongitude());
        }

    }
    
}
