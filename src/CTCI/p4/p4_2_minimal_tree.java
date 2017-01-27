package CTCI.p4;

class p4_2_minimal_tree {
    private static class Node{
        int val;
        Node left, right;
        Node(int val){
            this.val = val;
        }
    }

    static Node sortedArrayToTree(int[] arr){
        return minTree(arr, 0, arr.length-1);
    }
    static Node minTree(int[] arr, int lo, int hi){
        //base case
        if (hi < lo) return null;

        int mid = (hi + lo + 1) / 2;
        Node root = new Node(arr[mid]);
        root.left = minTree(arr, lo, mid-1);
        root.right = minTree(arr, mid+1, hi);
        return root;
    }

    static void print(Node root){
        if (root == null) return;
        System.out.print(root.val);
        print(root.left);

        print(root.right);
    }

    public static void main(String[] args){
        int[] arr = new int[7];
        for (int i = 0; i < arr.length; i++){
            arr[i] = i+1;
        }

        Node root = sortedArrayToTree(arr);
        print(root);
    }
}
