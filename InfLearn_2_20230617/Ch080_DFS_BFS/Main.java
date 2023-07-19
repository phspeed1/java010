import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = 4;
		int F = 16;
		N = sc.nextInt(); // 4
		F = sc.nextInt(); // 16
		System.out.println(new Main().solution(N, F));
	}
	
	int[] bias;
	String solution(int N, int F){
		combiNum = new int[N+1][N+1];
		bias = new int[N];
		for(int i=0; i<N; i++){
			bias[i] = combiCnt(N-1, i);
			//System.out.println("combiCnt("+(N-1)+", "+i+") : "+combiCnt(N-1, i));
		}

		DFS(N, F, 0, new int[N], new boolean[F+1]);
		return "";
	}
	
	boolean isEnded = false;
	void DFS(int N, int F, int lv, int[] res, boolean[] visited){
		if(isEnded) return;

		if(lv == N){
			
			int sum = 0;
			String buff = "";
			for(int i=0; i<N; i++){
				sum += (res[i] * bias[i]);
				buff += res[i]+" ";
			}
			if(sum == F){
				isEnded = true;
				System.out.println(buff);
				
			}
//			System.out.println(Arrays.toString(res)+" - isEnded : "+isEnded);
			return;
		}
		
		for(int i=1; i<=N; i++){
			if(visited[i]) continue;
			visited[i] = true;
			res[lv] = i;
			DFS(N, F, lv+1, res, visited);
			visited[i] = false;
		}
		
	}

	int[][] combiNum;
	int combiCnt(int N, int R){
		if(N == R || R == 0) return 1;
		if(combiNum[N][R] != 0) return combiNum[N][R];
		
		return combiNum[N][R] = combiCnt(N-1, R-1) + combiCnt(N-1, R);
	}
}
