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
		List<Bricks> list = new ArrayList<Bricks>();
		for(int[] ar : arr){
			list.add(new Bricks(ar[0], ar[1], ar[2]));
		}
		Collections.sort(list);
		int[] dp = new int[N];
		dp[0] = list.get(0).height;
		answer = dp[0];

		for(int i=1; i<N; i++){
			Bricks bricks = list.get(i);
			int maxHeight = 0;
			for(int j= i-1; j>=0; j--){
				if(list.get(j).weight > bricks.weight && dp[j] > maxHeight){
					maxHeight = dp[j];
				}
			}
			dp[i] = maxHeight + bricks.height;
			answer = Math.max(answer, dp[i]);
		}

		return answer;
	}

	class Bricks implements Comparable<Bricks>{
		int width, height, weight;
		Bricks(int width, int height, int weight){
			this.width = width;
			this.height = height;
			this.weight = weight;
		}
		public int compareTo(Bricks o){
			return o.width - this.width;
		}

	}

}
