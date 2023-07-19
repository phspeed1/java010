import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = 0;
		int K = 0;
		int[] arr;

  		N = sc.nextInt();
  		K = sc.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();

		System.out.println(new Main().solution(N, K, arr));
	}

	String solution(int N, int K, int[] arr){
		StringBuilder buff = new StringBuilder();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int lt=0;
		for(int rt=0; rt<K-1; rt++){
			map.put(arr[rt], map.getOrDefault(arr[rt], 0)+1);
		}
		for(int rt=K-1; rt<N; rt++){
			map.put(arr[rt], map.getOrDefault(arr[rt], 0)+1);
			buff.append(map.size()+" ");
			map.put(arr[lt], map.get(arr[lt])-1);
			if(map.get(arr[lt]) == 0) map.remove(arr[lt]);
			lt++;
		}

		return buff.toString().trim();
	}

	String solution1(int N, int K, int[] arr){
		StringBuilder buff = new StringBuilder();

		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int lt=0;
		for(int rt=0; rt<K; rt++){
			map.put(arr[rt], map.getOrDefault(arr[rt], 0)+1);
		}
		for(int rt=K; rt<N; rt++){
			buff.append(map.size()+" ");
			map.put(arr[rt], map.getOrDefault(arr[rt], 0)+1);
			map.put(arr[lt], map.get(arr[lt])-1);
			if(map.get(arr[lt]) == 0) map.remove(arr[lt]);
			lt++;
		}
		buff.append(map.size()+" ");

		return buff.toString().trim();
	}
}
