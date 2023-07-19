import java.util.*;
import java.io.*;

public class Inf041PermutationDup{

    public static void main(String[] args){
        int N = 3;
        int M = 2;
        String str = "";
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     str = br.readLine();
        //     String[] strArr = str.split(" ");
        //     N = Integer.parseInt(strArr[0]);
        //     M = Integer.parseInt(strArr[1]);
        // }catch(IOException ioe){
        //     ioe.printStackTrace();
        // }
    
        new Inf041PermutationDup().solution(N, M);
    }
    
    int[] pm;
    int N;
    int M;
    boolean[] visited;
    private void solution(int N, int M){
        pm = new int[M];
        this.N = N;
        this.M = M;
        visited = new boolean[N+1];
        permutation(0);
    }

    void permutation(int lv){
        if(lv == M){
            for(int x:pm) System.out.print(x+" ");
            System.out.println();
            return;
        }

        for(int i=1; i<=N; i++){
        //    if(visited[i]) continue;

            visited[i] = true;
            pm[lv] = i;
            permutation(lv+1);
            visited[i] = false;
        }
    }


}