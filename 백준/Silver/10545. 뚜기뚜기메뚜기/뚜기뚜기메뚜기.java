import java.util.*;
import java.io.*;

public class Main {
    static Map<Integer, char[]> dial;
    public static void main(String[] args) throws IOException {
        dial = new HashMap<>();
        dial.put(1, new char[]{});
        dial.put(2, new char[]{'a','b','c'});
        dial.put(3, new char[]{'d','e','f'});
        dial.put(4, new char[]{'g','h','i'});
        dial.put(5, new char[]{'j','k','l'});
        dial.put(6, new char[]{'m','n','o'});
        dial.put(7, new char[]{'p','q','r','s'});
        dial.put(8, new char[]{'t','u','v'});
        dial.put(9, new char[]{'w','x','y','z'});
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] chDial = new int[26];
        for(int i=1; i<=9; i++){            
            int num = Integer.parseInt(st.nextToken());
            char[] alphabet = dial.get(num);
            for(char a:alphabet){
                chDial[a-97] = i;
            }
        }

        String sentence = br.readLine();
        StringBuilder sb = new StringBuilder();
        int prev = 0;
        for(int i=0; i<sentence.length(); i++){
            char c = sentence.charAt(i);
            int first = chDial[c-97];
            if(first == prev) sb.append("#");
            sb.append(first);
            for(int j = c-98; j>=0; j--) {
                if(chDial[j] == first){
                    sb.append(first);
                } else {
                    break;
                }
            }
            prev = first;
        }
        System.out.println(sb.toString());
    }
}