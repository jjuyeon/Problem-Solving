package SWEA;

/**
 * 5658. [모의 SW 역량테스트] 보물상자 비밀번호
 * 깨달은 점: 16진수 -> 10진수로 바꾸는 함수가 있었다!
 *          Integer.parseInt(String str, 16);
 */

import java.util.*;

public class SW_5658 {
    static ArrayList<Integer> answerList;
    static String[] hexArr;

    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case ++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            String str = sc.next();

            answerList = new ArrayList<>();
            hexArr = str.split("");
            hexToint(N, N/4);
            answerList.sort(Collections.reverseOrder()); // 내림차순
            sb.append("#").append(test_case).append(" ").append(answerList.get(K-1)).append("\n");
        }

        System.out.print(sb.toString());
    }

    static void hexToint (int length, int stepSize){
        while(true){
            int addCount = 0;

            for(int i=0; i<length; i+=stepSize){
                StringBuilder s = new StringBuilder();
                for(int j=i; j<i+stepSize; j++){
                    s.append(hexArr[j]);
                }

                int val = Integer.parseInt(s.toString(), 16); // 16진수->10진수로 변경
                if(answerList.contains(val)){
                    addCount++;
                }else{
                    answerList.add(val);
                }
            }

            if(addCount == 4) // 종료조건(사각형 4개 면이 모두 이전에 나온 숫자와 같은 숫자)
                break;

            rotation(); // 안나오면 한칸씩 회전
        }
    }

    static void rotation() {
        int length = hexArr.length;
        String lastStr = hexArr[length-1];
        System.arraycopy(hexArr,0,hexArr,1,length-1);
        hexArr[0] = lastStr;
    }
}
