import java.util.*;
import java.io.*;

public class Inf011SubSetSumEqual{

    public static void main(String[] args){
        int N = 6;
        String str = "1 3 5 6 7 10";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            N = Integer.parseInt(str);
            str = br.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf011SubSetSumEqual().solution(str, N);
        System.out.println(rtn);
    }
    
    boolean answer = false;
    private String solution(String str, int N){
        StringBuilder buff = new StringBuilder();
        String[] strArr = str.split(" ");
        int[] arr = new int[N];
        for(int i=0; i<strArr.length; i++) arr[i] = Integer.parseInt(strArr[i]);
        // Initial end
        ////////////////////////////////
        int total = Arrays.stream(arr).sum();
        answer = false;
        DFS(arr, N, total, 0, 0);
       
        return answer?"YES":"NO";
    }

    void DFS(int[] arr, int N, int total, int lv, int sum){
        if(lv == N) return;
        if(total / 2 < sum) return;

        System.out.println("total : "+total + "sum : "+sum);
        if(total - sum == sum) answer = true;
        if(answer) return;

        DFS(arr, N, total, lv+1, sum);
        DFS(arr, N, total, lv+1, sum+arr[lv]);
    }



}