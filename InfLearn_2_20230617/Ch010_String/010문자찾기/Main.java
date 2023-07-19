import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		String str;
		String word="";
		String c="";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			word = br.readLine();
			c = br.readLine();
			
		}catch(Exception e){
		}
		new Main().solution(word, c);
	}
	void solution(String word1, String c1){
		word1 = word1.toLowerCase();
		c1 = c1.toLowerCase();
		char c = c1.charAt(0);
		char[] word = word1.toCharArray();
		int answer = 0;
		for(char s : word){
			if(s == c) answer++;
		}
		System.out.println(answer);
	}
}
