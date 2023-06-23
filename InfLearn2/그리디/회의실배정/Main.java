public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = sc.nextInt();
		java.util.ArrayList<Room> arr = new java.util.ArrayList<>();
		for(int i=0; i<N; i++){
			arr.add(new Room(sc.nextInt(), sc.nextInt()));
		}
		java.util.Collections.sort(arr);

		System.out.println(new Main().solution(N, arr));
	}

	int solution(int N, java.util.ArrayList<Room> arr){
		int ans = 0;
		int endTime=0;
		
		for(Room room : arr){
			if(room.st >= endTime){
				ans++;
				endTime = room.ed;
			}
		}

		return ans;
	}

	static class Room implements Comparable<Room>{
		int st;
		int ed;
		Room(int st, int ed){
			this.st = st;
			this.ed = ed;
		}

		public int compareTo(Room o){
			if( this.ed == o.ed ) return  this.st - o.st;
			return this.ed - o.ed;
		}
	}


}
