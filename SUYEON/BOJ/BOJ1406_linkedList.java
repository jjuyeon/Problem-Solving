package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1406_linkedList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<String> list = new LinkedList<>(Arrays.asList(br.readLine().split("")));
        int m = Integer.parseInt(br.readLine());

        ListIterator<String> it = list.listIterator();
        while(it.hasNext()){
            //처음 커서는 문장의 맨 뒤에 있어야하기 때문에 커서를 맨뒤로 이동시켜줌 (ex. abc|)
            it.next();
        }

        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "L":
                    if(it.hasPrevious()){
                        it.previous();
                    }
                    break;
                case "D":
                    if(it.hasNext()){
                        it.next();
                    }
                    break;
                case "B":
                    if(it.hasPrevious()){
                        it.previous();
                        it.remove();
                    }
                    break;
                case "P":
                    it.add(st.nextToken());
            }
        }

        StringBuilder ans = new StringBuilder();
        for(String s : list){
            ans.append(s);
        }
        System.out.print(ans.toString());
    }
}
