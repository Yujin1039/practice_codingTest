import java.util.*;
import java.io.*;

public class Main {       
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str1 = br.readLine();
        String str2 = br.readLine();

        // 두 단어의 첫 글자와 마지막 글자 동일 여부
        if(str1.charAt(0) != str2.charAt(0) || str1.charAt(n-1) != str2.charAt(n-1)){
            System.out.println("NO");
        } else {
            int[] aeiou1 = new int[5];
            int[] aeiou2 = new int[5];
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            List<Character> vowel = new ArrayList<>();
            vowel.add('a');
            vowel.add('e');
            vowel.add('i');
            vowel.add('o');
            vowel.add('u');
            for (int i=0; i<n; i++) {
                char c = str1.charAt(i);
                if(vowel.contains(c)){
                    aeiou1[vowel.indexOf(c)]++;
                } else {
                    sb1.append(c);
                }

                char c2 = str2.charAt(i);
                if(vowel.contains(c2)){
                    aeiou2[vowel.indexOf(c2)]++;
                } else {
                    sb2.append(c2);
                }
            }

            if(aeiou1[0] != aeiou2[0] || aeiou1[1] != aeiou2[1] || aeiou1[2] != aeiou2[2] 
               || aeiou1[3] != aeiou2[3] || aeiou1[4] != aeiou2[4]){
                System.out.println("NO");
            } else {
                System.out.println(sb1.toString().equals(sb2.toString()) ? "YES":"NO");
            } 
        }
    }
}