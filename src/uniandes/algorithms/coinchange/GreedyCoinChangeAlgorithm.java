package uniandes.algorithms.coinchange;

public class GreedyCoinChangeAlgorithm implements CoinChangeAlgorithm {
	@Override
	public int[] calculateOptimalChange(int totalValue, int[] denominations) {
		int [] result=new int[denominations.length];
		for(int i=denominations.length-1; i>=0; --i)
		{	
			result[i]=totalValue/denominations[i];
			totalValue-=(denominations[i]*result[i]);
		}
		return result;		
	}
}
