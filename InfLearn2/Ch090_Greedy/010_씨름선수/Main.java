import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = 5;
		N = sc.nextInt();
		int[][] arr = new int[N][2];
		for(int i=0; i<N; i++){
			for(int j=0; j<2; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.println(new Main().solution(N, arr));
	}
	

	int solution(int N, int[][] arr){
		List<Human> list = new ArrayList<>();
		for(int i=0; i<N; i++){
			list.add(new Human(arr[i][0], arr[i][1]));
		}
		Collections.sort(list);
		int cnt = 0;
		int maxWeight = 0;
		for(Human human : list){
			if(human.weight > maxWeight){
				cnt++;
				maxWeight = human.weight ;
			}
		}
		return cnt;
	}

	class Human implements Comparable<Human>{
		int height;
		int weight;
		Human(int height, int weight){
			this.height = height;
			this.weight = weight;
		}
		public int compareTo(Human o){
			return o.height - this.height;
		}
	}

}
