package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class dijkstraAlgo {
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
    public static void createEdge(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));
        graph[1].add(new Edge(1,3,7));
        graph[1].add(new Edge(1,2,1));
        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));
        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
    }

    static class pair implements Comparable<pair>{
        int n;
        int path;

        public pair(int n,int p){
            this.n=n;
            path=p;
        }
        public int compareTo(pair p){
            return this.path-p.path;// ascending
        }
    }

    public static void dijkstra(ArrayList<Edge> graph[],int src){
        int dist[]=new int[graph.length];
        for(int i=0;i< graph.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        boolean vis[]=new boolean[graph.length];
        PriorityQueue<pair> p=new PriorityQueue<>();
        p.add(new pair(src,0));
        while (!p.isEmpty()){
            pair curr=p.remove();
            if(!vis[curr.n]){
                vis[curr.n]=true;

                // neighbours
                for(int i=0;i<graph[curr.n].size();i++){
                    Edge e=graph[curr.n].get(i);
                    int u=e.src;
                    int v=e.dest;
                    int wt=e.wt;

                    if(dist[u]+wt<dist[v]){// update the distance of src to v
                        dist[v]=dist[u]+wt;
                        p.add(new pair(v,dist[v]));
                    }
                }
            }
        }
        for (int j : dist) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int v=6;
        ArrayList<Edge> graph[]=new ArrayList[v];
        createEdge(graph);
        int src=0;
        dijkstra(graph,src);
    }
}
