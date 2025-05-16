package String;

public class Shortest_Path {
    public static double getShortestPath(String path){
        double x=0;
        double y=0;
        for(int i=0;i<path.length();i++){
            if(path.charAt(i)=='S'){
                y--;
            }
            else if(path.charAt(i)=='N'){
                y++;
            }
            else if(path.charAt(i)=='W'){
                x--;
            }
            else{
                x++;
            }
        }
        return Math.sqrt((x*x)+(y*y));
    }
    public static void main(String args[]){
        String path="WNEENESNEEE";
        System.out.println(getShortestPath(path));
    }
}
