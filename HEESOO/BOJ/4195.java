import java.util.*;
import java.io.*;
/**
 * @author HEESOO
 *
 */
class Main {
	static int[] parent;
	static int[] cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 int t=Integer.parseInt(br.readLine());
		 for(int i=0;i<t;i++) {
			 int f=Integer.parseInt(br.readLine());
			 HashMap<String, Integer> map=new HashMap<>();
			 parent=new int[f*2]; // 부모 연결 배열
			 cnt=new int[f*2]; // 부모간의 거리 저장 배열
			 Arrays.fill(cnt, 1); 
			 
			 int idx=0;
			 for(int j=0;j<f;j++) {
				 String[] str=br.readLine().split(" ");
				 // 처음 들어온 이름이면 해시맵에 put
				 if(!map.containsKey(str[0])) {
					 parent[idx]=idx;
					 map.put(str[0], idx++);
				 }
				 if(!map.containsKey(str[1])) {
					 parent[idx]=idx;
					 map.put(str[1], idx++);
				 }
				 
				 // union으로 연결
				 union(map.get(str[0]), map.get(str[1]));
				 // find하며 저장된 cnt값을 출력
				 System.out.println(cnt[find(map.get(str[1]))]);
			 }
		 }
		 
	}
	

	 public static void union(int a, int b) {
		 // 최상위 부모 찾기
		 int parentA=find(a);
		 int parentB=find(b);
		 // 같다면 이미 연결되어 있는 노드
		 if(parentA==parentB) return; 
		 
		 parent[parentB]=parentA; // a밑에 b가 들어감
		 cnt[parentA]+=cnt[parentB]; // b가 추가됐으므로 cnt[a] 갱신
	 }
	 
	 public static int find(int a) {
		 if(parent[a]==a) return a; // 더 이상 부모가 없음
		 return parent[a]=find(parent[a]); // 부모로 이동
	 }
	 
}
