import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		System.out.println(new Main().solution(N));
		
		Main main = new Main();
		for(int N=1; N<=15; N++)
			System.out.println(N+" : "+main.solution(N));
	}

	int solution(int N){
		int ans = 0;
		
		int lt = 1;
		int sum = 1;
		for(int rt=2; rt <= N; rt++){
			sum+=rt;
			if( (N-sum) >= 0 && (N-sum) % rt == 0 ) ans++;
		}
		return ans;
	}

	int solution3(int N){
		int ans = 0;
		int cnt = 1;
		N--;

		while(N > 0){
			cnt++;
			N = N - cnt;
			if(N % cnt == 0) ans++;
		}
		return ans;
	}

	int solution2(int N){
		int ans = 0;

		int m = N/2+1;
		int[] arr = new int[m];
		for(int i=0; i<m; i++) arr[i] = i+1;
		
		int sum = 0, lt=0;
		for(int rt=0; rt<m; rt++){
			sum+= arr[rt];
			if(sum == N) ans++;
			while(sum >= N){
				sum -= arr[lt++];
				if(sum == N) ans++;
			}
		}

		return ans;
	}

	int solution1(int N){
		int ans = 0;
		
		int sum = 0, lt=1;
		for(int rt=1; rt<N; rt++){
			sum+=rt;
			if(sum == N) ans++;
			while(sum >= N){
				sum -= lt++;
				if(sum == N) ans++;
			}
		}

		return ans;
	}

}
