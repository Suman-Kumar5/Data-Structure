package Reccursion;

public class Power {
    public static double OptimizePowerOf(int num,int n){
        if(n==0){
            return 1;
        }

        // esma agar akhe bar function kraa to time complexity km hota , jitna jada bar function lekhaga
        // utna jada time complexity bhadaaga  esliya necha akhe bar kea h

        if(n>=0) {
            double halfPower = OptimizePowerOf(num, n / 2);
            double halfPowerSquare = halfPower * halfPower;
            if (n % 2 != 0) {
                halfPowerSquare = num * halfPowerSquare;
            }
            return halfPowerSquare;
        }
        else{
            double halfPower = OptimizePowerOf(1/num, n / 2);
            double halfPowerSquare = halfPower * halfPower;
            if (n % 2 != 0) {
                halfPowerSquare = num * halfPowerSquare;
            }
            return halfPowerSquare;
        }
    }
    public static int powerOf(int num,int n){
        if(n==0){
            return 1;
        }
        int pow=num*powerOf(num,n-1);
        return pow;
    }
    public static double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        double power=1;
        if(n>=0){
            power=myPow(x,n/2);
            if(n%2==0){
                return power*power;
            }
            else{
                return x*power*power;
            }
        }
        else{
            if(n%2==0){
                power=myPow(x,n/2);
                return 1/(power*power);
            }
            else{
                return 1/(x*power*power);
            }
        }
    }
    public static void main(String args[]){
//        System.out.println(powerOf(2,3));
        System.out.println(OptimizePowerOf(2,-3));
//        System.out.println(myPow(2,-3));

    }
}
