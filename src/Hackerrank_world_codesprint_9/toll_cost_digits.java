package Hackerrank_world_codesprint_9;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class AdjListNode{
    int v;//destination
    int weight;
    AdjListNode(int v, int weight){
        this.v = v;
        this.weight = weight;
    }
}
class DiGraph{
    int V;
    private List<AdjListNode> adj[];//list of adj list node linked lists
    boolean[] hasIncEdge;
    DiGraph(int V){
        this.V = V;
        adj = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++){
            adj[i] = new ArrayList<>();
        }
        hasIncEdge = new boolean[V+1];
    }

    void addEdge(int u, int v, int r){
        r %= 10;//only first digit matters
        adj[u].add(new AdjListNode(v, r));//can get reverse paths after finding normal path
        //adj[v].add(new AdjListNode(u, 10 - r));//going backwards is diff cost
        hasIncEdge[v] = true;//mark non-src edges so all graph components start from a source edge.
        // multiple src edges would make this inefficient
    }

    void dfs(int src, boolean[] visited, boolean[] processed, int[] parent, Map[] pathList){
        visited[src] = true;

        for (AdjListNode node : adj[src]){
            int dest = node.v;
            int weight = node.weight;

            if (!visited[dest]){
                parent[dest] = src;
                processEdge(dest, weight)
                dfs(dest, visited, processed, parent, pathList);
            }
            else if (!processed[dest]){
                //visited but not processed - this is back edge to a cycle
                processCycle()
            }
        }

        //process it
        processed[src] = true;


    }

    void printPathDigits(){
        boolean[] visited = new boolean[V+1];
        boolean[] processed = new boolean[V+1];
        int[] parent = new int[V+1];
        //indexed by source, containing dest, digit of weight of path
        Map<Integer, Integer>[] pathList = new Map[V+1];//use arraylist for generics?

        //dfs
        for (int i = 1; i <= V; i++){
            if (!hasIncEdge[i] && !processed[i]){
                dfs(i, visited, processed, parent, pathList);
            }
        }
        for (int i = 1; i <= V; i++){
            if (!processed[i]){
                dfs(i, visited, processed, parent, pathList);
            }
        }

        //go through all the vertices again and count the number of digits
        int[] digits = new int[10];
        for (int i = 1; i <= V; i++){
            Map<Integer, Integer> paths = pathList[i];//get paths from i to key, where value = cost
            for (Integer cost : paths.values()){
                digits[cost % 10]++;
                digits[(10 - cost % 10) % 10]++;//add the reverse path to i
            }
        }
        for (int d = 0; d < 10; d++){
            System.out.println(digits[d]);
        }
    }
}

class toll_cost_digits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int e = in.nextInt();

        DiGraph g = new DiGraph(n);

        for(int a0 = 0; a0 < e; a0++){
            int x = in.nextInt();
            int y = in.nextInt();
            int r = in.nextInt();

            g.addEdge(x, y, r);
        }
        g.printPathDigits();
    }
}
