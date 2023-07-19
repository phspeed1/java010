import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = 10;

		N = sc.nextInt();
		new Main().solution(N);
	}

	String solution(int N){
		StringBuilder ans = new StringBuilder();
		int a=1, b=1, c;
		System.out.print(a + " "+ b + " ");

		for(int i=3; i<=N; i++){
			c = a + b;
			System.out.print(c + " ");
			a = b;
			b = c;
		}
		System.out.println();

		return ans.toString();
	}

	int[] dp;
	String solution1(int N){
		StringBuilder ans = new StringBuilder();
		dp = new int[N+1];
		for(int i=1; i<=N; i++){
			System.out.print(pivo(i) + " ");
		}
		System.out.println();

		return ans.toString();
	}
	
	int pivo(int n){
		if(n <= 2) return 1;
		
		if(dp[n] >0) return dp[n];

		return dp[n] = (pivo(n-2) + pivo(n-1));
	}
}
