package CTCI.p2;

class p2_5_sum_lists {
    //recursive version
    static Node sum2(Node head1, Node head2, int carry){
        if (head1 == null && head2 == null) return null;
        if (head1 == null){
            head2.val += carry;
            return head2;
        }
        if (head2 == null){
            head1.val += carry;
            return head1;
        }

        int sum = head1.val + head2.val + carry;
        carry = sum / 10;

        Node sumNode = new Node(sum % 10);
        sumNode.next = sum2(head1.next, head2.next, carry);

        return sumNode;
    }


    //iterative
    static Node sum(Node head1, Node head2){
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        Node node1 = head1;
        Node node2 = head2;

        //first calculate the sum
        int sum = 0;
        int exp = 1;
        while (node1 != null && node2 != null){
            int a = node1.val;
            int b = node2.val;
            sum += (a + b) * exp;
            exp *= 10;

            node1 = node1.next;
            node2 = node2.next;
        }
        while (node1 != null){
            sum += node1.val * exp;
            exp *= 10;

            node1 = node1.next;
        }
        while (node2 != null){
            sum += node2.val * exp;
            exp *= 10;

            node2 = node2.next;
        }

        //convert sum into a list digit by digit
        Node sumHead = null;
        Node sumTail = null;
        while (sum > 0){
            int digit = sum % 10;
            Node node3 = new Node(digit);
            if (sumHead == null) {//first node gets assigned as head and tail
                sumHead = node3;
                sumTail = node3;
            }
            else{
                sumTail.next = node3;
                sumTail = node3;
            }
            sum /= 10;
        }

        return sumHead;
    }

    static void printReverse(Node head){
        printReverseRec(head);
        System.out.println();
    }
    static void printReverseRec(Node head){
        if (head == null) return;
        printReverseRec(head.next);
        System.out.print(head.val + " ");
    }

    public static void main(String[] args){
        //num1 = 617
        Node num1 = new Node(7);
        num1.next = new Node(1);
        num1.next.next = new Node(6);

        //num2 = 295
        Node num2 = new Node(5);
        num2.next = new Node(9);
        num2.next.next = new Node(2);
        num2.next.next.next = new Node(3);

        printReverse(sum(num1, num2));
        printReverse(sum2(num1, num2, 0));//recursive version
    }
}
