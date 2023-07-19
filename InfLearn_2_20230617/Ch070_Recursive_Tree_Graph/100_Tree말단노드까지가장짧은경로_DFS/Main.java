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
		// DFS(t, 0);
//		ans.append(minLv);

		int lv = DFS(0, t);
		ans.append(lv);

		return ans.toString().trim();
	}

	int DFS(int lv, Tree n){
		if(n.lt == null || n.rt == null){
			return lv;
		}
		return Math.min(DFS(lv+1, n.lt), DFS(lv+1, n.rt));
	}


	int minLv = Integer.MAX_VALUE;

	void DFS1(Tree n, int lv){

		if(n == null){
			minLv = Math.min(minLv, lv-1);
			return;
		}

		DFS1(n.lt, lv+1);
		DFS1(n.rt, lv+1);

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
