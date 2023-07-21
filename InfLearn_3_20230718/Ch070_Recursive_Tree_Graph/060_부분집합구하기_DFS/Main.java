import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		System.out.println(new Main().solution(N));
	}

	String solution(int N){
		String answer = "";
		DFS(N, 0, new int[N]);
		return answer;
	}

	void DFS(int N, int lv, int[] res){
		if(lv == N) {
			String temp = "";
			for(int j=0; j<N; j++){
				if(res[j] == 1) temp += (j+1) + " ";
			}
			if(temp.length() > 0)
				System.out.println(temp);
			return;
		}

		res[lv] =1;
		DFS(N, lv+1, res);
		res[lv] =0;
		DFS(N, lv+1, res);




	}
		



}
