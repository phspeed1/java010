import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = 7;
		N = sc.nextInt();
		
		int[][] board = new int[N][N];
/*
		board[0] = new int[]{1, 1, 0, 0, 0, 1, 0};
		board[1] = new int[]{0, 1, 1, 0, 1, 1, 0};
		board[2] = new int[]{0, 1, 0, 0, 0, 0, 0};
		board[3] = new int[]{0, 0, 0, 1, 0, 1, 1};
		board[4] = new int[]{1, 1, 0, 1, 1, 0, 0};
		board[5] = new int[]{1, 0, 0, 0, 1, 0, 0};
		board[6] = new int[]{1, 0, 1, 0, 1, 0, 0};
*/

		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				board[i][j] = sc.nextInt();
			}
		}

		System.out.println(new Main().solution(N, board));
	}
	
	int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	int[] dy = {0, 1, 1,  1, 0, -1, -1, -1};

	int solution(int N, int[][] board){
		int answer = 0;

		int cnt = 1;
		for(int x=0; x<N; x++){
			for(int y=0; y<N; y++){
				if(board[x][y] == 1){
					answer++;
					cnt++;
					DFS(N, board, new Point(x, y), cnt);
				}
			}
		}


		return answer;
	}

	void DFS(int N, int[][] board, Point p, int cnt){
		board[p.x][p.y] = cnt;

		for(int i=0; i<8; i++){
			int nx = p.x + dx[i];
			int ny = p.y + dy[i];
			if(nx >=0 && nx <N && ny >=0 && ny <N && board[nx][ny] == 1){
				DFS(N, board, new Point(nx, ny), cnt);
			}
		}
	}

	
	class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
