import java.util.*;
import java.io.*;

public class Inf020Stack{

    public static void main(String[] args){
        String str = "(A(BC)D)EF(G(H)(IJ)K)LM(N)";
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     str = br.readLine();
        // }catch(IOException ioe){
        //     ioe.printStackTrace();
        // }
    
        String rtn = new Inf020Stack().solution(str);
        System.out.println(rtn);
    }
    
    private String solution(String str){
        StringBuilder buff = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();

        for(char c : str.toCharArray()){
            if(c != ')'){
                stack.push(c);
            }else{
                while(stack.pop() != '(');
            }
        }
        for(int i=0; i<stack.size(); i++){
            buff.append(stack.get(i));
        }
        
        return buff.toString();
    }

}