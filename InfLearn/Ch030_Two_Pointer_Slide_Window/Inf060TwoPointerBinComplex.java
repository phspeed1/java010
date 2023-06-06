import java.util.*;
import java.io.*;

public class Inf060TwoPointerBinComplex{

    public static void main(String[] args){
        int N = 14;
        int K = 2;
        String str = "1 1 0 0 1 1 0 1 1 0 1 1 0 1";
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
    
        String rtn = new Inf060TwoPointerBinComplex().solution(N, K, str);
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

        // 강의 보고 한 방식
        // int cnt = 0;
        // int sum=0, using=0, lt=0, rt=0;

        // while(rt < N){
        //     sum++;
        //     if(arr[rt] == 1){
        //         // System.out.println(sum+"["+lt+"~"+rt+"]CASE-1 Go");
        //         cnt = Math.max(cnt, sum);
        //         // 그냥간다.
        //     }else if(using < K){
        //         // System.out.println(sum+"["+lt+"~"+rt+"]CASE-2 UsingChance");
        //         // 찬스 사용하고 끌고 간다.
        //         using++;
        //         cnt = Math.max(cnt, sum);
        //     }else{
        //         using++; // 중요. 여기서도 RT가 증가할 것이기 때문에 찬스 쓰고 증가할것
        //         // 더이상 그냥 끌고 갈 수 없음 때문에 카운트한다.
        //         while(arr[lt] == 1){
        //             lt++;
        //             sum--;
        //         }
        //         using--;
        //         lt++;
        //         sum--;
        //         cnt = Math.max(cnt, sum);
        //         // System.out.println(sum+"["+lt+"~"+rt+"]CASE-3");
        //     }
        //     rt++;
        // }

        // int cnt=0, using=0, lt=0;
        // for(int rt=0; rt<N; rt++){
        //     if(arr[rt] == 0) using++;
        //     while(using > K){
        //         if(arr[lt] == 0) using--;
        //         lt++;
        //     }
        //     cnt = Math.max(cnt, rt - lt +1);
        // }

        // int cnt =0, using=0, lt=0;
        // for(int rt=0; rt<N; rt++){
        //     if(arr[rt] == 0) using++;
        //     while(using > K){
        //         if(arr[lt] == 0) using--;
        //         lt++;
        //     }
        //     cnt = Math.max(cnt, rt - lt +1);

        // }


        int cnt =0, using=0, lt=0;
        for(int rt=0; rt<N; rt++){
            if(arr[rt] == 0){
                using++;
                while(using > K){
                    if(arr[lt] == 0) using--;
                    lt++;
                }
            }
            cnt = Math.max(cnt, rt - lt + 1);

        }

        buff.append(cnt);
        return buff.toString().trim();
    }

}