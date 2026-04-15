import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine().toUpperCase();
        char[] strChar = str.toCharArray();
        List<Character> list = new ArrayList<>();
        for(char i:strChar){
            list.add(i);
        }
        Map<Character,Integer> freq = new HashMap<>();
        for(int i=0;i<26;i++){
            freq.put((char)('A'+i),Collections.frequency(list,(char)('A'+i)));
        }
        int max = 0;
        String answer = "?";
        for(Character key:freq.keySet()){
            if(freq.get(key) > max){
                max = freq.get(key);
                answer = key.toString();
            }else if(freq.get(key) == max){
                answer = "?";
            }
        }
        bw.write(answer);
        bw.flush();
    }
}