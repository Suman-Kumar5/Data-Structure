package Graph1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
    static class Edge{
        int src;
        int dest;
        public Edge(int s,int d){
            src=s;
            dest=d;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]){//O(N)
        for(int i=0;i< graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        // vertex-0
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        // vertex-1
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));


        // vertex-2
        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,3));


        // vertex-3
        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));

        // vertex-4
        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,3));
    }

    public static boolean isBipartite(ArrayList<Edge> graph[]){
        int[] col =new int[graph.length];
        for(int i=0;i< graph.length;i++){
            col[i]=-1;
        }
//        Arrays.fill(col,-1);
        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<graph.length;i++){
            if(col[i]==-1){
                q.add(i);
                col[i]=0; // 0--> red,1--> yellow
            }
            while (!q.isEmpty()){
                int curr=q.remove();
                for(int j=0;j<graph[curr].size();j++){
                    Edge e=graph[curr].get(j);
                    if(col[e.dest]==-1){
                        int nextCol=col[curr]==0? 1:0;
                        col[e.dest]=nextCol;
                        q.add(e.dest);
                    }
                    else if(col[curr]==col[e.dest]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge> graph[]=new ArrayList[v];
        createGraph(graph);
        System.out.println(isBipartite(graph));
    }
}
