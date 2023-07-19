import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		String str = "StuDY";
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
	    System.out.println(new Main().solution(str));
	}

	String solution(String word){
		String answer = "";
		for(char c : word.toCharArray()){
			answer += Character.isUpperCase(c)?Character.toLowerCase(c):Character.toUpperCase(c);
		}
		
		return answer;
	}
}
