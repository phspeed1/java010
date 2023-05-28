import java.util.*;

public class HanoiTower030 {
    public static void main(String[] args) {
        int diskCnt = 3;
        int startPeg = 1;
        int endPeg = 3;
        new HanoiTower030().hanoi(diskCnt, startPeg, endPeg);
    }

    void hanoi(int diskCnt, int startPeg, int endPeg){
        hanoiSub(diskCnt, startPeg, endPeg, 2);
    }

    void hanoiSub(int N, int startPeg, int endPeg, int otherPeg){
        if(N == 1){
            movePeg(N, startPeg, endPeg);
            return;
        }
// 하노이 탑
        hanoiSub(N-1, startPeg, otherPeg, endPeg);
        movePeg(N, startPeg, endPeg);
        hanoiSub(N-1, otherPeg, endPeg, startPeg);

    }

    void movePeg(int peg, int startPeg, int endPeg){
        System.out.println("movePeg "+peg + " from : "+startPeg+", to : "+endPeg);
    }

}
