import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = 9;
		int M = 7;
		N = sc.nextInt();
		M = sc.nextInt();
		int[][] arr = new int[M][2];
		for(int i=0; i<M; i++){
			for(int j=0; j<2; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		int S1 = 3;
		int S2 = 8;
		S1 = sc.nextInt();
		S2 = sc.nextInt();
		System.out.println(new Main().solution(N, M, arr, S1, S2));
	}
	

	String solution(int N, int M, int[][] arr, int S1, int S2){
		String answer = "";

		return answer;
	}


}
