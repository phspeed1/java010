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
		recursive(N);
		return answer;
	}

	void recursive(int n){
		if(n == 0) return;
		recursive(n-1);
		System.out.print(n+" ");
	}



}
