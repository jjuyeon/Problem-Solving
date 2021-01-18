package SWEA;

import java.util.*;

public class D1_2056 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=Integer.parseInt(sc.nextLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String days = sc.nextLine();
            String year = days.substring(0,4);
            String month = days.substring(4,6);
            String day = days.substring(6);

            boolean isRight = false;
            // check month - day
            List<String> days31 = Arrays.asList("01","03","05","07","08","10","12");
            List<String> days30 = Arrays.asList("04","06","09","11");
            if(days31.contains(month)){
                isRight = match_month_and_days(Integer.parseInt(day), 31);
            }else if(month.equals("02")){ // days28
                isRight = match_month_and_days(Integer.parseInt(day), 28);
            }else if(days30.contains(month)){ // days30
                isRight = match_month_and_days(Integer.parseInt(day), 30);
            }

            if(isRight){
                String answer = year+"/"+month+"/"+day;
                System.out.println("#"+test_case+" "+answer);
            }else{
                System.out.println("#"+test_case+" -1");
            }
        }
    }

    static boolean match_month_and_days(int days, int endDay){
        return days <= endDay;
    }
}
