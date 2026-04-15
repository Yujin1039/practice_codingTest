import java.util.*;
import java.io.*;

public class Main {   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        int n = Integer.parseInt(br.readLine());

        int[] score = new int[n];
        for(int i=0;i<n;i++){
            score[i] = Integer.parseInt(br.readLine());
        }

        int[] decreaseFre = new int[n];
        for(int i=n-2;i>=0;i--){
            decreaseFre[i] = decreaseFre[i+1];
            
            if(score[i] < score[i+1]) continue;

            decreaseFre[i] += score[i] - score[i+1] + 1;
            score[i] = score[i+1] - 1;
        }
        System.out.println(decreaseFre[0]);
    }
}