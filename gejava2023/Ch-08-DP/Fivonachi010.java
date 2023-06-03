public class Fivonachi010 {
    public static void main(String args[]) {
        int in = 8;
        System.out.println("input : "+in);
        int out = new Fivonachi010().solution(in);
        System.out.println("output : "+out);
    }

    int solution(int n){

        return fivonachi(n);
    }

    int fivonachi(int n){
        if(n <= 1) return n;
        return fivonachi(n-1) + fivonachi(n-2);
    }
}
