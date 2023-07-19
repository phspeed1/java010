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
	boolean isSame = false;

	String solution(int N, int[] arr){
		total = Arrays.stream(arr).sum();
		DFS(arr, N, 0, 0);
		return isSame?"YES":"NO";
	}

	void DFS(int[] arr, int N, int lv, int sum){
		if(isSame) return;
		if(sum > total/2) return;
		if(lv == N) return;
		if(sum == total -sum){
			isSame = true;
			return;
		}
		DFS(arr, N, lv+1, sum+arr[lv]);
		DFS(arr, N, lv+1, sum);
	}

}
