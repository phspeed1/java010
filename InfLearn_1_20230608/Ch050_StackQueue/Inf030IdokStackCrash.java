import java.util.*;
import java.io.*;

public class Inf030IdokStackCrash{

    public static void main(String[] args){
        int N = 5;
        int M = 8;
        String[] board = new String[N];
        String moves = "1 5 3 5 1 2 1 4";
        board[0] = "0 0 0 0 0";
        board[1] = "0 0 1 0 3";
        board[2] = "0 2 5 0 1";
        board[3] = "4 2 4 4 2";
        board[4] = "3 5 1 3 1";
    
        String str = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            str = br.readLine();
            N = Integer.parseInt(str);
            board = new String[N];
            for(int i=0; i<N; i++){
                board[i] = br.readLine();
            }
            str = br.readLine();
            M = Integer.parseInt(str);
            moves = br.readLine();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    
        String rtn = new Inf030IdokStackCrash().solution(N, board, M, moves);
        System.out.println(rtn);
    }
    
    private String solution(int N, String[] strArr, int M, String moveStr){
        StringBuilder buff = new StringBuilder();
        int[][] board = new int[N][N+1];
        for(int i=0; i<strArr.length; i++){
            String[] strA = strArr[i].split(" ");
            for(int j=0; j<strA.length; j++)
                board[i][j+1] = Integer.parseInt(strA[j]);
        }

        int[] moves = new int[M];
        String[] strA = moveStr.split(" ");
        for(int i=0; i<strA.length; i++){
            moves[i] = Integer.parseInt(strA[i]);
        }

//        System.out.println(Arrays.deepToString(board));
        //System.out.println(Arrays.toString(moves));
        ///////////////////////////////////////////////
        // 초기화 완료
        ///////////////////////////////////////////////
        int crashCnt = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i : moves){
//            System.out.println(getIdol(board, N, i));
            int id = getIdol(board, N, i);
            if(id==0){

            }
            else if(stack.size() != 0 && stack.peek() == id){
                stack.pop();
                crashCnt+=2;
            }
            else{
                stack.push(id);
            }
        }
        buff.append(crashCnt);
        return buff.toString();
    }

    int getIdol(int[][] arr, int N, int k){


        for(int i=0; i<N; i++){
            if(arr[i][k] != 0){
                int idol = arr[i][k];
                arr[i][k] = 0;
                return idol;
            }
        }
        return 0;

    }

}