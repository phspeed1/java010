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
		
		int w = 0;
		for(int x : arr){
			
			if(x == 0) w = 0;
			else{
				w++;
				ans += w;
			}
		}

		return ans;
	}



}
