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

		int sum = 0, lt = 0;
		for(int rt = 0; rt<N; rt++){
			sum += arr[rt];
			if(sum == M) ans++;
			while(sum >= M){
				sum -= arr[lt++];
				if(sum == M) ans++;
			}
		}

		return ans;
	}

}
