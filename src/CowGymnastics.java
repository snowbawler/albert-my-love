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
		
		for(int i=0; i<k; i++) {
			list.add(new ArrayList<Integer>());
			for(int j=0; j<n; j++) {
				list.get(i).add(sc.nextInt());  System.out.print(list.get(i).get(j));
			}
			//System.out.println();
		}
		for(int h=1; h<=n; h++) {	
			for(int i=h+1; i<=n; i++) {
				for(int j=0; j<k-1; j++) {
					for(int k1=j+1; k1<k; k1++) {
						if(list.get(j).indexOf(h) < list.get(j).indexOf(i)) high = true;
						else high = false;
						if(list.get(k1).indexOf(h) < list.get(k1).indexOf(i)) high1 = true; 
						else high1 = false;
						if(high == high1) out++; break;
						//System.out.print(high); System.out.print(high1); System.out.print(list.get(i).indexOf(j) + "" + list.get(i).indexOf(k1)); System.out.println(list.get(i+1).indexOf(j) + "" + list.get(i+1).indexOf(k1));  
					}
					
					
				}
			}
		}
		
		pw.print(out);
	
		sc.close();
		pw.close();
	}
}
