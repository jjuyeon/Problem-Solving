import java.util.*;
import java.io.*;

public class BOJ2331 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        int p = stoi(st.nextToken());

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(stoi(a));
        while(true){
            int checkNum = arrayList.get(arrayList.size()-1);
            int result = 0;

            while(checkNum != 0){
                result += Math.pow(checkNum % 10, p);
                checkNum /= 10;
            }
            if(arrayList.contains(result)){
                System.out.print(arrayList.indexOf(result));
                return;
            }

            arrayList.add(result);
        }
    }

    static int stoi(String s){
        return Integer.parseInt(s);
    }
}
