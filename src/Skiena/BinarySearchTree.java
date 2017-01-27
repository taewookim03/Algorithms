//class BinarySearchTree {
//    class Node{
//        int val;
//        Node left, right;
//
//        Node(int val){
//            this.val = val;
//            left = right = null;
//        }
//    }
//
//    Node root;
//
//    BinarySearchTree(){
//        this.root = null;
//    }
//
//    void insert(int val){
//        root = insertRec(root, val);
//    }
//
//    Node insertRec(Node node, int val){
//        //base case
//        if (node == null) return new Node(val);
//
//        if (val < node.val){
//            node.left = insertRec(node.left, val);
//        }
//        else{
//            node.right = insertRec(node.right, val);
//        }
//        return node;
//    }
//
//    void inorder(){
//        inorderRec(root);
//        System.out.println();
//    }
//
//    void inorderRec(Node node){
//        //base case
//        if (node == null) return;
//
//        inorderRec(node.left);
//        System.out.print(node.val + " ");
//        inorderRec(node.right);
//    }
//
//    void deleteKey(int val){
//        root = deleteRec(root, val);
//    }
//
//    Node deleteRec(Node node, int val){
//        if (node == null) return node;
//        if (val < node.val) node.left = deleteRec(node.left, val);
//        else if (val > node.val) node.right = deleteRec(node.right, val);
//        else{
//            if (node.left == null){
//                node = node.right;
//            }
//            else if (node.right == null){
//                node = node.left;
//            }
//            else{
//                //2 children
//                Node successor = min(node.right);
//                node.val = successor.val;
//                node.right = deleteRec(node.right, successor.val);
//            }
//        }
//        return node;
//    }
//
//    Node min(Node node){
//        if (node == null) return node;
//        while (node.left != null){
//            node = node.left;
//        }
//        return node;
//    }
//
//    // Driver Program to test above functions
//    public static void main(String[] args)
//    {
//        BinarySearchTree tree = new BinarySearchTree();
//
//        /* Let us create following BST
//              50
//           /     \
//          30      70
//         /  \    /  \
//        20   40  60   80 */
//        tree.insert(50);
//        tree.insert(30);
//        tree.insert(20);
//        tree.insert(40);
//        tree.insert(70);
//        tree.insert(60);
//        tree.insert(80);
//
//        System.out.println("Inorder traversal of the given tree");
//        tree.inorder();
//
//        System.out.println("\nDelete 20");
//        tree.deleteKey(20);
//        System.out.println("Inorder traversal of the modified tree");
//        tree.inorder();
//
//        System.out.println("\nDelete 30");
//        tree.deleteKey(30);
//        System.out.println("Inorder traversal of the modified tree");
//        tree.inorder();
//
//        System.out.println("\nDelete 50");
//        tree.deleteKey(50);
//        System.out.println("Inorder traversal of the modified tree");
//        tree.inorder();
//    }
//}
