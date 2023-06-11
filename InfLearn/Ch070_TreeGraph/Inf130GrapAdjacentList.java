import java.util.*;
import java.io.*;

public class Inf130GrapAdjacentList{

    public static void main(String[] args){
        String str = "";
        int N = 5;
        int M = 9;
        int K = 5;
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list;
        list = new ArrayList<Integer>();
        list.add(2);
        list.add(3);
        list.add(4);
        map.put(1, list);

        list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(5);
        map.put(2, list);

        list = new ArrayList<Integer>();
        list.add(4);
        map.put(3, list);

        list = new ArrayList<Integer>();
        list.add(2);
        list.add(5);
        map.put(4, list);


        
        int[][] graph = {{}, {2, 3, 4}, {1, 3, 5}, {4}, {2,5}, {}};
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     str = br.readLine();
        // }catch(IOException ioe){
        //     ioe.printStackTrace();
        // }
    
        String rtn = new Inf130GrapAdjacentList().solution(N, M, K, map);
        System.out.println(rtn);
    }
    
    private String solution(int N, int M, int K,  Map<Integer, List<Integer>> map){
        StringBuilder buff = new StringBuilder();
        boolean[] visited = new boolean[N+1];
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        visited[1]=true;
        dfs(map, 1, K, list, resList, visited);
        buff.append(resList);
        
        return buff.toString();
    }

    void dfs(Map<Integer, List<Integer>> map, int node, int K, List<Integer> list, List<List<Integer>> resList, boolean[] visited){
        if(node == K){
            //System.out.println(list);
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.addAll(list);
            resList.add(tmp);

            return;
        }

        for(int link : map.get(node)){
         //   System.out.println(node+" -> "+link);
            if(!visited[link]){
                list.add(link);
                visited[link] = true;
                dfs(map, link, K, list, resList, visited);
                visited[link] = false;
                list.remove(list.size()-1);
            }
        }


    }

}