import java.io.*;
import java.util.*;

public class Main {  
    static int l,c;
    static String[] alphabet,tmp;
    static StringBuilder sb = new StringBuilder();

    static void getPassword(int a,int t){
        if(t == l){
            int con = 0; int vowel = 0;
            StringBuilder sub = new StringBuilder();
            for(String str:tmp){
                char ch = str.charAt(0);
                if(ch == 97 || ch == 101 || ch == 105 || ch == 111 || ch == 117) vowel++;
                else con++;
                sub.append(str);
            }
            if(con >= 2 && vowel >= 1){                
                sb.append(sub).append("\n");
            }
            return;
        }
        for(int i=a;i<c;i++){
            tmp[t] = alphabet[i];
            getPassword(i+1,t+1);
        }
    }
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        tmp = new String[l];
        alphabet = new String[c];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<c;i++){
            alphabet[i] = st.nextToken();
        }
        Arrays.sort(alphabet);
        getPassword(0,0);
        System.out.println(sb);
	}
}