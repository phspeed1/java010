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
		DFS(N, M, 0, 1, new int[M]);
		return "";
	}

	void DFS(int N, int M, int lv, int st, int[] res){
		
		if(lv==M){
			System.out.println(Arrays.toString(res));
			return;
		}

		for(int i=st; i<=N; i++){
			res[lv] = i;
			DFS(N, M, lv+1, i+1, res);
		}
	}
	

}
