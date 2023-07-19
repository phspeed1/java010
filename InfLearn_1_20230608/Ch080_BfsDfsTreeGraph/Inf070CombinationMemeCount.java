import java.util.*;
import java.io.*;

public class Inf070CombinationMemeCount{

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
    
        String rtn = new Inf070CombinationMemeCount().solution(N, M, arr);
        System.out.println(rtn);
    }
    
    private String solution(int N, int M, int[] arr){
        StringBuilder buff = new StringBuilder();
        
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> resList = new ArrayList<>();


        int[] answer = new int[M];
        List<int[]> ansList = new ArrayList<>();

        combination(arr, N, M, 0, 0, answer, ansList, list, resList);

        for(int[] a : ansList)
            System.out.println(Arrays.toString(a));
        
        System.out.println();
        System.out.println();

        buff.append(resList);
        return buff.toString();
    }
    int limit = 0;

    void combination(int[] arr, int N, int M, int lv, int start, int[] answer, List<int[]> ansList, List<Integer> list, List<List<Integer>> resList){
        if(limit++ > 10000) return;

        if(lv == M){
//            System.out.println(Arrays.toString(answer));
            ansList.add(answer.clone());
            resList.add(new ArrayList<>(list));
            // List<Integer> temp = new ArrayList<Integer>();
            // temp.addAll(list);
            // resList.add(temp);
            return;
        }

        for(int i=start; i<arr.length; i++){
            answer[lv] = arr[i];
            list.add(arr[i]);
            combination(arr, N, M, lv+1, i+1, answer, ansList, list, resList);
            list.remove(list.size()-1);
        }


    }



    

}