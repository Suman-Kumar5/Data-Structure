package GreedyAlgorithms_Pratice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public static void main(String[] args) {
        int start[]={1,3,0,5,8,5};
        int end[]={2,4,6,7,9,9};

        int activity[][]=new int[start.length][3];
        for(int i=0;i< start.length;i++){
            activity[i][0]=1;
            activity[i][1]=start[i];
            activity[i][2]=end[i];
        }
        Arrays.sort(activity, Comparator.comparingDouble(o->(o[2])));

        int maxAct=0;
        ArrayList<Integer>ans=new ArrayList<>();

        ans.add(activity[0][0]);
        maxAct=1;
        int lastEnd=activity[0][2];
        for(int i=1;i<start.length;i++){
            if(activity[i][1]>=lastEnd){
                maxAct++;
                ans.add(activity[i][0]);
                lastEnd=activity[i][2];
            }
        }
        System.out.println("Max activity is :" +maxAct);
        System.out.println(ans);
    }
}
