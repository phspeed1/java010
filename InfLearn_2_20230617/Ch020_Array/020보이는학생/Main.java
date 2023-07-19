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
	String solution(int N, int[] nums){
		StringBuilder ans = new StringBuilder();
		int max = nums[0];
		int answer = 1;

		for(int i=1; i<N; i++){
			if(max < nums[i]){
				max = nums[i];
				answer++;
			}
		}
		ans.append(answer);

		return ans.toString();
	}
}
