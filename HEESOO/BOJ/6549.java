import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st=new StringTokenizer(br.readLine());			
			
			int n=Integer.parseInt(st.nextToken());
			if(n==0) break;
			
			int[] height=new int[n];
			Stack<Integer> stack=new Stack<>();
			long max=0;
			for(int i=0;i<n;i++) { // 높이 저장
				height[i]=Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<n;i++) { // i 포함 왼쪽으로 만들수 있는 넓이 체크함
				// 왼쪽에 나보다 큰 높이 발견->걔 포함해서 넓이 만들 수 있음
				while(!stack.isEmpty() && height[stack.peek()]>height[i]) {
					int idx=stack.pop();
					// 맨 왼쪽에서 i까지이면 width=i, 부분 구간이면 ~.
					int width= stack.isEmpty()? i: i-stack.peek()-1;
					max=Math.max(max, (long)width*height[idx]);
				}
				stack.push(i);
			}
			
			// 남은 값들도 계산
			while(!stack.isEmpty()) {
				int idx=stack.pop();
				int width= stack.isEmpty()? n: n-stack.peek()-1;
				max=Math.max(max, (long)width*height[idx]);
			}
			
			System.out.println(max);
		}
	}
	
}
