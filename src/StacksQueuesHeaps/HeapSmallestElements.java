package StacksQueuesHeaps;

import java.util.Arrays;

class MinHeap {
    int[] arr;
    int n;

    MinHeap(int[] arr){
        this.arr = Arrays.copyOf(arr, arr.length);
        this.n = arr.length;
        this.buildHeap();
    }

    int leftChild(int parent){
        return 2*parent + 1;
    }

    void buildHeap(){
        for (int i = n - 1; i >= 0; i--){
            siftDown(i);
        }
    }

    void siftDown(int root){
        //base case: no children
        if (leftChild(root) >= n) return;

        int swap = root;//index of node to swap with
        //check if left child is smaller than parent-if so, need to swap (unless right is smaller)
        int left = leftChild(root);
        if (arr[left] < arr[root]){
            swap = left;
        }

        //check that right is a child then check right value
        int right = left + 1;
        if (right < n && arr[right] < arr[swap]){
            swap = right;
        }

        //if heap property is not maintained, perform swap and continue down the heap
        if (swap != root){
            int temp = arr[swap];
            arr[swap] = arr[root];
            arr[root] = temp;

            siftDown(swap);
        }
    }

    int popMin(){
        if (arr.length == 0) return -1;

        int min = arr[0];

        //swap head with tail
        arr[0] = arr[n-1];
        this.n = n-1;
        if (n >= 1) siftDown(0);
        return min;
    }
}

class HeapSmallestElements {
    static void getKSmallest(int[] arr, int k){
        MinHeap heap = new MinHeap(arr);
        for (int i = 0; i < k; i++){
            System.out.println(heap.popMin());
        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{6, 2, 5, 8, 1, 4, 7, 3};
        getKSmallest(arr, 4);
    }
}
