import java.util.*;
import java.io.*;

public class Inf090ArrayRowColCrosSum{

    public static void main(String[] args){
        int N = 5;
        String[] strArr;
        String str = "";
        strArr = new String[N];
        strArr[0] = "10 13 10 12 15";
        strArr[1] = "12 39 30 23 11";
        strArr[2] = "11 25 50 53 15";
        strArr[3] = "19 27 29 37 27";
        strArr[4] = "19 13 30 13 19";
        
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     str = br.readLine();
        //     N = Integer.parseInt(str);
        //     strArr = new String[N];
        //     for(int i=0; i<N; i++){
        //         str = br.readLine();
        //         strArr[i] = str;
        //     }
        // }catch(IOException ioe){
        //     ioe.printStackTrace();
        // }
    
        String rtn = new Inf090ArrayRowColCrosSum().solution(N, strArr);
        System.out.println(rtn);
    }
    
    private String solution(int N, String[] strArr){
        StringBuilder buff = new StringBuilder();
        int[][] arr = new int[N][N];
        for(int i=0; i<N; i++){
            String[] sr = strArr[i].split(" ");
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(sr[j]);
            }
        }

        int maxSum = 0;
        int lCrosSum = 0;
        int rCrosSum = 0;
        for(int i=0; i<N; i++){
            int sumCol = 0;
            int sumRow = 0;
            for(int j=0; j<N; j++){
                sumCol += arr[i][j];
                sumRow += arr[j][i];

                if(i==j)
                    lCrosSum += arr[i][j];
                if(i+j == N-1)
                    rCrosSum += arr[i][j];
            }
        //    System.out.println("sumCol["+i+"] : "+sumCol);
        //    System.out.println("sumRow["+i+"] : "+sumRow);
            maxSum = Math.max(maxSum, Math.max(sumCol, sumRow));
        }

        // 대각선 구하는 방법 2. 1중 루프에서 [i][i], [i][N-1 -i]로 구한다.
        lCrosSum = 0;
        rCrosSum = 0;
        for(int i=0; i<N; i++){
            lCrosSum += arr[i][i];
            rCrosSum += arr[i][N-1 -i];
        }


        System.out.println("lCrosSum : "+lCrosSum);
        System.out.println("rCrosSum : "+rCrosSum);
        maxSum = Math.max(maxSum, Math.max(lCrosSum, rCrosSum));

        buff.append(maxSum);
    
        return buff.toString().trim();
    }

}