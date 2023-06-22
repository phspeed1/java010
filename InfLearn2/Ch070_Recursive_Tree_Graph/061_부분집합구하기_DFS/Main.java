import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		System.out.println(new Main().solution(N));
	}

	String solution(int N){
		StringBuilder ans = new StringBuilder();

		boolean[] ch = new boolean[N+1];
		DFS(N, 1, ch);
		
		return ans.toString().trim();
	}

	void DFS(int N, int lv, boolean[] ch){
		
		if(lv == N+1){
			String temp = "";
			for(int i=1; i<=N; i++){
				if(ch[i]) temp += i+" ";
			}
			if(temp.length() > 0) System.out.println(temp);
			return;
		}

		ch[lv] = true;
		DFS(N, lv+1, ch);
		ch[lv] = false;
		DFS(N, lv+1, ch);
	}
		



}
