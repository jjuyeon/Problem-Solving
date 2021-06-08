import java.io.*;

public class BOJ1992 {
    static String[][] tree;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new String[n][n];
        for(int i=0; i<n; i++){ // 쿼드트리 완성
            tree[i] = (br.readLine()).split("");
        }
        compression(0,0,n);
    }

    static boolean isAllSame(int row, int col, int size){
        String s = tree[row][col];
        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                if(!tree[i][j].equals(s))
                    return false;
            }
        }
        return true;
    }

    static void compression(int row, int col, int size){
        if(isAllSame(row,col,size)){
            System.out.print(tree[row][col]);
        }
        else{ // 4개의 파트에 대한 계산
            System.out.print("("); // 쪼개질 때만 괄호 필요
            int updateSize = size / 2;
            compression(row,col,updateSize); // 왼쪽 위
            compression(row,col+updateSize,updateSize); // 오른쪽 위
            compression(row+updateSize,col,updateSize); // 왼쪽 아래
            compression(row+updateSize, col+updateSize, updateSize); // 오른쪽 아래
            System.out.print(")");
        }
    }
}
