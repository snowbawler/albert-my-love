import java.io.*;
import java.util.*;

public class LivestockLineup {
	
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(Sysetem.in));
//		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		BufferedReader  br = new  BufferedReader(new  FileReader ("lineup.in"));
		PrintWriter  pw = new  PrintWriter(new  BufferedWriter(new  FileWriter("lineup.out")));

		int N = br.read();
		System.out.print(N);
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		ArrayList<String> pair = new ArrayList<String>();
//		for(int i=0; i<N; i++) {
//			pair.add(st.nextToken());
//			pair.add(st.nextToken(" must be milked beside "));
//			st = new StringTokenizer(br.readLine());
//		}
//		
//		System.out.print(pair.toString());
		
		
		
		pw.close();
		br.close();
	}
}
