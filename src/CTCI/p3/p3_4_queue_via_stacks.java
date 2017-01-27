package CTCI.p3;

import java.util.Stack;

/**
 * Created by Taewoo Kim on 1/17/2017.
 */
class p3_4_queue_via_stacks {
    private static class MyQueue<T>{
        Stack<T> addingStack = new Stack<>();
        Stack<T> removingStack = new Stack<>();

        public boolean isEmpty(){
            return addingStack.isEmpty() && removingStack.isEmpty();
        }

        public void add(T e){
            addingStack.push(e);
        }

        public T remove(){
            if (removingStack.isEmpty()){
                shiftStacks();
            }
            return removingStack.pop();
        }

        public T front(){
            if (removingStack.isEmpty()){
                shiftStacks();
            }
            return removingStack.peek();
        }

        private void shiftStacks(){
            while (!addingStack.isEmpty()){
                removingStack.push(addingStack.pop());
            }
        }
    }

    public static void main(String[] args){
        MyQueue<Integer> q = new MyQueue<Integer>();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        while (!q.isEmpty()){
            System.out.println(q.remove());
        }

    }
}
