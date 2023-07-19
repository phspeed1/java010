import java.util.*;
import java.io.*;

public class Inf120GrapDirectionhPermutation{

    public static void main(String[] args){
        String str = "";
        int N = 5;
        int M = 9;
        int K = 5;
        int[][] graph = {{}, {2, 3, 4}, {1, 3, 5}, {4}, {2,5}, {}};
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     str = br.readLine();
        // }catch(IOException ioe){
        //     ioe.printStackTrace();
        // }
    
        String rtn = new Inf120GrapDirectionhPermutation().solution(N, M, K, graph);
        System.out.println(rtn);
    }
    
    private String solution(int N, int M, int K, int[][] graph){
        StringBuilder buff = new StringBuilder();
        boolean[] visited = new boolean[N+1];
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        visited[1]=true;
        dfs(graph, 1, K, list, resList, visited);
        buff.append(resList);
        
        return buff.toString();
    }

    void dfs(int[][] graph, int node, int K, List<Integer> list, List<List<Integer>> resList, boolean[] visited){
        if(node == K){
            //System.out.println(list);
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.addAll(list);
            resList.add(tmp);

            return;
        }

        for(int link : graph[node]){
         //   System.out.println(node+" -> "+link);
            if(!visited[link]){
                list.add(link);
                visited[link] = true;
                dfs(graph, link, K, list, resList, visited);
                visited[link] = false;
                list.remove(list.size()-1);
            }
        }


    }

}