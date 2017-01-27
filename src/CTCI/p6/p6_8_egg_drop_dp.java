package CTCI.p6;

class p6_8_egg_drop_dp {
    //find min number of drops for dropping at 100 floors with 2 eggs, and find where it is dropped
    static void eggDrop(int floors, int eggs){
        int[][] drops = new int[eggs+1][floors+1];
        int[][] dropAt = new int[eggs+1][floors+1];

        //initialize first row
        for (int j = 0; j <= floors; j++){
            drops[1][j] = j;
        }

        for (int i = 2; i <= eggs; i++){
            for (int j = 1; j <= floors; j++){
                if (i > j){
                    drops[i][j] = drops[i-1][j];
                    continue;
                }
                int minDrops = Integer.MAX_VALUE;
                for (int k = 1; k <= j; k++){
                    int numDrops = 1 + Math.max(drops[i-1][k-1], drops[i][j-k]);//DONT FORGET 1 + PART CRUCIAL !!!!!!!!
                    if (numDrops < minDrops){
                        minDrops = numDrops;
                        dropAt[i][j] = k;
                    }
                }
                drops[i][j] = minDrops;
            }
        }
        System.out.println(drops[eggs][floors] + " drops are necessary");
//        for (int i = 0; i < dropAt[0].length; i++){
//            System.out.println(i + " " + dropAt[2][i] + " " + drops[2][i]);
//        }
    }


    public static void main(String[] args){
        eggDrop(100, 2);
    }
}
