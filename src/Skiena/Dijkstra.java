//import java.util.*;
//
//class Vertex{
//    String name;
//    List<Edge> edges = new ArrayList<Edge>();//outgoing edges
//
//    Vertex(String name){
//        this.name = name;
//    }
//}
//
//class Edge{
//    Vertex dest;
//    int weight;
//
//    Edge(Vertex dest, int weight){
//        this.dest = dest;
//        this.weight = weight;
//    }
//}
//
//class Graph{
//    boolean directed;
//    List<Vertex> vertices;
//
//    Graph(boolean directed){
//        this.directed = directed;
//        vertices = new ArrayList<>();
//    }
//
//    void addVertex(Vertex v){
//        vertices.add(v);
//    }
//
//    void addEdge(Vertex u, Vertex v, int weight){
//        u.edges.add(new Edge(v, weight));
//        if (!directed){
//            v.edges.add(new Edge(u, weight));
//        }
//    }
//
//}
//
//class Dijkstra {
//    //time = (E * decreasekey + V * extractmin). e.g. with Fibonacci heap, O(E + VlogV)
//    //this min finding takes O(V) for total O(E*1 + V*V) = O(E + V^2) = O(V^2)
//    //Use modified binary heap implementation for O(logn) min extraction -> O((E+V)logV)
//    static Vertex minUnvisitedVertex(Set<Vertex> unvisited, Map<Vertex, Integer> distance){
//        Vertex min = null;
//        int minD = Integer.MAX_VALUE;
//
//        for (Vertex v : unvisited){
//            if (distance.get(v) < minD) {
//                min = v;
//                minD = distance.get(v);
//            }
//        }
//        return min;
//    }
//
//    static void findMinPath(Graph g, Vertex source){
//        Set<Vertex> unvisited = new HashSet<>(g.vertices);
//        Map<Vertex, Integer> distance = new HashMap<>();
//
//        for (Vertex v : g.vertices){
//            distance.put(v, Integer.MAX_VALUE);
//        }
//        distance.put(source, 0);
//
//        while (!unvisited.isEmpty()){
//            //pick minimum from unvisited vertices
//            Vertex current = minUnvisitedVertex(unvisited, distance);
//
//            for (Edge e : current.edges){
//                Vertex dest = e.dest;
//                int weight = e.weight;
//                if (distance.get(current) + weight < distance.get(dest)){
//                    distance.put(dest, distance.get(current) + weight);
//                }
//            }
//            unvisited.remove(current);
//        }
//
//        for (Vertex v : g.vertices){
//            System.out.println(v.name + "  " + distance.get(v));
//        }
//    }
//
//    public static void main(String[] args){
//        Graph g = new Graph(false);
//        Vertex a = new Vertex("A");
//        Vertex b = new Vertex("B");
//        Vertex c = new Vertex("C");
//        Vertex d = new Vertex("D");
//        Vertex e = new Vertex("E");
//        Vertex f = new Vertex("F");
//        g.addVertex(a);
//        g.addVertex(b);
//        g.addVertex(c);
//        g.addVertex(d);
//        g.addVertex(e);
//        g.addVertex(f);
//
//        g.addEdge(a, b, 5);
//        g.addEdge(b, c, 2);
//        g.addEdge(c, d, 3);
//        g.addEdge(a, d, 9);
//        g.addEdge(a, e, 2);
//        g.addEdge(e, f, 3);
//        g.addEdge(d, f, 2);
//
//        findMinPath(g, a);
//    }
//}
