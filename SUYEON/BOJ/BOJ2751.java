import java.util.*;
import java.io.*;

public class BOJ2751 {
    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());

        for(int i=0; i<n; i++){
            answer.add(stoi(br.readLine()));
        }

        sort(true); // 오름차순

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++)
            sb.append(answer.get(i)).append("\n");

        System.out.print(sb.toString());
    }

    static void sort(boolean isAscending){
        if(isAscending){ // 오름차순
            Collections.sort(answer);
        }else{ // 내림차순
            Collections.sort(answer, Comparator.reverseOrder());
        }
    }
    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
