import java.util.*;
import java.io.*;

public class Inf040ArraySubSumPermutaion{

    public static void main(String[] args){
        int N = 8;
        int M = 6;
        String str = "1 2 1 3 1 1 1 2";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     str = br.readLine();
        //     String[] strArr = str.split(" ");
        //     N = Integer.parseInt(strArr[0]);
        //     M = Integer.parseInt(strArr[1]);
        //     str = br.readLine();
        // }catch(IOException ioe){
        //     ioe.printStackTrace();
        // }
    
        String rtn = new Inf040ArraySubSumPermutaion().solution(N, M, str);
        System.out.println(rtn);
    }
    private String solution(int N, int M, String str){
        StringBuilder buff = new StringBuilder();
        String[] strArr = str.split(" ");
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(strArr[i]);
        }
        // 초기화 End
        ////////////////////////////////////////
        int cnt = 0;

        // 나의 시도 1 조합으로 해보려고 했지만 연속된 숫자가 아니므로 오답
        // List<Integer> list = new ArrayList<Integer>();
        // List<List<Integer>> resList = new ArrayList<>();

        // K = M;cnt = 0;
        // combination(arr, N, N, list, 0, resList, false);
        // System.out.println("combination : "+resList.toString());


        // 방법2. 완전탐색으로 다시 시도
        // List<Integer> list = new ArrayList<Integer>();
        // retrieve2(arr, N, list, 0, 0);

        // 방법3. 그냥 2중 for 문으로 제출 -- 시간초과
        // for(int i=0; i<N; i++){
        //     int sum = 0;
        //     for(int j=i; j<N; j++){
        //         sum += arr[j];
        //         if(sum == M) cnt++;
        //     }
        // }

        // 내가 제출한 방식
        // int pl = 0, pr = 0;
        // int sum = 0;
        // while(pl < N || pr < N){
        //     if(sum == M)
        //         cnt++;

        //     if(sum < M && pr<N){
        //         sum += arr[pr++];
        //     }else{
        //         sum-= arr[pl++];
        //     }
        // }

        // 강사 방식
        // int sum = 0, lt = 0;
        // for(int rt=0; rt<N; rt++){
        //     sum += arr[rt];
        //     if(sum == M)
        //         cnt++;
        //     while(sum >= M){
        //         sum -= arr[lt++];
        //         if(sum == M)
        //             cnt++;
        //     }
        // }

        // int sum = 0, lt=0, rt=0;
        // while(lt < N || rt < N){
        //     if(sum == M) cnt++;

        //     if(sum < M && rt<N){
        //         sum += arr[rt++];
        //     }else{
        //         sum -= arr[lt++];
        //     }
        // }

        // 강사방식        
        int sum=0, lt=0;
        for(int rt=0; rt<N; rt++){
            sum += arr[rt];
            if(sum == M) cnt++;

            while(sum >= M){
                sum -= arr[lt++];
                if(sum == M) cnt++;
            }            
            
        }




        buff.append(cnt);
        return buff.toString().trim();
    }

 

    void retrieve2(int[] arr, int N, List<Integer>list, int lev1, int lev2){
        if(lev1 ==N || lev2==N) return;

        list.add(arr[lev2]);
        System.out.println(list);

        retrieve2(arr, N, list, lev1, lev2 + 1);
        if (lev1 == lev2) {
            list.clear();
            retrieve2(arr, N, list, lev1 + 1, lev2 + 1);
        }
    }

    void retrieve(int[] arr, int N, List<Integer>list, int lev){
        for(int i=0; i<N; i++){
            for(int j=i; j<N; j++){
                list.add(arr[j]);
                System.out.println(list);
            }
            list.clear();
        }
    }


    void combination(int[] arr, int N, int M, List<Integer>list, int lev, List<List<Integer>> resList, boolean dup){
        if(list.size() >0){
            int sum = 0;
            for(int num : list) sum+=num;
            resList.add(new ArrayList<Integer>(list));
        }
        if(list.size() == M){
            return;
        }
        for(int i=lev; i<N; i++){
            list.add(arr[i]);
            combination(arr, N, M, list, i+(dup?0:1), resList, dup);
            list.remove(list.size()-1);
        }
    }

}