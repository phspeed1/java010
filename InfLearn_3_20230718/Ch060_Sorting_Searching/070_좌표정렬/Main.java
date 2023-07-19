import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][2];
		for(int i=0; i<N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}

		System.out.println(new Main().solution(N, arr));
	}

	String solution(int N, int[][] arr){
		String answer = "";
		List<Point> list = new ArrayList<Point>();		
		for(int[] ar : arr){
			list.add(new Point(ar[0], ar[1]));
		}
		Collections.sort(list);
		for(Point point : list){
			answer += point.toString()+"\n";
		}

		return answer;

	}

	class Point implements Comparable<Point>{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		public int compareTo(Point o){
			if(this.x == o.x) return this.y - o.y;
			return this.x - o.x;
		}
		public String toString(){
			return this.x + " " + this.y;
		}
	}

}
