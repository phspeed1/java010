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
		int answer = 0;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) queue.offer(i);

		int i = 1;
		while(!queue.isEmpty()){
			answer = queue.poll();
			if(i % K != 0) queue.offer(answer);
			i++;
		}


		return answer;
	}

}
