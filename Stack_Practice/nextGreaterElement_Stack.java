package Stack_Practice;

import java.util.Stack;

public class nextGreaterElement_Stack {

    public static void main(String[] args) {
        int arr[]={6,8,0,1,3};
        Stack<Integer> s=new Stack<>();
        int n= arr.length;
        int nextGreater[]=new int[n];
        for(int i=n-1;i>=0;i--){
            int curr=arr[i];
            while (!s.isEmpty() && curr>arr[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nextGreater[i]=-1;
            }
            else{
                nextGreater[i]=arr[s.peek()];
            }
            s.push(i);
        }
        for(int sq:nextGreater){
            System.out.print(sq+" ");
        }
    }
}
