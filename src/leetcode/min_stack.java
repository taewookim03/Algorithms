package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Taewoo Kim on 4/6/2017.
 */
public class min_stack {
    public class MinStack {
        Deque<Integer> stack;
        Deque<Integer> minStack;
        /** initialize your data structure here. */
        public MinStack() {
            stack = new ArrayDeque<>();
            minStack = new ArrayDeque<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty() || x <= minStack.peek()){
                minStack.push(x);
            }
        }

        public void pop() {
            if (stack.isEmpty()) return;
            int top = stack.pop();
            if (top == minStack.peek()){
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
