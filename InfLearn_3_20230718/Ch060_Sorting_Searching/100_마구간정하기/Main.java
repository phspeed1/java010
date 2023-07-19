import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int C = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(new Main().solution(N, C, arr));
	}

	int solution(int N, int C, int[] arr){
		int ans = 0;
		Arrays.sort(arr);
		int lt = 1;
		int rt = arr[N-1] - arr[0];

		while(lt <= rt){
			int mid = (lt + rt) / 2;
			int horseCnt = getPossibleHorseCnt(arr, mid);
			if(horseCnt >= C){
				ans = mid;
				lt = mid+1;
			}else{
				rt = mid -1;
			}
		}
		


		return ans;
	}

	int getPossibleHorseCnt(int[] arr, int distance){
		int cnt = 1;
		int ep = arr[0];
		for(int i=1; i<arr.length; i++){
			if(arr[i] - ep >= distance){
				cnt++;
				ep = arr[i];
			}
		}
		return cnt;
		/*
		1    1    1
		1 2 4 8 9
		dis 3

		*/
	}


}
