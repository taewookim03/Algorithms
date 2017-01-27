//import java.util.ArrayList;
//import java.util.List;
//
//class Node{
//    int index;
//    int max_diameter;
//    int depth;
//    List<Node> adj = new ArrayList<Node>();
//
//    Node(int index){
//        this.index = index;
//        this.max_diameter = 0;
//        this.depth = 0;
//    }
//}
//
//class Graph{
//    int V;
//    Node[] nodes;
//
//    Graph(int V){
//        this.V = V;
//        nodes = new Node[V];
//        for (int i = 0; i < V; i++){
//            nodes[i] = new Node(i);
//        }
//    }
//
//    void addEdge(int node1, int node2){
//        nodes[node1].adj.add(nodes[node2]);
//        nodes[node2].adj.add(nodes[node1]);
//    }
//}
//
//class TreeDiameter {
//    static int getDiameter(Graph g, int src){
//        boolean[] visited = new boolean[g.V];
//        return diameter(g.nodes[src], visited);//a random node as starting point
//    }
//
//    static int diameter(Node node, boolean[] visited){
//        visited[node.index] = true;
//        int d1 = -1;
//        int d2 = -1;
//
//        for (Node adj : node.adj){
//            if (!visited[adj.index]){
//                //DFS
//                diameter(adj, visited);
//
//                //process afterwards
//                if (adj.max_diameter > node.max_diameter){
//                    node.max_diameter = adj.max_diameter;
//                }
//                if (adj.depth > d1){
//                    d2 = d1;//copy d1 to d2 in case non -1 d1 is being replaced
//                    d1 = adj.depth;
//                }
//                else if (adj.depth > d2){
//                    d2 = adj.depth;
//                }
//            }
//        }
//        if (2 + d1 + d2 > node.max_diameter){
//            node.max_diameter = 2 + d1 + d2;
//        }
//        node.depth = d1 + 1;
//
//        //System.out.println("Node " + node.index + " depth: " + node.depth + " md: " + node.max_diameter + " " + d1 + " " + d2);
//
//        return node.max_diameter;
//    }
//
//    public static void main(String[] args){
//        Graph g = new Graph(9);
//        g.addEdge(0, 2);
//        g.addEdge(2, 1);
//        g.addEdge(2, 3);
//        g.addEdge(3, 4);
//        g.addEdge(3, 5);
//        g.addEdge(5, 6);
//        g.addEdge(6, 7);
//        g.addEdge(5, 8);
//        System.out.println(getDiameter(g, 4));
//    }
//}
