package CTCI.p8;

class p8_11_coins {
    static int changes(int[] coins, int val){
        int[][] ways = new int[coins.length][val+1];
        //first row
        for (int j = 0; j <= val; j++){
            ways[0][j] = j % coins[0] == 0 ? 1 : 0;//KEY IF WE WANT IT TO WORK WITHOUT PENNIES
        }
        //first col
        for (int i = 1; i < coins.length; i++){
            ways[i][0] = 1;
        }

        for (int i = 1; i < coins.length; i++){
            for (int j = 1; j <= val; j++){
                ways[i][j] = ways[i-1][j];
                if (coins[i] <= j) ways[i][j] += ways[i][j-coins[i]];
            }
        }
        return ways[coins.length-1][val];
    }
    public static void main(String[] args){
        int[] coins = new int[]{1, 5, 10, 25};
        System.out.println(changes(coins, 100));
    }
}
