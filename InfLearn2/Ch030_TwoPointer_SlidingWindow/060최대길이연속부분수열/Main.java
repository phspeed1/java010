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

		int cnt=0;
		int leng=0;
		int lt=0;

		for(int rt=0; rt<N; rt++){
			if(arr[rt] == 0) cnt++;
			if(cnt > K){
				System.out.println(lt+"~"+rt);
				ans = Math.max(ans, rt-(lt+1));
				lt++;
				for(lt=lt+1; arr[lt]==1; lt++); lt++;
				cnt--;
			}
		}
				System.out.println("end "+(lt)+"~"+(N-1));
		ans = Math.max(ans, (N-1)-(lt));

		return ans;
	}



}
