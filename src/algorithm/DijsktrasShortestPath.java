package algorithm;

import java.util.Arrays;

public class DijsktrasShortestPath {

    public static void main(String[] args)
    {
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        DijsktrasShortestPath t = new DijsktrasShortestPath();
        t.dijkstra(graph, 0);
    }

    public void dijkstra(int graph[][], int src){
        int[] dist = new int[graph.length];
        boolean[] spt = new boolean[graph.length];

        for(int i=0 ; i<graph.length ; i++){
            dist[i] = Integer.MAX_VALUE;
            spt[i] = false;
        }

        dist[src] = 0;

        for(int i=0 ; i<graph.length-1 ; i++){
            //Get the minum distance from the set that is not procesed yet
            int u = minDist(dist, spt);

            //marked the vertex as processed
            spt[u] = true;

            for(int v=0 ; v<graph.length ; v++){
                // Update the dist dist[v] If the following condition are achieved:
                // - only if the vertex (v) is not processed
                // - there is an edge from u to v
                // - total weight of path from src to v through u is smaller than current value of dist[v]
                //  (For this first validate if the distance has been initialized and
                //
                if (!spt[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]){
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        System.out.println(Arrays.toString(dist));
    }

    public int minDist(int[] dis, boolean[] spt){
        int index=-1;
        int min = Integer.MAX_VALUE;
        for(int i=0 ; i<dis.length ; i++){
            if(dis[i] < min && !spt[i]) {
                index = i;
                min = dis[i];
            }
        }
        return index;
    }
}
