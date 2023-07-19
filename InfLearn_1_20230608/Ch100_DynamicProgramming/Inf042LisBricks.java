import java.util.*;
import java.io.*;

public class Inf042LisBricks{

    public static void main(String[] args){
        int N = 5;
        String str = "";
        int[][] arr = new int[N][3];
        arr[0] = new int[]{25, 3, 4};
        arr[1] = new int[]{4, 4, 6};
        arr[2] = new int[]{9, 2, 3};
        arr[3] = new int[]{16, 2, 5};
        arr[4] = new int[]{1, 5, 2};

        // CASE-2 정답은 18
        arr[0] = new int[]{14, 5, 18};
        arr[1] = new int[]{19, 10, 5};
        arr[2] = new int[]{7, 12, 14};
        arr[3] = new int[]{5, 6, 19};
        arr[4] = new int[]{8, 13, 7};


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            N = Integer.parseInt(str);
            arr = new int[N][3];
            for(int i=0; i<N; i++){
                str = br.readLine();
                String[] sr = str.split(" ");
                for(int j=0; j<3; j++) arr[i][j] = Integer.parseInt(sr[j]);
            }
        }catch(Exception ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf042LisBricks().solution(N, arr);
        System.out.println(rtn);
    }
    
    private String solution(int N, int[][] arr){
        StringBuilder buff = new StringBuilder();
        int answer = 0;

        List<Brick> list = new ArrayList<Brick>();
        for(int i=0; i<N; i++) list.add(new Brick(arr[i][0], arr[i][1], arr[i][2]));
        Collections.sort(list);

        int[] dp = new int[N];
        dp[0] = list.get(0).height;
        answer = dp[0];

        for(int i=1; i<N; i++){
            int maxHeight = 0;
            for(int j=i-1; j>=0; j--){
                if(list.get(j).width > list.get(i).width && dp[j] > maxHeight){
                    maxHeight = dp[j];
                }
            }
            dp[i] = maxHeight + list.get(i).height;
            answer = Math.max(answer, dp[i]);
        }

 
        buff.append(answer);
        return buff.toString();
    }

    class Brick implements Comparable<Brick>{
        int width, height, weight;
        Brick(int width, int height, int weight){
            this.width = width;
            this.height = height;
            this.weight = weight;
        }

        public int compareTo(Brick o){
            return o.weight - this.weight;
        }
        public String toString(){
            return "{width:"+this.width+", height:"+this.height+", weight:"+this.weight+"}";
        }

    }

}