package Ch010_String;
import java.util.*;
import java.io.*;

public class Inf020ReverseCase{

    public static void main(String[] args){

        BufferedReader br;
        String str = "str";
        try{
            br = new BufferedReader(new InputStreamReader(System.in));
            str = br.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf020ReverseCase().solution(str);
        System.out.println(rtn);
    }
    
    String solution(String str){
        StringBuilder buff = new StringBuilder();
        for(char c : str.toCharArray()){
            if(Character.isUpperCase(c))
                buff.append(Character.toLowerCase(c));
            else
                buff.append(Character.toUpperCase(c));
        }
        return buff.toString();
    }

}