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

		int lt= Arrays.stream(arr).max().getAsInt();
		int rt = Arrays.stream(arr).sum();
		int mid = (lt+rt)/2;
		ans = rt;

		while(lt <= rt){
			mid = (lt+rt)/2;
			int needDvdCnt = needDVD(arr, mid);
		//	System.out.println("capacity ("+mid+") needDVD : "+needDvdCnt);
			if(needDvdCnt <= M){
				ans = mid;
				rt = mid-1;
			}else{
				lt = mid+1;
			}
		}



		return ans;
	}

	int needDVD(int[] arr, int capacity){
		int cnt = 1;
		int sum = 0;
		for(int song : arr){
			if(sum + song > capacity){
				cnt++;
				sum = song;
			}else{
				sum += song;
			}
		}
		return cnt;
	}



}
