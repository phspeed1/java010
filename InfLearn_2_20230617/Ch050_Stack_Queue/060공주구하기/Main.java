import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		System.out.println(new Main().solution(N, K));
	}

	int solution(int N, int K){
		int ans = 0;
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) q.offer(i);

		while(!q.isEmpty()){
			for(int i=0; i<K-1; i++){
				q.offer(q.poll());
			}
			ans = q.poll();
		}
		return ans;
	}

}
