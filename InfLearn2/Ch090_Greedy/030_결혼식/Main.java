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
		int answer = 0;
		List<Schedule> list = new ArrayList<>();
		for(int[] ar : arr){
			list.add(new Schedule(ar[0], 'S'));
			list.add(new Schedule(ar[1], 'E'));
		}
		Collections.sort(list);

		int cnt = 0;
		for(Schedule schedule : list){
			if(schedule.type == 'E') cnt--;
			else if(schedule.type == 'S') cnt++;
			answer = Math.max(answer, cnt);
		}

		return answer;
	}

	class Schedule implements Comparable<Schedule>{
		int time;
		char type;
		Schedule(int time, char type){
			this.time = time;
			this.type = type;
		}
		public int compareTo(Schedule o){
			if(this.time == o.time) return Character.getNumericValue(this.type) - Character.getNumericValue(o.type);
			return this.time - o.time ;
		}
	}

}
