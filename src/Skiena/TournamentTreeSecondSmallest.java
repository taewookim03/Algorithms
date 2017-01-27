////finding min and second min in less than 2n - 3 comparisons
////linear traverse with min and second min takes 2n - 3 comparisons exactly
////(1 cmp on first two elements, 2 cmp each on the other n-2 elements)
//
//import java.util.ArrayDeque;
//import java.util.Queue;
//
//class Node{
//    int idx;//index of the array
//    Node left, right;
//
//    Node(int idx){
//        this.idx = idx;
//        left = right = null;
//    }
//}
//
//class TournamentTree{
//    int[] arr;
//    Node root;//root of the tree
//    Queue<Node> winners = new ArrayDeque<>();//pop candidates and insert winners until 1 remaining
//    int secondSmallest;
//
//    TournamentTree(int[] arr){
//        this.arr = arr;
//        buildTree();
//        secondSmallest = findSecondSmallest();
//    }
//
//    boolean isOdd(int n){
//        return n % 2 == 1;
//    }
//
//    void buildTree(){
//        if (arr.length == 0) return;
//        if (arr.length == 1) {
//            root = new Node(0);
//            return;
//        }
//
//        //first make leaves out of the array and process winners from them into the queue
//        for (int i = 0; i < arr.length - 1; i += 2){
//            Node left = new Node(i);
//            Node right = new Node(i+1);
//
//            //winner between two children
//            Node root = new Node(arr[left.idx] < arr[right.idx] ? left.idx : right.idx);
//            root.left = left;
//            root.right = right;
//
//            //insert into the winner queue
//            winners.add(root);
//        }
//
//        //if odd number of leaves, put the bye in (last elt)
//        if (isOdd(arr.length)){
//            winners.add(new Node(arr.length - 1));
//        }
//
//        //build the rest of the tree
//        while (winners.size() > 1){
//            int n = winners.size();
//            for (int i = 0; i < n; i += 2){
//                Node left = winners.remove();
//                Node right = winners.remove();
//                Node root = new Node(arr[left.idx] < arr[right.idx] ? left.idx : right.idx);
//                root.left = left;
//                root.right = right;
//
//                winners.add(root);
//            }
//            if (isOdd(n)){
//                winners.add(winners.remove());
//            }
//        }
//        root = winners.remove();
//    }
//    int findSecondSmallest(){
//        int winner = arr[root.idx];//smallest val
//        Node node = root;//winner node
//        int second_smallest = Integer.MAX_VALUE;
//
//        while(node.left != null && node.right != null){
//            int left_val = arr[node.left.idx];
//            int right_val = arr[node.right.idx];
//
//            if (left_val == winner){
//                if (right_val < second_smallest) second_smallest = right_val;
//                node = node.left;
//            }
//            else{
//                if (left_val < second_smallest) second_smallest = left_val;
//                node = node.right;
//            }
//        }
//
//        return second_smallest;
//    }
//}
//
//class TournamentTreeSecondSmallest {
//    static void findSecondMin(int[] arr){
//        if (arr.length < 2) {
//            System.out.println("array must be larger than size 2");
//            return;
//        }
//        TournamentTree tt = new TournamentTree(arr);
//        System.out.println("Smallest: " + arr[tt.root.idx] + "\nSecond smallest: " + tt.secondSmallest);
//    }
//
//    public static void main(String[] args){
//        int arr[] = new int[]{9, 6, 100, 61, 10, 12, 17};
//        findSecondMin(arr);
//    }
//}
