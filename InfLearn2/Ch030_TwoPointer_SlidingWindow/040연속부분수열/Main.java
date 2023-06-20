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
		int lt=0;
		for(int rt=0; rt<N; rt++){
			sum += arr[rt];
			if(sum == M) ans++;
			while(sum >= M){
				sum -= arr[lt++];
				if(sum == M) ans++;
			}
		}
		return ans;
	}

	int solution1(int N, int M, int[] arr){
		int ans = 0;
		int sum = 0;
		int lt=0, rt=0;
		sum+=arr[rt++];
		while(lt < N && rt < N){
			if(sum == M){
				ans++;
				sum -= arr[lt++];
				sum += arr[rt++];
			}else if(sum < M){
				sum += arr[rt++];
			}else{
				sum -= arr[lt++];
			}
		}
		while(lt < N){
			if(sum == M){
				ans++;
				sum -= arr[lt++];
			}else{
				sum -= arr[lt++];
			}
		}

		return ans;
	}

}
