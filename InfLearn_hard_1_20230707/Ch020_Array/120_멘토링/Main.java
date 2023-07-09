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
				int cnt = 0;
				for(int k=0; k<M; k++){
					int iGrade = 0;
					int jGrade = 0;
					for(int l=0; l<N;l++){
						if(arr[k][l] == i) iGrade = l;
						if(arr[k][l] == j) jGrade = l;
					}
					if(iGrade < jGrade) cnt++;
				}
				if(cnt == M) ans++;
			}
		}

		return ans;
	}


}
