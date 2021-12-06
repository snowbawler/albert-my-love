import java.io.*;
import java.util.*;

public class LivestockLineup {
	static void reverse(ArrayList<String> list) {
		ArrayList<String> sto = new ArrayList<String>();
		for(int i=list.size()-1; i>=0; i--) {
			sto.add(list.get(i));
		}
		list.clear();
		list.addAll(sto);
	}

	
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
			pairs.get(i).add(st.nextToken()); 
//System.out.print(pairs.get(i));
		}
		
//System.out.println();


		for(int i=0; i<pairs.size()-1; i++) {
			boolean pair = true;
			while(pair) {
				pair = false;
				for(int j=i+1; j<pairs.size(); j++) {
					
					String firstI = pairs.get(i).get(0);
					String lastI = pairs.get(i).get(pairs.get(i).size()-1);
					String firstJ = pairs.get(j).get(0);
					String lastJ = pairs.get(j).get(pairs.get(j).size()-1);
//System.out.println(pairs.get(i));
					if(firstI.equals(firstJ)) {
						pairs.get(j).remove(0);
						reverse(pairs.get(j));
						pairs.get(i).addAll(0, pairs.get(j)); 
						pairs.remove(j); 
						j--; 
						pair = true;
					}
					else if(firstI.equals(lastJ)) {
						pairs.get(j).remove(pairs.get(j).size()-1);
						pairs.get(i).addAll(0, pairs.get(j)); 
						pairs.remove(j); 
						j--; 
						pair = true;}
					else if(lastI.equals(firstJ)) {
						pairs.get(j).remove(0);
						pairs.get(i).addAll(pairs.get(j)); 
						pairs.remove(j); 
						j--; 
						pair = true;}
					else if(lastI.equals(lastJ)) {
						pairs.get(j).remove(pairs.get(j).remove(pairs.get(j).size()-1));
						reverse(pairs.get(j));
						pairs.get(i).addAll(pairs.get(j)); 
						pairs.remove(j); 
						j--; 
						pair = true;}
				}
			}
		}
		
		for(int i1=0; i1<pairs.size(); i1++) {
//System.out.print(pairs.get(i1));
		}
		
//System.out.println();
		
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
//System.out.print(pairs.get(i));
		}
//System.out.println();
		
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
		
//System.out.print(ret);
		
		for(int i=0; i<ret.size(); i++) {
			pw.println(ret.get(i));
		}
		
		pw.close();
		br.close();
	}
}