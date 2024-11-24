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
        
        LinkedList<Label> scoreArr = new LinkedList<>();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            scoreArr.add(new Label(name,korean,english,math));
        }

        Collections.sort(scoreArr,(o1,o2)->{
            if(o1.korean == o2.korean){
                if(o1.english == o2.english){
                    if(o1.math == o2.math){
                        return o1.name.compareTo(o2.name);
                    }
                    return o2.math - o1.math;
                }
                return o1.english - o2.english;
            }
            return o2.korean - o1.korean;
        });
        StringBuilder sb = new StringBuilder();
        for(Label la:scoreArr){
            sb.append(la.name).append("\n");
        }
        System.out.println(sb);
    }
}