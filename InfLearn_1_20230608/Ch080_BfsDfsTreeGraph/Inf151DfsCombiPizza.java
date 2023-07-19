import java.util.*;
import java.io.*;

public class Inf151DfsCombiPizza{

    public static void main(String[] args){
        int N = 4;
        int M = 4;
        String[][] strArr = new String[N][N];
        String str = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            N = Integer.parseInt(str.split(" ")[0]);
            M = Integer.parseInt(str.split(" ")[1]);
            strArr = new String[N][N];

            for(int i=0; i<N; i++){
                str = br.readLine();
                String[] sr = str.split(" ");
                for(int j=0; j<N; j++){
                    strArr[i][j] = sr[j];
                }

            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf151DfsCombiPizza().solution(M, N, strArr);
        System.out.println(rtn);
    }
    
    int answer = Integer.MAX_VALUE;
    int[][] board;
    int N = 0;
    int M = 0;
    List<Point> homeList;
    List<Point> allStore;
    int len = 0;
    int[] combi;

    private String solution(int M, int N, String[][] strArr){
        StringBuilder buff = new StringBuilder();

        homeList = new ArrayList<Point>();
        allStore = new ArrayList<Point>();

        board = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                board[i][j] = Integer.parseInt(strArr[i][j]);
                if(board[i][j] == 1) homeList.add(new Point(i, j));
                else if(board[i][j] == 2) allStore.add(new Point(i, j));
            }
        }
        len = allStore.size();

        this.N = N;
        this.M = M;
        combi = new int[M];

        combination(0, 0);

        buff.append(answer);
        return buff.toString();
    }

    void combination(int lv, int start){
        if(lv == M){
            int sum = 0;
            for(Point p : homeList){
                int dis = Integer.MAX_VALUE;
                for(int i : combi){
                    dis = Math.min(dis, Math.abs(p.y - allStore.get(i).y)+Math.abs(p.x - allStore.get(i).x));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);

        }else{
            for(int i=start; i<len; i++){
                combi[lv] = i;
                combination(lv+1, i+1);
            }
        }
    }


    class Point {
        int x, y;
        Point(int y, int x){
            this.y = y;
            this.x = x;
        }
        public String toString(){
            return "["+y+"]["+x+"]";
        }
    }

}