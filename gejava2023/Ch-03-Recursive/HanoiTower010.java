import java.util.*;

public class HanoiTower010 {
    public static void main(String[] args) {
        int diskCnt = 4;
        int startPeg = 1;
        int endPeg = 3;
        new HanoiTower010().solution(diskCnt, startPeg, endPeg);
    }

    Stack<Integer>[] pegs;

    void solution(int diskCnt, int startPeg, int endPeg){
        pegs = new Stack[endPeg+1];
        for(int i=0; i<endPeg+1; i++){
            pegs[i] = new Stack<Integer>();
        }
        for(int i=diskCnt; i>0; i--){
            pegs[startPeg].push(i);
        }
        for(int i=1; i<=3; i++){
            System.out.println("pegs["+i+"] : "+pegs[i]);
        }

        hanoiSub(diskCnt, startPeg, endPeg, 2);
    }

    void hanoiSub(int diskCnt, int startPeg, int endPeg, int otherPeg){
        // 만약 diskCnt 1 이면 s -> e 로 move 하고 종료
        if(diskCnt == 1) {
            movePeg(diskCnt, startPeg, endPeg);
            return;
        }
        // diskCnt -1 만큼을 otherPeg 으로 move 한다.
        // diskCnt 를 endPeg 으로 move 한다.

        hanoiSub(diskCnt -1, startPeg, otherPeg, endPeg);
        movePeg(diskCnt, startPeg, endPeg);
        hanoiSub(diskCnt -1, otherPeg, endPeg, startPeg);
    }

    void movePeg(int disk, int startPeg, int endPeg){
        System.out.println("disk : "+disk + " move from peg["+startPeg+"] to pegs["+endPeg+"]");
        pegs[endPeg].push(pegs[startPeg].pop());
        for(int i=1; i<=3; i++){
            System.out.println("pegs["+i+"] : "+pegs[i]);
        }
    }




}
