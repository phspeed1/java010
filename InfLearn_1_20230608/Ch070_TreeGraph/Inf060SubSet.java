import java.util.*;
import java.io.*;

public class Inf060SubSet{

    public static void main(String[] args){
        String str = "";
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     str = br.readLine();
        // }catch(IOException ioe){
        //     ioe.printStackTrace();
        // }
    
        String rtn = new Inf060SubSet().solution(str);
        System.out.println(rtn);
    }
    
    private String solution(String str){
        StringBuilder buff = new StringBuilder();
        
        int[] arr = {1, 2, 3};
        int N = arr.length;
        int M = N;
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> resList = new ArrayList<>();
        combinationSub(arr, N, M, list, 0, resList);
        System.out.println("resList : "+resList);
  //      combinationSub2(N, 1, list);
        
   //     int[] ch = new int[N+1];
 //       combinationSub3(N, 1, ch);

        return buff.toString();
    }

    void combinationSub(int[] arr, int N, int M, List<Integer> list, int lv, List<List<Integer>> resList){

        if(list.size() == M)
            return;
        
        for(int i=lv; i<N; i++){
            list.add(arr[i]);


            combinationSub(arr, N, M, list, i+1, resList);

        System.out.println(list);
        //resList.add(list.subList(0, list.size()));
        List<Integer> newList = new ArrayList<Integer>();
        newList.addAll(list);
        resList.add(newList);

            list.remove(list.size()-1);
        }
    }

    void combinationSub2(int N, int lv, List<Integer> list){

        if(lv > N)
            return;
        
        for(int i=lv; i<=N; i++){
            list.add(i);
            combinationSub2(N, i+1, list);
            System.out.println("_"+list);
            list.remove(list.size()-1);
        }
    }    

    void combinationSub3(int N, int lv, int[] ch){
        if(lv == N+1){
            String tmp = "";
            for(int i=1; i<ch.length; i++){
                if(ch[i] == 1) tmp += i+" ";
            }
            if(tmp.length() >0) System.out.println(tmp);

            return;
        }
        
        ch[lv] = 1;
        combinationSub3(N, lv+1, ch);
        ch[lv] = 0;
        combinationSub3(N, lv+1, ch);

    }

}