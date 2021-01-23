package algorithm;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class SwapNodes {

    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {
        int[] tree = new int[indexes.length * 2 + 1];
        int nodeCount = 1;
        int count = 1;
        tree[0] = 1;
        for(int i =0; i < indexes.length ; i++){
            for(int j =0; j < indexes[0].length ; j++) {
                tree[count] = indexes[i][j];
                count++;
                if(indexes[i][j] != -1) nodeCount++;
            }
        }
        int[][] result = new int[queries.length][nodeCount];
        
        System.out.println(Arrays.toString(tree));

        double d = 0;
        int start = 0;
        int iterations = 0;
        int tmp = 0;
        for(int i =0; i < queries.length ; i++){
            d = queries[i];
            start = (int)Math.pow((double)2, d) - 2 + 1 ;
            iterations = (int)Math.pow((double)2, d+1) - 2;
            for(int j = start; j < iterations ; j+=2) {
                tmp = tree[j+1];
                tree[j+1] = tree[j];
                tree[j] = tmp;
            }

            System.out.println(Arrays.toString(printInOrderTraversal(tree, nodeCount)));
            result[i] = printInOrderTraversal(tree, nodeCount);
            //System.out.println(Arrays.toString(tree));
        }

        return result;
    }

    static int[] printInOrderTraversal(int[] tree, int numNode){
        Stack<Integer> s = new Stack<>();
        int[] tranverse = new int[numNode];
        int index = 0;
        int count = 0;
        while(!s.isEmpty() || tree[index] != -1){

            while(index < tree.length && tree[index] != -1){
                s.add(index);
                int left = (2 * index) + 1;
                index = left;
            }

            index= s.pop();
            //System.out.print(tree[index] + " " + "Count: "+count);
            tranverse[count] = tree[index];
            count++;


            index = (2 * index) + 2;
        }

        return tranverse;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                System.out.print(result[resultRowItr][resultColumnItr] + " ");

            }
            System.out.println(" ");
        }
    }
    /*
    public static void main(String[] args){

        int[][] indexes = new int[5][2];
        indexes = new int[][]{{2, 3}, {-1, 4}, {-1, 5}, {-1, -1}, {-1, -1}};

        int[] queries = new int[1];
        queries[0] = 2;


        int[][] result = swapNodes(indexes, queries);

        for(int i =0; i < result.length ; i++){
            for(int j =0; j < result[0].length ; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println(" ");
        }

    }*/
}
