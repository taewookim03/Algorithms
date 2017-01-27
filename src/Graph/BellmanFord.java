package Graph;

import java.util.ArrayList;
import java.util.List;

class CycleException extends Exception{}

class Edge{
    //directed v1 -> v2
    int v1;
    int v2;
    int weight;

    Edge(int v1, int v2, int weight){
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }
}

class Graph{
    int vertices = 5;//0, 1, 2, 3, 4
    List<Edge> edges = new ArrayList<>();
}

class BellmanFord {
    static void bf(Graph graph, int source){
        int V = graph.vertices;
        int[] distance = new int[V];
        for (int i = 0; i < V; i++){
            distance[i] = Integer.MAX_VALUE;
        }

        //set source distance to 0
        distance[source] = 0;

        for (int i = 0; i < V-1; i++){
            for (Edge e : graph.edges){
                //edge u -> v
                int u = e.v1;
                int v = e.v2;
                int w = e.weight;

                if ((distance[u] < Integer.MAX_VALUE) && (distance[u] + w < distance[v])){
                    //update distance to v
                    distance[v] = distance[u] + w;
                }
            }
        }

        for (Edge e : graph.edges){
            int u = e.v1;
            int v = e.v2;
            int w = e.weight;
            try{
                if (distance[u] + w < distance[v]){
                    throw new CycleException();
                }
            }
            catch (CycleException ex){
                System.out.println("There is a negative cycle");
            }
        }

        for (int i = 0; i < distance.length; i++){
            System.out.println("to " + i + ": " + distance[i]);
        }
    }

    public static void main(String[] args){
        Edge e01 = new Edge(0, 1, 4);
        Edge e02 = new Edge(0, 2, 5);
        Edge e12 = new Edge(1, 2, -3);
        Edge e24 = new Edge(2, 4, 4);
        Edge e03 = new Edge(0, 3, 8);
        Edge e34 = new Edge(3, 4, 2);
        Edge e43 = new Edge(4, 3, 1);

        Graph graph = new Graph();
        graph.edges.add(e01);
        graph.edges.add(e02);
        graph.edges.add(e12);
        graph.edges.add(e24);
        graph.edges.add(e03);
        graph.edges.add(e34);
        graph.edges.add(e43);

        bf(graph, 0);
    }
}
