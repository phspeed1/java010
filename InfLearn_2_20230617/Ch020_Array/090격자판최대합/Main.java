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
		int max = 0;
		
		int cross1 = 0;
		int cross2 = 0;
		for(int i=0; i<N; i++){
			int xSum = 0;
			int ySum = 0;
			for(int j=0; j<N; j++){
				xSum += arr[i][j];
				ySum += arr[j][i];
				if(i==j) cross1 += arr[i][j];
				if(i+j == N-1) cross2 += arr[i][j];
			}
			max = Math.max(max, xSum);
			max = Math.max(max, ySum);
		}
		max = Math.max(max, cross1);
		max = Math.max(max, cross2);

		
		return max;
	}


}
