import java.util.*;
import java.io.*;

public class Inf010Stack{

    public static void main(String[] args){
        String str = "(()(()))(()";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf010Stack().solution(str);
        System.out.println(rtn);
    }
    
    private String solution(String str){
        StringBuilder buff = new StringBuilder();

        Stack<Character> stack = new Stack<Character>();

        for(char c:str.toCharArray()){
            if(c == '('){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        if(!stack.isEmpty()) return "NO";
        buff.append("YES");
        
        return buff.toString();
    }

}