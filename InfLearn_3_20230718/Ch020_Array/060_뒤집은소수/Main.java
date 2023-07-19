import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = 0;
		int[] arr = null;

  		N = sc.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();

		System.out.println(new Main().solution(N, arr));
	}




	String solution(int N, int[] arr){
		String answer = "";

		int M = 100000;
		int[] ch = new int[M+1];
		for(int i=0; i<=M; i++){
			if(i<2) {
				ch[i] = 1;
				continue;
			}
			if(ch[i] == 0){
				for(int j=i+i; j<=M; j+=i){
					ch[j] = i;
				}
			}
		}

		for(int num : arr){
			int t = 0;
			while(num > 0){
				t = t * 10 + num % 10;
				num = num / 10;
			}
			if(ch[t] == 0) answer += t + " ";
		}

		return answer;
	}



}
