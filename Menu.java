package utiles;
/**
*
*
*
*
*/
public class Menu {
	private String title;
	private String [] options;
	private int option;

	public Menu(String title, String[] options){
		this.title=title;
		setOptions(options);
		setOption(options);
	}
	
	private void setOptions(String[] options){
		int i=0;
		this.options= new String[options.length+1]; 
		for(String option:options){				 
			this.options[i++]=option;
		}					
	}

	private void setOption(String[] options){
		this.option=options.length;
	}

	private void showMenu(){
		System.out.println(title+"\n");	
		for(int i = 0; i < option; i++){
			System.out.println("("+(i+1)+") "+options[i]);
		}
	}

	private int takeOption(){
		return Teclado.leerEntero("\nIntroduce an option: ");
	}

	public int manageMenu(){
		showMenu();
		return takeOption();
	}
}