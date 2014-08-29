package RECAST;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class CcA {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int[][] Edges=new int[3502][3502];
		int[]   node =new int[3502];
		int[]   big  =new int[3502];
		int K=-1;
		int L=-1;
		double[] result=new double[3502];// 每個點的COFF
		double Result=0;
		String A="",B="";
		
		for(int i=0;i<3502;i++){
			for(int j=0;j<3502;j++){
				Edges[i][j]=0;
			}
		}
		for(int i=0;i<3502;i++){node[i]=0;big[i]=0;}
		
		
		FileReader fr = new FileReader("D:/aa7.txt");
		FileReader fr1 = new FileReader("D:/aa7.txt");
		FileWriter dataFile = new FileWriter("D:/R5.txt");
        BufferedWriter input = new BufferedWriter(dataFile);

        
       
        
       
		BufferedReader br = new BufferedReader(fr);
		StringBuffer sb = new StringBuffer();
		String strNum="";
		while ((strNum=br.readLine())!=null){
		  sb.append(strNum);
		  String[] AfterSplit = strNum.split(" ");
		  Edges[Integer.parseInt(AfterSplit[0])][Integer.parseInt(AfterSplit[1])]=1;
		  Edges[Integer.parseInt(AfterSplit[1])][Integer.parseInt(AfterSplit[0])]=1;
		  node[Integer.parseInt(AfterSplit[0])]=1;
		  node[Integer.parseInt(AfterSplit[1])]=1;
		  
		}
		
		
		
		
		BufferedReader br1 = new BufferedReader(fr1);
		StringBuffer sb1 = new StringBuffer();
		String str1Num="";
		while ((str1Num=br1.readLine())!=null){
		  sb1.append(str1Num);
		  String[] AfterSplit = str1Num.split(" ");
		  
		   if(K == -1){
               K++;
               A=AfterSplit[0];
               big[K]=Integer.parseInt(AfterSplit[1]);
           }
           else if(A.equals(AfterSplit[0])){
               K++;
               A=AfterSplit[0];
               big[K]=Integer.parseInt(AfterSplit[1]);
           }
           else if(!A.equals(AfterSplit[0])){
               K++;
               big[K]=-1;
               int M=0; //計數器 
               
               for(int i=0;big[i]!=-1;i++){
                  for(int j=i;big[j]!=-1;j++){
                	  if(i!=j){
                		 if(Edges[big[i]][big[j]]==1)
                              M++;
                             
                     
                	  }
                  }
               }
               
               L++;
               if(M==0)
                  result[L]=0;
               else
                  result[L]=(double)(2*M)/(double)(K*(K-1));
               
               
               
              System.out.print(K+" "+M+" "+result[L]+" "+L+"\r\n");
              input.write( K+" "+M+" "+result[L]+" "+L+"\r\n");
               
               
               
               
               
               K=0;
               A=AfterSplit[0];
               big[K]=Integer.parseInt(AfterSplit[1]);
               
               
               
           }
		  
	   }
		
		
		result[++L]=-1;
        for(int i=0;result[i]!=-1;i++){
                Result+=result[i];
        }
        //input.write(  (double)Result/(double)L);
        System.out.println((double)Result/(double)L);
        
		
		
		input.close();
		System.out.print("end");
	}

}
