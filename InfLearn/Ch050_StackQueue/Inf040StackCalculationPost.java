import java.util.*;
import java.io.*;

public class Inf040StackCalculationPost{

    public static void main(String[] args){
        String str = "352+*9-";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

        String rtn = new Inf040StackCalculationPost().solution(str);
        System.out.println(rtn);
    }

    private String solution(String str){
        StringBuilder buff = new StringBuilder();

        Stack<Integer> stack = new Stack<Integer>();
        Queue<Character> queue = new LinkedList<Character>();
        for(char c : str.toCharArray()){
            if(c == '+'){
                stack.push(stack.pop() + stack.pop());
            }else if(c=='-'){
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val2-val1);
            }else if(c=='/'){
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val2 / val1);
            }else if(c=='*'){
                stack.push(stack.pop() * stack.pop());
            }else{
                stack.push(c-'0');
            }
        }

        buff.append(stack.pop());
        return buff.toString();
    }

}