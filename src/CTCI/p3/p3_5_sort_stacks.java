package CTCI.p3;

import java.util.Random;
import java.util.Stack;

/**
 * Created by Taewoo Kim on 1/17/2017.
 */
class p3_5_sort_stacks {
    //using another temporary stack and a temporary variable
    static void sortStack(Stack<Integer> s){
        Stack<Integer> t = new Stack<>();
        while (!s.isEmpty()){
            int temp = s.pop();
            while (!t.isEmpty() && t.peek() > temp){
                s.push(t.pop());
            }
            t.push(temp);
        }

        while (!t.isEmpty()){
            s.push(t.pop());
        }
    }
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++){
            stack.push(rand.nextInt(10));
        }

        sortStack(stack);

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
