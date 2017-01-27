package CTCI.p10;



class RankTree {
    RankNode root;

    private class RankNode{
        int val;
        int numLeft;
        RankNode left, right;
        RankNode(int val){
            this.val = val;
            numLeft = 0;
        }
    }

    void track(int val){
        root = insert(root, val);
    }
    RankNode insert(RankNode node, int val){
        if (node == null){
            node = new RankNode(val);
        }
        else if (val <= node.val){
            //if less than or equal, go left and increment node's left children counter
            node.numLeft++;
            node.left = insert(node.left, val);
        }
        else{
            node.right = insert(node.right, val);
        }
        return node;
    }

    int getRankOfNumber(int val){
        return search(root, val);
    }
    int search(RankNode node, int val){
        //modified search
        if (node == null) return -1;
        if (node.val == val) return node.numLeft;

        if (val <= node.val){
            //take left
            return search(node.left, val);
        }
        else{
            int rightSearch = search(node.right, val);
            if (rightSearch == -1) return -1;//if node not found
            else{
                return 1 + node.numLeft + rightSearch;
            }
        }
    }

    public static void main(String[] args){
        RankTree rt = new RankTree();
        int[] data = new int[]{5, 1, 4, 4, 5, 9, 7, 13, 3};
        for (int i : data){
            rt.track(i);
        }
        System.out.println(rt.getRankOfNumber(1));
        System.out.println(rt.getRankOfNumber(3));
        System.out.println(rt.getRankOfNumber(4));
        System.out.println(rt.getRankOfNumber(10));
    }
}
