import java.io.*;
import java.util.*;

class Label{
    String name;
    int korean;
    int english;
    int math;

    public Label(String name,int k,int e,int m){
        this.name = name;
        this.english = e;
        this.korean = k;
        this.math = m;
    }
}

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Label[] scoreArr = new Label[n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            scoreArr[i] = new Label(name,korean,english,math);
        }

        Arrays.sort(scoreArr,Comparator.comparingInt((Label o)->o.korean).reversed()
                                       .thenComparingInt(o->o.english)
                                       .thenComparing(Comparator.comparingInt((Label o) -> o.math).reversed())
                                       .thenComparing(o->o.name));
        StringBuilder sb = new StringBuilder();
        for(Label la:scoreArr){
            sb.append(la.name).append("\n");
        }
        System.out.println(sb);
    }
}