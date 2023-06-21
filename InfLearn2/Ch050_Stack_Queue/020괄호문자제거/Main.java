import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		System.out.println(new Main().solution(str));
	}

	String solution(String str){
		StringBuilder ans = new StringBuilder();
		
		Stack<Character> stack = new Stack<Character>();
		for(char c : str.toCharArray()){
			stack.push(c);
			if(stack.peek() == ')'){
				while(stack.pop() != '(');
			}
		}
		for(char c : stack){
			ans.append(c);
		}

		return ans.toString().trim();
	}

}
