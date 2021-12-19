import java.io.*;
import java.util.*;

public class DaisyChains{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
//		BufferedReader  br = new  BufferedReader(new  FileReader ("[ problem ].in"));
//		PrintWriter  pw = new  PrintWriter(new  BufferedWriter(new  FileWriter("[ problem ].out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
//	solution code goes here
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayList<Double> flowers = new ArrayList<>();
        for(int i=0; i<N; i++){
            flowers.add(Double.parseDouble(st.nextToken()));
        }
//System.out.print(flowers);
        int ret = 0;
        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                ArrayList<Double> sto = new ArrayList<>();
                double avg = 0;
                for(int k=i; k<=j; k++){
                    sto.add(flowers.get(k));    
                    avg += flowers.get(k);               
                }
                avg/=(j-i+1);
 //               System.out.print(sto);
                if(sto.contains(avg)) ret++;
            }
        }

        pw.println(N+ret);
		
		pw.close();
	}
}