package Ch010_String;
import java.util.*;
import java.io.*;

public class Inf040ReverseStartEnd{

    public static void main(String[] args){
        int lineCnt = Integer.MIN_VALUE;
        String[] strArr =null;
        String str = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            lineCnt = Integer.parseInt(str);
            strArr = new String[lineCnt];
            for(int i=0; i<lineCnt; i++){
                strArr[i] = br.readLine();
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String[] rtnArr = new Inf040ReverseStartEnd().solution(strArr);
        for(String rtn : rtnArr)
        System.out.println(rtn);
    }
    
    private String[] solution(String[] strArr){
        String[] res = new String[strArr.length];
        for(int i=0; i<strArr.length; i++){
            char[] arr = strArr[i].toCharArray();
            /*
            for(int j=arr.length-1; j>=0; j--){
                buff.append(arr[j]);
            }
            */
    //        StringBuilder buff = new StringBuilder(strArr[i]).reverse();
    //            res[i] = buff.toString();
            int left = 0;
            int right = arr.length-1;
            while(left < right){
                char t = arr[right];
                arr[right--] = arr[left];
                arr[left++] = t;
            }
            res[i] = String.valueOf(arr);
            
        }

        return res;
    }

}