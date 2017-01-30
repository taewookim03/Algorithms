package Hackerrank_world_codesprint_9;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
https://www.hackerrank.com/contests/world-codesprint-9/challenges/kingdom-division/editorial


This is an explanation (not exactly editorial): So, first you have a tree. When you divide the kingdom, it says that if a city is not connected to another, it will cause war.
All leaves of the tree can only connect to their parent, so immediately, you can forget about all leaves, and just assume they are connected to their parent.
A final leaf could be the root itself, if it only has one child. So if it only has one child, forget about it, and make the new root the child, and remember that the true root is connected to it.
Now, you have many nodes that are still not connected so they MUST connect to at least one other node, and some nodes that are already connected, so they dont HAVE TO connect to anything else.
Lets imagine the first node (root) is not connected, and has two childs, these childs have one child each, so they are connected already.
0->1
0->2
0 is root, besides these there is also nodes 3 and 4, leaves and connected to 1 and 2 so we dont bother with them. Bitmask of connected nodes 011, so node 0 is not connected, node 1 and 2 are connected.
Now you need to find all combinations you can make with these. The root could connect to node 1, connect to node 2, connect to both, or connect to neither, this is 4 possibilities, this is because it has two childs, the possibilities are 2^childs.
HOWEVER, the root is not connected, so it HAS to connect to somehting, so "connect to neither" is not available, so possibiltities are 2^childs-1.
Nodes 1 and 2 dont have any childs to connect to (they are already connected by default), so their "subtrees" only have 1 possibility. So the total setups for that tree is 2^2-1 = 3, however you have to multiply by 2, to give the one cities to Kid A and the others to Kid B, or the reverse, so 6 is the answer.
Now, if your tree is more complex, you still do the same, find the number of possibilities for a subtree (the smallest being next to a leaf, with only one possibility), and work your way up. Once you have defined all the possibilities for the subtrees child to a node, figure out the possibilities for the subtree of the rooting node itself. This is not just a multiplication sadly, if a node has 10 childs.
Then you have around 2^10 possibilities of connections to these childs, do you connect to child 1 only? child 2? 3, 4, 5..., or do you connect to 2 childs? 1+2, 1+3, 1+4.. 2+3, 2+4... 9+10?, 3 childs? ... 10 childs? no childs?
This is slow and SHOULDNT pass, but it seems to pass the test cases (probably because its medium and not expert), just use a number, have long childsconnected; as a bitmask (like gray codes, but without the gray part). If the bit i is 1, then the child i is connected. So you start with childsconnected = 0; no child is connected. If the parent node is not marked as connected then it wont use this, but if it is already connected (from its own parent), then it can.
Then you figure out how many possibilities the subtree has if the root is not connected to any of its childs (multiply the subtrees), store that in your accumulator (addition). Then childsconnected++; makes it 1, or * the child 1 is now connected *. So again you figure out all the possibilities with only the child 1 connected, add up. Then childsconnected is 2, so the second bit is turned on (child 2 is now connected), and so on until childsconnected = 2^childs-1 which will have all 10 bits turned on.
Once you are done, now you have the total number of possibilities for the subtree with root you selected. You save PC and PnotC, * possibilities if the root is connected *, * possibilities if it is not connected * so that its parent, when it starts calculating its own possibilities can just retrieve the correct number instead of recalculating the child subtree. Thats it.
 */

class kingdom_division {
    static final int PRIME = (int)Math.pow(10, 9) + 7;
    static int modPower(int n, int p){
        long result = 1;
        for (int i = 0; i < p; i++){
            result = (result * n) % PRIME;
        }
        return (int)result;
    }
    private static class Node{
        Set<Node> edges = new HashSet<>();
    }
    static int peaceConfig(Node root){
        Set<Integer> degrees = new HashSet<>();
        int total = countNonLeaf(root, new HashSet<Node>(), degrees);
        //System.out.println(total + " " + degrees.size());
        int ans = modPower(2, total);
        for (Integer degree : degrees){
            ans -= modPower(2, total - degree);
            ans = ans % PRIME;
        }
        return (ans + PRIME) % PRIME;
    }
    static int countNonLeaf(Node root, Set<Node> visited, Set<Integer> degrees){
        if (root == null) return 0;
        //special 2 node case
        if (isLeaf(root) && isLeaf(root.edges.iterator().next())) return 1;

        visited.add(root);
        int count = 0;
        for (Node child : root.edges){
            if (!visited.contains(child)){
                count += countNonLeaf(child, visited, degrees);
            }
        }

        if (isolated(root)) degrees.add(root.edges.size());
        if (!isLeaf(root)) count++;

        return count;
    }
    static boolean isLeaf(Node node){
        return node.edges.size() == 1;
    }
    static boolean isolated(Node node){
        if (isLeaf(node)) return false;
        for (Node child : node.edges){
            if (isLeaf(child)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++){
            nodes[i] = new Node();
        }

        for(int a0 = 0; a0 < n-1; a0++){
            int u = in.nextInt();
            int v = in.nextInt();
            // your code goes here
            nodes[u-1].edges.add(nodes[v-1]);
            nodes[v-1].edges.add(nodes[u-1]);
        }
        Node root = nodes[0];

        System.out.println(peaceConfig(root));
    }
}
