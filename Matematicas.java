package utiles;
/**
*
*
*
*/
public class Matematicas{
	
	public static int getAleatorio(int min, int max){
		return (int)(Math.random()*(max-min)+min);
	}
}