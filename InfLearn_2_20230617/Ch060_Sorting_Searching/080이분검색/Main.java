import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(new Main().solution(N, M, arr));
	}

	int solution(int N, int M, int[] arr){
		Arrays.sort(arr);
		int lt=0, rt=N-1;
		while(lt <= rt){
			int mid = (lt + rt) / 2;
			if(arr[mid] == M) return mid+1;

			if(arr[mid] < M)  lt = mid+1;
			else rt = mid-1;
		}
		
		return -1;
	}

	int solution1(int N, int M, int[] arr){
		int ans = 0;
		Arrays.sort(arr);
		int lt=0, rt=N-1;
		int mid = (rt + lt)/2;
		while(arr[mid] != M){
			if(arr[mid] < M){
				lt = mid+1;
			}else{
				rt = mid-1;
			}
			mid = (rt + lt)/2;
		}
		
		ans = mid+1;
		return ans;
	}


}
