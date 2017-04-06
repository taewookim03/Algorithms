package leetcode;
import java.util.*;
/**
 * Created by Taewoo Kim on 4/5/2017.
 */
public class insert_delete_getrandom_o1 {
    public class RandomizedSet {
        Map<Integer,Integer> valIndexMap;//val->index
        List<Integer> array;//index->val
        Random random;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            valIndexMap = new HashMap<>();
            array = new ArrayList<>();
            random = new Random();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (valIndexMap.containsKey(val)) return false;
            valIndexMap.put(val, array.size());
            array.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!valIndexMap.containsKey(val)) return false;

            int index = valIndexMap.get(val);
            int lastElt = array.get(array.size()-1);
            //copy last element to index
            array.set(index, lastElt);
            array.remove(array.size()-1);//O(1) delete
            //update map
            valIndexMap.put(lastElt, index);
            valIndexMap.remove(val);

            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return array.get(random.nextInt(array.size()));
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
