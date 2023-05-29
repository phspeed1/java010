import java.util.*;

public class Fivonachi030{

    public static void main(String[] args){
        long N = 13;
        String str = "str";
        System.out.println("input : "+str);
    
        long r = new Fivonachi030().fivonachi(N);
        System.out.println("output : "+r);
    }
    
    long fivonachi(long n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fivonachi(n -1) + fivonachi(n -2);

    }

}