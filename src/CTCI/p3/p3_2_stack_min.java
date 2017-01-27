package CTCI.p3;

import java.util.Stack;

class p3_2_stack_min {
    private static class minStack extends Stack<Integer>{
        Stack<Integer> mins = new Stack<Integer>();

        public void push(int element){
            if (min() == element){
                mins.push(element);
            }
            super.push(element);
        }

        public Integer pop(){
            int val = super.pop();
            if (val == min()){
                mins.pop();
            }
            return val;
        }

        public int min(){
            if (mins.isEmpty()) return Integer.MAX_VALUE;
            return mins.peek();
        }
    }
}
