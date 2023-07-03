import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int X = 7;
		int Y = 7;
		
		int[][] board = new int[X][Y];
		board[0] = new int[]{0, 0, 0, 0, 0, 0, 0};
		board[1] = new int[]{0, 1, 1, 1, 1, 1, 0};
		board[2] = new int[]{0, 0, 0, 1, 0, 0, 0};
		board[3] = new int[]{1, 1, 0, 1, 0, 1, 1};
		board[4] = new int[]{1, 1, 0, 0, 0, 0, 1};
		board[5] = new int[]{1, 1, 0, 1, 1, 0, 0};
		board[6] = new int[]{1, 0, 0, 0, 0, 0, 0};


		for(int i=0; i<X; i++){
			for(int j=0; j<Y; j++){
				board[i][j] = sc.nextInt();
			}
		}

		System.out.println(new Main().solution(board));
	}
	
	int solution(int[][] board){
		cnt = 0;
		DFS(board, 0, 0);
		return cnt;
	}
	
	int cnt = 0;
	int[] dx = {-1, 0, 1, 0};
	int[] dy = {0, 1, 0, -1};
	void DFS(int[][] board, int x, int y){
		if(x == 7-1 && y == 7-1){
		//	System.out.println(Arrays.deepToString(board));
			cnt++;
			return;
		}

		board[x][y] = 1;
		for(int i=0; i<4; i++){
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >=0 && nx <7 && ny >= 0 && ny < 7 && board[nx][ny] == 0){
				DFS(board, nx, ny);
			}
		}
		board[x][y] = 0;

	}


	

}
