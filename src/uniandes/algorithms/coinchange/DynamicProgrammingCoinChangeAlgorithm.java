package uniandes.algorithms.coinchange;

import java.awt.List;

public class DynamicProgrammingCoinChangeAlgorithm implements CoinChangeAlgorithm {

	@Override
	public int[] calculateOptimalChange(int totalValue, int[] denominations) {
		//Se inicializa el arreglo y las variables.
		int[][] m = new int[denominations.length][totalValue+1];
		int[] retorno=new int[denominations.length];
		//Se inicializa en cero el arreglo de retorno
		for(int i=0;i<retorno.length;++i)
		{
			retorno[i]=0;
		}
		
		int i=0;
		int j=0;
		
		while(i<denominations.length)
		{
			//Ecuación de recurrencia.
			if(j==0)
			{
				m[i][j]=0;
			}
			if(i==0)
			{
				m[i][j]=j;
			}
			if(i>0 && denominations[i]>j)
			{
				m[i][j]=m[i-1][j];
			}
			if(i>0 && denominations[i]<=j)
			{
				m[i][j]=Math.min(m[i-1][j], m[i][j-denominations[i]]+1);
			}
			
			//Se recorre la matriz.
			if(j<totalValue)
			{
				++j;
			}
			else if(j==totalValue)
			{
				++i;			
				j=0;
			}
		}
		
		//Recorremos nuevamente la matriz para saber la cantidad de monedas por denominación para llevar.
		i=denominations.length-1;
		j=totalValue;
		while(i>=0)
		{
			if(denominations[i]<=j && m[i][j]==m[i][j-denominations[i]]+1)
			{
				++retorno[i];
				j=j-denominations[i];
			}
			else if(i==0)
			{
				break;
			}
			else if(m[i][j]==m[i-1][j])
			{
				--i;				
			}
		}
		return retorno;		
	}

}
