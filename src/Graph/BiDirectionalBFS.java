package Graph;

import java.util.*;

class BiDirectionalBFS {
    private static class Vertex{
        int data;
        List<Vertex> adj = new ArrayList<>();
        Vertex(int data){
            this.data = data;
        }
    }

    private static class Graph{
        List<Vertex> vertices = new ArrayList<>();
        boolean directed;
        void addEdge(Vertex u, Vertex v){
            u.adj.add(v);
            if (!directed){
                v.adj.add(u);
            }
        }
        Graph(boolean directed){
            this.directed = directed;
        }
    }

    static boolean connected(Graph g, Vertex a, Vertex b){
        //checks if path exists between two vertices by bi-directional BFS
        Queue<Vertex> queueA = new ArrayDeque<>();
        Queue<Vertex> queueB = new ArrayDeque<>();
        Set<Vertex> visitedA = new HashSet<>();
        Set<Vertex> visitedB = new HashSet<>();

        queueA.add(a);
        visitedA.add(a);
        queueB.add(b);
        visitedB.add(b);

        while(!queueA.isEmpty() && !queueB.isEmpty()){
            if (biBFSUtil(queueA, visitedA, visitedB)) return true;
            if (biBFSUtil(queueB, visitedB, visitedA)) return true;
        }
        return false;
    }
    static boolean biBFSUtil(Queue<Vertex> queue, Set<Vertex> visitedFromHere, Set<Vertex> visitedFromThere){
        //do a BFS as normally but check if vertex is common
        Vertex u = queue.remove();

        for (Vertex v : u.adj){
            if (visitedFromThere.contains(v)) return true;
            if (visitedFromHere.add(v)){
                //visitedFromHere.add(v); combine contains and add since add returns bool
                queue.add(v);
            }
        }
        return false;
    }

    public static void main(String[] args){
        Vertex[] v = new Vertex[10];
        for (int i = 0; i < 10; i++){
            v[i] = new Vertex(i);
        }

        Graph g = new Graph(false);//undirected
        g.addEdge(v[1], v[2]);
        g.addEdge(v[2], v[3]);
        g.addEdge(v[1], v[3]);
        g.addEdge(v[2], v[5]);
        g.addEdge(v[4], v[5]);

        g.addEdge(v[2], v[6]);//try after removing this link

        g.addEdge(v[6], v[7]);
        System.out.println(connected(g, v[1], v[7]));

    }
}
