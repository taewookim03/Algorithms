package leetcode;

/**
 * Created by Taewoo Kim on 4/13/2017.
 */
public class count_primes {
    public class Solution {
        public int countPrimes(int n) {
            //sieve to rule out non-primes
            boolean[] prime = new boolean[n];
            for (int i = 2; i < n; i++){
                prime[i] = true;
            }

            for (int i = 2; i * i < n; i++){
                if (!prime[i]) continue;
                for (int j = i * i; j < n; j+= i){
                    prime[j] = false;
                }
            }

            int count = 0;
            for (int i = 0; i < n; i++){
                if (prime[i]) count++;
            }
            return count;
        }
    }
}
