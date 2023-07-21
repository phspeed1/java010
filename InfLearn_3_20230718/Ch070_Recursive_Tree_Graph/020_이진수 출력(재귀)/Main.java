import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		System.out.println(new Main().solution(N));
	}

	int n = 0;
	String solution(int N){
		String answer = "";
		recursiveBin(N);
		answer = n+"";
		return answer;
	}

	void recursiveBin(int N){
		if(N == 0) return;
		recursiveBin(N / 2);
		n = n * 10 + N % 2;
	}
/*
11	
	5	1
	2	1
	1	0
	0	1
*/
}
