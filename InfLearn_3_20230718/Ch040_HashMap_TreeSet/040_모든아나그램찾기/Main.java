import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String t = sc.nextLine();

		System.out.println(new Main().solution(str, t));
	}

	int solution(String str, String t){
		int answer = 0;
		
		Map<Character, Integer> map = new HashMap();
		Map<Character, Integer> tMap = new HashMap();
		for(char c : t.toCharArray()){
			tMap.put(c, tMap.getOrDefault(c, 0) +1);
		}
		
		int lt =0, rt = 0;
		for(rt=0; rt<t.length() -1; rt++){
			char c = str.charAt(rt);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		for(rt = t.length() -1; rt<str.length(); rt++){
			char c = str.charAt(rt);
			map.put(c, map.getOrDefault(c, 0) + 1);

			if(map.equals(tMap)) answer++;
			
			char l = str.charAt(lt++);
			if(map.get(l) == 1) map.remove(l);
			else map.put(l, map.get(l) -1);
		}


		return answer;
	}



}
