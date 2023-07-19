import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = 0;
		int[] arr1;
		int M = 0;

  		N = sc.nextInt();
  		M = sc.nextInt();
		arr1 = new int[N];
		for(int i=0; i<N; i++)
			arr1[i] = sc.nextInt();

		System.out.println(new Main().solution(N, M, arr1));
	}


	int solution(int N, int M, int[] arr){
		int ans = 0;
		int sum = 0;
		for(int i=0; i<M; i++){
			sum+=arr[i];
		}
		ans = Math.max(ans, sum);

		for(int i=M; i<N; i++){
			sum += arr[i] - arr[i-M];
			ans = Math.max(ans, sum);
		}
		return ans;
	}

	int solution1(int N, int M, int[] arr){
		int ans = 0;
		int lt=0;
		int rt=0;
		int sum=0;

		for(rt=0; rt<M; rt++){
			sum+=arr[rt];
		}

		while(rt <N){
			ans = Math.max(ans, sum);
			sum += arr[rt++];
			sum -= arr[lt++];
		}
		return ans;
	}

}
