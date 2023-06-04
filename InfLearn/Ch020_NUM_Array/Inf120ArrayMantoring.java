import java.util.*;
import java.io.*;

public class Inf120ArrayMantoring{

    public static void main(String[] args){
        int N = 4;
        int M = 3;
        String[] strArr;
        String str = "";
        strArr = new String[M];
        strArr[0] = "3 4 1 2";
        strArr[1] = "4 3 2 1";
        strArr[2] = "3 1 4 2";
        
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     str = br.readLine();
        //     String[] tmp = str.split(" ");
        //     N = Integer.parseInt(tmp[0]);
        //     M = Integer.parseInt(tmp[1]);

        //     strArr = new String[M];
        //     for(int i=0; i<M; i++){
        //         str = br.readLine();
        //         strArr[i] = str;
        //     }
        // }catch(IOException ioe){
        //     ioe.printStackTrace();
        // }
    
        String rtn = new Inf120ArrayMantoring().solution(N, M, strArr);
        System.out.println(rtn);
    }
    
    private String solution(int N, int M, String[] strArr){
        StringBuilder buff = new StringBuilder();
        int[][] arr = new int[M][N];
        for(int i=0; i<M; i++){
            String[] sr = strArr[i].split(" ");
            for(int j=0; j<sr.length; j++){
                arr[i][j] = Integer.parseInt(sr[j]);
            }
        }

        // 초기화 End
        //////////////////////////////////////
        int pCnt = 0;

        int[][] pArr = new int[N+1][N+1];
        
        // 0번학생 보다 성적이 좋은가? 0번F, 1번T, 2번T
        // 1번학생 보다
        // 
        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                if(i!=j) pArr[i][j] = 1;
            }
        }
    //    System.out.println(Arrays.deepToString(pArr));
/*
        // 각시험 회차마다 판별
        for(int i=0; i<M; i++){
            // 각 학생마다
            for(int j=0; j<N; j++){
                // 다른 학생과 비교한다.
                int stu = arr[i][j];
                for(int k=j+1; k<N; k++){
                    int lowStu = arr[i][k];
       //             System.out.println(stu+"번을 멘토링 못하는 학생"+lowStu);
                    pArr[stu][lowStu] = 0;
                }
            }
            System.out.println(Arrays.deepToString(pArr));
        }

        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                if(pArr[i][j] == 1)
                    pCnt++;
            }
        }
 */

        // 학생마다
        // 이학생을 매토링가능한지(보다 점수가 높은지)       
        // 시험회차
        // 등수를 읽는다.

        for(int i=1; i<=N; i++){
            for(int j=1;j<=N;j++){
                if(i==j) continue;
                int cnt = 0;
                int pi = 0;
                int pj = 0;
                for(int k=0; k<M; k++){
                    for(int s=0; s<N; s++){
                        // 지금 판단하려는게 무엇인지 봐야 한다.
                        if(arr[k][s] == i)
                            pi = s;
                        if(arr[k][s] == j)
                            pj = s;
                    }
                    if(pi>pj) cnt++;
                        
                    System.out.println(i+"("+pi+")가 "+j+"("+pj+") 보다 성적이좋은가?");
                }
                if(cnt == M) pCnt++;
            }
        }

        buff.append(pCnt);
    
        return buff.toString().trim();
    }

}