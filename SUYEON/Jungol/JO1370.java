package Jungol;

import java.io.*;
import java.util.*;

public class JO1370 {

    static class MeetingRoom implements Comparable<MeetingRoom>{
        int no, start, end;
        MeetingRoom(int no, int start, int end){
            this.no = no;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(MeetingRoom o){
            if(this.end == o.end){
                return this.start-o.start;
            }
            return this.end-o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        MeetingRoom[] rooms = new MeetingRoom[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            rooms[i] = new MeetingRoom(stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()));
        }
        Arrays.sort(rooms);

        List<MeetingRoom> ans = getMeetingSchedule(rooms);
        sb.append(ans.size()).append("\n");
        for(int i=0; i<ans.size(); i++)
            sb.append(ans.get(i).no).append(" ");

        System.out.print(sb.toString());
    }

    private static List<MeetingRoom> getMeetingSchedule(MeetingRoom[] arr){
        ArrayList<MeetingRoom> schedules = new ArrayList<>();
        schedules.add(arr[0]);

        for(int i=1, size=arr.length; i<size; i++){
            if(schedules.get(schedules.size()-1).end <= arr[i].start){
                schedules.add(arr[i]);
            }
        }

        return schedules;
    }
    private static int stoi(String str){
        return Integer.parseInt(str);
    }
}
