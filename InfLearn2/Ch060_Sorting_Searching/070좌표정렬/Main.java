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
		StringBuilder ans = new StringBuilder();
		List<Pnt> list = new ArrayList<Pnt>();

		for(int i=0; i<N; i++){
			list.add(new Pnt(arr[i][0], arr[i][1]));
		}
		Collections.sort(list);
		for(Pnt p : list) ans.append(p+"\n");

		return ans.toString().trim();
	}

	class Pnt implements Comparable<Pnt>{
		int x, y;
		Pnt(int x, int y){
			this.x = x;
			this.y = y;
		}
		public int compareTo(Pnt o){
			if(this.x == o.x) return this.y - o.y;
			return this.x - o.x;
		}
		public String toString(){
			return this.x + " " + this.y;
		}
	}


}
