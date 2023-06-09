import java.util.*;
import java.io.*;

public class Inf060SortTwoPointer{

    public static void main(String[] args){
        int N = 30;
        String str = "122 123 125 125 128 130 133 137 138 138 140 141 142 143 145 147 149 149 154 154 155 157 161 167 167 167 161 170 173 173";

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     str = br.readLine();
        //     N = Integer.parseInt(str);
        //     str = br.readLine();
        // }catch(IOException ioe){
        //     ioe.printStackTrace();
        // }

    
        String rtn = new Inf060SortTwoPointer().solution(str, N);
        System.out.println(rtn);
    }
    
    private String solution(String str, int N){
        StringBuilder buff = new StringBuilder();
        String[] strArr = str.split(" ");
        int[] arr = new int[N];
        for(int i=0; i<strArr.length; i++) arr[i] = Integer.parseInt(strArr[i]);

        int[] sarr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sarr);
        for(int i=0; i<arr.length; i++){
            if(arr[i] != sarr[i]){
                buff.append(" "+(i+1));
            }
        }
        return buff.toString().trim();
    }

}