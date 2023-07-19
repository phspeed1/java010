import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		System.out.println(new Main().solution(str));
	}

	int solution(String str){
		int answer = 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(char c : str.toCharArray()){
			if(Character.isDigit(c)) {
				stack.push(Character.digit(c, 10));
			}else{
				int n2 = stack.pop();
				int n1 = stack.pop();
				if(c == '+') stack.push(n1 + n2);
				else if(c == '-') stack.push(n1 - n2);
				else if(c == '*') stack.push(n1 * n2);
				else if(c == '/') stack.push(n1 / n2);
			}
		}
		answer = stack.pop();



		return answer;
	}

}
