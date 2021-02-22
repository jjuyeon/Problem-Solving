package BOJ;

import java.io.*;
import java.util.*;

public class BOJ2628 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        ArrayList<Integer> garo = new ArrayList<>();
        ArrayList<Integer> sero = new ArrayList<>();

        garo.add(0); sero.add(0);
        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            if(st.nextToken().equals("0")){
                garo.add(Integer.parseInt(st.nextToken()));
            }
            else{
                sero.add(Integer.parseInt(st.nextToken()));
            }
        }
        garo.add(m); sero.add(n);
        Collections.sort(garo); Collections.sort(sero);

        int ans = 0;
        for(int i=1, garoSize=garo.size(); i<garoSize; i++){
            int w = garo.get(i) - garo.get(i-1);
            for(int j=1, seroSize=sero.size(); j<seroSize; j++){
                int h = sero.get(j) - sero.get(j-1);
                ans = Math.max(ans, w*h);
            }
        }

        System.out.print(ans);
    }
}
