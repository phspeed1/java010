import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = 5;
		int[] numsA = {2, 3, 3, 1, 3};
		int[] numsB = {1, 1, 2, 2, 3};

		N = sc.nextInt();
		numsA = new int[N];
		numsB = new int[N];
		for(int i=0; i<N; i++){
			numsA[i] = sc.nextInt();
		}
		for(int i=0; i<N; i++){
			numsB[i] = sc.nextInt();
		}
		String answer = new Main().solution(N, numsA, numsB);
		System.out.println(answer);
	}
	String solution(int N, int[] numsA, int[] numsB){
		String answer = "";
		for(int i=0; i<N; i++){
			int A = numsA[i];
			int B = numsB[i];
			if(A==B) answer += "D\n";
			else if( (A==1 && B == 3) || (A==2 && B == 1) || ( A==3 && B == 2))  answer += "A\n";
			else answer += "B\n";
		}


		return answer;
	}

}
