package Sort;

public class bubbleSort {
    public static void BubbleSort(int number[]){
        int n=number.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                if(number[j]>number[j+1]){
                    int temp=number[j];
                    number[j]=number[j+1];
                    number[j+1]=temp;
                }
            }
        }
    }
    public static void main(String args[]){
        int number[]={345,76,12,78,87,45,7,23};
        BubbleSort(number);
        for(int d:number){
            System.out.print(d+" ");
        }
    }
}
