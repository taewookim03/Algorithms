///*
//8-24. Given a set of coin denominators, find the minimum number of coins to make a certain amount of change.
//
//variation: given the same thing, find the number of ways to make the change
// */
//class CoinChange {
//    //finds the minimum number of coins to make the change
//    static int minCoins(int[] coins, int val){
//        int[][] m = new int[coins.length][val+1];
//
//        //fill the initial row
//        for (int j = 0; j <= val; j++){
//            m[0][j] = j / coins[0];
//        }
//        //fill the initial column (if value is 0, 0 ways to make the change)
//        for (int i = 0; i < coins.length; i++){
//            m[i][0] = 0;
//        }
//
//        for (int d = 1; d < coins.length; d++){
//            for (int v = 1; v <= val; v++){
//                if (coins[d] <= v){
//                    m[d][v] = Math.min(m[d-1][v], m[d-1][v - coins[d]] + 1);
//                }
//                else{
//                    m[d][v] = m[d-1][v];
//                }
//            }
//        }
//        return m[coins.length-1][val];
//    }
//
//    //finds the number of changes possible with the coins
//    static int numChanges(int[] coins, int val){
//        int[][] m = new int[coins.length][val+1];
//
//        //initialize row
//        for (int v = 1; v <= val; v++){
//            m[0][v] = (v % coins[0] == 0) ? 1 : 0;
//        }
//        //initialize column (1 way to make 0 cents)
//        for (int d = 0; d < coins.length; d++){
//            m[d][0] = 1;
//        }
//
//        for (int d = 1; d < coins.length; d++){
//            for (int v = 1; v <= val; v++){
//                if (coins[d] > v){
//                    m[d][v] = m[d-1][v];
//                }
//                else{
//                    m[d][v] = m[d-1][v] + m[d][v - coins[d]];
//                }
//            }
//        }
//
//        return m[coins.length-1][val];
//    }
//
//    static int numChanges2(int[] coins, int val){
//        //clever version reducing O(nm) space to O(n) where n = val
//        int[] m = new int[val+1];
//        m[0] = 1;//ways to make 0 cents with any coin is 1
//
//        for (int d = 0; d < coins.length; d++){
//            for (int v = coins[d]; v <= val; v++){
//                m[v] += m[v - coins[d]];
//            }
//        }
//
//        return m[val];
//    }
//
//    public static void main(String[] args){
//        System.out.println(minCoins(new int[]{1, 5, 10}, 18));//ans = 5 (10 + 5 + 1 + 1 + 1)
//        System.out.println(numChanges(new int[]{1, 2, 3}, 4));//ans = 4 (4*1, 2*1 + 2, 2*2, 3 + 1)
//        System.out.println(numChanges2(new int[]{1, 2, 3}, 4));//ans = 4 (4*1, 2*1 + 2, 2*2, 3 + 1)
//    }
//}
