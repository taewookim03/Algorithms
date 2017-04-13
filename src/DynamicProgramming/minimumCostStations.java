package DynamicProgramming;

/**
 * Created by Taewoo Kim on 4/12/2017.
 */
public class minimumCostStations {
/*
http://www.geeksforgeeks.org/find-the-minimum-cost-to-reach-a-destination-where-every-station-is-connected-in-one-direction/

 There are N stations on route of a train. The train goes from station 0 to N-1. The ticket cost for all pair of stations (i, j) is given where j is greater than i. Find the minimum cost to reach the destination.

Consider the following example:

Input:
cost[N][N] = { {0, 15, 80, 90},
              {INF, 0, 40, 50},
              {INF, INF, 0, 70},
              {INF, INF, INF, 0}
             };


There are 4 stations and cost[i][j] indicates cost to reach j
from i. The entries where j < i are meaningless.

Output:

The minimum cost can be obtained by first going to station 1
from 0. Then from station 1 to station 3.


min(cost[i][j], cost[i][k] + cost[k][j]


dp
0  15 55 (90, 55 + 70, 15 + 50)
0  0  40 50
0  0  0  70
0  0  0  0


0 1 k = 0

*/
    static int minCost(int[][] cost){
        int n = cost.length;
        int[] dist = new int[n];//min distance from source (0) to i

        for (int i = 1; i < n; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        //in linear (topologically sorted) order of the DAG
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                if (dist[i] + cost[i][j] < dist[j]){
                    dist[j] = dist[i] + cost[i][j];
                }
            }
        }
        return dist[n-1];
    }

    public static void main(String[] args) {
        int[][] cost = new int[][]{
                {0,15,80,90},
                {0,0,40,50},
                {0,0,0,70},
                {0,0,0,0}
        };
        System.out.println(minCost(cost));
    }
}
