import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();

		System.out.println(new Main().solution(S, N, arr));
	}

	String solution(int S, int N, int[] arr){
		StringBuilder ans = new StringBuilder();

		int[] cache = new int[S];

		for(int w : arr){
			int io = S-1;
			for(int i=0; i<S; i++){
				if(cache[i] == w) {
					io = i;
					break;
				}
			}
			if(io == 0) continue;
			for(int i=io-1; i>=0; i--) cache[i+1] = cache[i];
			cache[0] = w;
			
		}


		for(int x : cache) ans.append(x + " ");
		return ans.toString().trim();
	}

	





}
