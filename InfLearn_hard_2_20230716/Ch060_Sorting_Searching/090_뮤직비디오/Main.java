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
		int ans = 0;

		int lt = Arrays.stream(arr).max().getAsInt();
		int rt = Arrays.stream(arr).sum();

		while(lt <= rt){
			int mid = (lt + rt)/2;
			int cnt = cntNeedDvd(arr, mid);
			if(cnt <= M){
				ans = mid;
				rt = mid-1;
			}else{
				lt = mid+1;
			}
		}

		return ans;
	}

	int cntNeedDvd(int[] arr, int capacity){
		int cnt = 1;
		int sum = arr[0];

		for(int i=1; i<arr.length; i++){
			if(sum + arr[i] > capacity){
				cnt++;
				sum = arr[i];
			}else{
				sum += arr[i];
			}
		}

		return cnt;
	}



}
