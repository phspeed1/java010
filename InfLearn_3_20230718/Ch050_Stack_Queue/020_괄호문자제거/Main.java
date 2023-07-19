import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		System.out.println(new Main().solution(str));
	}

	String solution(String str){
		String answer = "";
		Stack<Character> stack = new Stack<Character>();
		for(char c : str.toCharArray()){
			if(c != ')') {
				stack.push(c);
			}else{
				while(stack.peek() != '(') stack.pop();
				stack.pop();
			}
		}
		for(char c : stack){
			answer += c;
		}
		return answer;
	}

}
