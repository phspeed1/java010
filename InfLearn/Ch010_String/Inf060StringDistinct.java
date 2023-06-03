package Ch010_String;
import java.util.*;
import java.io.*;

public class Inf060StringDistinct{

    public static void main(String[] args){
        String str = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf060StringDistinct().solution(str);
        System.out.println(rtn);
    }
    
    private String solution(String str){
        StringBuilder buff = new StringBuilder();
        /*
        for(char c : str.toCharArray()){
            if(buff.toString().indexOf(c) == -1)
                buff.append(c);
        }
        */
        for(int i=0; i<str.length(); i++){
            if( str.indexOf(str.charAt(i)) == i)
                buff.append(str.charAt(i));
        }
        return buff.toString();
    }

}