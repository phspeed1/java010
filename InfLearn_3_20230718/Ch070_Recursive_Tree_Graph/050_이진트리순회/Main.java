import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
	//	Scanner sc = new Scanner(System.in);
	//	int N = sc.nextInt();

		System.out.println(new Main().solution());
	}

	String answer1 = "";
	String answer2 = "";
	String answer3 = "";
	String solution(){
		
		Tree t = new Tree(1);
		t.lt = new Tree(2);
		t.rt = new Tree(3);
		t.lt.lt = new Tree(4);
		t.lt.rt = new Tree(5);
		t.rt.lt = new Tree(6);
		t.rt.rt = new Tree(7);
		
		forSearch(t);
		System.out.println(answer1);
		System.out.println(answer2);
		System.out.println(answer3);

		return "";
	}

	void forSearch(Tree t){
		if(t == null) return;

		answer1 += t.toString();
		forSearch(t.lt);
		answer2 += t.toString();
		forSearch(t.rt);
		answer3 += t.toString();
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
