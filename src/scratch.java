import java.util.*;
import java.util.stream.Collectors;

class scratch {
    public class Solution {
        int minPenaltySchdule(int[] d, int[] p){
            int n = d.length;
            List<Integer> jobs = new ArrayList<>();//list of jobs by index
            for (int i = 0; i < n; i++) jobs.add(i);

            //sort jobs according to deadline, tie break with penalty
            Collections.sort(jobs, (a, b)-> d[a] == d[b] ? p[b] - p[a] : d[a] - d[b]);

            //process the highest penalty job for each minute and take the penalty from the rest of the jobs
            int penalty = 0;
            for (int i = 0; i < jobs.size(); i++){
                if (i != 0 && d[jobs.get(i)] == d[jobs.get(i-1)]){
                    penalty += p[jobs.get(i)];
                }
            }

            return penalty;
        }
    }
    public static void main(String[] args) {
        scratch.Solution s = new scratch().new Solution();
        System.out.println(s.minPenaltySchdule(new int[]{1, 2, 1}, new int[]{2, 300000000, 1}));
    }
}
