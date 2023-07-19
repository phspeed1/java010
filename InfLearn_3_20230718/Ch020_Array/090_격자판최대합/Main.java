import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = 0;
		int[][] arr;

  		N = sc.nextInt();
		arr = new int[N][N];
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				arr[i][j] = sc.nextInt();

		System.out.println(new Main().solution(N, arr));
	}


	int solution(int N, int[][] arr){
		int answer = 0;

		int sum1 = 0;
		int sum2 = 0;
		int cs1 = 0;
		int cs2 = 0;

		for(int i=0; i<N; i++){
			sum1 = 0;
			sum2 = 0;
			for(int j=0; j<N; j++){
				sum1 += arr[i][j];
				sum2 += arr[j][i];

				if(i==j) cs1 += arr[i][j];
				if(i + j == N-1) cs2 += arr[i][j];
			}
			answer = Math.max(answer, sum1);
			answer = Math.max(answer, sum2);
		}
		answer = Math.max(answer, cs1);
		answer = Math.max(answer, cs2);

		/*
		00 01 02 03
		10 11 12 13
		20 21 22 23
		30 31 32 33
		*/

		
		return answer;
	}


}
