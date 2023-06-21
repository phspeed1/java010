import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		System.out.println(new Main().solution(str));
	}

	int solution(String str1){
		int ans = 0;
		Stack<Character> stack = new Stack<Character>();
		char[] str = str1.toCharArray();
		for(int i=0; i<str.length; i++){
			char c = str[i];
			if(c == '(') stack.push(c);
			else{
				stack.pop();
				if(str[i-1]=='(') 	ans += stack.size();
				else ans += 1;
			}
		}
		return ans;
	}

	
	int solution1(String str){
		int ans = 0;
		
		Stack<Character> stack = new Stack<Character>();

		char bfr = ' ';
		for(char c : str.toCharArray()){
			if(c == '(') {
				stack.push(c);
			}else{
				stack.pop();
				if(bfr=='('){
					// laser
					ans += stack.size();
//					System.out.println("Laser : "+stack.size() +" -> "+ans);
				}else{
					ans += 1;
//					System.out.println("Edge : "+ 1 +" -> "+ans);
				}
			}
			bfr = c;
		}

		return ans;
	}

}
