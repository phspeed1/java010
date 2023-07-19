import java.util.*;
import java.io.*;

public class Inf041LisBricks{

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
    
        String rtn = new Inf041LisBricks().solution(N, arr);
        System.out.println(rtn);
    }
    
    private String solution(int N, int[][] arr){
        StringBuilder buff = new StringBuilder();
        int answer = 0;

        ArrayList<Brick> list = new ArrayList<Brick>();
        for(int i=0; i<N; i++) list.add(new Brick(arr[i][0], arr[i][1], arr[i][2]));
        Collections.sort(list); // 1차로 벽돌 무게로 Sort

        ArrayList<ArrayList<Brick>> lisList = new ArrayList<>();
        for(int i=0; i<N; i++) lisList.add(new ArrayList<Brick>());
        int[] dp = new int[N];
        dp[0] = list.get(0).height;
        lisList.get(0).add(list.get(0));
        answer = dp[0];

        // 최대부분수열 찾기
        
        for(int i=1; i<N; i++){
            int max = 0;
            int maxIdx = -1;

            for(int j=i-1; j>=0; j--){

                // if(list.get(j).width < list.get(i).width && dp[j] > max){
                //     max = dp[j];
                //     maxIdx = j;
                // }

                // max 를 개수가 아니라 가장 height 가 높은데 가중치를 두자
                if(list.get(j).width < list.get(i).width && dp[j] > max){
                    max = list.get(j).height; //여기가 틀렸네.
                    max = dp[j];
                    maxIdx = j;
                }                
            }
            dp[i] = max + list.get(i).height;
            if(maxIdx != -1)
                lisList.get(i).addAll(lisList.get(maxIdx));
            lisList.get(i).add(list.get(i));
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(list);
        System.out.println("dp : "+Arrays.toString(dp));
        answer = 0;
        for(int i=0; i<N; i++){
            int sum = 0;
            for(Brick brick : lisList.get(i)){
                sum += brick.height;
            }
            System.out.println(i+"("+sum+") : "+lisList.get(i));
            answer = Math.max(answer, sum);
        }
        
        buff.append(answer);
        return buff.toString();
    }

    class Brick implements Comparable<Brick>{
        int width, height, weigh;
        Brick(int width, int height, int weigh){
            this.width = width;
            this.height = height;
            this.weigh = weigh;
        }

        public int compareTo(Brick o){
            return this.weigh - o.weigh;
        }
        public String toString(){
            return "{width:"+this.width+", height:"+this.height+", weigh:"+this.weigh+"}";
        }

    }

}