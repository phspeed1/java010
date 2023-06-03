package Ch010_String;
import java.util.*;
import java.io.*;

public class Inf050ReverseOnlyAlpha{

    public static void main(String[] args){
        String str = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf050ReverseOnlyAlpha().solution(str);
        System.out.println(rtn);
    }
    
    private String solution(String str){
        char[] arr = str.toCharArray();
        int left = 0;
        int right = arr.length-1;

        while(left < right){
            while(!Character.isAlphabetic(arr[left]))
                left++;
            while(!Character.isAlphabetic(arr[right]))
                right--;
            if(left < right){
                swap(arr, left, right);
                left++; right--;
            }
        }

        return String.valueOf(arr);
    }

    void swap(char[] arr, int idx1, int idx2){
        char c = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = c;
    }

}