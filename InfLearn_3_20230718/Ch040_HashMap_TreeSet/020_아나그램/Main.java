import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String str1 = sc.next();
		String str2 = sc.next();

		System.out.println(new Main().solution(str1, str2));
	}

	String solution(String str1, String str2){
		String answer = "YES";

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(char c : str1.toCharArray()){
			map.put(c, map.getOrDefault(c, 0)+1);
		}

		/*
		for(char c : str2.toCharArray()){
			if(!map.containsKey(c)) return "NO";
			map.put(c, map.get(c) -1);
		}
		for(char c : map.keySet()){
			if(map.get(c) != 0) return "NO";
		}
		*/
		Map<Character, Integer> map2 = new HashMap<Character, Integer>();
		for(char c : str2.toCharArray()){
			map2.put(c, map2.getOrDefault(c, 0)+1);
		}
		if(!map.equals(map2)) return "NO";

		return answer;
	}


}
