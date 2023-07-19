import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = 0;
  		N = sc.nextInt();
		String str = sc.next();

		System.out.println(new Main().solution(N, str));
	}

	char solution(int N, String str){
		char answer = '0';

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int max = 0;
		for(char c : str.toCharArray()){
			map.put(c, map.getOrDefault(c, 0)+1);
			if(map.get(c) > max){
				answer = c;
				max = map.get(c);
			}
		}

		return answer;
	}
}
