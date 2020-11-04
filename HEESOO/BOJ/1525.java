import java.io.*;
import java.util.*;

class Main {	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		Queue<String> q=new LinkedList<>();
		HashMap<String, Integer> map=new HashMap<>();
		
		for(int i=0;i<3;i++) {
			sb.append(br.readLine().replace(" ", ""));
		}
		
		if(sb.toString().equals("123456780"))
			System.out.println("0");
		else {
			map.put(sb.toString(), 0);
			q.offer(sb.toString());		
			System.out.println(bfs(q, map));			
		}
		
	}
	
	public static int bfs(Queue<String> q, HashMap<String, Integer> map) {
		int[] dotX= {0,1,0,-1};
		int[] dotY= {1,0,-1,0};
		
		while(!q.isEmpty()) {
			String str=q.poll();
			int zeroIdx=str.indexOf("0");
			int row=zeroIdx/3;
			int col=zeroIdx%3;
			
			for(int i=0;i<4;i++) {
				int xx=row+dotX[i];
				int yy=col+dotY[i];
				if(xx<0 || xx>=3 || yy<0 || yy>=3) continue;				
				int swapIdx=3*xx+yy;
				
				StringBuilder sb=new StringBuilder(str);
				char ch=sb.charAt(swapIdx);
				sb.setCharAt(swapIdx, '0');
				sb.setCharAt(zeroIdx, ch);
				
				if(sb.toString().equals("123456780")) 
					return map.get(str)+1;
				
				if(!map.containsKey(sb.toString())) {
					q.offer(sb.toString());
					map.put(sb.toString(), map.get(str)+1);
				}
			}
		}
		
		return -1;
	}
}


