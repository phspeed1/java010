import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		System.out.println(new Main().solution(N));
	}

	String solution(int N){
		System.out.println();
		StringBuilder ans = new StringBuilder();
//		recursive(N);
//		printBinary(N);
//		ans.append(factorial(N));
//		fivonachi(1, 1, N, 0);
		for(int i=1; i<=N; i++) System.out.print(fibo(i)+ " ");
		
		return ans.toString().trim();
	}

	int fibo(int n){
		if(n == 1) return 1;
		if(n == 2) return 1;
		return fibo(n-2) + fibo(n-1);
	}

	void fivonachi(int n1, int n2, int N, int lev){
		if( lev == N) return ;
		System.out.print(n1 + " ");
		fivonachi(n2, n1+n2, N, lev+1);

	}

	int factorial(int num){
		if(num == 1) return 1;
		return num * factorial(num-1);
	}

	void printBinary(int num){
		if(num == 0) return;

		printBinary(num / 2);
		System.out.print(num % 2);

	}

	void recursive(int num){
		if(num == 0) return;
		recursive(num -1);
		System.out.print(num + " ");
	}

	void recursive1(int N, int st){
		if(st > N) return;

		System.out.println(st);
		recursive1(N, st+1);
	}



}
