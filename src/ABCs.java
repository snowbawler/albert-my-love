import java.io.*;
import java.util.*;

public class ABCs{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
//		BufferedReader  br = new  BufferedReader(new  FileReader ("[ problem ].in"));
//		PrintWriter  pw = new  PrintWriter(new  BufferedWriter(new  FileWriter("[ problem ].out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        ArrayList<Integer> store = new ArrayList<>();
        while(st.hasMoreTokens()){
            store.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(store);

        pw.print(store.get(0) + " " + store.get(1) + " " + (store.get(store.size()-2) - store.get(1)));
 //      System.out.print(store);
		
//	solution code goes here
		
		pw.close();
	}
}
