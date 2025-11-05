import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        /*
         * [스택 구현] - 배열로 구현하기
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int stackSize = Integer.parseInt(br.readLine());
        CustomStack stack = new CustomStack(stackSize);
        
        for(int i=0; i<stackSize; i++){
            String command = br.readLine();
            String[] sepCommand = command.split(" ");
            sb.append(stack.run(sepCommand));
        }

        System.out.println(sb.toString());
    }
}

class CustomStack {
    private int[] stack;
    private int index;

    // 배열 생성
    public CustomStack(int n){
        this.stack = new int[n];
        this.index = 0;
    }

    // 메서드 실행
    public String run(String[] sepCommand){
        String command = sepCommand[0];
        String result = "";
        
        if(command.equals("push")){
            push(Integer.parseInt(sepCommand[1]));
        } else if(command.equals("pop")){
            result = pop() + "\n";
        } else if(command.equals("size")){
            result = size() + "\n";
        } else if(command.equals("empty")){
            result = empty() + "\n";
        } else if(command.equals("top")){
            result = top() + "\n";
        } 

        return result;
    }
    
    // 스택에 넣는 연산
    private void push(int x){
        stack[index] = x;
        index++;
    }

    // 스택에서 빼는 연산
    private int pop(){
        if(index == 0) return -1;
        return stack[--index];
    }

    // 스택의 크기
    private int size(){
        return index;
    }

    // 스택 내 데이터 존재 여부
    private int empty(){
        return index == 0 ? 1:0;
    }

    // 스택의 가장 위의 정수
    private int top(){
        if(index == 0) return -1;
        return stack[index-1];
    }
}