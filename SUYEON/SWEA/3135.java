 import java.util.Map;
 import java.util.HashMap;
// import java.util.Set;

class Node { // 해쉬맵 사용해서 노드 구현
    Map<Character, Node> childNodes = new HashMap<>();
    int count = 0;
}

public class UserSolution {
	Node trieNode = new Node();
    
	public void init() { //각 테스트케이스 시작마다 호출되는 함수	
        this.trieNode.childNodes.clear(); // HashMap에 저장된 모든 객체 제거
	}
	
	public void insert(int buffer_size, String buf) { //추가하는 새로운 단어의 길이(= buffer_size)와 문자열 정보(= buf)가 인자로 주어지는 함수
		Node thisNode = this.trieNode;
		for(int i=0; i<buffer_size; i++) {
			thisNode=thisNode.childNodes.computeIfAbsent(buf.charAt(i), value->new Node());
            thisNode.count++;
		}
        /*
        System.out.println("________For test________"); // key와 count value 값 확인 용도
        Set<Map.Entry<Character, Node>> entries = trieNode.childNodes.entrySet();
        for(Map.Entry<Character, Node> entry : entries){
        	System.out.print("key: "+entry.getKey());
            System.out.println(", value(count): "+entry.getValue().count);
        }
        */
    }
	
	public int query(int buffer_size, String buf) { //buffer_size 길이의 buf 문자열이 주어졌을 때에, 현재의 단어들 중 buf로 시작하는 단어의 갯수를 반환하는 함수
		Node thisNode = this.trieNode;
		for(int i=0; i<buffer_size; i++) {
			Node node = thisNode.childNodes.get(buf.charAt(i));
            if (node == null) return 0; // 해당 단어가 없으면 갯수=0
            thisNode = node;
		}
		return thisNode.count;
	}
}
