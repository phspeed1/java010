import java.util.*;
import java.io.*;

public class Inf050CombinationSet{

    public static void main(String[] args){
        int N = 10;
        int K = 3;
        String str = "13 15 34 23 45 65 33 11 26 42";
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
    
        String rtn = new Inf050CombinationSet().solution(str, N, K);
        System.out.println(rtn);
    }
    
    private String solution(String str, int N, int K){
        StringBuilder buff = new StringBuilder();
        String[] strArr = str.split(" ");
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(strArr[i]);
        }
         // 초기화 End
        ////////////////////////////////////////

        // 내가 제출한 방식
        // Set<Integer> set = new HashSet<Integer>();
        // List<Integer> list = new ArrayList<Integer>();
        // int lev = 0;
        // int M = 3;
        // combination(arr, N, M, list, lev, set);
        // //System.out.println(set.size());
        // if(set.size()<K) return "-1";
        // Iterator<Integer> ite = set.iterator();
        // ArrayList<Integer> resList = new ArrayList<Integer>();
        // while(ite.hasNext()){
        //     resList.add(ite.next());
        // }
        // Collections.sort(resList);
        // buff.append(resList.get(resList.size()-K));
        
        Set<Integer> treeSet = new TreeSet<Integer>(Collections.reverseOrder());
        // 강사방식
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                for(int k=j+1; k<N; k++){
                    treeSet.add(arr[i]+arr[j]+arr[k]);
                }
            }
        }
        int k=0;
        for(int i:treeSet){
            k++;
            if(k == K) return String.valueOf(i);
        }
        buff.append("-1");
        return buff.toString();
    }

    void combination(int[] arr, int N, int M, List<Integer> list, int lev, Set<Integer> set){
        if(list.size() == M){
            int sum = 0;
            for(int i : list) sum+=i;
            set.add(sum);
            return;
        }
        for(int i=lev; i<N; i++){
            list.add(arr[i]);
            combination(arr, N, M, list, i+1, set);
            list.remove(list.size()-1);
        }
    }



}