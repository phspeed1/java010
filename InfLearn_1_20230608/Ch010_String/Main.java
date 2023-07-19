package Ch010_String;
import java.util.*;
import java.io.*;

public class Main{

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
        String rtn = new Main().solution(N, str);
        System.out.println(rtn);
    }
    
    private String solution(int N, String str){
        StringBuilder buff = new StringBuilder();
        for(int i=0; i<N; i++){
            String enc = str.substring(i*7, (i+1)*7);
            String word = getStrBin(enc);
            buff.append(word);
        }
        return buff.toString();
    }

    String getStrBin(String str){
        int num = 0;
        int w = 0;
        for(int i=str.length()-1; i>=0; i--){
            if(str.charAt(i) == '#'){
                num += Math.pow(2, w);
            }
            w++;
        }
        char c = (char)num;
        return String.valueOf(c);
    }

}