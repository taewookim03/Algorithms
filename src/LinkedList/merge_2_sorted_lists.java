package LinkedList;

/**
 * Created by Taewoo Kim on 1/31/2017.
 */
public class merge_2_sorted_lists {
    //recursive
    Node MergeLists(Node headA, Node headB) {
        // This is a "method-only" submission.
        // You only need to complete this method
        if (headA == null) return headB;
        if (headB == null) return headA;

        if (headA.data < headB.data){
            headA.next = MergeLists(headA.next, headB);
            return headA;
        }
        else{
            headB.next = MergeLists(headA, headB.next);
            return headB;
        }
    }


    //iterative
    Node MergeLists2(Node headA, Node headB) {
        if (headA == null) return headB;
        if (headB == null) return headA;

        Node current;
        if (headA.data < headB.data){
            current = headA;
            headA = headA.next;
        }
        else{
            current = headB;
            headB = headB.next;
        }
        Node head = current;

        while(headA != null && headB != null){
            if (headA.data < headB.data){
                current.next = headA;
                headA = headA.next;
            }
            else{
                current.next = headB;
                headB = headB.next;
            }
            current = current.next;
        }

        if (headA != null){
            current.next = headA;
        }
        else{
            current.next = headB;
        }
        return head;
    }
}
