package Array;

public class UniqueNumber {
    public static boolean uniqueNumber(int number[]){
        int n=number.length;
        for(int i=0;i<n;i++){
            int c=0;
            for(int j=0;j<n;j++){
                if(number[i]==number[j]){
                    c++;
                }
            }
            if(c>=2){
                return true;
            }
        }
        return false;
    }
    public static void main(String args[]){
        int number[]={1,1,1,2,3,1,3,3};
        System.out.println(uniqueNumber(number));
    }
}
