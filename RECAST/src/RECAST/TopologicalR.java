package RECAST;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class TopologicalR {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int[][] Edges=new int[3502][3502];
		
		for(int i=0;i<3502;i++){
			for(int j=0;j<3502;j++){
				Edges[i][j]=0;
			}
		}
		
		
		
		FileReader fr = new FileReader("D:/ToR.txt");
		BufferedReader br = new BufferedReader(fr);
		FileWriter dataFile = new FileWriter("D:/ToRtest.txt");
        BufferedWriter input = new BufferedWriter(dataFile);

        
       
        
        
		
		StringBuffer sb = new StringBuffer();
		String strNum="";
		while ((strNum=br.readLine())!=null){
		  sb.append(strNum);
		  String[] AfterSplit = strNum.split("	");
		  //System.out.println(AfterSplit[0]);
		  //System.out.println(AfterSplit[1]);
		  Edges[Integer.parseInt(AfterSplit[0])][Integer.parseInt(AfterSplit[1])]=1;
		  Edges[Integer.parseInt(AfterSplit[1])][Integer.parseInt(AfterSplit[0])]=1;
		  
		}
		
		
		for(int i=0;i<3502;i++){
			for(int j=i;j<3502;j++){
				if(Edges[i][j]==1){
					int I=0,J=0,N=0;
					for(int k=0;k<3502;k++){
						if(Edges[i][k]==Edges[j][k]&&Edges[i][k]==1&&Edges[j][k]==1) N++;
						if(Edges[i][k]==1&&k!=i) I++;
						if(Edges[j][k]==1&&k!=j) J++;
					}
					if(N!=0){
					   input.write( N+" "+(I+J-N)+" "+(double)(N)/(double)(I+J-N) +"\r\n");
					   
					}
					else if(N==0){
					   input.write( N+" "+(I+J-N)+" "+0 +"\r\n");
					}
				}
			}
			System.out.println("do");
		}
		
		
		
		
		input.close();
		System.out.print("end");
	}

}
