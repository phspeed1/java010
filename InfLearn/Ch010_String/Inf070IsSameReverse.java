package Ch010_String;
import java.util.*;
import java.io.*;

public class Inf070IsSameReverse{

    public static void main(String[] args){
        String str = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf070IsSameReverse().solution(str);
        System.out.println(rtn);
    }
    
    private String solution(String str){
        str = str.toUpperCase();
        boolean isR = true;

        int mid = str.length()/2;
        for(int i=0; i<mid; i++){
            char c = str.charAt( str.length()-1 -i );
            if(str.charAt(i) != c)
                return "NO";
        }
        
        return "YES";
    }

}