import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		List<List<Integer>> graph = new ArrayList<>();
		for(int i=0; i<=N; i++) graph.add(new ArrayList<Integer>());

		for(int i=0; i<M; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(b);
		}

		Main main = new Main();
		for(int i=2; i<=N; i++){
			int ans = main.solution(N, i, graph);
			System.out.println(i + " : "+ans);
		}
		
	}
	int answer;
	
	int solution(int N, int M, List<List<Integer>> graph){

		return answer;
	}



}
/*
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5

*/
/*
2 : 3
3 : 1
4 : 1
5 : 2
6 : 2
*/
