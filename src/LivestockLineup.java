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
			pairs.get(i).add(st.nextToken()); System.out.println(pairs.get(i));
		}
		
System.out.println();
		
		int sto = 0;
		int sto1 = 0;
		for(int i=0; i<pairs.size(); i++) {
			for(int j=1; i<pairs.size(); i++) {
				if(pairs.get(i).contains(pairs.get(j).get(0))) {sto = 0; sto1 = 1;}
				else if(pairs.get(i).contains(pairs.get(j).get(1))) {sto = 1; sto1 = 0;}
				else break;
				if(pairs.get(i).get(0).equals(pairs.get(j).get(sto1))) pairs.get(i).add(0, pairs.get(j).get(sto));
				else pairs.get(i).add(pairs.get(j).get(sto1));
				pairs.remove(j);
				j--;
			}
		}
		
		for(int i=0; i<pairs.size(); i++) {
			System.out.print(pairs.get(i));
		}
		
System.out.println();
		
		ArrayList<String> store = new ArrayList<>();
		for(int i=0; i<pairs.size(); i++) {
			if(pairs.get(i).get(0).compareTo(pairs.get(i).get(pairs.get(i).size()-1))>0) {
				for(int j = pairs.get(i).size()-1; j>=0; j--) {
					store.add(pairs.get(i).get(j));
				}
				pairs.get(i).clear();
				pairs.get(i).addAll(store);
			}
			store.clear();
		}
		
		for(int i=0; i<pairs.size(); i++) {
			System.out.print(pairs.get(i));
		}
System.out.println();
		
		ArrayList<String> ret = new ArrayList<>();
		boolean contain = false;
		
		for(int i=0; i<s.length; i++) { 
			if(!ret.contains(s[i])) {
				for(int j=0; j<pairs.size(); j++) {
					if(pairs.get(j).get(0).equals(s[i])) {
							ret.addAll(pairs.get(j));
					}
					if(pairs.get(j).contains(s[i])) contain = true;
				}
				if(!contain) {
					ret.add(s[i]);	
				}
				contain = false;
			}
		}
		
		System.out.print(ret);
		
		for(int i=0; i<ret.size(); i++) {
			pw.println(ret.get(i));
		}
		
		pw.close();
		br.close();
	}
}