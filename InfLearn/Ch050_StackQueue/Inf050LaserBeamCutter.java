import java.util.*;
import java.io.*;

public class Inf050LaserBeamCutter{

    public static void main(String[] args){
        String str = "()(((()())(())()))(())";
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     str = br.readLine();
        // }catch(IOException ioe){
        //     ioe.printStackTrace();
        // }
    
        String rtn = new Inf050LaserBeamCutter().solution(str);
        System.out.println(rtn);
    }
    
    private String solution(String str){
        StringBuilder buff = new StringBuilder();

        char[] arr = str.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        int cnt = 0, lt=0;
        for(int rt=0; rt<arr.length; rt++){
            char c = arr[rt];



        }
        
        return buff.toString();
    }

}