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
		System.out.println(new Main().solution(word, c));
	}
	int solution(String word1, String c1){
		int answer = 0;

		return answer;
	}
}
