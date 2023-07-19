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
	
	int answer = Integer.MAX_VALUE;
	int[] dx = {-1, 0, 1, 0};
	int[] dy = {0, 1, 0, -1};

	int solution(int[][] board){
		answer = Integer.MAX_VALUE;
		
		Queue<Point> queue = new LinkedList<Point>();

		queue.offer(new Point(0, 0));
		int lv = 0;
		board[0][0] = 1;

		while(!queue.isEmpty()){
			int length = queue.size();
			for(int i=0; i<length; i++){
				Point p = queue.poll();
				for(int j=0; j<4; j++){
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];
					if(nx >=0 && nx<7 && ny >=0 && ny <7 && board[nx][ny] == 0){
						if(nx == 6 && ny == 6) return lv+1;
						board[nx][ny] = lv+1;
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
