package algorithm;

import java.util.*;
import java.io.*;


public class LevelOrderTraversal {
    /*
    class Node
    	int data;
    	Node left;
    	Node right;
	*/
    public static void levelOrder(Node root) {

        if(root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){

            Node n = q.remove();

            System.out.print(n.data + " ");

            if(n.left != null){
                q.add(n.left);
            }

            if(n.right != null){
                q.add(n.right);
            }
        }
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.right = new Node(2);

        root.right.right = new Node(5);

        root.right.right.right = new Node(6);
        root.right.right.left = new Node(3);

        root.right.right.left.right= new Node(4);
        /*Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();*/
        levelOrder(root);
    }
}
