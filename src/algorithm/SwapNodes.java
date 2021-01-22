package algorithm;

import java.util.Arrays;

public class SwapNodes {

    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {
        int[][] swaping = new int[indexes.length][queries.length];

        for(int i =0; i < indexes.length ; i++){
            System.out.println(Arrays.toString(indexes[i]));
        }

        int a = -2;
        int b = -2;

        while(a != 0 && b != 0){
            a += 2;
            b += 2;

            if(indexes[a][b] != -1)
                swaping[0][0] = indexes[a][b];
        }



        System.out.println(Arrays.toString(queries));


        return swaping;
    }


    public static void main(String[] args){

        /*  5
            2 3
            -1 4
            -1 5
            -1 -1
            -1 -1
            1
            2*/

        int[][] indexes = new int[5][2];
        indexes = new int[][]{{2, 3}, {-1, 4}, {-1, 5}, {-1, -1}, {-1, -1}};

        int[] queries = new int[1];
        queries[0] = 2;


        int[][] result = swapNodes(indexes, queries);

    }
}
