package Other;

import java.util.Random;

/*
7-19. Use a random number generator (rng04) that generates numbers from {0,1,2,3,4} with equal probability to write
a random number generator that generates numbers from 0 to 7 (rng07) with equal probability.
What are expected number of calls to rng04 per call of rng07?
 */
class RNG7fromRNG4 {
    //provided:
    static int rng04(){
        Random random = new Random();
        return random.nextInt(5);
    }

    //make rng07 (0-7 inclusive)
    


}
