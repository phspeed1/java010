import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = 4;
		int M = 2;
		N = sc.nextInt(); // 4
		M = sc.nextInt(); // 16
		System.out.println(new Main().solution(N, M));
	}
	
	String solution(int N, int M){
		String answer = "";
		combination(N, M, 0, 1, new int[M]);
		return answer;
	}

	void combination(int N, int M, int lv, int s, int[] res){
		if(lv == M){
			for(int n : res)System.out.print(n+" ");
			System.out.println();
			return;
		}
		for(int i=s; i<=N; i++){
			res[lv] = i;
			combination(N, M, lv+1, i+1, res);
		}
	}

}
