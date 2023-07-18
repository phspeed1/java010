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
		new Main().solution(N, numsA, numsB);
	}
	String solution(int N, int[] numsA, int[] numsB){
		String answer = "";


		return answer;
	}

}
