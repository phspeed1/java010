import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = 8;
		int[] nums = {130, 135, 148, 140, 145, 150, 150, 153};

		N = sc.nextInt();
		nums = new int[N];
		for(int i=0; i<N; i++){
			nums[i] = sc.nextInt();
		}
		System.out.println(new Main().solution(N, nums));
	}
	int solution(int N, int[] nums){
		int answer = 0;

		return answer;
	}
}
