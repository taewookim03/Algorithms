package LinkedList;

class Solution{
    private static class LinkedList{
        private class Node{
            int data;
            Node next;

            Node(int data){
                this.data = data;
                next = null;
            }
        }
        Node head = null;

        void add(int data){
            Node newNode = new Node(data);
            if (head != null){
                newNode.next = head;
            }
            head = newNode;
        }

        void print(){
            Node n = head;
            while (n != null){
                System.out.print(n.data + " ");
                n = n.next;
            }
            System.out.println();
        }

        Node reverse(Node root){
            if (root == null || root.next == null) return root;

            head = reverse(root.next);
            Node last = root.next;
            last.next = root;
            root.next = null;

            return head;
        }
    }
    public static void main(String[] args){
        LinkedList a = new LinkedList();
        a.add(3);
        a.add(2);
        a.add(1);

        a.print();
        a.reverse(a.head);
        a.print();
    }
}
