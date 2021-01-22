package algorithm;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ShortestReachInAGraph {
    public static class Graph {
        int size;
        int[][] graph;

        public Graph(int size) {
            this.size = size;
            graph = new int[size][size];
        }

        public void addEdge(int first, int second) {
            graph[first][second] = 6;
            graph[second][first] = 6;
        }

        public int[] shortestReach(int startId) { // 0 indexed
            //Print the graph for reference
            System.out.println("Graph with startId: "+startId);
            for(int i=0 ; i<size ; i++){
                for(int j=0 ; j<size ; j++){
                    System.out.print(graph[i][j]);
                }
                System.out.println("");
            }

            int[] dist = new int[size];
            boolean[] srg = new boolean[size];

            //intialize dist and srg
            for(int i=0 ; i<size ; i++){
                dist[i] = Integer.MAX_VALUE;
                srg[i] = false;
            }

            //Start node
            dist[startId] = 0;

            for(int i=0 ; i<size ; i++){
                int u = minDist(dist, srg);

                srg[u] = true;

                for( int v=0; v<size ; v++){
                    if(!srg[v] && graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]){
                        dist[v] = dist[u] + graph[u][v];
                    }
                }
            }

            int[] result = new int[size-1];
            int indx = 0;
            for(int i=0 ; i<size ; i++){
                if(i != startId){
                    if(dist[i] == Integer.MAX_VALUE)
                        result[indx] = -1;
                    else{
                        result[indx] = dist[i];
                    }
                    indx++;
                }

            }

            return result;
        }

        public int minDist(int[] dist, boolean[] srg){
            int min = Integer.MAX_VALUE;
            int index = 0;
            for(int i =0 ; i<size ; i++){
                if(!srg[i] && dist[i] < min){
                    index = i;
                    min = dist[i];
                }
            }
            return index;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            System.out.println(Arrays.toString(distances));
        }

        scanner.close();
    }
}
