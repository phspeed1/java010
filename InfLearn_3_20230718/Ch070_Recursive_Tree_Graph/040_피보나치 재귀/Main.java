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
		for(int i=1; i<=N; i++){
			answer += fivo(i)+" ";
		}
		return answer;
	}

	int fivo(int n){
		if(n <= 2) return 1;
		return fivo(n-1) + fivo(n-2);
	}
/*
1 1 2 3 5 8 13
0 1 2 3 4 
*/
}
