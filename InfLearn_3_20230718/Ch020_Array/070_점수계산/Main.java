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


	int solution(int N, int[] arr){
		int ans = 0;
		int cnt = 0;

		// 1 0 1 1 1 0 0 1 1 0
		// 1 0 1 2 3 0 0 1 2 0
		for(int i : arr){
			if(i == 1){
				cnt += 1; 
				ans += cnt;
			}else{
				cnt = 0;
			}
		}

		return ans;
	}



}
