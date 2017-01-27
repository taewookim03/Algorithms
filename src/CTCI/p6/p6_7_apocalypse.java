package CTCI.p6;


import java.util.Random;

class p6_7_apocalypse {
    static double girlFraction(int n){
        int girls = 0;
        int boys = 0;
        //n trials
        for (int i = 0; i < n; i++){
            int[] genders = runFamily();
            girls += genders[0];
            boys += genders[1];
        }
        return girls / (double)(girls + boys);
    }
    static int[] runFamily(){
        Random rand = new Random();
        int girls = 0;
        int boys = 0;
        while (girls == 0){
            if (rand.nextBoolean()){
                girls++;
            }
            else boys++;
        }
        return new int[]{girls, boys};
    }

    public static void main(String[] args){
        System.out.println(girlFraction(10000));
    }
}
