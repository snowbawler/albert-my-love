import java.util.*;
import java.io.*;

public class HighCardWins {
//commit
	public static void main(String[] args) throws IOException{
		
//		BufferedReader br = new BufferedReader(new FileReader("highcard.in"));
//		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		ArrayList<Integer> els = new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			els.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(els);
		ArrayList<Integer> bes = new ArrayList<Integer>();
		
		int x = 0;
		for(int i=1; i<=n*2; i++) {
			if(x==n)x--;
			if(els.get(x)==i)x++;
			else bes.add(i);
		}
		
		int sto = 0;
		while(!els.isEmpty()&&!bes.isEmpty()) {
			if(els.get(0)<bes.get(0)) {
				els.remove(0);
				bes.remove(0);
				sto++;
			}
			else bes.remove(0);			
		}
//		pw.print(els);
//		pw.print(bes);
		pw.print(sto);
		pw.close();
		
		

	}

}
