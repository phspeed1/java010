import java.util.*;
import java.io.*;

public class Inf072CombinationMemeCount{

    public static void main(String[] args){
        int N = 33;
        int M = 19;
        String str = "1 3 6 7 9";
        String[] strArr;
        int[] arr = new int[N];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            // str = br.readLine();
            // strArr = str.split(" ");
            // N = Integer.parseInt(strArr[0]);
            // M = Integer.parseInt(strArr[0]);
            // str = br.readLine();
            // arr = new int[N];
            // strArr = str.split(" ");
            // for (int i = 0; i < N; i++)
            //     arr[i] = Integer.parseInt(strArr[i]);

        }catch(Exception ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf072CombinationMemeCount().solution(N, M);

        System.out.println(rtn);
    }

    String solution(int N, int M){
        
        // int num = 9;
        // int fac = factorial(num);
        // return num+" fac : "+fac;
        return ""+combiCount(N, M);
    }

    int combiCount(int n, int r){
        // n-1Cr-1 n-1Cr

        int[][] arr = new int[n+1][r+1];
        int combiNum = combiSub(n, r, arr);

        return combiNum;
    }

    int combiSub(int n, int r, int[][] arr){
        if(r == 0) return 1;
        if(n == r) return 1;

        if(arr[n][r] != 0) return arr[n][r];

        return arr[n][r] = combiSub(n-1, r-1, arr) +combiSub(n-1, r, arr);
    }


    private int factorial(int N){
        int[] arr = new int[N+1];
        arr[1] = 1; arr[2] = 2;
        int fac = factorialSub(N, arr);
        return fac;
    }

    private int factorialSub(int N, int[] arr){
        if(arr[N] != 0) return arr[N];
        return arr[N] = N * factorialSub(N-1, arr);
    }
    
    private String solution1(int N, int M, int[] arr){
        StringBuilder buff = new StringBuilder();
        int[] answer = new int[M];
        List<int[]> answerList = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> resList = new ArrayList<>();

        combination(arr, N, M, 0, 0, answer, answerList, list, resList);

        for(int[] a : answerList) System.out.println(Arrays.toString(a));
        System.out.println("----------------");
        buff.append(resList);

        return buff.toString();
    }
    int limit = 0;

    void combination(int[] arr, int N, int M, int lv, int start, int[] answer, List<int[]> answerList, List<Integer> list, List<List<Integer>> resList){
        if(limit++ > 10000) return;

        if(lv == M){
            answerList.add(answer.clone());
            resList.add(new ArrayList<>(list));
            return;
        }

        for(int i=start; i<N; i++){
            answer[lv] = arr[i];
            list.add(arr[i]);
            combination(arr, N, M, lv+1, i+1, answer, answerList, list, resList);
            list.remove(list.size()-1);
        }

    }

}