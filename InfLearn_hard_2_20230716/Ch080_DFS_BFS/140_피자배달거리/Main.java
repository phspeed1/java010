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

		List<Point> hList = new ArrayList<Point>();
		List<Point> pList = new ArrayList<Point>();

		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(board[i][j] == 1)
					hList.add(new Point(i, j, hList.size()));
				if(board[i][j] == 2)
					pList.add(new Point(i, j, pList.size()));
			}
		}

		DFS(M, hList, pList, new Point[M], 0, 0);


		return answer;
	}

	void DFS(int M, List<Point> hList, List<Point> pList, Point[] resList, int lv, int s){
		if(lv == M) {
			int sum = 0;
			for(Point h : hList){
				int min = Integer.MAX_VALUE;
				for(Point p : resList){
					min = Math.min(min, Math.abs(h.x - p.x) + Math.abs(h.y - p.y));
				}
				sum += min;
			}
			answer = Math.min(answer, sum);
//			System.out.println(sum+" : "+Arrays.toString(resList));

			return;
		}

		for(int i=s; i<pList.size(); i++){
			resList[lv] = pList.get(i);
			DFS(M, hList, pList, resList, lv+1, i+1);
		}
	}

	class Point{
		int x, y, no;
		Point(int x, int y, int no){
			this.x = x; this.y = y; this.no = no;
		}
		public String toString(){
			return "["+no+"]x:"+x+", y:"+y;
		}
	}
}
