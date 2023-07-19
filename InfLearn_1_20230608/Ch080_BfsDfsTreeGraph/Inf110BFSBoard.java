import java.util.*;
import java.io.*;

public class Inf110BFSBoard{

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
    
        String rtn = new Inf110BFSBoard().solution(strArr);
        System.out.println(rtn);
    }
    
    int answer = -1;
    int[][] board;
    Queue<Point> queue = null;
    private String solution(String[][] strArr){
        StringBuilder buff = new StringBuilder();
        board = new int[strArr.length+1][strArr[0].length+1];
        for(int i=0; i<strArr.length; i++){
            for(int j=0; j<strArr[i].length; j++){
                board[i+1][j+1] = Integer.parseInt(strArr[i][j]);
            }
        }

        BFS();
        buff.append(answer);
        return buff.toString();
    }


    int[]dx = {0, 1, 0, -1};
    int[]dy = {-1, 0, 1, 0};
    int lv;
    int limit=0;

    void BFS(){
        answer = -1;
        queue = new LinkedList<Point>();
        queue.offer(new Point(1, 1, 0));
        board[1][1] = 1;

        while(!queue.isEmpty()){
            int len = queue.size();
            for(int j=0; j<len; j++){
                Point p = queue.poll();
            //    System.out.println(p);

                if(p.x == 7 && p.y == 7){
                    answer = p.lv;
                    return;
                }

                for(int i=0; i<dx.length; i++){
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];

                    if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] != 1){
                        board[nx][ny] = 1;
                        queue.offer(new Point(nx, ny, p.lv+1));
                    //    board[nx][ny] = 0;
                    }
                }
            }
            lv++;
        }

    }


    class Point implements Comparable<Point>{
        int x, y, lv;
        Point(int x, int y, int lv){
            this.x = x;
            this.y = y;
            this.lv = lv;
        }
        public int compareTo(Point ot){
            return this.x == ot.x && this.y == ot.y ? 0:-1;
        }
        public String toString(){
            return "("+lv+")["+x+"]["+y+"]";
        }
    }

}