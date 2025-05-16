public class Pratice_3 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int k=m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i]<nums2[j]){
                nums1[k--]=nums2[j--];
            }
            else{
                nums1[k--]=nums1[i--];
            }
        }

        for(int d=0;d< nums1.length;d++){
            System.out.println(nums1[d]);
        }
    }
    public static void main(String args[]){
        int num1[]={1,2,3,0,0,0};
        int m= num1.length;
        int num2[]={2,5,6};
        int n= num2.length;
        merge(num1,m,num2,n);
    }
}
