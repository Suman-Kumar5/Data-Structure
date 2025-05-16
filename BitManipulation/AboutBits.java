package BitManipulation;

public class AboutBits {
    public static int getIthBits(int n,int i){
        int bitMask=1<<i;
        if((n&bitMask )==0){
            return 0;
        }
        else {
            return  1;
        }
    }
    public static int setIthBits(int n,int i){
        int bitMask=1<<i;
        return bitMask|n;
    }
    public static int clearIthBits(int n,int i){
        int bitMask=~(1<<i);
        return bitMask&n;
    }

    // -1 ko hmlog represent krta h 111111 esma sra 1 hota h
    // or agar -1<<i kra to i tk sra number 0 ho jaaga
    public static int clearLastIthBits(int n,int i){
        int bitMass=(-1<<i);
        return bitMass& n;
    }
    public static void main(String args[]){
        System.out.println(getIthBits(10,2));
        System.out.println(setIthBits(10,2));
        System.out.println(clearIthBits(10,1));
        System.out.println(clearLastIthBits(15,2));
    }
}
