package RankVoting;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;


public class BordaMethod 
{

	public static void BordaCount(int[][] votes,String [] canididatename)
	{
		HashMap<String,Integer> Votingresult=new HashMap<String,Integer>();  
		
			for(int i=0;i<votes.length;i++)
			{
				int sum=0;
				int multiplier=votes.length;
				for (int j=0; j<votes.length; j++)
				{
					sum=sum+multiplier*votes[i][j];
					multiplier=multiplier-1;
				}
				Votingresult.put(canididatename[i],sum);
			}
			System.out.println("sum values"+FindingWinner(Votingresult));	
			Map candidateorder=FindingWinner(Votingresult);
			
			Iterator iterator = candidateorder.keySet().iterator();
			  
			while (iterator.hasNext()) {
			   String key = iterator.next().toString();
			   String value = candidateorder.get(key).toString();
			  
			   System.out.println(key + " " + value);
			}
				
	 }
	
	// Ordering the Voting Results According to Candidate Identity
	public static Map FindingWinner(Map Votingresult) 
	{
		Map CandidateOrder = new TreeMap(new ValueComparator(Votingresult));
		CandidateOrder.putAll(Votingresult);
		return CandidateOrder;
	}
 
	
	public static void main(String [] args)
	{
		System.out.println("AJMAL AZAD");
		int[][] names = {
		        {14, 0 , 0,23},
		        {4, 24 , 9,0},
		        {11,8, 18,0},
		        {8, 5, 10,14},
		    };
		String [] canididatename= {"A", "B" , "C","D"};
		BordaMethod test= new BordaMethod();
		test.BordaCount(names,canididatename);
	}

}
