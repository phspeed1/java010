import java.util.*;
import java.io.*;

public class Inf010StringMinNUm{

    public static void main(String[] args){
        int N = 0;
        String str = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            N = Integer.parseInt(str);
            str = br.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf010StringMinNUm().solution(N, str);
        System.out.println(rtn);
    }
    
    private String solution(int N, String str){
        StringBuilder buff = new StringBuilder();
/*
        str += " 0";
        String[] arr = str.split(" ");
        for(int i=0; i<arr.length-1; i++){
            int prevNum = Integer.parseInt(arr[i]);
            int nextNum = Integer.parseInt(arr[i+1]);
            if(i==0)
                buff.append(prevNum);
            if(prevNum < nextNum)
                buff.append(" "+nextNum);
        }
*/
        String[] arr = str.split(" ");
        for(int i=1; i<arr.length; i++){
            int prevNum = Integer.parseInt(arr[i-1]);
            int curNum = Integer.parseInt(arr[i]);
            if(i==1)
                buff.append(prevNum);
            if(prevNum < curNum)
                buff.append(" "+curNum);
        }

        return buff.toString().trim();
    }

}