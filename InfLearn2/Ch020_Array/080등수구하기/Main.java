import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = 0;
		int[] arr;

  		N = sc.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();

		System.out.println(new Main().solution(N, arr));
	}


	String solution(int N, int[] arr){
		StringBuilder buff = new StringBuilder();
		
		PriorityQueue<Student> pq = new PriorityQueue<Student>();

		Student[] students = new Student[N];
		for(int i =0; i<N; i++){
			pq.offer(new Student(i, arr[i]));
		}
		int max = Integer.MAX_VALUE;
		int idx = 1;
		int g =1;
		while(!pq.isEmpty()){
			Student s = pq.poll();
			if(s.score != max) {
				max = s.score;
				g = idx;
			}
			s.grade = g;
			students[s.no] = s;
			idx++;
		}
		for(Student s : students){
			buff.append(s.grade + " ");
		}

		return buff.toString().trim();
	}

	String solution1(int N, int[] arr){
		StringBuilder buff = new StringBuilder();
		
		for(int i =0; i<N; i++){
			int g = 1;
			for(int j=0; j<N; j++){
				if(j == i) continue;
				if(arr[i] < arr[j]) g++;
			}
			buff.append(g + " ");
		}

		return buff.toString().trim();
	}

	class Student implements Comparable<Student>{
		int no, score, grade;
		Student(int no, int score){
			this.no = no;
			this.score = score;
		}
		public int compareTo(Student o){
			return o.score - this.score;
		}
	}
}
