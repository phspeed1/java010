import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
	//	Scanner sc = new Scanner(System.in);
	//	int N = sc.nextInt();

		System.out.println(new Main().solution());
	}

	String solution(){
		StringBuilder ans = new StringBuilder();
		Tree t = new Tree(1);
		t.lt = new Tree(2);
		t.rt = new Tree(3);
		t.lt.lt = new Tree(4);
		t.lt.rt = new Tree(5);
		t.rt.lt = new Tree(6);
		t.rt.rt = new Tree(7);
		BFS(t);

		return ans.toString().trim();
	}

	void BFS(Tree n){
		Queue<Tree> q = new LinkedList<Tree>();
		q.offer(n);

		while(!q.isEmpty()){
			Tree t = q.poll();
			if(t == null) continue;

			System.out.print(t);
			q.offer(t.lt);
			q.offer(t.rt);
		}


	}

	class Tree{
		int node;
		Tree lt;
		Tree rt;
		Tree(int node){
			this.node = node;
			lt = rt = null;
		}
		public String toString(){
			return " "+this.node;
		}
	}



}
