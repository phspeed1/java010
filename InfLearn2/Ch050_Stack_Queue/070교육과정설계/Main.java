import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();

		System.out.println(new Main().solution(str1, str2));
	}

	String solution(String need, String plan){

		Queue<Character> q = new LinkedList<Character>();
		for(char c : need.toCharArray()) q.offer(c);

		for(char c : plan.toCharArray()){
			if(q.contains(c)){
				if(q.poll() != c) return "NO";
			}
		}
		if(!q.isEmpty()) return "NO";

		return "YES";
	}

	String solution1(String str1, String str2){

		Queue<Character> q = new LinkedList<Character>();
		for(char c : str2.toCharArray()) q.offer(c);

		for(char c : str1.toCharArray()){

			boolean isFind = false;
			while(!q.isEmpty()){
				if(c == q.poll()){
					isFind = true;
					break;
				}
			}
			if(!isFind) return "NO";
		}

		return "YES";
	}

}
