package RECAST;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class GraphA {
	public static void main(String[] args) throws IOException{
        int[][] Edges=new int[3935][3935];
        int[][] Persistance=new int[3935][3935];
        int[][] PerTamp1=new int[3935][3935];
        int[][] PerTamp2=new int[3935][3935];
        int[] Degree=new int[3935];
        int[] nodenumber=new int[5000];
		
		for(int i=0;i<3935;i++){
			for(int j=0;j<3935;j++){
				Edges[i][j]=0;
				Persistance[i][j]=0;
				PerTamp1[i][j]=0;
				PerTamp2[i][j]=0;
			}
			Degree[i]=0;
		}
		
		
		for(int i=0;i<5000;i++){
			nodenumber[i]=-1;
		}
		FileReader nr = new FileReader("D:/USC12node.txt");
		BufferedReader nnr = new BufferedReader(nr);
		StringBuffer sn = new StringBuffer();
		String strNode="";
		while ((strNode=nnr.readLine())!=null){
			  sn.append(strNode);
			  String[] AfterSplit = strNode.split(" ");
			  nodenumber[Integer.parseInt(AfterSplit[0])]=Integer.parseInt(AfterSplit[1]);
			  
		}
		
		
		
		
		
		
		
		
		
		
		FileReader fr = new FileReader("D:/USC12.txt");
		BufferedReader br = new BufferedReader(fr);
		FileWriter dataFile = new FileWriter("D:/GraphA.txt");
        BufferedWriter input = new BufferedWriter(dataFile);
		
      
        StringBuffer sb = new StringBuffer();
		String strNum="";
		
		int Timestamp=0;
		int Time=0;
		while ((strNum=br.readLine())!=null){
		  sb.append(strNum);
		  String[] AfterSplit = strNum.split(" ");
		  
		  if(Timestamp==0){
			  Time=Integer.parseInt(AfterSplit[2]);
			  Timestamp=1;
		  }
		  if( (Time+(Timestamp)*43200)<Integer.parseInt(AfterSplit[2])){
			  Timestamp++;
			  for(int i=0;i<3935;i++){
					for(int j=0;j<3935;j++){
						
						Persistance[i][j]+=PerTamp1[i][j];
						PerTamp1[i][j]=PerTamp2[i][j];
						PerTamp2[i][j]=0;
					}
					
				}
		  }
		  
		  if( (Time+(Timestamp-1)*43200)<=Integer.parseInt(AfterSplit[2])&&Integer.parseInt(AfterSplit[2])<=(Time+Timestamp*43200)){
			  
			  if( (Time+(Timestamp-1)*43200)<=Integer.parseInt(AfterSplit[3])&&Integer.parseInt(AfterSplit[3])<=(Time+Timestamp*43200)){  
				  PerTamp1[nodenumber[Integer.parseInt(AfterSplit[0])]][nodenumber[Integer.parseInt(AfterSplit[1])]]=1;
				  PerTamp1[nodenumber[Integer.parseInt(AfterSplit[1])]][nodenumber[Integer.parseInt(AfterSplit[0])]]=1;
		      }
			  else if((Time+Timestamp*43200)<=Integer.parseInt(AfterSplit[3])&&Integer.parseInt(AfterSplit[3])<=(Time+(Timestamp+1)*43200)){
				  PerTamp2[nodenumber[Integer.parseInt(AfterSplit[0])]][nodenumber[Integer.parseInt(AfterSplit[1])]]=1;
				  PerTamp2[nodenumber[Integer.parseInt(AfterSplit[1])]][nodenumber[Integer.parseInt(AfterSplit[0])]]=1;
				  PerTamp1[nodenumber[Integer.parseInt(AfterSplit[0])]][nodenumber[Integer.parseInt(AfterSplit[1])]]=1;
				  PerTamp1[nodenumber[Integer.parseInt(AfterSplit[1])]][nodenumber[Integer.parseInt(AfterSplit[0])]]=1;
			  }
			  
		  }	  
			  
		  if(Edges [nodenumber[Integer.parseInt(AfterSplit[0])]][nodenumber[Integer.parseInt(AfterSplit[1])]]==0)
		  {
			  if( Edges [nodenumber[Integer.parseInt(AfterSplit[1])]][nodenumber[Integer.parseInt(AfterSplit[0])]]==0)
			  {
				  Edges [nodenumber[Integer.parseInt(AfterSplit[0])]][nodenumber[Integer.parseInt(AfterSplit[1])]]=1;
		          Edges [nodenumber[Integer.parseInt(AfterSplit[1])]][nodenumber[Integer.parseInt(AfterSplit[0])]]=1;
		          Degree[nodenumber[Integer.parseInt(AfterSplit[0])]]++;
		          Degree[nodenumber[Integer.parseInt(AfterSplit[1])]]++;
			  }
		  }
			  
		}
		
		  
		  
		for(int i=0;i<3935;i++){
			for(int j=i;j<3935;j++){
				if(Edges[i][j]==1){
					
					int Degreeintersection=0;
					for(int k=0;k<3935;k++){
						if(Edges[i][k]==Edges[j][k]&&Edges[i][k]==1&&Edges[j][k]==1) Degreeintersection++;
						
					}
					if(Degreeintersection!=0){
						   input.write(i+" "+j+" "+(double)Persistance[i][j]/25+" "+(double)(Degreeintersection)/(double)(Degree[i]+Degree[j]-Degreeintersection)+" "+Degree[i]+" "+Degree[j]+"\r\n");
						   
					}
					else if(Degreeintersection==0){
						   input.write(i+" "+j+" "+(double)Persistance[i][j]/25+" "+0+" "+Degree[i]+" "+Degree[j]+"\r\n");
					}
					
					
					
					
					
				}
			}
		}
		
		
		
		input.close();
		System.out.print("end");
	}
	
}
