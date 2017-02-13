package leetcode;

import java.util.*;

/**
 * Created by Taewoo Kim on 2/11/2017.
 */
public class binary_watch {
    public List<String> readBinaryWatch(int num) {
        if (num > 10) return new ArrayList<>();

        List<String> results = new ArrayList<>();
        bt(0, num, new BitSet(10), results);

        return results;
    }

    void bt(int i, int k, BitSet bits, List<String> results){
        int remaining = 10 - i;
        if (k > remaining) return;

        if (k == 0){
            String t = time(bits);
            if (t != null) {
                results.add(t);
            }
            return;
        }

        bits.set(i);//turn on
        bt(i+1, k-1, bits, results);
        bits.clear(i);
        bt(i+1, k, bits, results);
        //keep off
    }

    String time(BitSet bits){
        int m = 0;
        for (int i = 0; i < 6; i++){
            if (bits.get(i)) m += 1 << i;
        }
        int h = 0;
        for (int i = 6; i < 10; i++){
            if (bits.get(i)) h += 1 << (i-6);
        }
        if (h >= 12 || m >= 60) return null;
        return String.format("%d:%02d", h, m);
    }

    public static void main(String[] args){
        binary_watch bw = new binary_watch();
        List<String> list = bw.readBinaryWatch(1);
        for (String s : list){
            System.out.println(s);
        }
    }
}
