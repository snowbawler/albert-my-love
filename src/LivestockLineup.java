import java.io.*;
import java.util.*;

public class LivestockLineup {
	
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(Sysetem.in));
//		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		BufferedReader  br = new  BufferedReader(new  FileReader ("lineup.in"));
		PrintWriter  pw = new  PrintWriter(new  BufferedWriter(new  FileWriter("lineup.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<ArrayList<String>> pairs = new ArrayList<ArrayList<String>>();
		
		String[] s = {"Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue"};
		
		int N = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			pairs.add(new ArrayList<String>());
			pairs.get(i).add(st.nextToken());
			for(int j=0; j<4; j++) {
				st.nextToken();
			}
			pairs.get(i).add(st.nextToken()); System.out.print(pairs.get(i));
		}
		
		for(int i=0; i<N; i++) {	
			for(int j=0; j<2; j++) {
				
			}
		}
		
		
		pw.close();
		br.close();
	}
}
