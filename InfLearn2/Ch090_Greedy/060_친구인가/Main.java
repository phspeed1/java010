import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = 9;
		int M = 7;
		N = sc.nextInt();
		M = sc.nextInt();
		int[][] arr = new int[M][2];
		for(int i=0; i<M; i++){
			for(int j=0; j<2; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		int S1 = 3;
		int S2 = 8;
		S1 = sc.nextInt();
		S2 = sc.nextInt();
		System.out.println(new Main().solution(N, M, arr, S1, S2));
	}
	
	int[] dr;
	
	int find(int n){
		if(dr[n] == n) return n;
		return dr[n] = find(dr[n]);
	}
	void union(int n1, int n2){
		int u1 = find(n1);
		int u2 = find(n2);
		if(u1 != u2) dr[u1] = u2;
	}

	String solution(int N, int M, int[][] arr, int S1, int S2){
		dr = new int[N+1];
		for(int i=1; i<=N; i++) dr[i] = i;

	//	System.out.println(Arrays.toString(dr));

		for(int[] ar : arr){
			union(ar[0], ar[1]);
	//		System.out.println(Arrays.toString(dr));
		}

		if(find(S1) == find(S2)) return "YES";


		return "NO";
	}


}
