package Graph1;

import java.util.ArrayList;

public class Cycle_DirectedGraph {
    static class Edge{
        int src;
        int dist;
        public Edge(int s,int d){
            src=s;
            dist=d;
        }
    }

    static  void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i< graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,3));
    }
    public static boolean  isCycle(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        boolean stack[]=new boolean[graph.length];

        for(int i=0;i< graph.length;i++){
            if(!vis[i]){
                if(isCycleUtil(graph,vis,stack,i)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge> graph[],boolean vis[],boolean stack[],int curr){
        vis[curr]=true;
        stack[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(stack[e.dist]){
                return true;
            }
            if(!vis[e.dist] && isCycleUtil(graph,vis,stack,e.dist)){
                return true;
            }
        }
        stack[curr]=false;
        return false;
    }
    public static void main(String[] args) {
        int v=4;
        ArrayList<Edge> graph[]=new ArrayList[v];
        createGraph(graph);
        System.out.println(isCycle(graph));
    }
}
