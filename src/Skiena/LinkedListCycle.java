//class Node{
//    int data;
//    Node next;
//
//    Node(int data){
//        this.data = data;
//    }
//}
//
//class LinkedList{
//    Node head;
//
//
//
//    void add(int data){
//        Node newNode = new Node(data);
//        if (head == null){
//            head = newNode;
//        }
//        else{
//            newNode.next = head;
//            head = newNode;
//        }
//    }
//
//    void print(){
//        Node n = head;
//        while (n != null){
//            System.out.print(n.data + " ");
//            n = n.next;
//        }
//        System.out.println();
//    }
//
//    boolean hasCycle(){
//        boolean cycle = false;
//        if (head == null) return false;
//
//        Node fast = head, slow = head;
//        while (fast != null){
//            fast = fast.next.next;
//            slow = slow.next;
//            if (fast == slow) {
//                cycle = true;
//                break;
//            }
//        }
//        if (!cycle) return false;
//
//        //if there is a cycle, determine loop length and start of the cycle
//        slow = slow.next;
//        int cycle_len = 1;
//
//        while (fast != slow){
//            slow = slow.next;
//            cycle_len++;
//        }
//
//
//        Node cycle_start = null;
//        fast = slow = head;
//        for (int i = 0; i < cycle_len; i++) fast = fast.next;
//
//        while (fast != slow){
//            fast = fast.next;
//            slow = slow.next;
//        }
//        cycle_start = fast;
//        return true;
//    }
//
//    public static void main(String[] args){
//        LinkedList a = new LinkedList();
//        a.add(4);
//        a.add(3);
//        a.add(2);
//        a.add(1);
//        a.head.next.next.next.next = a.head.next;//cycle from 4 to 2
//
//        System.out.println(a.hasCycle());
//    }
//}