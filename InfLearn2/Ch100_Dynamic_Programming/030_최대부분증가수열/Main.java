import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = 8;
		N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();

		System.out.println(new Main().solution(N, arr));
	}
	// 5  3  7  8  6  2  9  4
   //    5      7  8           9
	//	1 1  2  3  2  1  4  2


	int[] dp;
	int solution(int N, int[] arr){	
		dp = new int[N];
		dp[0] = 1;
		int answer = 1;

		for(int i=1; i<N; i++){
			int max = 0;
			for(int j=i-1; j>=0; j--){
				if(arr[j] < arr[i]) max = Math.max(max, dp[j]); 
			}
			dp[i] = max +1;
			answer = Math.max(answer, dp[i]);
		}
		return answer;
	
	}


}
