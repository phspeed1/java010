import java.util.*;

public class HanoiTower010 {
    public static void main(String[] args) {
        int diskCnnt = 3;
        int startPeg = 1;
        int endPeg = 3;
        new HanoiTower010().hanoi(diskCnnt, startPeg, endPeg);
    }

    void hanoi(int cnt, int startPeg, int endPeg){
        int otherPeg =0;
        Stack<Integer>[] arr = new Stack[4];

        for(int i=1; i<=3; i++){
            arr[i] = new Stack<Integer>();
            if(i != startPeg && i != endPeg) otherPeg = i;
        }
        for(int i=cnt; i >= 1; i--){
            arr[startPeg].push(i);
        }
        for(int i=1; i<=3; i++){
            System.out.println("Peg-"+i+" : "+ arr[i]);
        }
        hanoiSub(cnt, startPeg, endPeg, otherPeg, arr);

    }

    void hanoiSub(int N, int startPeg, int endPeg, int otherPeg, Stack<Integer>[] arr){
        if(N == 1) {
            moveDisk(N, startPeg, endPeg, arr);
            return;
        }

        hanoiSub(N-1, startPeg, otherPeg, endPeg, arr);
        moveDisk(N, startPeg, endPeg, arr);
        hanoiSub(N-1, otherPeg, endPeg, startPeg, arr);


    }

    void moveDisk(int disk, int startPeg, int endPeg, Stack<Integer>[] arr){
        System.out.println("disk-"+disk+" move from peg-"+startPeg+" => to peg-"+endPeg);
        arr[endPeg].push(arr[startPeg].pop());
        for(int i=1; i<=3; i++){
            System.out.println("Peg-"+i+" : "+ arr[i]);
        }
    }
}
