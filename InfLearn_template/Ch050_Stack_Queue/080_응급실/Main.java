import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();

		System.out.println(new Main().solution(N, M, arr));
	}

	int solution(int N, int M, int[] arr){
		int ans = 0;
		Queue<Person> queue = new LinkedList<Person>();
		
		for(int i=0; i<N; i++) queue.offer(new Person(i, arr[i]));

		while(!queue.isEmpty()){
			Person tmp = queue.poll();

			for(Person x: queue){
				if(x.pt > tmp.pt){
					queue.offer(tmp);
					tmp = null;
					break;
				}
			}
			if(tmp != null){
				ans++;
				if(tmp.no == M) return ans;
			}
		}

		return ans;
	}

	int solution1(int N, int M, int[] arr){
		int ans = 0;
		PriorityQueue<Person> pq = new PriorityQueue<Person>();
		Queue<Person> queue = new LinkedList<Person>();
		
		for(int i=0; i<N; i++){
			Person person = new Person(i, arr[i]);
			pq.offer(person);
			queue.offer(person);
		}

		while(!pq.isEmpty()){
			Person max = pq.poll();

			while(!queue.isEmpty()){
				Person p = queue.poll();

				// System.out.println(max + " "+p);
				if(max.pt == p.pt){
					ans++;
					if(p.no == M) return ans;
					break;
				}
				queue.offer(p);
			}
		}

		return ans;
	}

	class Person implements Comparable<Person>{
		int no, pt;
		Person(int no, int pt){
			this.no = no;
			this.pt = pt;
		}
		public int compareTo(Person o){
			return o.pt - this.pt;
		}
		public String toString(){
			return "{no:"+no+"pt:"+pt+"}";
		}
	}

}
