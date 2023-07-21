import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
	//	Scanner sc = new Scanner(System.in);
	//	int N = sc.nextInt();

		System.out.println(new Main().solution());
	}

	String solution(){
		String answer = "";
		Tree t = new Tree(1);
		t.lt = new Tree(2);
		t.rt = new Tree(3);
		t.lt.lt = new Tree(4);
		t.lt.rt = new Tree(5);
		t.rt.lt = new Tree(6);
		t.rt.rt = new Tree(7);

		BFS(t);

		return answer;
	}

	void BFS(Tree t){

		Queue<Tree> q = new LinkedList<>();
		q.offer(t);

		while(!q.isEmpty()){
			Tree temp = q.poll();
			if(temp == null) continue;

			System.out.print(temp.toString());
			q.offer(temp.lt);
			q.offer(temp.rt);

		}

	}


	class Tree{
		int n;
		Tree lt, rt;
		Tree(int n){
			this.n = n;
			this.lt = null; this.rt = null;
		}
		public String toString(){
			return this.n + " ";
		}

	}


}
