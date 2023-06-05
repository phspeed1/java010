import java.util.*;
import java.io.*;

public class CombiPermuInt{

    public static void main(String[] args){
        int N = 4;
        int M = 2;
        String str = "1 2 2 3";
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     str = br.readLine();
        //     String[] strArr = str.split(" ");
        //     N = Integer.parseInt(strArr[0]);
        //     M = Integer.parseInt(strArr[1]);
        //     str = br.readLine();
        // }catch(IOException ioe){
        //     ioe.printStackTrace();
        // }
    
        String rtn = new CombiPermuInt().solution(N, M, str);
        System.out.println(rtn);
    }
    
    private String solution(int N, int M, String str){
        StringBuilder buff = new StringBuilder();
        String[] strArr = str.split(" ");
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(strArr[i]);
        }
        N = arr.length;
        // 초기화 End
        ////////////////////////////////////////

        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> resList = new ArrayList<>();
        HashSet<Integer> hash = new HashSet<Integer>();
        boolean[] visited = new boolean[arr.length];

        boolean DUP_TRUE = true;
        boolean DUP_FALSE = false;


        combination(arr, arr.length, 2, list, 0, resList, DUP_FALSE);
        System.out.println("combination : "+resList.toString());

        list = new ArrayList<Integer>();
        resList = new ArrayList<>();
        combination(arr, arr.length, 2, list, 0, resList, DUP_TRUE);
        System.out.println("combi-DUP : "+resList.toString());

        list = new ArrayList<Integer>();
        resList = new ArrayList<>();
        permutation(arr, arr.length, 2, list, 0, resList, visited, DUP_FALSE);
        System.out.println("permutation : "+resList.toString());
        
        list = new ArrayList<Integer>();
        resList = new ArrayList<>();
        hash = new HashSet<Integer>();
        visited = new boolean[arr.length];
        permutation(arr, arr.length, 2, list, 0, resList, visited, DUP_TRUE);
        System.out.println("permu-DUP : "+resList.toString());

        return buff.toString().trim();
    }


    void combination(int[] arr, int N, int M, List<Integer>list, int lev, List<List<Integer>> resList, boolean dup){
        if(list.size() == M){
            resList.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=lev; i<N; i++){
            list.add(arr[i]);
            combination(arr, N, M, list, i+(dup?0:1), resList, dup);
            list.remove(list.size()-1);
        }
    }

    void permutation(int[] arr, int N, int M, List<Integer> buff, int lev, List<List<Integer>> resList, HashSet<Integer> hash, boolean dup){
        if(buff.size() == M){
            resList.add(new ArrayList<Integer>(buff));
            return;
        }

        for(int i=0; i<N; i++){
            int num = arr[i];
            if(!dup && hash.contains(num)) continue;

            buff.add(num);
            hash.add(num);

            permutation(arr, N, M, buff, lev, resList, hash, dup);

            buff.remove(buff.size()-1);
            hash.remove(num);
        }
    }

    void permutation(int[] arr, int N, int M, List<Integer> buff, int lev, List<List<Integer>> resList, boolean[] visited, boolean dup){
        if(buff.size() == M){
            resList.add(new ArrayList<Integer>(buff));
            return;
        }

        for(int i=0; i<N; i++){
            int num = arr[i];
            if(!dup && visited[i]) continue;

            buff.add(num);
            visited[i] = true;

            permutation(arr, N, M, buff, lev, resList, visited, dup);

            buff.remove(buff.size()-1);
            visited[i] = false;
        }
    }


}