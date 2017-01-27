package Graph;//using adj matrix

import java.util.ArrayDeque;
import java.util.Queue;

class Bipartite {
    boolean isBipartite(int[][] graph, int src){
        //do bfs while assigning color different from parent
        //-1: no color, 0: one color, 1: another color
        int V = graph.length;//number of vertices
        int[] color = new int[V];
        for (int i = 0; i < V; i++){
            color[i] = -1;
        }

        //assign color to source
        color[src] = 1;

        //bfs
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(src);

        while (!queue.isEmpty()){
            int u = queue.remove();
            //assign color if an adjacent vertex exists and does not have a color
            for (int v = 0; v < V; v++){
                if (graph[u][v] == 1 && color[v] == -1){
                    color[v] = 1 - color[u];
                    queue.add(v);
                }
                //if it exists and already has the same color, return false
                else if (graph[u][v] == 1 && color[v] == color[u]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main (String[] args)
    {
        int G[][] = {{0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };
        Bipartite b = new Bipartite();
        if (b.isBipartite(G, 0))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
