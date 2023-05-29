import java.util.*;

public class HanoiTower040{

    public static void main(String[] args){
        int countRing = 5;
        int start = 1;
        int end = 3;
        String str = "str";
        System.out.println("input : "+str);
    
        new HanoiTower040().solution(countRing, start, end);
        System.out.println("output : "+str);
    }
    
    void solution(int N, int start, int end){
        List<Stack<Integer>> stacks = new ArrayList<>();
        stacks.add(null);

        int other = 0;
        for(int i=1; i<=3; i++){
            if(i != start && i != end) other = i;
            Stack<Integer> stack = new Stack<Integer>();
            if(i==start){
                for(int j=N; j>0; j--) stack.push(j);
            }
            stacks.add(stack);
        }

        System.out.println("stacks"+stacks);
        hanoiSub(N, start, end, other, stacks);
        System.out.println("stacks"+stacks);
    }

    void hanoiSub(int N, int start, int end, int other, List<Stack<Integer>> stacks){
        if(N == 0) return;
        hanoiSub(N-1, start, other, end, stacks);
        movePeg(N, start, end, stacks);
        hanoiSub(N-1, other, end, start, stacks);
    }

    void movePeg(int n, int start, int end, List<Stack<Integer>> stacks){
        int ring = stacks.get(start).pop();
        System.out.println("movePeg("+n+") from-"+start+" to-"+end+"<"+ring+">");
        
        stacks.get(end).push(ring);
        for(int i=1; i<stacks.size(); i++){
            System.out.println("stacks["+i+"]"+stacks.get(i));
        }
    }

}