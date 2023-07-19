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
		int ans = 0;
		int[] dx = {0, 1, 0, -1};
		int[] dy = {-1, 0, 1, 0};
		
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				int nx, ny;
				boolean isPike = true;
				for(int k=0; k<4; k++){
					nx = i+dx[k];
					ny = j+dy[k];
					if(nx >=0 && nx <N && ny >= 0 && ny<N && arr[nx][ny] >= arr[i][j]){
						isPike = false;
						break;
					}
				}
				if(isPike) ans++;
			}
		}
		
		return ans;
	}


}
