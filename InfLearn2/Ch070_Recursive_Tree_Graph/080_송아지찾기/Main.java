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
		int lv = 0;
		int[] dr = {1, -1, 5};
		boolean[] ch = new boolean[10001];
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(S);

		while(!q.isEmpty()){
			int len = q.size();
			for(int i=0; i<len; i++){
				int t = q.poll();
				if(t == E) return lv;
				ch[S] = true;

				for(int j=0; j<dr.length; j++){
					int nx = t + dr[j];
					if(nx == E) return lv+1;
					if(nx >=0 && nx <=10000 && !ch[nx]){
						ch[nx] = true;
						q.offer(nx);
					}
				}
			}
			lv++;
		}

		return lv;
	}

	int solution1(int S, int E){
		int lv = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(S);

		while(!q.isEmpty()){
			int len = q.size();
			for(int i=0; i<len; i++){
				int t = q.poll();
				if(t == E) return lv;
				q.offer(t+1);
				q.offer(t-1);
				q.offer(t+5);
			}
			lv++;
		}

		return lv;
	}




}
