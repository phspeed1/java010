public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = sc.nextInt();
		java.util.ArrayList<Schedule> arr = new java.util.ArrayList<>();
		int maxDay = 0;
		for(int i=0; i<N; i++){
			int income = sc.nextInt();
			int day = sc.nextInt();
			maxDay = Math.max(maxDay, day);
			arr.add(new Schedule(income, day));
		}

		System.out.println(new Main().solution(N, arr, maxDay));
	}

	int solution(int N, java.util.ArrayList<Schedule> arr, int maxDay){
		int ans = 0;

		java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<Integer>(java.util.Collections.reverseOrder());
		java.util.Collections.sort(arr);

		int i=0;
		for(int cha = maxDay; cha >0; cha--){
			for(; i<arr.size(); i++){
				Schedule sch = arr.get(i);
				if(sch.day < cha) break;
				pq.offer(sch.income);
			}
			if(!pq.isEmpty()){
				ans += pq.poll();
			}
		}
		

		return ans;
	}

	static class Schedule implements Comparable<Schedule>{
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
