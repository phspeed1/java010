import java.util.*;
import java.io.*;

public class Inf100DFSBoard{

    public static void main(String[] args){
        int NX = 7;
        int NY = 7;
        String[][] strArr = new String[NX][NY];
        String str = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            for(int i=0; i<NY; i++){
                str = br.readLine();
                String[] sr = str.split(" ");
                for(int j=0; j<NX; j++){
                    strArr[i][j] = sr[j];
                }

            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf100DFSBoard().solution(strArr);
        System.out.println(rtn);
    }
    
    int answer = 0;
    int[][] board;
    private String solution(String[][] strArr){
        StringBuilder buff = new StringBuilder();
        board = new int[strArr.length+1][strArr[0].length+1];
        for(int i=0; i<strArr.length; i++){
            for(int j=0; j<strArr[i].length; j++){
                board[i+1][j+1] = Integer.parseInt(strArr[i][j]);
            }
        }

        answer = 0;
        board[1][1] = 1;
        DFS(1, 1);
        buff.append(answer);
        return buff.toString();
    }

    int[]dx = {0, 1, 0, -1};
    int[]dy = {-1, 0, 1, 0};

    void DFS(int x, int y){
        if(x == 7 && y == 7){
            answer++;
            return;
        }

        for(int i=0; i<dx.length; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] != 1){
                board[nx][ny] = 1;
                DFS(nx, ny);
                board[nx][ny] = 0;
            }
        }


    }

}