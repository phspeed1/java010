import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = 0;
		int K = 0;
		int[] arr;

  		N = sc.nextInt();
  		K = sc.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();

		System.out.println(new Main().solution(N, K, arr));
	}

	int solution(int N, int K, int[] arr){
		int ans = 0;
		
		int cnt =0;
		int lt=0;
		for(int rt=0; rt<N; rt++){
			if(arr[rt] == 0) cnt++;

			while(cnt > K){
				if(arr[lt] == 0) cnt--;
				lt++;
			}

			int leng = rt + 1 - lt;
			ans = Math.max(ans, leng);
		}

		return ans;
	}
}
