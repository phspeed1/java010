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
		int ans = 0;

		Map<Character, Integer> tMap = new HashMap<Character, Integer>();
		Map<Character, Integer> sMap = new HashMap<Character, Integer>();

		for(char c : t.toCharArray()) tMap.put(c, tMap.getOrDefault(c, 0)+1);
		int T = t.length();
		int N = str.length();
		char[] arr = str.toCharArray();
		for(int rt=0; rt<T-1; rt++) sMap.put(arr[rt], sMap.getOrDefault(arr[rt], 0)+1);

		int lt = 0;
		for(int rt=T-1; rt<N; rt++){
			sMap.put(arr[rt], sMap.getOrDefault(arr[rt], 0)+1);

			if(tMap.equals(sMap)) ans++;

			sMap.put(arr[lt], sMap.get(arr[lt]) -1);
			if(sMap.get(arr[lt]) == 0) sMap.remove(arr[lt]);
			lt++;
		}
		return ans;
	}

	int solution1(String str, String t){
		int ans = 0;

		Map<Character, Integer> tMap = new HashMap<Character, Integer>();
		Map<Character, Integer> sMap = new HashMap<Character, Integer>();

		for(char c : t.toCharArray()) tMap.put(c, tMap.getOrDefault(c, 0)+1);
		int T = t.length();
		int N = str.length();
		char[] arr = str.toCharArray();
		for(int rt=0; rt<T-1; rt++) sMap.put(arr[rt], sMap.getOrDefault(arr[rt], 0)+1);
		int lt = 0;
		for(int rt=T-1; rt<N; rt++){
			sMap.put(arr[rt], sMap.getOrDefault(arr[rt], 0)+1);
			//
			boolean isAna = true;
			if(tMap.size() != sMap.size() ){
				isAna = false;
			}else{
				for(char key : tMap.keySet()){
					if(!sMap.containsKey(key) || tMap.get(key) != sMap.get(key)){
						isAna = false;
						break;
					}
				}
			}
			if(isAna) ans++;

			sMap.put(arr[lt], sMap.get(arr[lt]) -1);
			if(sMap.get(arr[lt]) == 0) sMap.remove(arr[lt]);
			lt++;
		}

		return ans;
	}

}
