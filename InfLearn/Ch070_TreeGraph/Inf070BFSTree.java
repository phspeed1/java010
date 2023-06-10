import java.util.*;
import java.io.*;

public class Inf070BFSTree{

    public static void main(String[] args){
        String str = "";
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // try{
        //     str = br.readLine();
        // }catch(IOException ioe){
        //     ioe.printStackTrace();
        // }
    
        String rtn = new Inf070BFSTree().solution(str);
        System.out.println(rtn);
    }
    
    Node root;
    private String solution(String str){
        StringBuilder buff = new StringBuilder();
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        
        bfs(root, buff);

        return buff.toString();
    }

    void bfs(Node n, StringBuilder buff){
        Queue<Node> queue = new LinkedList<Node>();
   //     n.visited = true;
        queue.offer(n);

        while(!queue.isEmpty()){
            Node node = queue.poll();
            buff.append(node.val+" ");

            if(node.lt != null && !node.lt.visited){
            //    node.lt.visited = true;
                queue.offer(node.lt);
            }
            if(node.rt != null && !node.rt.visited){
          //      node.rt.visited = true;
                queue.offer(node.rt);
            }
        }
    }

    class Node implements Comparable<Node>{
        int val;
        Node lt;
        Node rt;
        boolean visited;
        Node(int val){
            this.val = val;
            lt = rt = null;
            visited = false;
        }
        public int compareTo(Node other){
            return this.val - other.val;
        }
    }

}