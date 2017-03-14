package Trees;

class Solution{
    static class BinaryTree{
        static class Node{
            int data;
            Node left, right;
            Node(int data){
                this.data = data;
            }
        }
        Node root;//root of the BT
        Node head;//head of the converted list

        Node BinaryTree2DoubleLinkedList(Node node, Node prev){
            //edge case if first call is null
            if (node == null) return null;

            //recursively convert right
            if (node.right != null){
                prev = BinaryTree2DoubleLinkedList(node.right, prev);
            }

            //connect with the last node looked at (minimum of right tree)
            node.right = prev;
            if (prev != null) prev.left = node;
            prev = node;

            //pass last node looked at to left subtree and recurse
            if (node.left != null){
                prev = BinaryTree2DoubleLinkedList(node.left, prev);
            }

            return prev;
        }

        void printList(Node head){
            while(head != null){
                System.out.print(head.data + " ");
                head = head.right;
            }
            System.out.println();
        }
        void printListRev(Node tail){
            while (tail != null){
                System.out.print(tail.data + " ");
                tail = tail.left;
            }
            System.out.println();
        }

        // Driver program to test above functions
        public static void main(String[] args)
        {
            BinaryTree tree1 = new BinaryTree();
            tree1.root = new Node(1);
            tree1.root.left = new Node(2);
            tree1.root.right = new Node(5);
            tree1.root.left.left = new Node(3);
            tree1.root.left.right = new Node(4);
            tree1.root.right.left = new Node(7);
            tree1.root.right.left.left = new Node(8);

            /*
            BinaryTree tree = new BinaryTree();
            tree.root = new Node(10);
            tree.root.left = new Node(12);
            tree.root.right = new Node(15);
            tree.root.left.left = new Node(25);
            tree.root.left.right = new Node(30);
            tree.root.right.left = new Node(36);
            */

            // convert to DLL
            tree1.head = tree1.BinaryTree2DoubleLinkedList(tree1.root, null);

            // Print the converted List
            tree1.printList(tree1.head);

            // print reverse
            Node n = tree1.head;
            while (n.right != null){
                n = n.right;
            }
            tree1.printListRev(n);
        }
    }
}
