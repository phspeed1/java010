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

	int max;
	int solution(int N, int M, int[][] board){
		int answer = 0;
		max = 0;

		int zeroCnt = 0;
		for(int x = 0; x<N; x++){
			for(int y =0; y<M; y++){
				if(board[x][y] == 0) zeroCnt++;
			}
		}
		if(zeroCnt == 0) return 0;

		queue = new LinkedList<Point>();
		for(int x = 0; x<N; x++){
			for(int y =0; y<M; y++){
				if(board[x][y] == 1){
					queue.offer(new Point(x, y));
				}
			}
		}
		BFS(N, M, board);
//		System.out.println(Arrays.deepToString(board));

		zeroCnt = 0;
		max = 0;
		for(int x = 0; x<N; x++){
			for(int y =0; y<M; y++){
				max = Math.max(max, board[x][y]);
				if(board[x][y] == 0) zeroCnt++;
			}
		}
		if(zeroCnt > 0) return -1;
		answer = max -1;

		return answer;
	}

	Queue<Point> queue;
	void BFS(int N, int M, int[][] board){
		int lv = 1;
		while(!queue.isEmpty()){
			int leng = queue.size();
			for(int i=0; i<leng; i++){
				Point p = queue.poll();

//				System.out.println(p);
				for(int j=0; j<dx.length; j++){
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];
					int day = board[p.x][p.y];

					if(nx >= 0 && nx < N && ny >=0 && ny <M && ( board[nx][ny] == 0 ||  day + 1 < board[nx][ny] )){
						board[nx][ny] = day + 1;
						max = Math.max(max, day+1);
						queue.offer(new Point(nx, ny));
					}
				}
			}
			lv++;
		}
	}
	
	class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		public String toString(){
			return "{x:"+x+", y:"+y+"}";
		}
	}

}


/*
0 0 -1 0 0 0
0 0 1 0 -1 0
0 0 -1 0 0 0
0 0 0 0 -1 1


[[4, 3, -1, 3, 4, 4]
, [3, 2, 1, 2, -1, 3]
, [4, 3, -1, 3, 3, 2]
, [5, 4, 5, 4, -1, 1]]
*/