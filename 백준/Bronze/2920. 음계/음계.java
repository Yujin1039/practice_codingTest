import java.util.*;
import java.io.*;

public class Main {    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String rendition = br.readLine();
        
        if(rendition.equals("1 2 3 4 5 6 7 8")) System.out.println("ascending");
        else if(rendition.equals("8 7 6 5 4 3 2 1")) System.out.println("descending");
        else System.out.println("mixed");
    }
}