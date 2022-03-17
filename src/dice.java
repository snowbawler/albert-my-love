import java.io.*;
import java.util.*;

public class dice {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
//		BufferedReader  br = new  BufferedReader(new  FileReader ("[ problem ].in"));
//		PrintWriter  pw = new  PrintWriter(new  BufferedWriter(new  FileWriter("[ problem ].out")));
     StringTokenizer st = new StringTokenizer(br.readLine());
     int N = Integer.parseInt(st.nextToken());
     
//	solution code goes here
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            int[] x = new int[4];
            int[] y = new int[4];
            int xwin = 0;
            int ywin = 0;
            for(int j=0; j<4; j++){
                x[j] = Integer.parseInt(st.nextToken());
            }
            for(int j=0; j<4; j++){
                y[j] = Integer.parseInt(st.nextToken());
            }
            for(int i=0; i<4; i++){
                for(int j=0; j<4; j++){
                    if(x[i]>y[j]) xwin++;
                    else if(x[i]<y[j]) ywin++;
                }
            }
            if(ywin == 9 || xwin == 9 ) pw.println("yes");
            else pw.println("no");
        }
		
		pw.close();
	}
}
