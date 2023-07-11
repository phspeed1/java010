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

		List<Point> houseList = new ArrayList<Point>();
		List<Point> pizzaList = new ArrayList<Point>();
		
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(board[i][j] == 1){
					houseList.add(new Point(i, j));
				}
				if(board[i][j] == 2){
					pizzaList.add(new Point(i, j));
				}
			}
		}

		combination(houseList, pizzaList, M, 0, 0, new ArrayList<Point>());

		return answer;
	}

	void combination(List<Point> houseList, List<Point> pizzaList, int M, int lv, int s, List<Point> resList){
		if(lv == M){
			int sum = 0;
			for(Point hl : houseList){
				int min = Integer.MAX_VALUE;
				for(Point pl : resList){
					min = Math.min(min,   Math.abs(pl.x - hl.x) + Math.abs(pl.y - hl.y)   );
				}
				sum += min;
			}
	//		System.out.println(sum+" -> "+resList);
			answer = Math.min(answer, sum);
			return;
		}
		
		for(int i=s; i<pizzaList.size(); i++){
			resList.add(pizzaList.get(i));
			combination(houseList, pizzaList, M, lv+1, i+1, resList);
			resList.remove(resList.size() -1);
		}
	}

	class Point {
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		public String toString(){
			return "["+x+","+y+"]";
		}
	}
}
