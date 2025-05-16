package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord_algo2 {
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
    public static void createGraph(ArrayList<Edge> graph){
        graph.add(new Edge(0,2,1));
        graph.add(new Edge(0,2,4));
        graph.add(new Edge(1,2,-4));
        graph.add(new Edge(2,3,2));
        graph.add(new Edge(3,4,4));
        graph.add(new Edge(4,1,-1));
    }

    public static void bellman(ArrayList<Edge> graph,int src,int V){
        int dist[]=new int[graph.size()];
//        Arrays.fill(dist, Integer.MAX_VALUE); OR
        for(int i=0;i< dist.length;i++){
            if(i!=src){
            dist[i]=Integer.MAX_VALUE;
            }
        }

        for(int i=0;i<V-1;i++){
            for (int j=0;i< graph.size();j++){
                Edge e=graph.get(j);

                int u=e.src;
                int v=e.dest;
                int wt=e.wt;

                if(dist[u]!=Integer.MAX_VALUE && dist[u]+wt<dist[v]){
                    dist[v]=dist[u]+wt;
                }
            }
        }
        for(int i=0;i< dist.length;i++){
            System.out.print(dist[i]+" ");
        }
    }
    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge> graph=new ArrayList<>();
        createGraph(graph);
        bellman(graph,0,v);
    }
}
