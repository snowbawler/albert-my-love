 import java.io.*;
 import java.util.*;
 public class WhereAmI {
 //yo this works
 	public static void main(String[] args) throws IOException {
 	    //BufferedReader br = new BufferedReader(new FileReader("whereami.in"));
 	    Scanner sc = new Scanner(new File("whereami.in"));
 		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));

 		int size = sc.nextInt();
 		String str = sc.next();
 		ArrayList<String> sto = new ArrayList<String>(str.length()*str.length()-1);
 		int out = 0;
 		int stoout = 0;
		

 			for(int i=0; i<=str.length(); i++) {
 				for(int j=i+1; j<=str.length(); j++) {
 					sto.add(str.substring(i,j));
 				}
 			}
 			for(int i=0; i<sto.size(); i++) {
 				for(int j=i+1; j<sto.size(); j++) {
 					if(sto.get(i).equals(sto.get(j))) stoout = sto.get(i).length();
 				}
 				if(stoout>out) out = stoout;
 			}

		
		
		
// 		pw.print(out+1);

	    
// 	    //br.close();
// 	    sc.close();
// 	    pw.close();


// 	}

// }
