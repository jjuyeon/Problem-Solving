import java.util.*;

class Node implements Comparable<Node> {
    String str;
    int cost;
    
    public Node(String str, int cost){
        this.str = str;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Node n){
        return this.cost - n.cost;
    }
}

class Solution {
    /*
    Level 1 : 문자열 내 마음대로 정렬하기
    */
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings); // 오름차순
        
        ArrayList<Node> list = new ArrayList<>();
        for(int i=0; i<strings.length; i++){
            int num = strings[i].charAt(n) - 'a';
            list.add(new Node(strings[i], num));
        }
        
        Collections.sort(list); // 오름차순
        
        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i).str;
        
        return answer;
    }
    
    // 다른 사람 코드(발상의 전환!)
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            arr.add("" + strings[i].charAt(n) + strings[i]);
        }
        Collections.sort(arr);
        answer = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i).substring(1, arr.get(i).length());
        }
        return answer;
    }
}