public abstract class Lienzo {
	char [][] tablero = new char [9][9];
	char [][] almacen1 = new char [9][9];
	char [][] almacen2 = new char [9][9];

	

	public Lienzo(){
		inicializar(tablero);
	}

	
	public void inicializar(char[][] tablero){
		 	for (int f =0;f<tablero.length ;f++ ) { 
	   

	     		for (int c=0;c<tablero[0].length ;c++ ) {  

	     		
	   	
	     			tablero[f][c]='T';
	     		}
	     		
	     	}
	}


	 public void mostrar() {



	 	 		for (int f=0;f<tablero.length ;f++ ) {

	 	 			for (int c=0;c<tablero[0].length ;c++ ) {
	 	 				
	 	 				System.out.print(tablero[f][c]);
	 	 				System.out.print(" ");  //este es para dejar espacio

	 	 			}
	 	 				System.out.println(" ");
	 	 		}
	 	 		//return	miArray; 	 	
}


	public abstract void interactua();




}