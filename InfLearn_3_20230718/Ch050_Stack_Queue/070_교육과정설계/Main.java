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
		String answer = "NO";

		Queue<Character> nq = new LinkedList<Character>();
		for(char c : need.toCharArray()) nq.offer(c);
		Queue<Character> pq = new LinkedList<Character>();
		for(char c : plan.toCharArray()) pq.offer(c);

		while(!pq.isEmpty()){
			char c = pq.poll();
			if(!nq.isEmpty() && nq.peek() == c) nq.poll();
		}
		if(nq.isEmpty()) answer = "YES";

		return answer;
	}



}
