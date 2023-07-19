import java.util.*;
import java.io.*;

public class Inf080GuessPermutation{

    public static void main(String[] args){
        int N = 4;
        int F = 16;
        String[] strArr;
        int[] arr = new int[N];
        String str = "9 730";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
         //   str = br.readLine();
            strArr = str.split(" ");
            N = Integer.parseInt(strArr[0]);
            F = Integer.parseInt(strArr[1]);

        }catch(Exception ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf080GuessPermutation().solution(N, F);

        System.out.println(rtn);
    }

    int[][] combiArr;


    int combiCount(int n, int r){
        if(r == 0) return 1;
        if(n == r) return 1;

        if(combiArr[n][r] != 0) return combiArr[n][r];

        return combiArr[n][r] = combiCount(n-1, r-1) +combiCount(n-1, r);
    }

    
    private String solution(int N, int F){
        StringBuilder buff = new StringBuilder();
        combiArr = new int[N+1][N+1];

        int[] arr = new int[N];
        for(int i=0; i<N; i++) arr[i] = i+1;

        int[] answer = new int[N];
        boolean[] visited = new boolean[N];

        int M = N;
        this.F = F;

        List<int[]> answerList = new ArrayList<>();

        permutation(arr, N, M, 0, answer, answerList, visited);

     //   for(int[] a : answerList) System.out.println(Arrays.toString(a));
        
        return solve.trim();
    }
    int limit = 0;
    boolean isFinish = false;
    int F;
    String solve = "";

    void permutation(int[] arr, int N, int M, int lv, int[] answer, List<int[]> answerList, boolean[] visited){
        //if(limit++ > 10000) return;
        if(isFinish) return;

        if(lv == M){

            int sum = 0;
            for(int i=0; i<answer.length; i++){
                sum += answer[i] * combiCount(N-1, i);
            }
            if(sum == F){
                for(int x : answer) solve += x+" ";
                answerList.add(answer.clone());
                isFinish = true;
            }

            return;
        }

        for(int i=0; i<N; i++){
            if(visited[i]) continue;
            
            visited[i] = true;
            answer[lv] = arr[i];
            permutation(arr, N, M, lv+1, answer, answerList, visited);
            visited[i] = false;
        }

    }

}