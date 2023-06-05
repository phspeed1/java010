import java.util.*;
import java.io.*;

public class Inf050TwoPointerMath{

    public static void main(String[] args){
        String str = "15";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf050TwoPointerMath().solution(str);
        System.out.println(rtn);
    }
    
    private String solution(String str){
        StringBuilder buff = new StringBuilder();
        int N = Integer.parseInt(str);
        int L = (N+1)/2;
        int[] arr = new int[L];
        int cnt=0;

        for(int i=0; i<L; i++){
            arr[i] = i+1;
        }

        int sum=0, lt=0, rt=0;
        while(lt<L || rt<L){
            if(sum == N) cnt++;
            if(sum < N && rt < L){
                sum += arr[rt++];
            }else{
                sum -= arr[lt++];
            }
        }

        // int sum = 0, lt = 0;
        // for(int rt=0; rt<L; rt++){
        //     sum += arr[rt];
        //     if(sum == N) cnt++;

        //     while(sum >= N){
        //         sum -= arr[lt++];
        //         if(sum == N) cnt++;
        //     }
        // }

        buff.append(cnt);
        return buff.toString().trim();
    }

}