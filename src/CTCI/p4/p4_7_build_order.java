package CTCI.p4;

import java.util.*;

class p4_7_build_order {
    private static class Vertex{
        String name;
        List<Vertex> adj = new ArrayList<>();
        Vertex(String name){
            this.name = name;
        }
    }

    private static class DiGraph{
        class CycleException extends RuntimeException{};

        List<Vertex> vertices = new ArrayList<>();
        public void addEdge(Vertex u, Vertex v){
            u.adj.add(v);
        }

        public void topologicalSort(){
            Set<Vertex> visited = new HashSet<>();
            Set<Vertex> processed = new HashSet<>();
            Stack<Vertex> stack = new Stack<>();

            for (Vertex u : vertices){
                if (!visited.contains(u)){
                    if(!DFS(u, visited, processed, stack)) throw new CycleException();
                }
            }
            while (!stack.isEmpty()){
                System.out.print(stack.pop().name + " ");
            }
            System.out.println();
        }

        private boolean DFS(Vertex u, Set<Vertex> visited, Set<Vertex> processed, Stack<Vertex> stack){
            visited.add(u);
            for (Vertex v : u.adj){
                if (visited.contains(v) && !processed.contains(v)) return false;
                if (!visited.contains(v)){
                    if (!DFS(v, visited, processed, stack)) return false;
                }
            }
            processed.add(u);
            stack.push(u);

            return true;
        }
    }

    public static void main(String[] args){
        DiGraph g = new DiGraph();
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");
        Vertex f = new Vertex("f");

        g.vertices.add(a);
        g.vertices.add(b);
        g.vertices.add(c);
        g.vertices.add(d);
        g.vertices.add(e);
        g.vertices.add(f);

        g.addEdge(a, d);
        g.addEdge(f, b);
        g.addEdge(b, d);
        g.addEdge(f, a);
        g.addEdge(d, c);

        g.topologicalSort();
    }
}
