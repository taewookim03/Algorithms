package CTCI.p4;


import java.util.Random;

class randomBST{
    private Node root;

    public static class Node{
        int val;
        int size;//size of the subtree of which this node is the root
        Node left, right;
        Node(int val){
            this.val = val;
            size = 1;
        }
    }

    public void insert(int val){
        root = insert(root, val);
    }
    private Node insert(Node node, int val){
        if (node == null) return new Node(val);

        if (val < node.val){
            node.left = insert(node.left, val);
        }
        else if (val > node.val){
            node.right = insert(node.right, val);
        }
        else{
            //duplicate values-ignore because BST is supposed to be an ordered set
        }

        //increase the size of the node passed through
        node.size++;
        return node;
    }

    public void delete(int val){
        root = delete(root, val);
    }
    private Node delete(Node node, int val){
        if (node == null) return null;

        if (val < node.val){
            node.left = delete(node.left, val);
        }
        else if (val > node.val){
            node.right = delete(node.right, val);
        }
        else{
            //0 or 1 child
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            //2 children
            Node temp = node;
            node = min(node.right);//get successor of node
            node.right = delete(temp.right, node.val);
            node.left = temp.left;
            node.size = temp.size;
        }
        node.size--;

        return node;
    }

    private Node min(Node node){
        if (node == null) return null;
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

    public Node find(int val){
        return find(root, val);
    }
    private Node find(Node node, int val){
        if (node == null) return null;
        if (node.val == val) return node;
        else if (val < node.val) return find(node.left, val);
        else return find(node.right, val);
    }

    public void inorder(){
        inorder(root);
        System.out.println();
    }
    private void inorder(Node node){
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.val + "(" + node.size + ") ");
        inorder(node.right);
    }

    public Node getRandomNode(){
        return getRandomNode(root);
    }
    private Node getRandomNode(Node node){
        if (node == null) return null;

        Random rand = new Random();
        int r = rand.nextInt(node.size);
        int leftSize = node.left == null ? 0 : node.left.size;

        //with 1/size chance, pick node - in this case return this
        if (r < 1) return node;

        //with left/size chance, pick left and recur
        else if (r < 1 + leftSize) return getRandomNode(node.left);
        //same with right
        else return getRandomNode(node.right);
    }
}

class p4_11_random_node {
    //insert, find, delete, getRandomNode()
    //use an array?
    //augment node to track subtree size, pick node randomly based on size starting from root, proportional to the size
    public static void main(String[] args){
        randomBST bst = new randomBST();
        bst.insert(3);
        bst.delete(3);
        bst.insert(3);
        bst.insert(1);
        bst.insert(0);
        bst.insert(2);
        bst.insert(5);
        bst.insert(4);
        bst.insert(6);
        //bst.delete(5);
        System.out.println(bst.find(4).val);
        bst.inorder();

        int[] count = new int[7];
        for (int i = 0; i < 10000; i++){
            count[bst.getRandomNode().val]++;
        }
        for (int c : count){
            System.out.print(c + " ");
        }
    }
}
