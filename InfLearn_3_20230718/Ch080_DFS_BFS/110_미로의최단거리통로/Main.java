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
		board[4] = new int[]{1, 1, 0, 1, 0, 0, 0};
		board[5] = new int[]{1, 0, 0, 0, 1, 0, 0};
		board[6] = new int[]{1, 0, 1, 0, 0, 0, 0};


		for(int i=0; i<X; i++){
			for(int j=0; j<Y; j++){
				board[i][j] = sc.nextInt();
			}
		}

		System.out.println(new Main().solution(board));
	}
	
	int answer;
	int[] dx = {-1, 0, 1, 0};
	int[] dy = {0, 1, 0, -1};

	int solution(int[][] board){
		answer = 0;
		board[0][0] = 1;
		answer = BFS(board, new Point(0, 0));

		return answer;
	}

	int BFS(int[][] board, Point root){
		int N = board.length;
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(root);
		
		int lv = 0;
		while(!queue.isEmpty()){
			int leng = queue.size();
			for(int i=0; i<leng; i++){
				Point temp = queue.poll();
				int dis = board[temp.x][temp.y];

				for(int j=0; j<dx.length; j++){
					int nx = temp.x + dx[j];
					int ny = temp.y + dy[j];

					if(nx >= 0 && nx <N && ny >= 0 && ny <N && board[nx][ny] == 0){
						if(nx == N-1 && ny == N-1) return dis;
						board[nx][ny] = dis+1;
						queue.offer(new Point(nx, ny));
					}
				}
			}
			lv++;
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
