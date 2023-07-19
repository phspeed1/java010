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
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};

		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				int num = arr[i][j];
				int p = 1;
				for(int k=0; k<4; k++){
					int nx = i + dx[k];
					int ny = j + dy[k];

					if(nx >=0 && nx <N && ny >=0 && ny <N && arr[i][j] <= arr[nx][ny]) p = 0;
				}
				answer += p;
			}
		}
		
		return answer;
	}


}
