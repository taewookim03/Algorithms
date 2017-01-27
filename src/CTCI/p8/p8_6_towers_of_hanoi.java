package CTCI.p8;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class p8_6_towers_of_hanoi {
    //solve towers of hanoi using stacks
    static void hanoi(List<Stack<Integer>> towers, int n, int src, int dest){
        //base
        if (n == 0){
            return;
        }
        int spare = 3 - dest - src;//src + dest + spare = 3 always
        //recursively move n-1 disks to spare
        hanoi(towers, n-1, src, spare);
        //move bottom to dest
        towers.get(dest).push(towers.get(src).pop());
        System.out.println("move " + towers.get(dest).peek() + " from " + src + " to " + dest);
        //move spare to dest
        hanoi(towers, n-1, spare, dest);
    }

    public static void main(String[] args){
        List<Stack<Integer>> towers = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            towers.add(new Stack<Integer>());
        }
        for (int i = 3; i >= 1; i--){
            towers.get(0).push(i);
        }

        hanoi(towers, 3, 0, 2);

        Stack<Integer> r = towers.get(2);
        while (!r.isEmpty()){
            System.out.println(r.pop());
        }
    }
}
