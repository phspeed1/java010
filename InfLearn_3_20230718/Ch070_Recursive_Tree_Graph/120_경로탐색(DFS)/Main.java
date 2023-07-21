import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[21][21];
		for(int i=0; i<M; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 1;
		}
		System.out.println(new Main().solution(N, M, arr));
	}
	int answer;

	int solution(int N, int M, int[][] graph){
		answer = 0;
		int[] ch = new int[N+1];
		ch[1] = 1;
		DFS(graph, N, 1, ch, "1 ");

		return answer;
	}

	void DFS(int[][] graph, int M, int n, int[] ch, String s){
		
		if(n == M){
			answer++;
	//		System.out.println(s);
			return;
		}

		for(int i=1; i<=20; i++){
			if(graph[n][i] == 1 && ch[i] == 0){
				ch[i] = 1;
				DFS(graph, M, i, ch, s+i+" ");
				ch[i] = 0;
			}
		}

	}

/*
5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5
*/


}
