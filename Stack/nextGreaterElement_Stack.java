package Stack;

import java.util.Stack;

public class nextGreaterElement_Stack {
    public static void main(String[] args) {
        int arr[]={6,8,0,1,3};
        int n=arr.length;
        Stack<Integer> s=new Stack<>();
        int greaterInteger[]=new int[n];

        for(int i=n-1;i>=0;i--){
            while (!s.isEmpty() && arr[s.peek()]<=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                greaterInteger[i]=-1;
            }else {
                greaterInteger[i]=arr[s.peek()];
            }
            s.push(i);
        }
        for(int f:greaterInteger){
            System.out.print(f+" ");
        }
    }
}
