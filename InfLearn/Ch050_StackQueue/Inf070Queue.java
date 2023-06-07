import java.util.*;
import java.io.*;

public class Inf070Queue{

    public static void main(String[] args){
        String mandatory = "CBA";
        String str = "CBDAGE";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            mandatory = br.readLine();
            str = br.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf070Queue().solution(mandatory, str);
        System.out.println(rtn);
    }
    
    private String solution(String mandatory, String str){
        Queue<Character> queue = new LinkedList<Character>();
        for(char c : str.toCharArray()) queue.offer(c);

        for(char c : mandatory.toCharArray()){
            
        }


       return "YES";
    }

}