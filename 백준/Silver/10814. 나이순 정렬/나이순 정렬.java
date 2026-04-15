import java.io.*;
import java.util.*;

class Info{
    int age;
    String name;

    public Info(int age,String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString(){
        return age+" "+name;
    }
}

public class Main { 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringBuilder sb = new StringBuilder();
          
        int a = Integer.parseInt(br.readLine());
        Info[] arr = new Info[a];
        for(int i=0;i<a;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            arr[i] = new Info(age,name);
        }

        Arrays.sort(arr,(o1,o2) -> o1.age - o2.age);
        
        for(Info d:arr){
            sb.append(d.toString()+"\n");
        }
        System.out.println(sb.toString());
	}    
}