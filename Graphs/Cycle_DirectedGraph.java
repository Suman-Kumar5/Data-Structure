package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class Cycle_DirectedGraph {
    static class Edge{
        int src;
        int dist;
        public Edge(int s,int d){
            src=s;
            dist=d;
        }
    }
//    static void createGraph(ArrayList<Edge> graph[]) {//O(N)
//
//        for (int i = 0; i < graph.length; i++) {
//            graph[i] = new ArrayList<>();
//        }
//        // vertex-0
//        graph[0].add(new Edge(0, 2));
//
//        // vertex-1
//        graph[1].add(new Edge(1, 0));
//
//        // vertex-2
//        graph[2].add(new Edge(2, 3));
//
//        // vertex-3
//        graph[3].add(new Edge(3, 0));
//    }
    static  void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i< graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,3));
    }
    public static boolean isCycle(ArrayList<Edge> []graph){
        boolean vis[]=new boolean[graph.length];
        boolean stack[]=new boolean[graph.length];

        for(int i=0;i< graph.length;i++){
            if(!vis[i]){
                if(isCycleUtil(graph,i,vis,stack)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge> []graph,int curr,boolean vis[],boolean stack[]){
        vis[curr]=true;
        stack[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(stack[e.dist]){
                return true;
            }
            if(!vis[e.dist] && isCycleUtil(graph,e.dist,vis,stack)){
                return true;
            }
        }
        stack[curr]=false;
        return false;
    }
    public static void main(String[] args) {
        int v=4;
        ArrayList<Edge> graph[] =new ArrayList[v];
        createGraph(graph);
        System.out.println(isCycle(graph));
    }
}
