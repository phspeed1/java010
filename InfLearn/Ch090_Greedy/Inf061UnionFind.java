import java.util.*;
import java.io.*;

public class Inf061UnionFind{

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
    
        String rtn = new Inf061UnionFind().solution(N, M, arr, pair1, pair2);
        System.out.println(rtn);
    }

    int Find(int[] grp, int v){
        if(v == grp[v]) return grp[v];
        else return grp[v] = Find(grp, grp[v]);
    }
    void Union(int[] grp, int a, int b){
        int fa = Find(grp, a);
        int fb = Find(grp, b);
        if(fa != fb) grp[fa] = fb;
    }
    
    private String solution(int N, int M, int[][] arr, int p1, int p2){
        int[] grp = new int[N+1];
        for(int i=1; i<N+1; i++) grp[i] = i;
        for(int i=0; i<M; i++){
            Union(grp, arr[i][0], arr[i][1]);
        }

        if(Find(grp, p1) == Find(grp, p2)) return "YES";
        else return "NO";
    }


}