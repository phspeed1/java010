package Ch010_String;
import java.util.*;
import java.io.*;

public class Inf110StringCompress{

    public static void main(String[] args){
        String str = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf110StringCompress().solution(str);
        System.out.println(rtn);
    }
    
    private String solution(String str){
        str += " ";
        StringBuilder buff = new StringBuilder();
        int cnt = 1;
        for(int i=0; i<str.length() -1; i++){
            if(str.charAt(i) == str.charAt(i+1)){
                cnt++;
            }else{
                buff.append(str.charAt(i));
                if(cnt >1)
                    buff.append(cnt);
                cnt = 1;
            }

        }
        return buff.toString();
    }

}