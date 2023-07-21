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
		int f = factorial(N);
		answer = f+"";
		return answer;
	}

	int factorial(int n){
		if(n == 1) return 1;
		return n * factorial(n-1);
	}



}
