import java.util.*;
import java.io.*;

public class Inf020StringMinNum2{

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
    
        String rtn = new Inf020StringMinNum2().solution(N, str);
        System.out.println(rtn);
    }
    
    private String solution(int N, String str){
        StringBuilder buff = new StringBuilder();
        int cnt = 0;
        int prevMin =0;
        String[] arr = str.split(" ");
        for(int i=0; i<arr.length; i++){
            int curNum = Integer.parseInt(arr[i]);
            if(prevMin < curNum){
                cnt++;
                prevMin = curNum;
            }
        }

        return String.valueOf(cnt);
    }

}