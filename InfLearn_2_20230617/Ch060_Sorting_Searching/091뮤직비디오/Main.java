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
			int midCapacity = (lt + rt) / 2;
			int needDisk = getNeedDiskCount(arr, midCapacity);

			if(needDisk <= M){
				ans = midCapacity;
				rt = midCapacity - 1;
			}else{
				lt = midCapacity + 1;
			}
		}

		return ans;
	}

	int getNeedDiskCount(int[] arr, int capacity){
		int needDisk = 1;
		int sum = 0;

		for(int songL : arr){
			if(sum + songL > capacity){
				needDisk++;
				sum = songL;
			}else{
				sum += songL;
			}
		}
		return needDisk;
	}

}
