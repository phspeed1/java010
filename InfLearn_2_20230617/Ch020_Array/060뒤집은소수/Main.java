import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = 0;
		int[] arr;

  		N = sc.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();

		System.out.println(new Main().solution(N, arr));
	}

	String solution1(int N, int[] arr){
		StringBuilder buff = new StringBuilder();
		
		primeInitial(100000);

		for(int x : arr){
			String s = String.valueOf(x);
			s = new StringBuilder(s).reverse().toString();
			int num = Integer.parseInt(s);

			if(isPrime(num)) buff.append(num + " ");
		}

		return buff.toString().trim();
	}


	String solution(int N, int[] arr){
		StringBuilder buff = new StringBuilder();
		
		primeInitial(100000);

		for(int x : arr){
			int num = 0;
			while(x > 0){
				num = (num*10) + x % 10;
				x = x / 10;
			}
			if(isPrime(num)) buff.append(num + " ");
		}

		return buff.toString().trim();
	}

	int[] dp;
	void primeInitial(int N){
		dp = new int[N+1];
		for(int i=2; i<=N; i++){
			if( dp[i] != 0 ) continue;
			for(int j=i+i; j<= N; j+=i){
				dp[j] = i;
			}
		}
	}
	boolean isPrime(int N){
		if(N < 2) return false;
		return dp[N] == 0 ? true:false;
	}

	boolean isPrime1(int N){
		dp = new int[N+1];
		for(int i=2; i<=N; i++){
			if( dp[i] != 0 ) continue;
			for(int j=i+i; j<= N; j+=i){
				dp[j] = i;
			}
		}

		if(N < 2) return false;
		return dp[N] == 0 ? true:false;
	}

}
