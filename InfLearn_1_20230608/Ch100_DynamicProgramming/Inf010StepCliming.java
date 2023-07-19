import java.util.*;
import java.io.*;

public class Inf010StepCliming{

    public static void main(String[] args){
        int N = 7;
        String str = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            N = Integer.parseInt(str);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf010StepCliming().solution(N);
        System.out.println(rtn);
    }
    
    int[] steps;
    private String solution(int N){
        StringBuilder buff = new StringBuilder();
        steps = new int[N+1];
        count = dp(N);
//        System.out.println("steps : "+Arrays.toString(steps));

        // Arrays.fill(steps, 0);
        // int stepReturn  = step(N);
        // System.out.println("stepReturn : "+stepReturn+", loop_count : "+loop_count);
        // System.out.println("steps : "+Arrays.toString(steps));

        buff.append(count);
        return buff.toString();
    }

    int dp(int n){

        steps[1] = 1;
        steps[2] = 2;
        for(int i=3; i<=n; i++){
            steps[i] = steps[i-1] + steps[i-2];
        }
        return steps[n];

    }


    int count = 0;
    int loop_count = 0;
    int step(int n){
        loop_count++;
        if(n == 0){
        //    System.out.println("step 0 : "+(ct));
            return count;
        }else if(n == 1){
        //    System.out.println("step 1 : "+(ct+1));
            count++;
            return 1;
        }else if(n == 2){
        //    System.out.println("step 2 : "+(ct+1));
            count += 2;
            return 1;
        }else{
            if(steps[n] != 0) return steps[n];
            steps[n] = Math.min(step(n-1), step(n-2))+1;
            return steps[n];
        }

    }

}