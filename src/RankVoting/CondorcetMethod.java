package RankVoting;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class CondorcetMethod 
{

		
	public static void main(String [] args)
	{
	//	System.out.println("AJMAL AZAD");
		int numberofcandidates=5;
		int[][] CondorcetMatrix =new int[numberofcandidates][numberofcandidates];
		CondorcetMatrix[0][0]=0;
		CondorcetMatrix[0][1]=0;
		CondorcetMatrix[0][2]=0;
		CondorcetMatrix[0][3]=0;
		CondorcetMatrix[0][4]=0;
		
		CondorcetMatrix[1][0]=0;
		CondorcetMatrix[1][1]=0;
		CondorcetMatrix[1][2]=0;
		CondorcetMatrix[1][3]=0;
		CondorcetMatrix[1][4]=0;
		
		String [] canididatename= {"A", "B" , "C","D","E"};
		CondorcetMatrix[4][0]=0;
		CondorcetMatrix[4][1]=0;
		CondorcetMatrix[4][2]=0;
		CondorcetMatrix[4][3]=0;
		CondorcetMatrix[4][4]=0;
		
		int [][] vote= {
		        {5, 1 , 2,4,3},
		        {1, 2 , 3,4,5},
		        {5, 1 , 3,4,2},
		        {5, 1 , 3,4,2},
		        {5, 1 , 3,4,2},
		        {4, 1 , 3,5,2},
		        {4, 1 , 3,5,2},
		};
		
		CondorcetMatrix= ConstructingCondorcetMatrix(vote,numberofcandidates,CondorcetMatrix);
		CondorcetWinner(CondorcetMatrix,canididatename);
		
		
		
	}

	public static int[][] ConstructingCondorcetMatrix(int [][] vote,int numberofcandidates,int[][] CondorcetMatrix)
	{
		
			for (int i=0;i<vote.length;i++)
			{
				if (vote[i].length==numberofcandidates)
				{
					for (int j=0;j<vote[i].length;j++)
					{
						//System.out.println("vote valid"+vote[i][j]);
							for (int k=j+1;k<vote[i].length;k++)
							{
								//DoneSet.add();
								int x= vote[i][j]-1;
								int bb=vote[i][k]-1;
							//	System.out.println(j+"......."+bb+"........"+x+"...."+vote[i][j]);
								CondorcetMatrix[x][bb]=CondorcetMatrix[x][bb]+1;
								//CondorcetMatrix[k][x]=CondorcetMatrix[k][x]+0;
							}
					}
				}
			}
	
						
		return 	CondorcetMatrix;
	}	
	
	public static void CondorcetWinner(int[][] CondorcetMatrix,String [] canididatename)
	{
		Map<Integer, ArrayList<Integer>> WinnerList = new HashMap<Integer, ArrayList<Integer>>();
		Map<Integer, Integer> Winnerint = new HashMap<Integer, Integer>();
				
			for (int i=0;i<CondorcetMatrix.length;i++)
			{
				ArrayList<Integer> arraylist = new ArrayList<Integer>();			
				for (int j=0; j<CondorcetMatrix.length;j++)
				{
					if (CondorcetMatrix[i][j]>CondorcetMatrix[j][i])
					{
						arraylist.add(j);
					}
					
				}
				Winnerint.put(i,arraylist.size());
				//System.out.println(i+"..........."+j+"........"+WinnerList);
			}
			System.out.println(Winnerint);
			
			for (int i=0;i<CondorcetMatrix.length;i++)
			{
				for (int j=0;j<CondorcetMatrix.length;j++)
				{
					System.out.print(CondorcetMatrix[i][j]+";");
				}
				System.out.println();
			}
			
			Map CandidateOrder=FindingWinner(Winnerint);
				System.out.println(CandidateOrder);
			
			Iterator entries = CandidateOrder.entrySet().iterator();
			while (entries.hasNext()) {
			    Map.Entry entry = (Map.Entry) entries.next();
			    Integer key = (Integer)entry.getKey();
			    Integer value = (Integer)entry.getValue();
			    if (value==4)
			    {
			    	System.out.println("Winner is......"+key);
			    }
			  //  System.out.println("Key = " + key + ", Value = " + value);
			}
		
	}	
	
	public static Map FindingWinner(Map Votingresult) 
	{
		
		Map CandidateOrder = new TreeMap(new ValueComparator(Votingresult));
		CandidateOrder.putAll(Votingresult);
		
		return CandidateOrder;
	}
}
