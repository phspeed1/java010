import java.util.*;
import java.io.*;

public class Inf140IslnadCountBFS{

    public static void main(String[] args){
        int N = 7; // y
        String[][] strArr = new String[N][N];
        String str = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            N = Integer.parseInt(str);
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
    
        String rtn = new Inf140IslnadCountBFS().solution(N, strArr);
        System.out.println(rtn);
    }
    
    int N;
    int[][] board;
    private String solution(int N, String[][] sr){
        StringBuilder buff = new StringBuilder();
        board = new int[N][N];
        this.N = N;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                board[i][j] = Integer.parseInt(sr[i][j]);
            }
        }

        ///////////////////
        int lv = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(board[i][j] == 1){
                    lv++;
                    BFS(i, j);
                }
            }
        }

        buff.append(lv);
        return buff.toString();
    }

    int[] dy={-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dx={0, 1, 1, 1, 0, -1, -1, -1};

    void BFS(int y, int x){
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(new Point(y, x));
        board[y][x] = 0;

        while(!queue.isEmpty()){
            Point p = queue.poll();

            for(int i=0; i<8; i++){
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if(ny >=0 && ny < N && nx >=0 && nx < N && board[ny][nx] == 1){
                    board[ny][nx] = 0;
                    queue.offer(new Point(ny, nx));
                }
            }
        }

    }

    class Point{
        int y, x;
        Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

}