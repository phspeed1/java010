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
		
		Queue<Person> q = new LinkedList<Person>();
		for(int i=0; i<N; i++){
			q.offer(new Person(i, arr[i]));
		}
		while(!q.isEmpty()){
			Person p = q.poll();
			boolean first = true;
			for(Person t : q){
				if(t.priority > p.priority) first = false;
			}
			if(first) {
				ans++;
				if(p.no == M) break;
			}else{
				q.offer(p);
			}
		}
		return ans;
	}

	class Person implements Comparable<Person>{
		int no, priority;
		Person(int no, int priority){
			this.no = no;
			this.priority = priority;
		}
		public int compareTo(Person o){
			if(o.priority == this.priority) return this.no - o.no;
			return o.priority - this.priority;
		}
		public String toString(){
			return "{no:"+this.no+",pri:"+this.priority+"}";
		}
	}

}
