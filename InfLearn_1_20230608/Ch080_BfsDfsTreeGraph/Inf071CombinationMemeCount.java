import java.util.*;
import java.io.*;

public class Inf071CombinationMemeCount{

    public static void main(String[] args){
        int N = 3;
        int M = 2;
        String str = "3 6 9";
        String[] strArr;
        int[] arr = new int[N];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            // str = br.readLine();
            // strArr = str.split(" ");
            // N = Integer.parseInt(strArr[0]);
            // M = Integer.parseInt(strArr[0]);
            // str = br.readLine();
            arr = new int[N];
            strArr = str.split(" ");
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(strArr[i]);

        }catch(Exception ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf071CombinationMemeCount().solution(N, M, arr);
        System.out.println(rtn);
    }
    
    private String solution(int N, int M, int[] arr){
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