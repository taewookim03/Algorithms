package Graph;

import java.util.*;

class TopologicalSort {
    static class Vertex{
        String name;
        List<Vertex> adj;

        Vertex(String name){
            this.name = name;
            adj = new ArrayList<Vertex>();
        }

        void addEdge(Vertex dest){
            adj.add(dest);
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static class Graph{
        List<Vertex> vertices = new ArrayList<>();

        void add(Vertex v){
            vertices.add(v);
        }
    }

    static void topSort(Graph g){
        Set<Vertex> visited = new HashSet<>();
        Deque<Vertex> sorted = new ArrayDeque<>();
        for (Vertex v : g.vertices){
            if (!visited.contains(v)){
                topSortUtil(v, visited, sorted);
            }
        }

        for (Vertex v : sorted){
            System.out.print(v);
        }
        System.out.println();
    }

    static void topSortUtil(Vertex v, Set<Vertex> visited, Deque<Vertex> sorted){
        visited.add(v);

        //dfs on children
        for (Vertex dest : v.adj){
            if (!visited.contains(dest)){
                topSortUtil(dest, visited, sorted);
            }
        }
        //after visiting all children, process vertex
        sorted.addFirst(v);
    }

    public static void main(String[] args){
        Graph graph = new Graph();
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        Vertex h = new Vertex("H");
        a.addEdge(c);
        b.addEdge(c);
        b.addEdge(d);
        c.addEdge(e);
        d.addEdge(f);
        e.addEdge(f);
        e.addEdge(h);
        f.addEdge(g);
        graph.add(a);
        graph.add(b);
        graph.add(c);
        graph.add(d);
        graph.add(e);
        graph.add(f);
        graph.add(g);
        graph.add(h);

        topSort(graph);
    }
}
