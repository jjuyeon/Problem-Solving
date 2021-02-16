package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1931 {

    static class MeetingRoom {
        int start, end;
        MeetingRoom(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        MeetingRoom[] arr = new MeetingRoom[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new MeetingRoom(stoi(st.nextToken()), stoi(st.nextToken()));
        }
        Arrays.sort(arr, (o1, o2) -> {
            if(o1.end == o2.end){
                return o1.start-o2.start;
            }
            return o1.end-o2.end;
        });

        System.out.print(getMeetingCnt(arr));
    }

    private static int getMeetingCnt(MeetingRoom[] arr){
        int count = 1, end = arr[0].end;
        for(int i=1, size=arr.length; i<size; i++){
            if(end<=arr[i].start){
                end = arr[i].end;
                count++;
            }
        }
        return count;
    }

    private static int stoi(String str){
        return Integer.parseInt(str);
    }
}
