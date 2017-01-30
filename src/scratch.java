import java.util.Random;

class scratch{
    scratch(ListNode head){
        this.head = head;
    }
    ListNode head;
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    int getRandom(){
        //count length
        ListNode curr = head;
        int count = 0;
        while (curr != null){
            count++;
            curr = curr.next;
        }

        curr = head;
        Random random = new Random();
        while (curr != null){
            if (random.nextInt(count--) == 0){
                return curr.val;
            }
            curr = curr.next;
        }
        return -1;
    }
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        scratch scratch = new scratch(head);
        for (int i = 0; i < 100; i++){
            System.out.println(scratch.getRandom());
        }
    }
}
