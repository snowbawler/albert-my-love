import java.io.*;
import java.util.*;

public class StuckInARut {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
//		BufferedReader  br = new  BufferedReader(new  FileReader ("[ problem ].in"));
//		PrintWriter  pw = new  PrintWriter(new  BufferedWriter(new  FileWriter("[ problem ].out")));
     StringTokenizer st = new StringTokenizer(br.readLine());
     int N = Integer.parseInt(st.nextToken());
     char[] dir = new char[N];
     int[] xpos = new int[N];
     int[] ypos = new int[N];

     for(int i=0; i<N; i++){
         st = new StringTokenizer(br.readLine());
         dir[i] = st.nextToken().charAt(0);
         xpos[i] = Integer.parseInt(st.nextToken());
         ypos[i] = Integer.parseInt(st.nextToken());
     }
    //  System.out.println(dir);
    //  System.out.println(xpos);
    //  System.out.println(ypos);    
int[] retsto = new int[N];
for(int i=0; i<N; i++){
    retsto[i] = Integer.MAX_VALUE;
}
for(int h=0; h<N; h++){

     for(int i=0; i<N; i++){
         int sto = Integer.MAX_VALUE;
         int ret = Integer.MAX_VALUE;
         for(int j=0; j<N; j++){        
             if(dir[i] == 'N' && dir[j] == 'E'){
                if(xpos[i]>xpos[j] && ypos[i]<ypos[j] && xpos[i]-xpos[j]<ypos[j]-ypos[i]  && (retsto[j]+xpos[j]>xpos[i] || retsto[j]+xpos[j]<0)) 
                    sto=Math.abs(ypos[j]-ypos[i]);
                else 
                    sto = Integer.MAX_VALUE;
             }
             else if(dir[i] == 'E' && dir[j]== 'N'){
               //  System.out.print(retsto[j]+ypos[j]);
                if(xpos[j]>xpos[i] && ypos[j]<ypos[i] && xpos[j]-xpos[i]>ypos[i]-ypos[j] && (retsto[j]+ypos[j]>ypos[i] || retsto[j]+ypos[j]<0))
                    sto= Math.abs(xpos[j]-xpos[i]);
                else 
                    sto = Integer.MAX_VALUE;
             }
             else if(dir[i] == 'E' && dir[j]== 'E' && ypos[i]==ypos[j] && xpos[i]<xpos[j]){
                sto = xpos[j]-xpos[i];
             }
             else if(ypos[j]>ypos[i] && xpos[j]==xpos[i])
                sto = ypos[j]-ypos[i];
             if(sto<ret && sto>0){
                  ret = sto; 
             }
         }
         retsto[i]=ret;
        //System.out.println(Arrays.toString(retsto));

     }
     //System.out.println();

    }

    for(int i=0; i<N; i++){
        if(retsto[i] == Integer.MAX_VALUE) pw.println("Infinity");
        else pw.println(retsto[i]);
    }

//	solution code goes here
		
		pw.close();
	}
}
