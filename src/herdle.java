import java.io.*;
import java.util.*;

public class herdle {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
//		BufferedReader  br = new  BufferedReader(new  FileReader ("[ problem ].in"));
//		PrintWriter  pw = new  PrintWriter(new  BufferedWriter(new  FileWriter("[ problem ].out")));
     StringTokenizer st = new StringTokenizer(br.readLine());
		
//	solution code goes here
        String ans = st.nextToken();
        st = new StringTokenizer(br.readLine());
        ans += st.nextToken();
        st = new StringTokenizer(br.readLine());
        ans += st.nextToken();

        int green = 0;
        int yellow = 0;

        st = new StringTokenizer(br.readLine());
        String ges = st.nextToken();
        st = new StringTokenizer(br.readLine());
        ges += st.nextToken();
        st = new StringTokenizer(br.readLine());
        ges += st.nextToken();

        String sto = "";

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<ges.length(); i++){
            char c = ges.charAt(i);
            if(c == ans.charAt(i)) green++;
            else{
                sto += ans.charAt(i);
                if(!map.containsKey(c)) map.put(c, 0);
                map.put(c, map.get(c)+1);
            }
        }
        for(int i=0; i<sto.length(); i++){
            char k = sto.charAt(i);
            if(map.containsKey(k)){
                yellow++;
                map.put(k, map.get(k)-1);
                if(map.get(k)==0)map.remove(k);
            }
        }
        


		pw.println(green);
        pw.println(yellow);
		pw.close();
	}
}
