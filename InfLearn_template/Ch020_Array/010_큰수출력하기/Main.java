import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = 6;
		int[] nums = {7, 3, 9, 5, 6, 12};

		N = sc.nextInt();
		nums = new int[N];
		for(int i=0; i<N; i++){
			nums[i] = sc.nextInt();
		}
		System.out.println(new Main().solution(N, nums));
	}
	String solution(int N, int[] nums){
		String answer = "";


		return answer;
	}
}
