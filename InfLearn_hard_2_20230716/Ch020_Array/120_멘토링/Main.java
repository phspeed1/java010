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

		for(int s1=1; s1<=N; s1++){
			for(int s2=1; s2<=N; s2++){
				int cnt = 0;
				for(int i=0; i<M; i++){
					int rank1 = 0;
					int rank2 = 0;
					for(int j=0; j<N; j++){
						if(arr[i][j] == s1) rank1 = j;
						if(arr[i][j] == s2) rank2 = j;
					}
					if(rank1 < rank2) cnt++;
				}
				if(cnt == M){
				//	System.out.println(s1+" < "+s2);
					ans++;
				}
			}
		}

		return ans;
	}


}
