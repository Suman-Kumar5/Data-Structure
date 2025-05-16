package Sort;

public class selectionSort {
    public static void SelectionSort(int number[]){
        int n=number.length;
        for(int i=0;i<n-1;i++){
            int minValue=i;
            for(int j=i+1;j<n;j++){
                if(number[minValue]>number[j]){
                    minValue=j;
                }
            }
            int temp=number[minValue];
            number[minValue]=number[i];
            number[i]=temp;
        }
    }
    public static void main(String args[]){
        int number[]={35,76,12,78,87,45,7,23};
        SelectionSort(number);
        for(int d:number){
            System.out.print(d+" ");
        }
    }
}
