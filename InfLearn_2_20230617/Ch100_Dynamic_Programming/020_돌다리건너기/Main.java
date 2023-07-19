import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = 7;
		N = sc.nextInt();

		System.out.println(new Main().solution(N));
	}


	int[] dp;
	int solution(int N){	
		dp = new int[N+2];
		dp[1] = 1;
		dp[2] = 2;

		for(int i=3; i<= N+1; i++) dp[i] = dp[i-2] + dp[i-1];
		return dp[N+1];
	
	}


}
