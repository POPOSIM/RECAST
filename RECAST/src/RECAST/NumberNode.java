package RECAST;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class NumberNode {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		int[]   node =new int[5000];
		
		
		
		for(int i=0;i<5000;i++)node[i]=0;
		
		
		FileReader fr = new FileReader("D:/USC18.txt");
		FileWriter dataFile = new FileWriter("D:/Node.txt");
        BufferedWriter input = new BufferedWriter(dataFile);

        
       
        
       
		BufferedReader br = new BufferedReader(fr);
		StringBuffer sb = new StringBuffer();
		String strNum="";
		while ((strNum=br.readLine())!=null){
		  sb.append(strNum);
		  String[] AfterSplit = strNum.split(" ");
		  node[Integer.parseInt(AfterSplit[0])]=1;
		  node[Integer.parseInt(AfterSplit[1])]=1;
		  
		}
		
		
		
		
		int K=0;
        for(int i=0;i<5000;i++)
        	if(node[i]==1){
              input.write(i+" "+K+"\n");
              K++;
        	}   
               
               
               
               
              
               
               
               
        
		  
	   
		
		
		
		input.close();
		System.out.print("end");
	}

}
