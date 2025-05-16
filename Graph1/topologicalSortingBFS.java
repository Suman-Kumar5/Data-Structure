package Graph1;

import java.util.ArrayList;
import java.util.*;

public class topologicalSortingBFS {
    static class Edge{
        int src;
        int dest;
        public Edge(int s,int d){
            src=s;
            dest=d;
        }
    }
    public static void createEdge(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,1));
        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }

    public static void topSort(ArrayList<Edge> graph[]){
        int inDegree[]=new int[graph.length];
        Queue<Integer> q=new LinkedList<>();

        calc(graph,inDegree);

        for(int i=0;i< graph.length;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            int curr=q.remove();
            System.out.print(curr+" ");

            for(int i=0;i< graph[curr].size();i++){
                Edge e=graph[curr].get(i);
                inDegree[e.dest]--;
                if(inDegree[e.dest]==0){
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }
    public static void calc(ArrayList<Edge> graph[],int inDegree[] ){
        for(int i=0;i<graph.length;i++){
            int degree=i;
            for(int j=0;j<graph[degree].size();j++){
                Edge e=graph[degree].get(j);
                inDegree[e.dest]++;
            }
        }
    }

    public static void main(String[] args) {
        int v=6;
        ArrayList<Edge> graph[]=new ArrayList[v];
        createEdge(graph);
        topSort(graph);
    }
}
