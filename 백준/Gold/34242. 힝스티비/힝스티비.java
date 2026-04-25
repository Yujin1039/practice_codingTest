import java.util.*;
import java.io.*;

public class Main {   
    public static char getChar(int idx, int skip, String cmd, boolean isIncrease){        
        int finalIdx = idx;

        if (finalIdx == skip) {
            if (isIncrease) finalIdx++;
            else finalIdx--;               
        }
        if (finalIdx < 0 || finalIdx >= cmd.length()) return ' ';
        
        return cmd.charAt(finalIdx);
    }

    public static int calculatePoint(char prev, char next, String cmd){
        if(prev == '+' && next == '+'){
            return 1;
        } else if(prev == '-' && next == '-'){
            return -1;
        }
        return 0;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] left = new int[str.length()];
        int[] right = new int[str.length()];
        int prIdx = -1;
        for(int i=0; i<str.length(); i++){
            left[i] = prIdx;
            if(str.charAt(i) == '^'){
                prIdx = i;
            }             
        }

        prIdx = -1;
        for(int i=str.length()-1; i>=0; i--){
            right[i] = prIdx;
            if(str.charAt(i) == '^'){
                prIdx = i;
            }             
        }
        
        int score = 0;
        // 변경 없을 때 점수
        for(int i=1; i<str.length()-1; i++){
            if(str.charAt(i) == '^'){
                score += calculatePoint(str.charAt(i-1), str.charAt(i+1), str);
            }            
        }

        // 문자 1개 삭제시
        int maxScore = score;
        for(int i=0; i<str.length(); i++){  
            int curScore = score;

            if (str.charAt(i) == '^') {
                curScore -= calculatePoint(getChar(i-1,-1, str, false), getChar(i+1,-1, str, true), str);
            }
            
            int lf = left[i]; // 좌측 ^
            int rt = right[i]; // 우측 ^
            
            if(lf != -1) {
                char prev = getChar(lf-1,i,str, false);
                char next = getChar(lf+1,i,str, true);
                char ppv = getChar(lf-1,-1,str, false);
                char pnt = getChar(lf+1,-1,str, true);
                
                if(prev != ' ' && next != ' ') curScore += calculatePoint(prev, next, str);
                if(ppv != ' ' && pnt != ' ') curScore -= calculatePoint(ppv, pnt, str);
            }

            if(rt != -1 && rt != lf){
                char prev = getChar(rt-1,i,str, false);
                char next = getChar(rt+1,i,str, true);
                char ppv = getChar(rt-1,-1,str, false);
                char pnt = getChar(rt+1,-1,str, true);

                if(prev != ' ' && next != ' ') curScore += calculatePoint(prev, next, str);
                if(ppv != ' ' && pnt != ' ') curScore -= calculatePoint(ppv, pnt, str);
            }            
            maxScore = Math.max(maxScore, curScore);
        }
        System.out.println(maxScore);
    }
}