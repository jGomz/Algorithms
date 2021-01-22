package algorithm;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class FindRunningMedian {
    /*
     * Complete the runningMedian function below.
     */
    static double[] runningMedian(int[] a) {
        /*
         * Write your code here.
         */
        double[] dArr = new double[a.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0 ; i<a.length ; i++) {
            if (maxHeap.isEmpty()) {
                maxHeap.add(a[i]);
            } else if (maxHeap.size() == minHeap.size()) {
                if (a[i] < minHeap.peek()) {
                    maxHeap.add(a[i]);
                } else {
                    minHeap.add(a[i]);
                    maxHeap.add(minHeap.remove());
                }
            } else if (maxHeap.size() > minHeap.size()) {
                if (a[i] > maxHeap.peek()) {
                    minHeap.add(a[i]);
                } else {
                    maxHeap.add(a[i]);
                    minHeap.add(maxHeap.remove());
                }
            }

            if (maxHeap.isEmpty()) {
            } else if (maxHeap.size() == minHeap.size()) {
                dArr[i] = (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else { // maxHeap must have more elements than minHeap
                dArr[i] = maxHeap.peek();
            }

        }
        return dArr;
    }

    public static void main(String[] args) throws IOException {

        int[] a = new int[] {94455,
                20555,
                20535,
                53125,
                73634,
                148,
                63772,
                17738,
                62995,
                13401,
                95912,
                13449,
                92211,
                17073,
                69230,
                22016,
                22120,
                78563,
                16571,
                1817,
                41510,
                74518};

        double[] result = runningMedian(a);

        System.out.println(Arrays.toString(result));
    }
}
