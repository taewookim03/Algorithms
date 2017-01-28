package Hackerrank_world_codesprint_9;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


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
