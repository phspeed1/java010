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
	int ansCnt;

	int solution(int N, int M, int[][] graph){
		ansCnt = 0;
		int[] ch = new int[21];
		ch[1] = 1;
		DFS(graph, N, 1, ch);

		return ansCnt;
	}

	void DFS(int[][] graph, int N, int node, int[] ch){
		if(node == N){
			ansCnt++;
			return;
		}
		for(int i=0; i<graph.length; i++){
			if(graph[node][i] == 1 && ch[i] == 0){
				ch[i] = 1;
				DFS(graph, N, i, ch);
				ch[i] = 0;
			}
		}
	}





	
	public static void main1(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr = new int[M][2];
		for(int i=0; i<M; i++){
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		System.out.println(new Main().solution1(N, M, arr));
	}

	String solution1(int N, int M, int[][] arr){
		StringBuilder ans = new StringBuilder();
		boolean[] visited = new boolean[21];
		int[] res = new int[21];
		
		visited[1] = true;
		res[0] = 1;
		DFS1(arr, N, 1, 0, visited, res);
		
		ans.append(ansCnt);
		return ans.toString().trim();
	}

	void DFS1(int[][] arr, int N, int node, int lv, boolean[] visited, int[] res){
		if(node == N){
			ansCnt++;

			for(int i=0; i<=lv; i++){
				System.out.print(res[i]+" ");
			}
			System.out.println();

			return;
		}
		for(int i=0; i<arr.length; i++){
			if(arr[i][0] == node){
				int link = arr[i][1];
				if(!visited[link]){
					visited[link] = true;
					res[lv+1] = link;
					DFS1(arr, N, link, lv+1, visited, res);
					visited[link] = false;
				}
			}
		}
	}




}
