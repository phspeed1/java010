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
		
		Stack<Character> stack = new Stack<Character>();
		char prev = ' ';
		for(int i=0; i<str.length(); i++){
			char c = str.charAt(i);
			if(c == '('){
				stack.push(c);
			}else{
				if(str.charAt(i-1) == '('){
					stack.pop();
					answer += stack.size();
				}else{
					stack.pop();
					answer += 1;
				}
			}
		}


		return answer;
	}

	


}
