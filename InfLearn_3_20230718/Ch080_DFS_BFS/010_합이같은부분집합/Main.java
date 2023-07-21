 import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();

		System.out.println(new Main().solution(N, arr));
	}

	int total;
	boolean finished;
	String solution(int N, int[] arr){
		String answer = "NO";
		total = Arrays.stream(arr).sum();
		finished = false;
		
		DFS(N, arr, 0, 0);

		if(finished) return "YES";
		return answer;
	}

	void DFS(int N, int[] arr, int lv, int sum){
		if(finished) return;
		if(total - sum == sum){
			finished = true;
			return;
		}
		if(lv == N) return;

		DFS(N, arr, lv+1, sum+arr[lv]);
		DFS(N, arr, lv+1, sum);
		
	}


}
