import java.util.*;
import java.io.*;

public class Inf050LaserBeamCutter{

    public static void main(String[] args){
        String str = "()(((()())(())()))(())";
      //  str = "(((()(()()))(())()))(()())";
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     str = br.readLine();
        // }catch(IOException ioe){
        //     ioe.printStackTrace();
        // }
    
        String rtn = new Inf050LaserBeamCutter().solution(str);
        System.out.println(rtn);
    }
    
    // 강사방식
    private String solution(String str){
        StringBuilder buff = new StringBuilder();
        int answer = 0;

        Stack<Character> stack = new Stack<Character>();

        char pre = ' ';
        for(char c : str.toCharArray()){
            if(c == '(') {
                stack.push(c);
            }
            if(c== ')'){
                stack.pop();
                if(pre == '('){
                    answer += stack.size();
                }else{
                    answer++;
                }
            }

            pre = c;
        }

        buff.append(answer);
        return buff.toString();
    }

    // 내방식
    private String solution1(String str){
        StringBuilder buff = new StringBuilder();

        str = str.replaceAll("\\(\\)", "1");

        char[] arr = str.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        Stack<Character> temp = new Stack<Character>();
        int answer = 0;
        int K = 0;
        for(char c : arr){
            if(c == '1');
            K++;
        }

        for(char c : arr){
            if(c != ')'){
                stack.push(c);
            }else{
                int inCnt = 0;
                while(stack.peek() != '('){
                    inCnt++;
                    temp.push(stack.pop());
                }
                answer += inCnt+1;
                stack.pop(); 
                while(!temp.isEmpty()) stack.push(temp.pop());
            }
        }
        buff.append(answer);
        return buff.toString();
    }

}