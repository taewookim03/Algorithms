package CTCI.p2;

class p2_3_delete_middle_node {
    //delete without being given access to head, only the node to be deleted
    static void deleteMiddle(Node d){
        if (d == null || d.next == null) return;

        //shift the node after d by 1 left and delete that instead
        d.val = d.next.val;
        d.next = d.next.next;
    }

    static void print(Node head){
        Node n = head;
        while (n != null){
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        Node head = new Node(1);
        Node n = head;
        for (int i = 2; i <= 9; i++){
            n.next = new Node(i);
            n = n.next;
        }

        print(head);
        deleteMiddle(head.next.next.next);//delete node with val 4
        print(head);
    }
}
