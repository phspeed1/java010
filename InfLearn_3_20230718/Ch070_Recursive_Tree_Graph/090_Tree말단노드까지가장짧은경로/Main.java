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
		
		answer = BFS(t) + "";
		return answer;
	}

	int BFS(Tree root){
		int lv = 0;
		Queue<Tree> Q = new LinkedList<>();
		Q.offer(root);
		while(!Q.isEmpty()){
			int l = Q.size();
			for(int i=0; i<l; i++){
				Tree t = Q.poll();
				if(t.lt == null && t.rt == null) return lv;
				if(t.lt != null) Q.offer(t.lt);
				if(t.rt != null) Q.offer(t.rt);
			}
			lv++;
			
		}
		return lv;
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
