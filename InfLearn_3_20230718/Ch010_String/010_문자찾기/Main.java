import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		String str="";
		String c="";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try{
			str = br.readLine();
			c = br.readLine();
			
		}catch(Exception e){
		}

		System.out.println(new Main().solution(str, c));
	}
	int solution(String str, String c1){
		int answer = 0;
		char c = Character.toUpperCase(c1.charAt(0));
		for(char s : str.toUpperCase().toCharArray()){
			if(s==c) answer++;
		}
		return answer;
	}
}
