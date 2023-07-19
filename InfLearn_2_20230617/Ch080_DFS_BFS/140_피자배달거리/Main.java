import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = 4;
		int M = 4;

		N = sc.nextInt();
		M = sc.nextInt();

		int[][] board = new int[N][N];
/*
		board[0] = new int[]{0, 1, 2, 0};
		board[1] = new int[]{1, 0, 2, 1};
		board[2] = new int[]{0, 2, 1, 2};
		board[3] = new int[]{2, 0, 1, 2};
*/

		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				board[i][j] = sc.nextInt();
			}
		}

		System.out.println(new Main().solution(N, M, board));
	}
	

	List<Point> houseList;
	List<Point> storeList;
	int solution(int N, int M, int[][] board){
		houseList = new ArrayList<Point>();
		storeList = new ArrayList<Point>();
		answer = Integer.MAX_VALUE;

		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(board[i][j] == 1){
					houseList.add(new Point(houseList.size(), i, j));
				}else if(board[i][j] == 2){
					storeList.add(new Point(storeList.size(), i, j));
				}
			}
		}
//		System.out.println("houseList : "+ houseList);

		List<Point> resList = new ArrayList<Point>();
		combination(storeList.size(), M, 0, 0, resList);

		return answer;
	}

	int answer;
	int min;

	void combination(int N, int M, int lv, int st, List<Point> resList){
		if(lv == M){
			int sum = 0;
			for(Point house : houseList){
				int min = Integer.MAX_VALUE;
				for(Point store : resList){
					min = Math.min(min, Math.abs(house.x - store.x) + Math.abs(house.y - store.y));
				}
				sum += min;
			}
//			System.out.println(sum+" : "+resList);
			answer = Math.min(answer, sum);
			return;
		}

		for(int i=st; i<N; i++){
			resList.add(storeList.get(i));
			combination(N, M, lv+1, i+1, resList);
			resList.remove(resList.size() -1);
		}

	}
	
	class Point{
		int no, x, y;
		Point(int no, int x, int y){
			this.no = no;
			this.x = x;
			this.y = y;
		}
		public String toString(){
			return " {"+this.x + ","+this.y+"} ";
		}
	}

}
