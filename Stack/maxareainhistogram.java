package Stack;

import java.util.Stack;

public class maxareainhistogram {
    public static int maxArea(int []height){
        int n=height.length;
        int maxArea=0;
        int nsr[]=new int[n];
        int nsl[]=new int[n];

        Stack<Integer> s=new Stack<>();

        // next smaller Right
        for(int i=n-1;i>=0;i--){
            while (!s.empty() && height[s.peek()]>=height[i]){
                s.pop();
            }
            if(s.empty()){
                nsr[i]=n;
            }
            else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }

        // next smaller left
        for(int i=0;i<n;i++){
            while (!s.empty() && height[s.peek()]>=height[i]){
                s.pop();
            }
            if(s.empty()){
                nsl[i]=n;
            }
            else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }

        for(int i=0;i<n;i++){
            int h=height[i];
            int width=nsr[i]-nsl[i]-1;
            int currArea=h*width;
            maxArea=Math.max(maxArea,currArea);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int height[]={2,1,5,6,2,3};
        System.out.println(maxArea(height));
    }
}
