import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		System.out.println(new Main().solution(str));
	}

	int solution(String str){
		int ans = 0;
		
		Stack<Integer> stack = new Stack<Integer>();

		for(char c : str.toCharArray()){
			int n;
			if(c == '+'){
				stack.push(stack.pop() + stack.pop());
			}else if(c == '*') {
				stack.push(stack.pop() * stack.pop());
			}else if(c == '-') {
				int t = stack.pop();
				stack.push(stack.pop() - t);
			}else if(c == '/') {
				int t = stack.pop();
				stack.push(stack.pop() / t);
			}else{
				stack.push(Character.getNumericValue(c));
			}
		}
		ans = stack.pop();

		return ans;
	}

}
