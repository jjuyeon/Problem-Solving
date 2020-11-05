import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		PriorityQueue<Integer> maxHeap=new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return i2-i1;
			}
		}); // 내림차순
		PriorityQueue<Integer> minHeap=new PriorityQueue<>((o1, o2)->o1-o2); // 오름차순
		
		for(int i=0;i<n;i++) {
			int num=sc.nextInt();
			if(i%2==0) maxHeap.offer(num);
			else minHeap.offer(num);
			
			if(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
				if(maxHeap.peek()>minHeap.peek()) {
					int maxRoot=maxHeap.poll();
					maxHeap.offer(minHeap.poll());
					minHeap.offer(maxRoot);
				}
			}
			
			System.out.println(maxHeap.peek());
		}
	}
	
}
