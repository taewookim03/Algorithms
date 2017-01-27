package CTCI.p2;

class p2_7_intersection {
    private static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }

    static Node intersection(Node head1, Node head2){
        //if allowed, augment node with visited = false and see first conflict, return
        //if not, use 2 traverses:
        if (head1 == null || head2 == null) return null;

        int count1 = 1;
        Node n1 = head1;
        while (n1.next != null){
            count1++;
            n1 = n1.next;
        }
        int count2 = 1;
        Node n2 = head2;
        while (n2.next != null){
            count2++;
            n2 = n2.next;
        }

        //no intersection
        if (n1 != n2) return null;

        //reset nodes and compare
        n1 = head1;
        n2 = head2;
        if (count1 < count2){
            for (int i = 0; i < (count2 - count1); i++){
                n2 = n2.next;
            }
        }
        else if (count2 < count1){
            for (int i = 0; i < count1 - count2; i++){
                n1 = n1.next;
            }
        }

        while (n1 != n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }


    public static void main(String[] args){
        Node head1 = new Node(1);
        head1.next = new Node(2);
        Node middle = new Node(3);
        head1.next.next = middle;
        middle.next = new Node(4);
        middle.next.next = new Node(5);

        Node head2 = new Node(0);
        head2.next = new Node(2);
        head2.next.next = new Node(2);
        head2.next.next.next = middle;

        Node intersect = intersection(head1, head2);
        if (intersect != null) System.out.println(intersect.val);
    }
}
