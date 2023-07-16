import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = 5;
		N = sc.nextInt();
		int[][] arr = new int[N][3];
		for(int i=0; i<N; i++) {
			for(int j=0; j<3; j++){
				arr[i][j] = sc.nextInt();
			}
		}

		System.out.println(new Main().solution(N, arr));
	}

	int solution(int N, int[][] arr){	
		int answer = 0;
		List<Brick> list = new ArrayList<Brick>();
		for(int[] ar : arr) list.add(new Brick(ar[0], ar[1], ar[2]));
		Collections.sort(list);

		int[] dp = new int[N];
		for(int i=0; i<N; i++){
			int maxHt = 0;
			int weight = list.get(i).wg;
			int height = list.get(i).ht;
			for(int j=i; j>=0; j--){
				if(weight < list.get(j).wg) maxHt = Math.max(maxHt, dp[j]);
			}
			dp[i] = maxHt + height;
			answer = Math.max(answer, dp[i]);
		}

		return answer;
	}

	class Brick implements Comparable<Brick>{
		int wt, ht, wg;
		Brick(int wt, int ht, int wg){
			this.wt=wt; this.ht=ht; this.wg=wg;
		}
		public int compareTo(Brick o){
			return o.wt - this.wt;
		}
	}

}
