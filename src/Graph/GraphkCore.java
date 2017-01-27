package Graph;

import java.util.*;

//http://stackoverflow.com/questions/10205191/graph-how-to-find-maximum-induced-subgraph-h-of-g-such-that-each-vertex-in-h-h

class kCore {
    static class Vertex{
        String name;
        List<Vertex> adj;

        Vertex(String name){
            this.name = name;
            adj = new ArrayList<>();
        }

        int degree(){
            return adj.size();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Vertex){
                Vertex other = (Vertex)obj;
                return this.name.equals(other.name);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }
    }

    static class Graph{
        List<Vertex> vertices = new ArrayList<>();

        Graph(){
            ;
        }

        Graph(Graph other){
            for (Vertex u : other.vertices){
                Vertex v = new Vertex(u.name);
                for (Vertex w : u.adj){
                    v.adj.add(new Vertex(w.name));
                }
                vertices.add(v);
            }
        }

        void addEdge(Vertex u, Vertex v){
            //assuming undirected
            u.adj.add(v);
            v.adj.add(u);
        }

        void dfs(){
            //pick a random source
            if (vertices.isEmpty()) return;
            Vertex src = vertices.get(0);

            Set<Vertex> unvisited = new HashSet<>(vertices);
            dfsRec(src, unvisited);
        }
        void dfsRec(Vertex u, Set<Vertex> unvisited){
            unvisited.remove(u);
            System.out.println(u.name + " " + u.degree());

            for (Vertex v : u.adj){
                if (unvisited.contains(v)){
                    dfsRec(v, unvisited);
                }
            }
        }

        Graph kCore(int k){
            //whenever an edge with degree less than k is encountered, delete.
            //after deleting an edge, also delete its neightbors recursively if their degree falls < k.

            Set<Vertex> deleted = new HashSet<>();

            Graph induced = new Graph(this);
            for (Vertex u : induced.vertices){
                if (!deleted.contains(u) && u.degree() < k){
                    deleteVertex(deleted, u, k);
                }
            }

            List<Vertex> remaining = new ArrayList<>();
            for (Vertex u : vertices){
                if (!deleted.contains(u)){
                    remaining.add(u);
                }
            }
            induced.vertices = remaining;

            return induced;
        }

        void deleteVertex(Set<Vertex> deleted, Vertex u, int k){
            for (Vertex v : u.adj){
                v.adj.remove(u);
                if (!deleted.contains(v) && v.degree() < k){
                    deleteVertex(deleted, v, k);
                }
            }
            deleted.add(u);
        }
    }

    public static void main(String[] args){
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");

        Graph graph = new Graph();
        graph.vertices.add(a);
        graph.vertices.add(b);
        graph.vertices.add(c);
        graph.vertices.add(d);
        graph.vertices.add(e);
        graph.vertices.add(f);
        graph.vertices.add(g);

        graph.addEdge(a, b);
        graph.addEdge(b, c);
        graph.addEdge(c, d);
        graph.addEdge(d, a);
        graph.addEdge(d, e);
        graph.addEdge(c, f);
        graph.addEdge(f, g);

        System.out.println("original:");
        graph.dfs();
        System.out.println();

        Graph induced = graph.kCore(2);
        System.out.println("induced: ");
        induced.dfs();
    }
}
