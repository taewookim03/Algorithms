package Math;

/**
 * Created by Taewoo Kim on 2/3/2017.
 * http://www.geeksforgeeks.org/modular-exponentiation-power-in-modular-arithmetic/
 */
public class mod_exponentiation {
    static int pow(int x, int y, int p){
        int res = 1;
        while (y > 0){
            if ((y & 1) == 1){
                res = (res * x) % p;
            }
            y >>= 1;
            x = (x * x) % p;
        }
        return res;
    }

    public static void main(String[] args){
        System.out.println(pow(2,5,13));
    }
}