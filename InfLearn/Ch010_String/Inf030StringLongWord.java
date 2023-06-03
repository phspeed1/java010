package Ch010_String;
import java.util.*;
import java.io.*;

public class Inf030StringLongWord{

    public static void main(String[] args){
        String str = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf030StringLongWord().solution(str);
        System.out.println(rtn);
    }
    
    private String solution(String str){
        String[] strArr = str.split(" ");
        List<String> list = Arrays.asList(strArr);
        int longIdx = 0;
        for(int i=0; i<list.size(); i++){
            if(list.get(i).length() > list.get(longIdx).length())
                longIdx = i;
        }
        return list.get(longIdx);
    }

}