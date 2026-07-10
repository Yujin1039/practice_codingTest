import java.util.*;

class Solution {
    static boolean check(boolean[][][] struct){
        int len = struct.length;
                
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(struct[i][j][0]){ // 기둥
                    boolean isValid = false;
                    
                    if(i == 0) isValid = true;
                    if(j > 0 && struct[i][j-1][1]) isValid = true;
                    if(struct[i][j][1]) isValid = true;
                    if(i > 0 && struct[i-1][j][0]) isValid = true;
                    
                    if(!isValid) return false;
                    
                }
                // ⚠️ else if 아님
                if(struct[i][j][1]){ // 보
                    boolean isValid = false;
                    
                    if(i > 0 && struct[i-1][j][0]) isValid = true;
                    if(i > 0 && j+1 < len && struct[i-1][j+1][0]) isValid = true;
                    if(j > 0 && j+1 < len && struct[i][j-1][1] && struct[i][j+1][1]) isValid = true;
                    
                    if(!isValid) return false;

                }
            }
        }
        return true;    
    }
    
    public int[][] solution(int n, int[][] build_frame) {
        // 1. 설치
        // 기둥: 높이 0, 설치지점에 보 존재
        // 보: 연결될 보의 양 끝점이 기둥과 연결 or 올리는 보가 기둥과 연결
        
        // 2. 삭제
        // 기둥: 기둥 양 끝단과 연결된 보가 공중에 뜨면 X
        // 보: 2이상 길이의 보가 절단될때?
        
        // 일단 설치, 삭제해라. → 공중에 뜨는 기둥/보가 있는지 확인
        
        boolean[][][] structure = new boolean[n+1][n+1][2];
        for(int i=0; i<build_frame.length; i++){
            int[] cur = build_frame[i];
            int x = cur[0]; int y = cur[1]; 
            int a = cur[2]; int b = cur[3];
            
            if(b == 0){
                structure[y][x][a] = false;
            } else {
                structure[y][x][a] = true;
            }
            //System.out.println(Arrays.toString(cur)+" "+check(structure));
            if(!check(structure)){
                if(b == 0){
                    structure[y][x][a] = true;
                } else {
                    structure[y][x][a] = false;
                }
            }            
        }
        
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                if(structure[j][i][0]) list.add(new int[]{i,j,0});
                if(structure[j][i][1]) list.add(new int[]{i,j,1});
            }
        }
        
        return list.stream().toArray(int[][]::new);
    }
}