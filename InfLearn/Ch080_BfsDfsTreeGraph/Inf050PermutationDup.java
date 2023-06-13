import java.util.*;
import java.io.*;

public class Inf050PermutationDup{

    public static void main(String[] args){
        int N = 3;
        int M = 15;
        String str = "1 2 5";
        String[] strArr;
        int[] arr = new int[N];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            N = Integer.parseInt(str);
            str = br.readLine();
            arr = new int[N];
            strArr = str.split(" ");
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(strArr[i]);

            str = br.readLine();
            M = Integer.parseInt(str);

        }catch(Exception ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf050PermutationDup().solution(N, M, arr);
        System.out.println(rtn);
    }
    
    int N;
    int M;
    int[] arr;
    int answer = Integer.MAX_VALUE;
    private String solution(int N, int M, int[] arr1){
        StringBuilder buff = new StringBuilder();
        this.N = N;
        this.M = M;

        int[] arr2 = new int[N];
        Arrays.sort(arr1);
        for(int i=0; i<N; i++){
            arr2[N-1 -i] = arr1[i];
        }
        this.arr = arr2;


        List<Integer> list = new ArrayList<Integer>();
        permutation(0, 0, list);

        buff.append(answer);
        return buff.toString();
    }
    int counter = 0;

    void permutation(int lv, int sum, List<Integer> list){
    //    if(counter++ > 10000) arr[counter] = counter;
    //    System.out.println("["+counter+"]"+lv+" : "+sum+list);
        
        if(lv >= answer) return;
        if(sum > M) return;
        if(sum == M){
            answer = Math.min(answer, lv);
            return;
        }

        for(int i=0; i<N; i++){
            list.add(arr[i]);
            permutation(lv+1, sum+arr[i], list);
            list.remove(list.size() -1);
        }

    }


    

}