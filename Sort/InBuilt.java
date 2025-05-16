package Sort;
import java.util.*;
public class InBuilt {
    public static void main(String args[]){
        Integer number[]={345,76,12,78,87,45,7,23};
//        Arrays.sort(number,Collections.reverseOrder());
        Arrays.sort(number,0,5);
        for(Integer d:number){
            System.out.print(d+" ");
        }
    }
}
