package Graph;//Union-Find by Rank and Path compression - Disjoint Set
//log(m logn) where m = number of union/find operations, n = number of set elements

import java.util.HashMap;
import java.util.Map;

class DisjointSet{
    class Node{
        int data;
        int rank;
        Node parent;

        Node(int data){
            this.data = data;
            this.parent = this;
            this.rank = 0;
        }
    }

    Map<Integer, Node> map = new HashMap<>();

    void makeSet(int data){
        Node newNode = new Node(data);
        map.put(data, newNode);
    }

    void union(int data1, int data2){
        Node node1 = map.get(data1);
        Node node2 = map.get(data2);

        Node parent1 = find(node1);
        Node parent2 = find(node2);

        //application for graph - if node1 and node2 belong to the same set, there is a cycle
        if (parent1.equals(parent2)){
            System.out.println("if this is a graph there is a cycle");
            return;
        }

        if (parent1.rank >= parent2.rank){
            parent2.parent = parent1;

            //if they have the same rank, increment parent1's rank by 1
            parent1.rank = parent1.rank == parent2.rank ? parent1.rank + 1 : parent1.rank;
        }
        else{
            parent1.parent = parent2;
        }
    }

    int find(int data){
        return find(map.get(data)).data;
    }

    Node find(Node node){
        //base case - node is the representative of the set
        if (node.parent.equals(node)){
            return node;
        }
        //find by recursion + path compression step-make parent immediately available from all nodes traversed
        node.parent = find(node.parent);

        return node.parent;
    }

    static public void main(String[] args){
        DisjointSet ds = new DisjointSet();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(3, 1);//this makes a cycle
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);

        for (int i = 1; i <= 7; i++){
            System.out.println(ds.find(i));
        }
    }
}