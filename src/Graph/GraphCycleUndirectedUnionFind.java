package Graph;//Detect cycle in undirected graph using UF
//iterate over edges to process

class UF{
    static class Graph {
        int V, E;
        Edge[] edges;
        int[] parent;

        class Edge{
            //undirected
            int v1;
            int v2;
        }

        Graph(int V, int E){
            this.V = V;
            this.E = E;
            edges = new Edge[E];
            for (int i = 0; i < E; i++){
                edges[i] = new Edge();
            }
            parent = new int[V];
            for (int i = 0; i < V; i++){
                parent[i] = -1;
            }
        }

        boolean hasCycle(){
            for (Edge e : edges){
                if (!union(e.v1, e.v2)) return true;
            }
            return false;
        }
        //This take O(n) time
        boolean union(int u, int v){
            int comp_u = find(u);
            int comp_v = find(v);
            if (comp_u == comp_v) return false;

            parent[comp_u] = comp_v;
            return true;
        }
        //This also takes O(n) time
        int find(int u){
            if (parent[u] == -1) return u;
            return find(parent[u]);
        }

        public static void main(String[] args){
        /* Let us create following graph
         0
        |  \
        |    \
        1-----2 */
            Graph g = new Graph(3, 3);

            //add the edges
            g.edges[0].v1 = 0;
            g.edges[0].v2 = 1;
            g.edges[1].v1 = 1;
            g.edges[1].v2 = 2;
            g.edges[2].v1 = 2;
            g.edges[2].v2 = 0;

            System.out.println(g.hasCycle());
        }
    }
}

