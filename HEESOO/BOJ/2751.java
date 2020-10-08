import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> num=new ArrayList<>();
		
		int n=Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++){
			num.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(num);
		
		for(int j=0;j<n;j++){
			bw.write(num.get(j)+"\n");
		}
		bw.flush();
		bw.close();
	}
}
