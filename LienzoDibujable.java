import java.util.Scanner;
public class LienzoDibujable extends Lienzo implements Dibujable {
	

	 private  final  String DIBUJA = "DIBUJA";
	 private  final String BORRA  = "BORRA";
	 private  final String GUARDA = "GUARDA";
	 private  final String RECUPERA = "RECUPERA";
	 private  final char MARCA = '*';
	  private  final char BLANCO = ' ';



	public  void interactua(){
		Scanner teclado = new Scanner(System.in);
		String comando;
	do{
		mostrar();
		System.out.println("Dime orden");
		comando = teclado.nextLine();
		if (!comando.equals("FIN")) {
			try{
		ejecutaComando(comando);
	}catch(Exception e){

	}
		}
		mostrar();
		System.out.println();
	
	}while(!comando.equals("FIN"));
		
	}

	public void dibuja(int x, int y){
		tablero[x][y] ='*';
	}

	public void borra(int x,int y){
		tablero[x][y] =BLANCO;
	}

	public void guarda (int almacen){

	 	 		for (int f=0;f<tablero.length ;f++ ) {

	 	 			for (int c=0;c<tablero[0].length ;c++ ) {
	 	 				if (almacen == 1) {
	 	 					almacen1[f][c] = tablero[f][c] ;
	 	 				}else if (almacen == 2){
	 	 				almacen2[f][c] = tablero[f][c] ;
	 	 				}

	 	 			}
	 	 				
	 	 		}	 	 	

	}

	public void ejecutaComando(String comando) throws  CoordenadaIcorrecta, ComandoIncorrecto , AlmacenIncorrecto{
		int c1 = obtenerCordenada1(comando);
		int c2 = obtenerCordenada2(comando);
		String orden = obtenerOrden(comando);

		if (orden.equals("")) throw new ComandoIncorrecto();
			
		
		if (orden.equals(DIBUJA)||orden.equals(BORRA)) {
			if (c1 < 0 || c2 < 0) {
				throw new  CoordenadaIcorrecta();
			}else{
				if (c1 < 0)
					throw new CoordenadaIcorrecta();
				if ((c1 == 0) || (c1 > 2 ))
					throw new AlmacenIncorrecto(); 
			}
		}

		if (orden.equals("DIBUJA")) 		 dibuja(c1,c2);
		else if (orden.equals("BORRA"))   	 borra(c1,c2);
		else if (orden.equals("GUARDA"))	 guarda(c1);
		else if (orden.equals("RECUPERA")) 	 recupera(c1);

			
		

	}

	
	public void recupera(int almacen){

		for (int f=0;f<tablero.length ;f++ ) {

	 	 			for (int c=0;c<tablero[0].length ;c++ ) {
	 	 				if (almacen == 1) {
	 	 					 tablero[f][c] = almacen1[f][c]  ;
	 	 				}else if (almacen == 2){
	 	 					 tablero[f][c] = almacen2[f][c]  ;
	 	 				}

	 	 			}
	 	 				
	 	 		}	 	 	

	}

	private String obtenerOrden(String comando){

		String resultado = "";

		if (comando.indexOf(DIBUJA)==0)  resultado = DIBUJA;
	    else if (comando.indexOf(BORRA)==0)  resultado = BORRA;
	    else if (comando.indexOf(GUARDA)==0)  resultado = GUARDA;
	    else if (comando.indexOf(RECUPERA)==0)  resultado = RECUPERA;
			
		return resultado;	
		
	}

	
	private int obtenerCordenada1(String comando){
		int resultado = -1 ;
		char corenada1 ;
		//String orden = obtenerOrden(comando);

		corenada1 = comando.charAt(comando.indexOf(" ")+1);

		resultado = Character.getNumericValue(corenada1);
		return resultado;
	}

		

		private int obtenerCordenada2(String comando){
		int resultado = -1 ;
		char corenada2 ;
		//String orden = obtenerOrden(comando);

		corenada2 = comando.charAt(comando.indexOf(" ")+3);

		resultado = Character.getNumericValue(corenada2) ;
		return resultado;
	}



}