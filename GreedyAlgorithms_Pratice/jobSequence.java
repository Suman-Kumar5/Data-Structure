package GreedyAlgorithms_Pratice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class jobSequence {
    static class job{
        int id;
        int deadLine;
        int profit;
        public job(int i,int deadLine,int profit){
            this.id=i;
            this.deadLine=deadLine;
            this.profit=profit;
        }
    }
    public static void main(String[] args) {
        int jobInfo[][]={{4,20},{2,10},{1,40},{1,30}};
        ArrayList<job> jobs=new ArrayList<>();

        for(int i=0;i<jobInfo.length;i++){
            jobs.add(new job(i,jobInfo[i][0],jobInfo[i][1]));
        }
        Collections.sort(jobs,(obj1,obj2)->obj2.profit-obj1.profit);

        ArrayList<Integer> seq=new ArrayList<>();

        int time=0;
        int profit=0;
        for(int i=0;i<jobs.size();i++){
            job curr=jobs.get(i);
            if(curr.deadLine>time){
                seq.add(curr.id);
                time++;
                profit+= curr.profit;
            }
        }
        System.out.println("Max Jobs: "+seq.size());
        System.out.println("Max profit : "+profit);
        System.out.println(seq);
    }
}
