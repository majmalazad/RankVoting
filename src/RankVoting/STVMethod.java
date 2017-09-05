package RankVoting;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class STVMethod {

	
	public static void STVCount()
	{
		int [][] vote= {
		        {5, 1 , 2,4,3},
		        {1, 2 , 3,4,5},
		        {5, 1 , 3,4,2},
		        {5, 1 , 3,4,2},
		        {5, 1 , 3,4,2},
		        {4, 1 , 3,5,2},
		        {4, 1 , 3,5,2},
		        {4, 2 , 3,5,1},
		        {4, 2 , 3,1,5},
		        {4, 2 , 1,3,5},
		};
		
		int numberofcandidate=vote[0].length;
		int numberofvoters=vote.length;
		int removecandidate=-1;
		
		ArrayList<String> canididateName = new ArrayList<String>();
		
		int seats=1;
		int quota=  (numberofvoters/(seats+1))+1;
		
		Map<String, Integer> Candidatevote = new HashMap<String, Integer>();	
		for (int k=0;k<numberofcandidate;k++)
		{
			if (k==0)// round 1	
			{
					for (int i=0;i<numberofcandidate;i++)
					{
						canididateName.add("C"+i);
						int sum=0;
						
							for (int j=0;j<numberofvoters;j++)
							{
								//System.out.println(i+"......"+j);
							//	System.out.println(vote[j][i]+"....."+j+"......"+i);
								if (vote[j][i]==1)
								{
									sum=sum+1;
								}
								
							}
						Candidatevote.put(canididateName.get(i), sum);
					}	
					
							
					Entry<String, Integer> min = null;
						for (Entry<String, Integer> entry : Candidatevote.entrySet())
						{
						    if (min == null || min.getValue() > entry.getValue()) {
						        min = entry;
						    }
						}
			
					System.out.println("key is "+min.getKey()); // 0.1
					removecandidate= canididateName.lastIndexOf(min.getKey());
					//System.out.println(k+"..............ABC...."+removecandidate);
					canididateName.remove(min.getKey());
					Candidatevote.remove(min.getKey());
					//System.out.println("here"+canididateName);
				}
			if (k>0)
			{
				for (int i=0;i<Candidatevote.size();i++)
				{
					int sum=0;
					
					for (int j=0;j<numberofvoters;j++)
					{
						
						if(vote[j][removecandidate]==1)
						{
							if (vote[j][i]==2)
							{
							//	System.out.println(j+"........."+i+"....."+removecandidate+".....ABC...."+vote[j][i]+"....."+vote[removecandidate][i]);
							sum=sum+1;
							
							}	
						}
						
						
					}
					
					Candidatevote.put(canididateName.get(i),Candidatevote.get(canididateName.get(i))+ sum);
					
				 }
				
				//Candidatevote.remove("C"+removecandidate);
				
				Entry<String, Integer> min = null;
					for (Entry<String, Integer> entry : Candidatevote.entrySet())
					{
					    if (min == null || min.getValue() > entry.getValue()) {
					        min = entry;
					    }
					}
		
				 // 0.1
				
				removecandidate= canididateName.lastIndexOf(min.getKey());
				canididateName.remove(min.getKey());
				Candidatevote.remove(min.getKey());
			}
		
			
			Map CandidateOrder = new TreeMap(new ValueComparator(Candidatevote));
			CandidateOrder.putAll(Candidatevote);
			
			Iterator iterator = CandidateOrder.keySet().iterator();		
			while (iterator.hasNext()) 
			{
			   String key = iterator.next().toString();
			   Integer value = (Integer)CandidateOrder.get(key);
					if (value>quota && k==numberofcandidate-2)
					{
						System.out.println("Winner is ......"+key+" and number of votes"+value);
						break;
					}
			}	
					
		
	}	
		
		
}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		STVMethod STV= new STVMethod();
		STV.STVCount();
		
	}

}
