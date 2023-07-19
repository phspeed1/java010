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
		char ans = '0';
		int max = 0;
		Map<Character, Integer> map = new HashMap<>();
		for(char c : str.toCharArray()){
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		for(char c : map.keySet()){
			if(map.get(c) > max){
				max = map.get(c);
				ans = c;
			}
		}
		return ans;
	}
}
