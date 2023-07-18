import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = 0;
		int M = 0;
		int[][] arr;

  		N = sc.nextInt();
  		M = sc.nextInt();
		arr = new int[M][N];
		for(int i=0; i<M; i++)
			for(int j=0; j<N; j++)
				arr[i][j] = sc.nextInt();

		System.out.println(new Main().solution(N, M, arr));
	}


	int solution(int N, int M, int[][] arr){
		int ans = 0;



		return ans;
	}


}
