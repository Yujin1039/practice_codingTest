import java.io.*;
import java.util.*;

public class Main { 
    static int[][] rotate(int[][] arr,int h,int w){
        int[][] newArr = new int[w][h];

        for(int i=0;i<w;i++){
            for(int j=0;j<h;j++){
                newArr[i][j] = arr[h-1-j][i];
            }
        }
        return newArr;
    } 

    static boolean putStickers(int[][] sticker, boolean[][] computer, int cnt){
        int ch = computer.length; int cl = computer[0].length;
        int sh = sticker.length; int sl = sticker[0].length;

        LinkedList<int[]> list = new LinkedList<>();
        for(int i=0;i<=ch-sh;i++){
            for(int j=0;j<=cl-sl;j++){
                next:
                for(int k=0;k<sh;k++){
                    for(int l=0;l<sl;l++){
                        if(sticker[k][l] == 1){
                            if(computer[i+k][j+l]){
                                list.clear();
                                break next;
                            } 
                            list.add(new int[]{i+k,j+l});                            
                        }
                    }
                }
                if(!list.isEmpty()){
                    while(!list.isEmpty()){
                        int[] coo = list.poll();
                        computer[coo[0]][coo[1]] = true;
                    }
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 노트북 세로
        int m = Integer.parseInt(st.nextToken()); // 노트북 가로
        int k = Integer.parseInt(st.nextToken()); // 스티커 수

        ArrayList<int[][]> stickers = new ArrayList<>();
        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken()); // 스티커 세로
            int w = Integer.parseInt(st.nextToken()); // 스티커 가로
            int[][] sticker = new int[h][w];
            
            for(int j=0;j<h;j++){
                st = new StringTokenizer(br.readLine());
                for(int l=0;l<w;l++){
                    sticker[j][l] = Integer.parseInt(st.nextToken());
                }
            }
            stickers.add(sticker);
        }

        boolean[][] computer = new boolean[n][m];
        for(int i=0;i<k;i++){
            int[][] sticker = stickers.get(i);
            int cnt = 0;
            while(!putStickers(sticker,computer,cnt++) && cnt < 4){
                sticker = rotate(sticker,sticker.length,sticker[0].length);
            }
        }

        int square = 0;
        for(boolean[] com:computer){
            for(boolean c:com){
                if(c) square++;
            }
        }
        System.out.println(square);
	}
}