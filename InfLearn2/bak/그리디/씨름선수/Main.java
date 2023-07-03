public class Main{
	public static void main(String[] args){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		int N = sc.nextInt();
		java.util.ArrayList<Body> arr = new java.util.ArrayList<>();
		for(int i=0; i<N; i++){
			arr.add(new Body(sc.nextInt(), sc.nextInt()));
		}
		java.util.Collections.sort(arr);

		System.out.println(new Main().solution(N, arr));
	}

	int solution(int N, java.util.ArrayList<Body> arr){
		int ans = 0;
		
		int maxWeight = 0;
		for(Body bd : arr){
			if(bd.weight > maxWeight){
				ans++;
				maxWeight = bd.weight ;
			}
		}

		return ans;
	}

	static class Body implements Comparable<Body>{
		int height;
		int weight;
		Body(int height, int weight){
			this.height = height;
			this.weight = weight;
		}

		public int compareTo(Body o){
			return o.height - this.height;
		}
	}


}
