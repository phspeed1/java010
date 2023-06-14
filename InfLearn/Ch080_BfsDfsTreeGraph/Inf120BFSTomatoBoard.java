import java.util.*;
import java.io.*;

public class Inf120BFSTomatoBoard{

    public static void main(String[] args){
        int M = 6; // x
        int N = 4; // y
        String[][] strArr = new String[N][M];
        String str = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            M = Integer.parseInt(str.split(" ")[0]);
            N = Integer.parseInt(str.split(" ")[1]);
            strArr = new String[N][M];

            for(int i=0; i<N; i++){
                str = br.readLine();
                String[] sr = str.split(" ");
                for(int j=0; j<M; j++){
                    strArr[i][j] = sr[j];
                }

            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf120BFSTomatoBoard().solution(M, N, strArr);
        System.out.println(rtn);
    }
    
    int answer = -1;
    int[][] board;
    Queue<Point> queue = null;
    int N = 0;
    int M = 0;

    private String solution(int M, int N, String[][] strArr){
        StringBuilder buff = new StringBuilder();
        board = new int[N][M];
        for(int i=0; i<strArr.length; i++){
            for(int j=0; j<strArr[i].length; j++){
                board[i][j] = Integer.parseInt(strArr[i][j]);
            }
        }

        this.N = N;
        this.M = M;

        BFS();
        buff.append(answer);
        return buff.toString();
    }


    int[]dx = {0, 1, 0, -1};
    int[]dy = {-1, 0, 1, 0};

    void BFS(){
        answer = -1;
        queue = new LinkedList<Point>();

        int youngCnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j] == 0){
                    youngCnt++;
                }else if(board[i][j] == 1){
                    queue.offer(new Point(i, j, 1));
                }
            }
        }
        if(youngCnt == 0){
            answer = 0;
            return;
        } 
//System.out.println(Arrays.deepToString(board));

        while(!queue.isEmpty()){
            int len = queue.size();
            for(int j=0; j<len; j++){
                Point p = queue.poll();
//System.out.println(p);
                for(int i=0; i<dx.length; i++){
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];
                    if(nx >= 0 && nx < M && ny >= 0 && ny < N && board[ny][nx] == 0){
                        board[ny][nx] = p.lv+1;
                        queue.offer(new Point(ny, nx, p.lv+1));
                    }
                }
            }
        }
//System.out.println(Arrays.deepToString(board));

        youngCnt = 0;
        int max = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j] == 0){
                    youngCnt++;
                }else{
                    max = Math.max(max, board[i][j]);
                }
            }
        }

        if(youngCnt > 0){
            answer = -1;
            return;
        } 

        answer = max-1;
        return;


    }


    class Point implements Comparable<Point>{
        int x, y, lv;
        Point(int y, int x, int lv){
            this.y = y;
            this.x = x;
            this.lv = lv;
        }
        public int compareTo(Point ot){
            return this.x == ot.x && this.y == ot.y ? 0:-1;
        }
        public String toString(){
            return "("+lv+")["+y+"]["+x+"]";
        }
    }

}