package algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class Main {


    public static int maxWidthOfVerticalArea(int[][] points) {
        int maxWidth = 0;
        int rest = 0;
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i=0 ; i < points.length ; i++){
            arr.add(points[i][0]);
        }

        Collections.sort(arr);

        for (int i=1 ; i < arr.size() ; i++){
            //System.out.println(arr.get(i));
            rest = Math.abs((arr.get(i-1)-arr.get(i)));
            if(rest > maxWidth){
                maxWidth = rest;
            }
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        int[][] points = {{3,1},{9,0},{1,0},{1,4},{5,3},{8,8},{3,1},{9,0},{1,0},{1,4},{5,3},{8,8}};

        System.out.println(maxWidthOfVerticalArea(points));
    }
}
