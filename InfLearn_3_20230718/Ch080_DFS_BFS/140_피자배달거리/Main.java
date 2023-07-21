import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] board = new int[N][N];
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				board[i][j] = sc.nextInt();
			}
		}

		System.out.println(new Main().solution(N, M, board));
	}
	

	int answer;
	int solution(int N, int M, int[][] board){
		answer = Integer.MAX_VALUE;

		List<Point> hl = new ArrayList<>();
		List<Point> pl = new ArrayList<>();

		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(board[i][j] == 1) hl.add(new Point(i, j));
				else if(board[i][j] == 2) pl.add(new Point(i, j));
			}
		}

		combination(hl, pl, N, M, 0, 0, new Point[M]);

		return answer;
	}

	void combination(List<Point> hl, List<Point> pl, int N, int M, int lv, int s, Point[] res){
		if(lv == M){
		//	System.out.println(Arrays.toString(res));

			int sum = 0;
			for(Point h : hl){
				int min = Integer.MAX_VALUE;
				for(Point p : res){
					int dis = Math.abs(h.x - p.x) + Math.abs(h.y - p.y);
					min = Math.min(min, dis);
				}
				sum += min;
			}
			answer = Math.min(answer, sum);
			return;
		}

		for(int i=s; i<pl.size(); i++){
			res[lv] = pl.get(i);
			combination(hl, pl, N, M, lv+1, i+1, res);
		}

	}

	class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		public String toString(){
			return "{x:"+this.x+", y:"+this.y+"}";
		}
	}

}
