import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++){
			arr[i] = sc.nextInt();
		}
		Main main = new Main();
		List<Integer> list = main.solution(N, K, arr);
		for(int n : list){
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	List solution(int N, int K, int[] arr){
		List<Integer> answer = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int lt=0;
		for(int rt=0; rt <N; rt++){
			map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
			if(rt >= K){
				map.put(arr[lt], map.get(arr[lt]) -1);
				if(map.get(arr[lt]) == 0) map.remove(arr[lt]);
				lt++;
			}
			if(rt >= K-1){
				answer.add(map.size());
			}
		}
		return answer;
	}

/*
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0; i<N; i++){
			int n = sc.nextInt();
			queue.offer(n);
			map.put(n, map.getOrDefault(n, 0) + 1);

			if(i >= K){
				int p = queue.poll();
				map.put(p, map.get(p) -1);
				if(map.get(p) == 0) map.remove(p);
			}
			if(i >= K-1){
				System.out.print(map.size() + " ");
			}
		}
		System.out.println();
	}
*/

/*
	String solution(int N, int K, int[] arr){
		String answer = "";

		Set<Integer> set = new HashSet<Integer>();
		for(int i=0; i <=N-K; i++){
			set.clear();
			for(int j=i; j<i+K; j++){
				set.add(arr[j]);
			}
			answer += set.size() + " ";
		}
		return answer;
	}
*/

/*
	String solution(int N, int K, int[] arr){
		String answer = "";

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int lt=0;
		for(int rt=0; rt <N; rt++){
			map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
			if(rt >= K){
				map.put(arr[lt], map.get(arr[lt]) -1);
				if(map.get(arr[lt]) == 0) map.remove(arr[lt]);
				lt++;
			}
			if(rt >= K-1){
				answer += map.size() + " ";
			}
		}

		return answer;
	}
*/

}
