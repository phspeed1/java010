import java.util.*;
import java.io.*;

public class Inf060UnionFind{

    public static void main(String[] args){
        int N = 9;
        int M = 7;
        int pair1 = 3;
        int pair2 = 8;

        int[][] arr;
        String str = "";
        arr = new int[M][2];
	    arr[0] = new int[]{1, 2};
        arr[1] = new int[]{2, 3};
        arr[2] = new int[]{3, 4};
        arr[3] = new int[]{1, 5};
        arr[4] = new int[]{6, 7};
        arr[5] = new int[]{7, 8};
        arr[6] = new int[]{8, 9};
//        arr[6] = new int[]{4, 6};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            N = Integer.parseInt(str.split(" ")[0]);
            M = Integer.parseInt(str.split(" ")[1]);
            arr = new int[M][2];
            String[] sr;
            for(int i=0; i<M; i++){
                str = br.readLine();
                sr = str.split(" ");
                arr[i][0] = Integer.parseInt(sr[0]);
                arr[i][1] = Integer.parseInt(sr[1]);
            }
            str = br.readLine();
            pair1 = Integer.parseInt(str.split(" ")[0]);
            pair2 = Integer.parseInt(str.split(" ")[1]);
        }catch(Exception ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf060UnionFind().solution(N, M, arr, pair1, pair2);
        System.out.println(rtn);
    }
    
    private String solution(int N, int M, int[][] arr, int pair1, int pair2){
        StringBuilder buff = new StringBuilder();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<N+1; i++) list.add(new ArrayList<Integer>());
        for(int i=0; i<M; i++){
            list.get(arr[i][0]).add(arr[i][1]);
            list.get(arr[i][1]).add(arr[i][0]);
        }

        boolean[] visited = new boolean[N+1];

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(pair1);
        visited[pair1] = true;

        while(!queue.isEmpty()){
            int j = queue.poll();

            for(int nj : list.get(j)){
                if(nj == pair2) return "YES";
                if(visited[nj]) continue;
                visited[nj] = true;
                queue.offer(nj);
            }
        }

        buff.append("NO");

        return buff.toString();
    }


}