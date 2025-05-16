package Graph1;

import Graphs.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class graph {
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
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i< graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,5));

        // vertex-1
        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));

        // vertex-2
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,2));

        // vertex-3
        graph[3].add(new Edge(3,1,3));
        graph[3].add(new Edge(3,2,1));

        // vertex-4
        graph[4].add(new Edge(4,2,2));
    }

    public static void bsf(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i< graph.length;i++){
            if(!vis[i]){
                bstUtil(graph,vis);
            }
        }
    }
    public static void bstUtil(ArrayList<Edge> graph[],boolean vis[]){
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()){
            int curr=q.remove();
            if(!vis[curr]){
                System.out.print(curr+" ");
                vis[curr]=true;
                for(int i=0;i<graph[curr].size();i++){
                    Edge e=graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[],int curr,boolean vis[]){
        System.out.print(curr+" ");
        vis[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }
    public static boolean hasPath(ArrayList<Edge> graph[],int src,int dest,boolean vis[]){
        if(src==dest){
            return true;
        }
        vis[src]=true;
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            if(!vis[e.dest] && hasPath(graph,e.dest,dest,vis)){
                return true;
            }
        }
        return false;
    }
    public static boolean detectCycle(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i< graph.length;i++){
            if(!vis[i]){
                if(detectCycleUtil(graph,vis,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean detectCycleUtil(ArrayList<Edge> graph[],boolean vis[],int curr,int par){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!vis[e.dest]){
                if(detectCycleUtil(graph,vis,e.dest,curr)){
                    return true;
                }
            }
            if(vis[e.dest] && e.dest!=par){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge> graph[]=new ArrayList[v];
        createGraph(graph);
        bsf(graph);
        System.out.println();
        dfs(graph,0,new boolean[v]);
        System.out.println(hasPath(graph,0,4,new boolean[v]));
        System.out.println(detectCycle(graph));
    }
}
