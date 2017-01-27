package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//detecting cycle for a directed graph
class Solution{
    private static class Vertex{
        int index;
        List<Vertex> adj;

        Vertex(int index){
            this.index = index;
            adj = new ArrayList<>();
        }

        @Override
        public int hashCode() {
            return index;
        }
    }

    private static class Graph{
        List<Vertex> vertices = new ArrayList<Vertex>();

        //DIRECTED GRAPH
        void addEdge(Vertex u, Vertex v){
            u.adj.add(v);
        }
    }
    static class cycleDFS {
        static boolean hasCycle(Graph graph) {
            //do a dfs and detect if there is a back edge
            //(edge points to a vertex that has been visited but not yet processed)

            Set<Vertex> white = new HashSet<>(graph.vertices);//unvisited
            Set<Vertex> grey = new HashSet<>();//visited but not yet processed;
            Set<Vertex> black = new HashSet<>();//processed

            //get a random source vertex from unvisited set
            while (!white.isEmpty()) {
                Vertex src = white.iterator().next();
                if (dfs(src, white, grey, black)) return true;
            }
            return false;
        }

        static boolean dfs(Vertex src, Set<Vertex> white, Set<Vertex> grey, Set<Vertex> black) {
            //mark visited
            white.remove(src);
            grey.add(src);

            //dfs
            for (Vertex dest : src.adj) {
                //skip if dest has already been processed
                if (black.contains(dest)) {
                    continue;
                }

                //check if dest is grey (already visited but not yet processed)
                if (grey.contains(dest)) {
                    return true;
                }

                //otherwise perform dfs as normal
                if (dfs(dest, white, grey, black)) return true;
            }
            //mark processed
            grey.remove(src);
            black.add(src);

            return false;
        }
        public static void main(String[] args){
            Graph graph = new Graph();
            Vertex v1 = new Vertex(1);
            Vertex v2 = new Vertex(2);
            Vertex v3 = new Vertex(3);
            Vertex v4 = new Vertex(4);
            Vertex v5 = new Vertex(5);
            Vertex v6 = new Vertex(6);

            graph.vertices.add(v1);
            graph.vertices.add(v2);
            graph.vertices.add(v3);
            graph.vertices.add(v4);
            graph.vertices.add(v5);
            graph.vertices.add(v6);

            graph.addEdge(v1, v2);
            graph.addEdge(v4, v1);
            graph.addEdge(v4, v5);
            graph.addEdge(v5, v6);
            graph.addEdge(v6, v4);

            System.out.println(hasCycle(graph));
        }
    }
}
