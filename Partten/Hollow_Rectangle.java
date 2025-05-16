package Partten;

import java.util.Scanner;

public class Hollow_Rectangle {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int totRows=sc.nextInt();
        int totColumns= sc.nextInt();
        for(int i=1;i<=totRows;i++){
            for(int j=1;j<=totColumns;j++){
                if(i==1 ||j==1||i==totRows||j==totColumns){
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
