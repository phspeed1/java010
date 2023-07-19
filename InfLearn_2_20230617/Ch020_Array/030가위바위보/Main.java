import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = 5;
		int[] numsA = {2, 3, 3, 1, 3};
		int[] numsB = {1, 1, 2, 2, 3};

		N = sc.nextInt();
		numsA = new int[N];
		numsB = new int[N];
		for(int i=0; i<N; i++){
			numsA[i] = sc.nextInt();
		}
		for(int i=0; i<N; i++){
			numsB[i] = sc.nextInt();
		}
		new Main().solution(N, numsA, numsB);
	}
	String solution(int N, int[] numsA, int[] numsB){
		StringBuilder ans = new StringBuilder();

		for(int i=0; i<N; i++){
			if(numsA[i] == numsB[i])
				System.out.println("D");
			else if(numsA[i] == 1 && numsB[i] == 3)
				System.out.println("A");
			else if(numsA[i] == 2 && numsB[i] == 1)
				System.out.println("A");
			else if(numsA[i] == 3 &&numsB[i] == 2 )
				System.out.println("A");
			else
				System.out.println("B");
		}
		return ans.toString();
	}
	String solution1(int N, int[] numsA, int[] numsB){
		StringBuilder ans = new StringBuilder();

		for(int i=0; i<N; i++){
			if(numsA[i] == numsB[i]){
				System.out.println("D");
			}else if(numsA[i] == 1){
				if(numsB[i] == 3) System.out.println("A");
				else  System.out.println("B");
			}else if(numsA[i] == 2){
				if(numsB[i] == 1) System.out.println("A");
				else  System.out.println("B");
			}else if(numsA[i] == 3){
				if(numsB[i] == 2) System.out.println("A");
				else  System.out.println("B");
			}
		}
		return ans.toString();
	}
}
