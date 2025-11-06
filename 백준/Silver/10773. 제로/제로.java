import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());
        int[] stack = new int[size];
        int index = 0;

        for(int i=0; i<size; i++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                stack[--index] = 0;
            } else{
                stack[index++] = num;
            }
        }
        System.out.println(Arrays.stream(stack).sum());
    }
}