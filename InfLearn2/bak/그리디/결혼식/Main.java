public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = sc.nextInt();
		java.util.ArrayList<Schedule> arr = new java.util.ArrayList<>();
		for(int i=0; i<N; i++){
			arr.add(new Schedule(sc.nextInt(), 'S'));
			arr.add(new Schedule(sc.nextInt(), 'E'));
		}
		java.util.Collections.sort(arr);

		System.out.println(new Main().solution(N, arr));
	}

	int solution(int N, java.util.ArrayList<Schedule> arr){
		int ans = 0;
		int cnt=0;
		
		for(Schedule sch : arr){
			if(sch.tp == 'S'){
				cnt++;
			}else{
				cnt--;
			}
			ans = Math.max(ans, cnt);
		}

		return ans;
	}

	static class Schedule implements Comparable<Schedule>{
		int tm;
		char tp;
		Schedule(int tm, char tp){
			this.tm = tm;
			this.tp = tp;
		}

		public int compareTo(Schedule o){
			if( this.tm == o.tm ) return  this.tp - o.tp;
			return this.tm - o.tm;
		}
	}


}
