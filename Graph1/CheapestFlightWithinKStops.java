package Graph1;
import java.util.*;

public class CheapestFlightWithinKStops {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int w){
            src=s;
            dest=d;
            wt=w;
        }
    }
    public static void createGraph(int flight[][], ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flight.length; i++) {
            int src = flight[i][0];
            int dest = flight[i][1];
            int wt = flight[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e);
        }
    }

    static class info {
        int v, cost, stop;

        public info(int v, int cost, int stop) {
            this.v = v;
            this.cost = cost;
            this.stop = stop;
        }
    }
    public static int cheapestFlight(int n,int [][]flights,int src,int dest,int k){
        ArrayList<Edge> graph[]=new ArrayList[n];
        createGraph(flights,graph);

        int dist[]=new int[graph.length];

        for(int i=0;i< graph.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }

        Queue<info> q=new LinkedList<>();
        q.add(new info(src,0,0));

        while (!q.isEmpty()){
            info curr=q.remove();

            if(curr.stop>k){
                continue;
            }
            for(int i=0;i<graph[curr.v].size();i++){
                Edge e=graph[curr.v].get(i);
                int u=e.src;
                int v=e.dest;
                int wt=e.wt;

                if(dist[u]!=Integer.MAX_VALUE && dist[u]+wt<dist[v] && curr.stop<=k){
                    dist[v]=dist[u]+wt;
                    q.add(new info(v,dist[v],curr.stop+1));
                }
            }
        }
        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] flights = { {0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200} };
        int src = 0, dest = 3, k = 1;
        System.out.println(cheapestFlight(n, flights, src, dest, k));
    }
}
