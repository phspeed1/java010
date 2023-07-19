import java.util.*;
import java.io.*;

public class Inf060Permutation{

    public static void main(String[] args){
        int N = 3;
        int M = 2;
        String str = "3 6 9";
        String[] strArr;
        int[] arr = new int[N];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            // str = br.readLine();
            // strArr = str.split(" ");
            // N = Integer.parseInt(strArr[0]);
            // M = Integer.parseInt(strArr[0]);
            // str = br.readLine();
            arr = new int[N];
            strArr = str.split(" ");
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(strArr[i]);

        }catch(Exception ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf060Permutation().solution(N, M, arr);
        System.out.println(rtn);
    }
    
    int N;
    int M;
    int[] arr;
    int[] answer;
    private String solution(int N, int M, int[] arr){
        StringBuilder buff = new StringBuilder();
        this.N = N;
        this.M = M;
        this.arr = arr;
        boolean[] visited = new boolean[N];
        answer = new int[M];
        permutation(0, visited);

        buff.append("");
        return buff.toString();
    }

    private void permutation(int lv, boolean[] visited){
        if(lv == M){
            for(int x : answer) System.out.print(x + " ");
            System.out.println();
            return;
        }

        for(int i=0; i<N; i++){
    //        if(visited[i]) continue;

            visited[i] = true;
            answer[lv] = arr[i];
            permutation(lv+1, visited);
            visited[i] = false;

        }


    }



    

}