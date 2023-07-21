import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();
		int E = sc.nextInt();

		System.out.println(new Main().solution(S, E));
	}

	int solution(int S, int E){
		int answer = 0;
		answer = BFS(S, E);
		return answer;
	}

	int BFS(int S, int E){
		int lv = 0;
		int[] ch = new int[10001];
		int[] dx = {-1, 1, 5};
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(S);

		while(!queue.isEmpty()){
			int l = queue.size();
			for(int i=0; i<l; i++){
				int n = queue.poll();
				if(n == E) return lv;

				for(int j=0; j<3; j++){
					int nx = n + dx[j];
					if(nx >=0 && nx<= 10000 && ch[nx] == 0){
						ch[nx] = 1;
						queue.offer(nx);
					}
				}
			}
			lv++;
		}

		return lv;
	}

/*
S 3, E 8
E - S = 5

S 8, E 3
E - S = -5
n

5 14
10
15
-1

*/



}
