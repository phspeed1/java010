import java.util.*;
import java.io.*;

public class Inf010SubSetSumEqual{

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
    
        String rtn = new Inf010SubSetSumEqual().solution(str, N);
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
        int sum = Arrays.stream(arr).sum();
        List<Integer> list = new ArrayList<Integer>();
        answer = false;
        combination(arr, N, sum, list, 0);
       
        return answer?"YES":"NO";
    }

    void combination(int[] arr, int N, int sum, List<Integer> list, int lv){
        if(lv >= N) return;

        if(lv != 0) answer = answer || (sum-getSum(list) == getSum(list));
        if(answer) {
   //         System.out.println("sum : "+(sum-getSum(list))+"!="+(getSum(list))+" list ("+getSum(list)+") : "+list);
           return;
        }

        for(int i=lv; i<N; i++){
            list.add(arr[i]);
            combination(arr, N, sum, list, i+1);
            list.remove(list.size()-1);
        }
    }

    int getSum(List<Integer> list){
        int sum = 0;
        for(int i:list) sum+=i;
        return sum;
    }


}