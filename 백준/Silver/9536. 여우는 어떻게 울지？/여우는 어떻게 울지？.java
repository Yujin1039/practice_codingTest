import java.util.*;
import java.io.*;

public class Main {        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<T; i++) {
            String[] record = br.readLine().split(" ");
            Set<String> sound = new HashSet<>();

            String animal = br.readLine();
            while (!animal.equals("what does the fox say?")) {
                String[] word = animal.split(" ");
                sound.add(word[2]);
                animal = br.readLine();
            }

            for (String say: record) {
                if(!sound.contains(say)) sb.append(say+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}