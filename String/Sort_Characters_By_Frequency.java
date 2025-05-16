package String;


import java.util.PriorityQueue;

public class Sort_Characters_By_Frequency {
    static class pair implements Comparable<pair>{
        char ch;
        int freq;
        public pair(char c,int f){
            ch=c;
            freq=f;
        }
        public int compareTo(pair p){
            return p.freq-this.freq;
        }
    }
    public static String frequencySort(String s) {
        int n=s.length();
        int freq[]=new int[128];
        PriorityQueue<pair> pq=new PriorityQueue<>();
        StringBuilder str=new StringBuilder("");
        for(int i=0;i<n;i++){
            freq[s.charAt(i)]++;
        }
        for(int i=0;i<128;i++){
            if(freq[i]>0){
                pq.add(new pair((char)(i),freq[i]));
            }
        }
        while(!pq.isEmpty()){
            pair p=pq.remove();

            while(p.freq!=0){
                str.append(p.ch);
                p.freq--;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String s = "Aabb";
        System.out.println(frequencySort(s));
    }
}
