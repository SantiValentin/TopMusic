package utiles;

public class Continua{
	
	public static boolean wishContinue(){
		char option;
		try {
			option = Teclado.leerCaracter();
		} catch (Exception e) {
			option = 0;
		}
		do{
			if(option == 'y' || option == 'Y'){
				return true;
			}
			else if (option == 'n' || option == 'N') {
				return false;
			}
			else{
				System.err.println("\nIntroduce a valid option");
				return false;
			}
		}while(true);
		
	}

	public static boolean wishContinue(String msj){
		System.out.print(msj);
		return wishContinue();
	}

}