package HashMap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class implementation {
    static class hashMap<k,v>{
        private class Node{
            k key;
            v value;
            Node(k key,v value){
                this.key=key;
                this.value= value;
            }
        }

        private int size;// n
        private LinkedList<Node> []bucket; // n=buckets.length

        public hashMap(){
            this.size=0;
            this.bucket=new LinkedList[4];
            for(int i=0;i<4;i++){
                this.bucket[i]=new LinkedList<>();
            }
        }
    }
    public static void main(String[] args) {
        HashMap<String ,Integer> h=new HashMap<>();
    }
}
