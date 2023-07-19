import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = 0;
		int[][] arr;

  		N = sc.nextInt();
		arr = new int[N][5];
		for(int i=0; i<N; i++)
			for(int j=0; j<5; j++)
				arr[i][j] = sc.nextInt();

		System.out.println(new Main().solution(N, arr));
	}


	int solution(int N, int[][] arr){
		int ans = 0;
		int max = 0;
		int[] stu = new int[N+1];
		Set<Integer>[] set = new HashSet[N+1];
		
		for(int i=0; i<N; i++){
			set[i+1] = new HashSet<Integer>();
			for(int j=0; j<5; j++){
				for(int k=0; k<N; k++){
					if(arr[i][j] == arr[k][j]){
						set[i+1].add(k+1);
					}
				}
			}
			stu[i+1] = set[i+1].size();
		}
		
		for(int i=1; i<=N; i++){
			if(stu[i] > max){
				max = stu[i];
				ans = i;
			}
		}
		return ans;
	}


}
