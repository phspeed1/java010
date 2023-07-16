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
		int[] dp = new int[N];

		List<Brick> list = new ArrayList<Brick>();
		for(int[] ar : arr){
			list.add(new Brick(ar[0], ar[2], ar[1]));
		}
		Collections.sort(list);
//		System.out.println(list);

		for(int i=0; i<N; i++){
			int max = 0;
			for(int j=i; j>=0; j--){
				if(list.get(i).weight < list.get(j).weight){
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] = max + list.get(i).height;
			answer = Math.max(answer, dp[i]);
		}
//		System.out.println(Arrays.toString(dp));

		return answer;
	}

	class Brick implements Comparable<Brick>{
		int width, weight, height;
		Brick(int width, int weight, int height){
			this.width = width;
			this.weight = weight;
			this.height = height;
		}
		public int compareTo(Brick o){
			return o.width - this.width;
		}
		public String toString(){
			return "{wd:"+this.width+", wg:"+this.weight+", ht:"+this.height+"}";
		}
	}

}
/*
[{wd:25, wg:4, ht:3} : 3
, {wd:16, wg:5, ht:2} : 2
, {wd:9, wg:3, ht:2} : 5
, {wd:4, wg:6, ht:4} : 4
, {wd:1, wg:2, ht:5}] : 10
*/
