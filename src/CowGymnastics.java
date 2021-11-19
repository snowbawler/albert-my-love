
import java.util.*;
import java.io.*;
public class CowGymnastics {
	public static void main(String[] args) throws IOException {
	    //BufferedReader br = new BufferedReader(new FileReader("whereami.in"));
	    Scanner sc = new Scanner(new File("gymnastics.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
		
		int k = sc.nextInt();
		int n = sc.nextInt();
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		boolean high = false;
		boolean high1 = false;
		int out = 0;
		int out1 = 0;
		
		for(int i=0; i<k; i++) {
			list.add(new ArrayList<Integer>());
			for(int j=0; j<n; j++) {
				list.get(i).add(sc.nextInt());  //System.out.print(list.get(i).get(j));
			}
			//System.out.println();
		}
		for(int h=1; h<=n; h++) {	
			for(int i=h+1; i<=n; i++) {
				for(int j=0; j<k-1; j++) {
						if(list.get(j).indexOf(h) < list.get(j).indexOf(i)) high = true; 
						else high = false; //System.out.print(h);
						if(list.get(j+1).indexOf(h) < list.get(j+1).indexOf(i)) high1 = true; 
						else high1 = false; //System.out.println(i);
						//System.out.print(high); System.out.println(high1);
						if(high == high1) { out++;} //System.out.println(out); 
				}
				if(out==k-1) out1++;out=0;
			}
		}
		
		pw.print(out1);
	
		sc.close();
		pw.close();
	}
}