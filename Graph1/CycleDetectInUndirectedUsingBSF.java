package Graph1;

import java.util.ArrayList;

public class CycleDetectInUndirectedUsingBSF {
    static class Edge{
        int src;
        int dest;
        public Edge(int s,int d){
            src=s;
            dest=d;
        }
    }
    public static void createEdge(ArrayList<Edge> graph[]){
        for(int i=0;i< graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,2));
        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,3));

    }
    public static void bfs(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
//                bfsUtil(graph,vis);
            }
        }
    }

    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge> graph[]=new ArrayList[v];
        createEdge(graph);
    }
}
