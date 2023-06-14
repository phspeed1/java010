import java.util.*;
import java.io.*;

public class Inf150DfsCombiPizza{

    public static void main(String[] args){
        int N = 4; // 줄
        int M = 4; // 선택피자집
        String[][] strArr = new String[N][N];
        String str = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            N = Integer.parseInt(str.split(" ")[0]);
            M = Integer.parseInt(str.split(" ")[1]);
            strArr = new String[N][M];

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
    
        String rtn = new Inf150DfsCombiPizza().solution(M, N, strArr);
        System.out.println(rtn);
    }
    
    int answer = Integer.MAX_VALUE;
    int[][] board;
    int N = 0;
    int M = 0;
    List<Point> homeList;
    List<Point> allStore;

    private String solution(int M, int N, String[][] strArr){
        StringBuilder buff = new StringBuilder();

        homeList = new ArrayList<Point>();
        allStore = new ArrayList<Point>();

        board = new int[N][N];
        for(int i=0; i<strArr.length; i++){
            for(int j=0; j<strArr[i].length; j++){
                board[i][j] = Integer.parseInt(strArr[i][j]);
                if(board[i][j] == 1) homeList.add(new Point(i, j));
                else if(board[i][j] == 2) allStore.add(new Point(i, j));
            }
        }

        List<Point> storeList = new ArrayList<Point>();

        this.N = N;
        this.M = M;

        combination(0, 0, storeList);

        buff.append(answer);
        return buff.toString();
    }

    void combination(int lv, int start, List<Point> storeList){
        if(lv == M){
            // System.out.println(storeList);
            int sum = 0;
            for(Point p : homeList){
                initialBoard(p, storeList);
                sum += BFS(p);
            }
            answer = Math.min(answer, sum);

        }else{
            for(int i=start; i<allStore.size(); i++){
                storeList.add(allStore.get(i));
                combination(lv+1, i+1, storeList);
                storeList.remove(storeList.size()-1);
            }
        }
    }

    int BFS(Point s){
        int lv = 0;
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(s);

        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0; i<len; i++){
                Point p = queue.poll();
                for(int j=0; j<4; j++){
                    int ny = p.y+dy[j];
                    int nx = p.x+dx[j];
                    if(ny >= 0 && ny < N && nx >= 0 && nx < N){
                        if(board[ny][nx] == 2) return lv+1;
                        if(board[ny][nx] == 0){
                            board[ny][nx] = 1;
                            queue.offer(new Point(ny, nx));
                        }
                    }
                }
            }
            lv++;
        }

        return lv;
    }


    int[]dx = {0, 1, 0, -1};
    int[]dy = {-1, 0, 1, 0};

    void initialBoard(Point s, List<Point> storeList){
        board = new int[N][N];
        board[s.y][s.x] = 1;
        for(Point p : storeList){
            board[p.y][p.x] = 2;
        }
    }



    class Point implements Comparable<Point>{
        int x, y, lv;
        Point(int y, int x){
            this.y = y;
            this.x = x;
        }
        public int compareTo(Point ot){
            return this.x == ot.x && this.y == ot.y ? 0:-1;
        }
        public String toString(){
            return "("+lv+")["+y+"]["+x+"]";
        }
    }

}