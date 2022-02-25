import java.util.Scanner;
import java.util.Vector;

public class Fabrica {
	
	static Scanner teclado = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		Vector almacen = new Vector(5);
		
		int eleccion;
		do {
			eleccion = 0;
			System.out.print("1) Fabricar coche (conociendo la matrícula)\n" +
					"2) Fabricar coche (a partir del nº puertas y el nº de plazas)\n" +
					"3) Fabricar coche (a partir de la marca, el modelo y el color)\n" +
					"4) Fabricar coche (cuando no tenemos ningún dato)\n" +
					"5) Tunear coche (pintándolo de color)\n" +
					"6) Tunear coche (sin pintarlo)\n" +
					"7) Avanzar kilómetros\n" +
					"8) Mostrar características de un coche\n" +
					"9) Ordenar coches\n" +
					"10) Sumar kilometros recursivo\n" +
					"11) Buscar coche recursivo\n" +
					"12) Salir del programa\n" +
					"Elige una opción: ");
			
			try {
				eleccion = Integer.parseInt(teclado.next());
			}catch(Exception e) {
				System.out.println("Solo números entre 1-12");
			}
			
			menu(almacen, eleccion);
			
		}while(eleccion != 12);
		
	}	
		
	private static void menu(Vector almacen, int elec) {
		Coche c = null;
		
		switch(elec) { 
			case 1:			
				if(Coche.numCoches < Coche.MAX_COCHES) {
					fabricarConMatricula(almacen, c);
					
				} else {
					System.out.println("Lo siento el almacen está lleno.");
				}
				break;
			case 2:
				if(Coche.numCoches < Coche.MAX_COCHES) {
					fabricarConPuertaPlaza(almacen, c);
				}else {
					System.out.println("Lo siento el almacen está lleno.");
				}
	
				break;
			case 3:
				if(Coche.numCoches < Coche.MAX_COCHES) {
					fabricarConMarcaModeloColor(almacen, c);
				}else {
					System.out.println("Lo siento el almacen está lleno.");
				}
				break;
			case 4:
				if(Coche.numCoches < Coche.MAX_COCHES) {
					fabricarPredeterminado(almacen, c);
				} else {
					System.out.println("Lo siento el almacen está lleno.");
				}
				break;
			case 5:
				tunearCoche(almacen, c);
				break;
			case 6:
				tunearConTecho(almacen, c);
				break;
			case 7:
				avanzarkmCoche(almacen, c);
				break;
			case 8:
				for(int i=0; i<almacen.size(); i++) {
					System.out.println("-------------");
					System.out.println((i+1) + ") " + caracteristicas((Coche)almacen.get(i)));
				}
				/*System.out.println("Dame la matricula: ");
				String _matricula = teclado.next();
				c = buscaCoche(almacen, _matricula);
				if(c != null) {
					System.out.println(caracteristicas(c));
				}else {
					System.out.println("No se ha encontrado la matrícula.");
				}*/
				break;
			case 9:
				System.out.println("1) Ordenar iterativamente");
				System.out.println("2) Ordenar recursiva");
				System.out.println("Dame tu elección: ");
				int op = 0;
				try {
					op = Integer.parseInt(teclado.next());
				}catch(Exception e) {
					System.out.println("Parametros incorrectos.");
				}
				
				if(op == 1) {
					ordenarPorKM(almacen, op);
					
				}else if(op == 2) {
					ordenarRecursivaPorKM(almacen, 0, 0);
					
				}else {
					System.out.println("No se ha podido realizar");
				}
				
				mostrarCochesRecursiva(almacen, 0);
				/*for(int i=0; i<almacen.size(); i++) {
					System.out.println("-------------");
					System.out.println((i+1) + ") " + caracteristicas((Coche)almacen.get(i)));
				}*/
				
				break;
			case 10: 
				System.out.println("La suma total es de: " + sumarKMRecursiva(almacen, 0));
				break;
			case 11:
				System.out.println("Dame la matricula: ");
				String mat = teclado.next();
				c = buscaCocheRecursivo(almacen, mat, 0);
				if(c != null) {
					System.out.println(caracteristicas(c));
				}else {
					System.out.println("No se ha encontrado la matrícula.");
				}
		}
	}
	
	private static void mostrarCochesRecursiva(Vector almacen, int i) {

		if(i == almacen.size()) {
			
		}else {
			
			System.out.println("-------------");
			System.out.println((i+1) + ") " + caracteristicas((Coche)almacen.get(i)));
			mostrarCochesRecursiva(almacen, i+1);
			
		}
		
		
		
	}

	private static Coche buscaCocheRecursivo(Vector almacen, String mat, int i) {
		
		if(i == almacen.size()) {
			return null;
		}else {
			if( ((Coche) almacen.get(i)).getMatricula().equalsIgnoreCase(mat) ) {
				 return (Coche)almacen.get(i);
			}
			else {
				return buscaCocheRecursivo(almacen, mat, i+1);
			}
		}
			
	}

	
	
	private static void ordenarRecursivaPorKM(Vector almacen, int i, int j) {
		Object _aux;
		if(i < almacen.size()-1) { //aqui es -1, porque si j es = a i, i le hacemos +1, se nos va fuera del vector
			
			if(  ((Coche) almacen.get(i)).getKilometros()  >  ((Coche) almacen.get(j+1)).getKilometros()) {
				_aux = almacen.get(i);
				almacen.set(i, almacen.get(j+1));
				almacen.set(j+1, _aux);
			}
			
			//hay que volver a llamar al método
			if(j == almacen.size()-2) { //es j-2 porque j = almacen.size, es j=6, -2 seria 4, arriba hacemos j+1, por tanto digamos q j seria 5, entraria dentro del tamaño del vector
				ordenarRecursivaPorKM(almacen, i+1, i+1); //le sumamos 1 a la i(primer for) y como j debe ser igual que i, pues ponemos i+1(segundo for)
			}else {
				ordenarRecursivaPorKM(almacen, i, j+1); //mientras que la j no haya llegado al final, le sumaremos 1
			}	
		}
	}
	
	private static float sumarKMRecursiva(Vector almacen, int i) {
		
		if(i == almacen.size()-1) {
			return ((Coche) almacen.get(i)).getKilometros();
		}else {
			return ((Coche) almacen.get(i)).getKilometros() + sumarKMRecursiva(almacen, i+1);
		}
		
	}
	
	private static void ordenarPorKM(Vector almacen, int op) {
		Object _aux;
		
		for(int i=0; i<almacen.size(); i++) {
			for(int j=i; j<almacen.size()-1; j++) {
				if(op == 1) {
					if(  ((Coche) almacen.get(i)).getKilometros()  >  ((Coche) almacen.get(j+1)).getKilometros()) {
						_aux = almacen.get(i);
						almacen.set(i, almacen.get(j+1));
						almacen.set(j+1, _aux);
					}
				}else {
					if(  ((Coche) almacen.get(i)).getKilometros()  <  ((Coche) almacen.get(j+1)).getKilometros()) {
						_aux = almacen.get(i);
						almacen.set(i, almacen.get(j+1));
						almacen.set(j+1, _aux);
					}
				}
			}
		}
		
	}

 	private static void mostrarCaracteristicas(Vector almacen, Coche c) {
		String _matricula;
		
		System.out.println("Dame la matricula: ");
		_matricula = teclado.next();
		c = buscaCoche(almacen, _matricula);
		if(c != null) {
			System.out.println(caracteristicas(c));
		}else {
			System.out.println("No se ha encontrado la matrícula.");
		}		
	}

	private static void avanzarkmCoche(Vector almacen, Coche c) {
		String _matricula;
		float _avanzar = 0;
		boolean _error = true;
		
		System.out.println("Dame la matricula: ");
		_matricula = teclado.next();
		c = buscaCoche(almacen, _matricula);
		if(c != null) {
			System.out.println("Cuantos km quiere avanzar: ");
			
			try {
				 _avanzar = Float.parseFloat(teclado.next());
			}catch (Exception e){
				System.out.println("Valor introducido incorrecto.");
				//_error = false;
			}
			
			//if(_error) {
				System.out.println(c.avanzar(_avanzar));
				System.out.println(caracteristicas(c));
			//}
			
		}else {
			System.out.println("No se ha encontrado la matrícula.");
		}
		
	}

	private static void tunearConTecho(Vector almacen, Coche c) {
		String _matricula;
		
		System.out.println("Dame la matricula: ");
		_matricula = teclado.next();
		c = buscaCoche(almacen, _matricula);
		if(c != null) {
			System.out.println(c.tunear());
			System.out.println(caracteristicas(c));
		}else {
			System.out.println("No se ha encontrado la matrícula.");
		}
	}

	private static void tunearCoche(Vector almacen, Coche c) {
		String _matricula;
		
		System.out.println("Dame la matricula: ");
		_matricula = teclado.next();
		c = buscaCoche(almacen, _matricula);
		if(c != null) {
			System.out.println("Dame el color: ");
			System.out.println(c.tunear(teclado.next()));
			System.out.println(caracteristicas(c));
		}else {
			System.out.println("No se ha encontrado la matrícula.");
		}
		
	}

	private static void fabricarPredeterminado(Vector almacen, Coche c) {

		c = new Coche();
		c.matricular(matAleatoria());
		c.avanzar(((int)Math.floor(Math.random()*(200-0+1) + 0)));
		System.out.println(caracteristicas(c));
		
		almacen.add(c);
		Coche.numCoches++;
		
	}

	private static void fabricarConMarcaModeloColor(Vector almacen, Coche c) {
		
		String _marca;
		String _modelo;
		String _color;
		
		System.out.println("Dame la marca: ");
		_marca = teclado.next();
		System.out.println("Dame el modelo: ");
		_modelo = teclado.next();
		System.out.println("Dame el color: ");
		_color = teclado.next();
		c = new Coche(_marca, _modelo, _color);
		c.matricular(matAleatoria());
		System.out.println(caracteristicas(c));
		Coche.numCoches++;
		almacen.add(c);
		
	}

	private static void fabricarConPuertaPlaza(Vector almacen, Coche c) {

		int _n_puertas = 0;
		int _n_plazas = 0;
		//boolean _error = true;
		
		System.out.println("Dame el Nº de puertas: ");
		
		try {
			_n_puertas = Integer.parseInt(teclado.next());
		}catch(Exception e) {
			System.out.println("El valor introducido no es correcto.");
			//_error = false;
			_n_puertas = 3;
		}
		
		//if(_error) {
			System.out.println("Dame el Nº de plazas: ");
			try {
				_n_plazas = Integer.parseInt(teclado.next());
			}catch(Exception e){
				System.out.println("El valor introducido no es correcto.");
				//_error = false;
				_n_plazas = 5;
			}
		//}
		
		//if(_error) {
			c = new Coche(_n_puertas, _n_plazas);
			c.matricular(matAleatoria());
			System.out.println(caracteristicas(c));
			Coche.numCoches++;
			almacen.add(c);
		/*}else {
			System.out.println("No se ha podido crear el coche.");
		}*/
	}

	private static void fabricarConMatricula(Vector almacen, Coche c) {

		String _matricula;
		System.out.println("Dame la matricula: ");
		_matricula = teclado.next();
		c = new Coche(_matricula);
		System.out.println(caracteristicas(c));
		Coche.numCoches++;
		almacen.add(c);
		
	}

	private static Coche buscaCoche(Vector almacen, String mat) {

		Coche c = null;
		int contador = 0;
		//boolean encontrado = false;
		while(contador < almacen.size() && c == null) {
			if( ((Coche) almacen.get(contador)).getMatricula().equalsIgnoreCase(mat) ) {
				 c = (Coche)almacen.get(contador);
				//return ((Coche) almacen.get(contador));
			}
			contador++;
		}
		return c;
	}
	
	public static String matAleatoria() {
		String matricula = "";
		String letras =  "BCDFGHJKLMNPQRSTVWXYZ";
		
		for(int i=0; i <4; i++) {
			matricula = matricula + ((int)Math.floor(Math.random()*(9-0+1) + 0));
		}
		
		matricula = matricula + "-";
		
		for(int i=0; i<2; i++) {
			matricula = matricula + "" + letras.charAt(((int)Math.floor(Math.random()*(20-0+1) + 0)));
		}
		
		return matricula;
		
	}
	
	private static String caracteristicas(Coche car) {
		String _techo;
		if(car.isTechoSolar()) {
			_techo = "tiene techo solar";
		}else {
			_techo = "no tiene techo solar";
		}
		
		return "Este coche tiene los siguientes datos:\n" +
				"Matricula: " + car.getMatricula() +
				"\nMarca: " + car.getMarca() + 
				"\nModelo: " + car.getModelo() +
				"\nColor: " + car.getColor() + 
				"\nkilómetros: " + car.getKilometros() + 
				"\ny " + _techo +
				"\nTiene " + car.getNumPuertas() + " puertas y " + car.getNumPlazas() + " plazas.";
	}

}
