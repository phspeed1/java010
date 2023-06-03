package Ch010_String;
import java.util.*;
import java.io.*;

public class Inf090StringToOnlyNumber{

    public static void main(String[] args){
        String str = "g0en2T0s8eSoft";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        try{
            str = br.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    */
        String rtn = new Inf090StringToOnlyNumber().solution(str);
        System.out.println(rtn);
    }
    
    private String solution(String str){
        long num = 0;
        for(char c:str.toCharArray()){
            if('0' <= c && c <= '9')
                num = (num * 10) + (c - '0');
        }

        
        return String.valueOf(num);
    }

}