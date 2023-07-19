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


		for(int i=1; i<=N; i++){
			for(int j=1; j<=N; j++){
				int pc = 0;

				for(int k = 0; k<M; k++){
					int ig = 0;
					int jg = 0;
					for(int l = 0; l <N; l++){
						if(arr[k][l] == i) ig = l;
						if(arr[k][l] == j) jg = l;
					}
					if(ig > jg) pc++;
				}

				if(pc == M) ans++;
			}
		}

		return ans;
	}


}
