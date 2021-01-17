package algorithm;

import java.util.Arrays;

public class BubbleSort {
    static int sizeArr;
    static int[] arr;
    public static void main (String args[]){
        sizeArr = 10;
        arr = new int[]{2, 1, 6, 4, 9, 10, 8};
        bubbleSort();
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(){
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0 ; j < arr.length ; j++){
                if(arr[i] < arr[j]){
                    swap(i, j);
                }
            }
        }
    }

    public static void swap (int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
