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
		
		ans = 0;
		DFS(t, 0) ;
		answer = ans + "";

		return answer;
	}

	int ans;
	void DFS(Tree t, int lv){
		if(t.lt == null && t.rt == null) {
			ans = lv;
			return;
		}

		if(t.lt != null) DFS(t.lt, lv+1);
		if(t.rt != null)  DFS(t.rt, lv+1);

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
