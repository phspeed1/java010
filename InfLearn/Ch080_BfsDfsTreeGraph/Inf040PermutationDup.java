import java.util.*;
import java.io.*;

public class Inf040PermutationDup{

    public static void main(String[] args){
        int N = 3;
        int M = 2;
        String str = "";
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     str = br.readLine();
        //     String[] strArr = str.split(" ");
        //     N = Integer.parseInt(strArr[0]);
        //     M = Integer.parseInt(strArr[1]);
        // }catch(IOException ioe){
        //     ioe.printStackTrace();
        // }
    
        String rtn = new Inf040PermutationDup().solution(N, M);
        System.out.println(rtn);
    }
    
    private String solution(int N, int M){
        StringBuilder buff = new StringBuilder();
        boolean[] visited = new boolean[N];
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = i+1;
        }
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> resList = new ArrayList<>();

        permutation(arr, N, M, 0, list, resList, visited);
        for(List<Integer> l : resList){
            for(int i : l)
                System.out.print(i+ " ");
            System.out.println();
        }

        return buff.toString();
    }
    int counter = 0;

    void permutation(int[] arr, int N, int M, int lv, List<Integer> list, List<List<Integer>> resList, boolean[] visited){
        if(counter++ > 1000) return;
        
        if(lv == M){
        //    System.out.println(list);
            List<Integer> temp = new ArrayList<Integer>();
            temp.addAll(list);
            resList.add(temp);
            return;
        }

        for(int i=0; i<N; i++){

        //    if(visited[i]) continue;

            visited[i] = true;
            list.add(arr[i]);
            permutation(arr, N, M, lv + 1, list, resList, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }



    }

}