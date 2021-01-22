package algorithm;

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class HeighBinaryTree {
    /*
    class Node
    	int data;
    	Node left;
    	Node right;
	*/
    public static int height(Node root) {
        // Write your code here.
        if(root == null) return 0;

        int h = 0;
        Queue<Node> q = new LinkedList<>();
        Queue<Integer> qH = new LinkedList<>();

        q.add(root);
        qH.add(0);

        while(!q.isEmpty()){
            Node n = q.remove();
            h = qH.remove();

            if(n.left != null){
                q.add(n.left);
                qH.add(h+1);
            }

            if(n.right != null){
                q.add(n.right);
                qH.add(h+1);
            }
        }
        return h;
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
        Node root = new Node(4);
        root.right = new Node(6);
        root.left = new Node(2);

        root.right.right = new Node(7);
        root.right.left = new Node(5);

        root.left.right = new Node(3);
        root.left.left = new Node(1);

        /*Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();*/
        int height = height(root);
        System.out.println(height);
    }
}
