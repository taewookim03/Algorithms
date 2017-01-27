package CTCI.p4;
import java.util.*;

class p4_1_route_bet_2_nodes {
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

    static boolean hasPath(Vertex src, Vertex dest){
        //bfs from u
        Queue<Vertex> queue = new ArrayDeque<>();
        Set<Vertex> visited = new HashSet<>();

        queue.add(src);
        visited.add(src);
        while (!queue.isEmpty()){
            Vertex u = queue.remove();
            for (Vertex v : u.adj){
                if (visited.add(v)){
                    queue.add(v);
                }
                if (visited.contains(dest)){
                    return true;
                }
            }
        }
        return false;
    }


    static boolean hasPathDFS(Vertex src, Vertex dest){
        Set<Vertex> visited = new HashSet<>();
        return DFSUtil(src, visited, dest);
    }
    static boolean DFSUtil(Vertex u, Set<Vertex> visited, Vertex dest){
        visited.add(u);
        for (Vertex v : u.adj){
            if (!visited.contains(v)){
                if (v == dest) return true;
                if (DFSUtil(v, visited, dest)) return true;
            }
        }
        return false;
    }

    //for a directed graph, so assuming checking only 1 way (no bidirectional bfs)
    public static void main(String[] args){
        Vertex[] v = new Vertex[10];
        for (int i = 0; i < 10; i++){
            v[i] = new Vertex(i);
        }
        Graph g = new Graph(true);
        g.addEdge(v[1], v[2]);
        g.addEdge(v[1], v[3]);
        g.addEdge(v[2], v[3]);

        g.addEdge(v[2], v[4]);

        System.out.println(hasPath(v[1], v[4]));
        System.out.println(hasPathDFS(v[1], v[4]));
    }
}
