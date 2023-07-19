import java.util.*;
import java.io.*;

public class Inf130IslnadCountDFS{

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
    
        String rtn = new Inf130IslnadCountDFS().solution(N, strArr);
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
        int lv = 1;
        while(isRemain() != null){
            lv++;
            Point p = isRemain();
            DFS(p.y, p.x, lv);
        }

        int answer = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                answer = Math.max(answer, board[i][j]);
            }
        }

        buff.append(answer - 1);
        return buff.toString();
    }

    int[] dy={-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dx={0, 1, 1, 1, 0, -1, -1, -1};

    void DFS(int y, int x, int lv){
        board[y][x] = lv;

        for(int i=0; i<8; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny >=0 && ny < N && nx >=0 && nx < N && board[ny][nx] == 1){
                DFS(ny, nx, lv);
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
    Point isRemain(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(board[i][j] == 1) return new Point(i, j);
            }
        }
        return null;
    }

}