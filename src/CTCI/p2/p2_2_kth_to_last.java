package CTCI.p2;

class p2_2_kth_to_last {
    static Node kthToLast(Node head, int k){
        //check 0 nodes
        if (head == null) return null;

        Node left = head;
        Node right = head;
        for (int i = 0; i < k-1; i++){
            right = right.next;
            if (right == null) return null;//fewer than k elements
        }

        while (right.next != null){
            left = left.next;
            right = right.next;
        }

        return left;
    }

    public static void main(String[] args){
        Node head = new Node(1);
        Node n = head;
        for (int i = 2; i <= 9; i++){
            n.next = new Node(i);
            n = n.next;
        }

        Node ptr = head;
        while (ptr != null){
            System.out.print(ptr.val + " ");
            ptr = ptr.next;
        }
        System.out.println();

        System.out.println(kthToLast(head, 2).val);
    }


}
