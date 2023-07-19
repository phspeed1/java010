import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = 10;

		N = sc.nextInt();
		String answer = new Main().solution(N);
		System.out.println(answer);
	}

	String solution(int N){
		String answer = "";
		
		int a = 1, b = 1, t = 0;
		answer += a + " ";
		answer += b + " ";
		for(int i=2; i<N; i++){
			t = a + b;
			a = b;
			b = t;
			answer += t + " ";

		}

		return answer;
	}


}
