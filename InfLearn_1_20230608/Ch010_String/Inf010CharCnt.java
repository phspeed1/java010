package Ch010_String;
import java.util.*;
import java.io.*;

public class Inf010CharCnt{

    public static void main(String[] args){
   //     System.out.println("please input string!");
        BufferedReader br;
        try{
        br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
 //       System.out.println("please input char!");
        char c = br.readLine().charAt(0);

   //     System.out.println("input : "+str+" char : "+c);
    
        int res = new Inf010CharCnt().solution(str, c);
        System.out.println(res);
        }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    
    int solution(String str, char c){
       int cnt = 0;
       str = str.toUpperCase();
       c = Character.toUpperCase(c);
       for(char x : str.toCharArray()){
        if(x == c)cnt++;
       }
       return cnt;
    }

}