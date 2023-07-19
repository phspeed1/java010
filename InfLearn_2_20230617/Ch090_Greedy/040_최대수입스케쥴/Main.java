import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = 6;
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
		int maxDay = Integer.MIN_VALUE;
		List<Schedule> list = new ArrayList<>();
		for(int[] ar : arr){
			list.add(new Schedule(ar[0], ar[1]));
			maxDay = Math.max(maxDay, ar[1]);
		}
		Collections.sort(list);

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		int j=0;
		for(int i=maxDay; i>0; i--){
			/*
			for(int j=0; j<list.size(); j++){
				if(list.get(j).day == i)
					pq.offer(list.get(j).income);
			}
			*/
			while(j<list.size() && list.get(j).day == i){
				pq.offer(list.get(j).income);
				j++;
			}
	//		System.out.println(pq);
			if(!pq.isEmpty())
				answer += pq.poll();
		}

		

		return answer;
	}

	class Schedule implements Comparable<Schedule>{
		int income;
		int day;
		Schedule(int income, int day){
			this.income = income;
			this.day = day;
		}
		public int compareTo(Schedule o){
			return o.day - this.day;
		}
	}

}
