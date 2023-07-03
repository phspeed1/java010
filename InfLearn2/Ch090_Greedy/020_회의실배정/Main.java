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
		int cnt = 0;
		List<Room> list = new ArrayList<>();
		for(int[] ar : arr){
			list.add(new Room(ar[0], ar[1]));
		}
		Collections.sort(list);
		int endTime = 0;
		for(Room room : list){
			if(room.startTime >= endTime){
				cnt++;
				endTime = room.endTime;
			}
		}

		return cnt;
	}

	class Room implements Comparable<Room>{
		int startTime;
		int endTime;
		Room(int startTime, int endTime){
			this.startTime = startTime;
			this.endTime = endTime;
		}
		public int compareTo(Room o){
			if(this.endTime == o.endTime) return this.startTime - o.startTime;
			return this.endTime - o.endTime ;
		}
	}

}
