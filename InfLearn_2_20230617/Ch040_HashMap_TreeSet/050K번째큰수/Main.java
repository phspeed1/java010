import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = 3;
		int K = 3;
		int[] arr = {1, 2, 3};

  		N = sc.nextInt();
  		K = sc.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();

		System.out.println(new Main().solution(N, K, arr));
	}

	int solution(int N, int K, int[] arr){
		int ans = -1;
	
		TreeSet<Integer> set = new TreeSet<Integer>(Collections.reverseOrder());

		for(int i=0; i<N; i++)
			for(int j=i+1;j<N;j++)
				for(int k=j+1; k<N; k++)
					set.add(arr[i]+arr[j]+arr[k]);
		
		int cnt=0;
		for(int x : set){
			cnt++;
			if(cnt == K) return x;
		}


		return ans;
	}

	int solution1(int N, int K, int[] arr){
		int ans = -1;

	
		TreeSet<Integer> set = new TreeSet<Integer>();
		int[] list = new int[3];
		
		combination(arr, N, 3, 0, 0, list, set);
		
		boolean[] visited = new boolean[N];
//		permutation(arr, N, 3, 0, 0, list, set, visited);

//		System.out.println("set"+set);

		if(set.size() < K) return -1;
		for(int i=0; i<K; i++){
			ans = set.pollLast();
		}

		return ans;
	}

	void combination(int[] arr, int N, int M, int lev, int start, int[] list, TreeSet<Integer> set){
		if(lev == M){
//			System.out.println("Combi : "+Arrays.toString(list));
			set.add(Arrays.stream(list).sum());
			return;
		}
		for(int i=start; i<N; i++){
			list[lev] = arr[i];
			combination(arr, N, M, lev+1, i+1, list, set);
		}
	}

	void permutation(int[] arr, int N, int M, int lev, int start, int[] list, TreeSet<Integer> set, boolean[] visited){
		if(lev == M){
//			System.out.println("Permu : "+Arrays.toString(list));
			set.add(Arrays.stream(list).sum());
			return;
		}
		for(int i=0; i<N; i++){
			if(visited[i]) continue;

			visited[i] = true;
			list[lev] = arr[i];
			permutation(arr, N, M, lev+1, i+1, list, set, visited);
			visited[i] = false;
		}
	}

}
