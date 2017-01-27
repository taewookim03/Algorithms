package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * triangle count can be done in O(V^3) with matrix multiplication
 * for a sparse graph, O(E*V) (expected with hash) is possible simply by iterating over all edges and possible third vertex,
 * then checking if v1-v3 and v2-v3 exist. Contains should be O(1) expected
 *
 * DFS idea: traverse using dfs to anything not parent, check if it is the same as its grandparent
 * time complexity is worse than O(EV). see number of possible triangles in a graph (something like O(V*(V+M)^3/2))
 */


class TriangleInGraphDFS {
    static class Vertex{
        String name;

        Vertex(String name){
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Vertex){
                Vertex other = (Vertex)obj;
                return name.equals(other.name);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }
    }

    static class Edge{
        Vertex u;
        Vertex v;
        Edge(Vertex u, Vertex v){
            this.u = u;
            this.v = v;
        }

        @Override
        public boolean equals(Object obj){
            if (obj instanceof Edge){
                Edge other = (Edge)obj;
                return (u.equals(other.u) && v.equals(other.v)) ||
                        (u.equals(other.v) && v.equals(other.u));
            }
            return false;
        }

        @Override
        public int hashCode() {
            return u.name.hashCode() + v.name.hashCode();
        }
    }

    static class Graph{
        List<Vertex> vertices = new ArrayList<>();
        Set<Edge> edges = new HashSet<>();
    }



    static int triangles(Graph g){
        int count = 0;
        for (Edge e : g.edges){
            Vertex u = e.u;
            Vertex v = e.v;
            for (Vertex w : g.vertices){
                if (g.edges.contains(new Edge(u, w)) && g.edges.contains(new Edge(v, w))){
                    count++;
                }
            }
        }
        return count / 3;//each of 3 edges in traingle finds one triangle so divide by 3
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

        graph.vertices.add(a);
        graph.vertices.add(b);
        graph.vertices.add(c);
        graph.vertices.add(d);
        graph.vertices.add(e);
        graph.vertices.add(f);
        graph.vertices.add(g);

        graph.edges.add(new Edge(a, b));
        graph.edges.add(new Edge(b, c));
        graph.edges.add(new Edge(c, d));
        graph.edges.add(new Edge(d, a));

        graph.edges.add(new Edge(d, e));
        graph.edges.add(new Edge(e, f));
        graph.edges.add(new Edge(f, g));
        graph.edges.add(new Edge(g, d));

        graph.edges.add(new Edge(a, g));//makes a triangle ADG

        System.out.println(triangles(graph));
    }
}
