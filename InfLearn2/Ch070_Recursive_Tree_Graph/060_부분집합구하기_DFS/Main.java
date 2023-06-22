import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		System.out.println(new Main().solution(N));
	}

	String solution(int N){
		StringBuilder ans = new StringBuilder();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = i+1;
		int[] res = new int[N];
		
		combination(arr, N, 0, 0, res);
		
		return ans.toString().trim();
	}

	void combination(int[] arr, int N, int lv, int st, int[] res){
		if(lv > N) return;
/*
		if(lv >0){
			for(int i=0; i<lv; i++) System.out.print(res[i]+" ");
			System.out.println();
		}
*/
		for(int i=st; i<N; i++){
			res[lv] = arr[i];
			combination(arr, N, lv+1, i+1, res);
		}
		if(lv >0){
			for(int i=0; i<lv; i++) System.out.print(res[i]+" ");
			System.out.println();
		}

	}



}
