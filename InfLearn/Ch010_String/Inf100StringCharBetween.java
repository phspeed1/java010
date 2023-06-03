package Ch010_String;
import java.util.*;
import java.io.*;

public class Inf100StringCharBetween{

    public static void main(String[] args){
        String str = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       /*
        try{
            str = br.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        String[] arr = str.split(" ");
    
        String rtn = new Inf100StringCharBetween().solution(arr[0], arr[1]);
        */
        String rtn = new Inf100StringCharBetween().solution("teachermode", "e");
        System.out.println(rtn);
    }
    
    private String solution(String str, String ts){
        StringBuilder buff = new StringBuilder();
        char t = ts.charAt(0);
        char[] arr = str.toCharArray();
        int[] dis = new int[arr.length];

        int p = 1000;
        for(int i=arr.length-1; i >=0; i--){
            if(arr[i] == t){
                p = 0;
            }else{
                p++;
            }
            dis[i] = p;
        }

        p = 1000;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == t){
                p = 0;
            }else{
                p++;
            }
//            dis[i] = Math.min(p, dis[i]);
            buff.append(" "+Math.min(p, dis[i]));
        }


        return buff.toString().trim();
    }

}