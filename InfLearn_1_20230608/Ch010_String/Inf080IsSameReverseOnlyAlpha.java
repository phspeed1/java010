package Ch010_String;
import java.util.*;
import java.io.*;

public class Inf080IsSameReverseOnlyAlpha{

    public static void main(String[] args){
        String str = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf080IsSameReverseOnlyAlpha().solution(str);
        System.out.println(rtn);
    }
    
    private String solution(String str){
/*
        str = str.toUpperCase();
        char[] arr = str.toCharArray();
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            while(!Character.isAlphabetic(arr[left]))
                left++;
            while(!Character.isAlphabetic(arr[right]))
                right--;
            if(arr[left] != arr[right])
                return "NO";
            left++; right--;
        }
*/
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        if(!str.equals(new StringBuilder(str).reverse().toString()))
            return "NO";
        return "YES";
        
    }

}