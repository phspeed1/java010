import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = 20;
   		N = sc.nextInt();

		System.out.println(new Main().solution(N));
	}

	int[] dp;

	int solution(int N){
		StringBuilder ans = new StringBuilder();
		int answer = 0;
		dp = new int[N+1];

		for(int i=2; i<=N; i++){
			if( dp[i] != 0 ) continue;
			for(int j=i+i; j<= N; j+=i){
				dp[j] = i;
			}
		}
		System.out.println(Arrays.toString(dp));
		for(int i=2; i<dp.length; i++){
			if(dp[i] == 0) {
				answer++;
			//	System.out.print(i+ " ");
			}
		}
	//	System.out.println();

		return answer;
	}

	int solution1(int N){
		StringBuilder ans = new StringBuilder();
		int answer = 0;

		for(int i=2; i<=N; i++){
			boolean isPrime = true;
			for(int j=2; j< Math.sqrt(N); j++){
				if( i!=j && i%j == 0){
					isPrime = false;
					break;
				}
			}
			if(isPrime){
				answer++;
		//		System.out.print(i + " ");
			}
		}
//		System.out.println();

		return answer;
	}


}
