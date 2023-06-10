import java.util.*;

public class Inf050TreeRetrieve{

    public static void main(String[] args){
        String str = "str";
        System.out.println("input : "+str);
    
        new Inf050TreeRetrieve().solution(str);
        System.out.println("output : "+str);
    }
    
    void solution(String str){
        int[][] arr = {{1},{2, 3}, {4, 5}, {6, 7}, {}, {}, {}, {}};
        boolean[] visited = new boolean[7+1];
        StringBuilder buff = new StringBuilder();
        //dfs(arr, 1, visited, buff);
        dfs2(arr, 1, visited, buff);

        System.out.println(buff.toString().trim());

    }

    void dfs(int[][] arr, int node, boolean[] visited, StringBuilder buff){
        buff.append(" "+node);
        for(int link : arr[node]){
            if(!visited[link]){
                visited[link] = true;
                dfs(arr, link, visited, buff);
            }else{
                
            }
        }
    }


    void dfs2(int[][] arr, int node, boolean[] visited, StringBuilder buff){

        if(arr[node].length>=1)
           dfs2(arr, arr[node][0], visited, buff);

           buff.append(" "+node);

        if(arr[node].length>=2)
           dfs2(arr, arr[node][1], visited, buff);

    }    
}