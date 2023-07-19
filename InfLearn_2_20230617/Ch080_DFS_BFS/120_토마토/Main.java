import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int M = 6;
		int N = 4;
		M = sc.nextInt();
		N = sc.nextInt();
		
		int[][] board = new int[N][M];
/*
		board[0] = new int[]{0, 0, -1, 0, 0, 0};
		board[1] = new int[]{0, 0, 1, 0, -1, 0};
		board[2] = new int[]{0, 0, -1, 0, 0, 0};
		board[3] = new int[]{0, 0, 0, 0, -1, 1};
*/
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				board[i][j] = sc.nextInt();
			}
		}

		System.out.println(new Main().solution(N, M, board));
	}
	
	int[] dx = {-1, 0, 1, 0};
	int[] dy = {0, 1, 0, -1};

	int solution(int N, int M, int[][] board){

		Queue<Point> queue = new LinkedList<>();
		int zeroCnt = 0;
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				if(board[i][j] == 1) queue.offer(new Point(i, j));
				else if(board[i][j] == 0) zeroCnt++;
			}
		}
		if(zeroCnt ==0) return 0;

		int lv = 0;
		while(!queue.isEmpty()){
			int len = queue.size();
			for(int i=0; i<len; i++){
				Point p = queue.poll();
				for(int j=0; j<4; j++){
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];

					if(nx >=0 && nx < N && ny >=0 && ny <M && board[nx][ny] == 0){
						board[nx][ny] = 1;
						zeroCnt--;
						queue.offer(new Point(nx, ny));
					}
				}
			}
			lv++;
			if(zeroCnt == 0) return lv;
		}
		return -1;
	}
	
	class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
