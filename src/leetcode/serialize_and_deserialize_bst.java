package leetcode;

/**
 * Created by Taewoo Kim on 4/1/2017.
 */
public class serialize_and_deserialize_bst {
    public class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int val){
            this.val = val;
        }
    }


    //O(n^2) BST insert vs O(n) boundary method - deserialize
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serializeUtil(root, sb);
            return sb.toString();
        }
        private void serializeUtil(TreeNode root, StringBuilder sb){
            if (root == null) return;

            sb.append(root.val).append(" ");
            serializeUtil(root.left, sb);
            serializeUtil(root.right, sb);
        }

        //O(n) optimal
        public TreeNode deserialize(String data){
            if (data.length() == 0) return null;
            return buildTree(data.split(" "), Integer.MIN_VALUE, Integer.MAX_VALUE, new int[]{0});
        }
        private TreeNode buildTree(String[] nodes, int low, int high, int[] pos){
            if (pos[0] == nodes.length) return null;
            int val = Integer.parseInt(nodes[pos[0]]);
            if (val < low || val > high) return null;

            TreeNode root = new TreeNode(val);
            pos[0]++;
            root.left = buildTree(nodes, low, val, pos);
            root.right = buildTree(nodes, val, high, pos);
            return root;
        }

        //O(n^2) naive
        // Decodes your encoded data to tree.
        public TreeNode deserialize2(String data) {
            if (data.length() == 0) return null;

            TreeNode root = null;
            for (String s : data.split(" ")){
                int val = Integer.parseInt(s);
                root = addNode(root, val);
            }
            return root;
        }
        private TreeNode addNode(TreeNode node, int val){
            if (node == null){
                return new TreeNode(val);
            }
            if (val > node.val){
                node.right = addNode(node.right, val);
            }
            else{
                node.left = addNode(node.left, val);
            }
            return node;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
