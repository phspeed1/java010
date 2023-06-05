import java.util.*;
import java.io.*;

public class Inf030ArrayBoxSumMax{

    public static void main(String[] args){
        int N = 10;
        int K = 3;
        String str = "12 15 11 20 25 10 20 19 13 15";
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     str = br.readLine();
        //     String[] strArr = str.split(" ");
        //     N = Integer.parseInt(strArr[0]);
        //     K = Integer.parseInt(strArr[1]);
        //     str = br.readLine();
        // }catch(IOException ioe){
        //     ioe.printStackTrace();
        // }
    
        String rtn = new Inf030ArrayBoxSumMax().solution(N, K, str);
        System.out.println(rtn);
    }
    
    private String solution(int N, int K, String str){
        StringBuilder buff = new StringBuilder();
        String[] strArr = str.split(" ");
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(strArr[i]);
        }
        // 초기화 End
        ////////////////////////////////////////

        int maxSum = 0;
        int sum = 0;
        for(int i=0; i<N-K; i++){

            // 방법1. 불필요한 시간이 있음
            // sum = 0;
            // for(int j=i; j<(i+K); j++){
            //     sum += arr[j];
            // }
            if(i==0){
                for(int j=i; j<(i+K); j++){
                    sum += arr[j];
                }
            }else{
                sum -= arr[i-1];
                sum += arr[i-1+K];
            }
            if(sum > maxSum) maxSum = sum;
        }

        // 방법3. 방법2를 조금 수정해서 다시
        maxSum = 0;
        sum = 0;
        for(int i=0; i<K; i++){
            sum += arr[i];
        }
        maxSum = sum;

        for(int i=K; i<N; i++){
            sum += arr[i] - arr[i-K];
            maxSum = Math.max(maxSum, sum);
        }



        buff.append(maxSum);
        
        return buff.toString().trim();
    }

}