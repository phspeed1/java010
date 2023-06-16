import java.util.*;
import java.io.*;

public class Inf060NapsackMaxScore{

    public static void main(String[] args){
        int N = 5;
        int M = 20;
        String str = "";
        int[][] arr = new int[N][2];
        arr[0] = new int[]{10, 5};
        arr[1] = new int[]{25, 12};
        arr[2] = new int[]{15, 8};
        arr[3] = new int[]{6, 3};
        arr[4] = new int[]{7, 4};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            String[] sr = str.split(" ");
            N = Integer.parseInt(sr[0]);
            M = Integer.parseInt(sr[1]);
            arr = new int[N][2];
            for(int i=0; i<N; i++){
                str = br.readLine();
                sr = str.split(" ");
                arr[i][0] = Integer.parseInt(sr[0]);
                arr[i][1] = Integer.parseInt(sr[1]);
            }
        }catch(Exception ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf060NapsackMaxScore().solution(N, M, arr);
        System.out.println(rtn);
    }
    
    int maxScore;
    String solution(int N, int M, int[][] arr){
        StringBuilder buff = new StringBuilder();
        int answer = 0;
        maxScore = 0;

       // DFS(N, M, arr, 0, M, 0, new ArrayList<String>());

       int[] dp = new int[M+1];
       int[] used = new int[N];

       for(int i=0; i<N; i++){
        // 점수, 시간
            int iScore = arr[i][0];
            int iTime = arr[i][1];
            for(int j=M; j>= iTime; j--){
                dp[j] = Math.max(dp[j], dp[j-iTime]+iScore);
            }
//       System.out.println(Arrays.toString(dp));
       }

        answer = dp[M];

        buff.append(answer);
        return buff.toString();
    }


    void DFS(int N, int M, int[][] arr, int score, int R, int S, List<String> list){
        if(R >= 0){
     //       System.out.println("("+score+")"+list);
            maxScore = Math.max(maxScore, score);
        }
        if(R < 0){
            return;
        }

        for(int i=S; i<N; i++){
            list.add("["+i+"]"+arr[i][0] + " "+arr[i][1]);
            DFS(N, M, arr, score+arr[i][0], R-arr[i][1], i+1, list);
            list.remove(list.size() - 1);
        }
    }


}