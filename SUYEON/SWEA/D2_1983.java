package SWEA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Member implements Comparable<Member>{
    int number;
    double score;

    Member(int n, double s){
        number = n;
        score = s;
    }

    @Override
    public int compareTo(Member m){
        if(this.score > m.score){
            return -1;
        }else if(this.score == m.score){
            return 0;
        }else{
            return 1;
        }
    }
}

public class D2_1983 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int count = sc.nextInt();
            int pick = sc.nextInt();

            ArrayList<Member> memberList = new ArrayList<>();
            for(int i=1; i<=count; i++){
                double score = sc.nextInt()*0.35 + sc.nextInt()*0.45 + sc.nextInt()*0.2;
                memberList.add(new Member(i, score));
            }
            Collections.sort(memberList);

            int pickRank = -1;
            for(int i=0; i<count; i++){
                if(memberList.get(i).number == pick) {
                    pickRank = i;
                    break;
                }
            }

            String[] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
            int divide = count / 10;

            if(pickRank == -1){
                return;
            }
            System.out.printf("#%d %s%n", test_case, grades[pickRank/divide]);
        }
    }
}
