import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    Node head;
    Node tail;
    Node cursor;
    int size;
    
    public CircularLinkedList(){
        this.head = null;
        this.tail = null;
    }                

    public void add(int data){
        Node newN = new Node(data);
        if(head == null){            
            head = newN;            
        } else{
            tail.next = newN;            
        }
        newN.next = head;
        tail = newN;
        cursor = tail;
        size++;
    }
    public Node next(){
        cursor = cursor.next;
        return cursor;
    }
    public Node getCursor(){
        return cursor;
    }
    public Node remove(Node preDel){
        Node del = preDel.next;
        preDel.next = preDel.next.next;
        size--;
        return del;
    }
    public boolean isEmpty(){
        return size == 0;
    }
}
public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        CircularLinkedList cl = new CircularLinkedList();
        for(int i=1;i<=n;i++){
            cl.add(i);
        }

        StringBuilder sb = new StringBuilder("<");
        while(!cl.isEmpty()){
            Node pre = cl.getCursor();
            for(int i=1;i<k;i++){
                pre = cl.next();
            }
            int m = cl.remove(pre).data;
            sb.append(m).append(", ");
        }
        sb.deleteCharAt(sb.length()-1).deleteCharAt(sb.length()-1).append(">");
        System.out.println(sb);
    }
}