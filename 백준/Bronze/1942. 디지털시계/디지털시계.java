import java.util.*;
import java.io.*;

public class Main {   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String start = st.nextToken();
            String end = st.nextToken();
            int multiple = 0;

            st = new StringTokenizer(start,":");
            int[] sT = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            st = new StringTokenizer(end,":");
            int[] eT = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            
            while (sT[0] != eT[0] || sT[1] != eT[1] || sT[2] != eT[2]) {
                int num = Integer.parseInt(sT[0]+""+sT[1]+sT[2]);
                if(num % 3 == 0) multiple++;

                int tmpM = sT[1]; int tmpS = sT[2];
                sT[2] = (sT[2]+1)%60;
                sT[1] = (sT[2] == 0) ? (sT[1]+1)%60:sT[1];
                sT[0] = (tmpM == 59 && tmpS == 59) ? (sT[0]+1)%24:sT[0];
            }
            int num = Integer.parseInt(eT[0]+eT[1]+eT[2]+"");
            if(num % 3 == 0) multiple++;

            sb.append(multiple+"\n");
        }
        System.out.println(sb.toString());

        
    }
}