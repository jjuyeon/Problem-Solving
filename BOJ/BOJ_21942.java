package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_21942 {

    static class Info {
        String component, nickname;

        Info(String component, String nickname) {
            this.component = component;
            this.nickname = nickname;
        }

        @Override
        public int hashCode() {
            return component.hashCode() + nickname.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if(o instanceof Info) {
                Info i = (Info) o;
                return this.component.equals(i.component) && this.nickname.equals(i.nickname);
            }
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long L = convertInputToDate(st.nextToken());
        int F = Integer.parseInt(st.nextToken());

        Map<Info, Long> map = new HashMap<>();
        Map<String, Long> cost = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String date = st.nextToken();
            String time = st.nextToken();
            long dateTime = convertStringToDate(date, time);
            Info info = new Info(st.nextToken(), st.nextToken());

            if (map.containsKey(info)) {
                long startTime = map.get(info);
                long diffMin = dateTime - startTime - L;
                if (diffMin > 0) {
                    cost.computeIfPresent(info.nickname, (k, v) -> v + diffMin);
                    cost.putIfAbsent(info.nickname, diffMin);
                }
                map.remove(info);
            } else {
                map.put(info, dateTime);
            }
        }

        if (cost.isEmpty()) {
            System.out.println(-1);
        } else {
            for (String key : cost.keySet()) {
                System.out.println(key + " " + cost.get(key) * F);
            }
        }
    }

    private static long convertInputToDate(String date) {
        long result = 0;
        String[] days = date.split("/");
        String[] times = days[1].split(":");

        result += Integer.parseInt(days[0]) * 24 * 60L;
        result += Integer.parseInt(times[0]) * 60L + Integer.parseInt(times[1]);

        return result;
    }

    static int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static long convertStringToDate(String date, String time) {
        String[] days = date.split("-");
        String[] times = time.split(":");

        int month = Integer.parseInt(days[1]);
        int day = Integer.parseInt(days[2]);
        int hour = Integer.parseInt(times[0]);
        int min = Integer.parseInt(times[1]);

        long result = 0;
        for (int i = 1; i < month; i++) {
            result += months[i] * 24 * 60L;
        }
        result += day * 24 * 60L;
        result += hour * 60L + min;

        return result;
    }
}