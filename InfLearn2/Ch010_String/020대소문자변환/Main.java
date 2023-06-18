import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		String str = "StuDY";
		Scanner sc = new Scanner(System.in);
		try{
			str = sc.nextLine();
		}catch(Exception e){
		}
		new Main().solution(str);
	}
	void solution(String word){
		StringBuilder answer = new StringBuilder();

		for(char c : word.toCharArray()){
			if(Character.isLowerCase(c)) answer.append(Character.toUpperCase(c));
			else if(Character.isUpperCase(c)) answer.append(Character.toLowerCase(c));
		}

//		for(char c : word.toCharArray()){
//			if('a' <= c && c <= 'z') answer.append((char)(c - ('a' - 'A')) );
//			else answer.append((char)(c + 'a' - 'A') );
//		}

		System.out.println(answer);
	}
}
