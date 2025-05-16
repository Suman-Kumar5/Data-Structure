package Backtracking;

import java.util.ArrayList;
import java.util.Stack;

public class RatInMaze {
    static ArrayList<String> arr=new ArrayList<>();

    static boolean isSafe(int i,int j,int n){
        return (i>=0 && i<n && j>=0 && j<n);
    }
    public static void solve(int i,int j,int [][] maze,int n,String path){
        if(!isSafe(i,j,n) && maze[i][j]==0){
            return;
        }
        if(i==n-1 && j==n-1){
            arr.add(path);
        }
        maze[i][j]=0;

        // L,R,D,U
        path+='D';
        solve(i+1,j,maze,n,path);
    }
    public static void main(String[] args) {

    }
}
