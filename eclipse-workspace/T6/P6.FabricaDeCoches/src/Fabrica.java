import java.util.Vector;

public class Fabrica {

	public static void main(String[] args) {

		
		//Coche[] arr = new Coche[4];
		Vector vec = new Vector(4);
		Coche car1 = new Coche();
		Coche car2 = new Coche("5678-AG");
		Coche car3 = new Coche(5, 5);
		Coche car4 = new Coche("VW", "Caddy", "blanco");
		
		//coche 1
		car1.matricular("1234-DF");
		car1.setModelo("Toledo");
		car1.setColor("azul");
		car1.avanzar(200);
		//coche 2
		car2.setMarca("Fiat");
		car2.setModelo("Uno");
		car2.tunear("rojo");
		car2.avanzar(400);
		car2.setNumPlazas(2);
		//coche 3
		car3.matricular("9012-HH");
		car3.setMarca("BMW");
		car3.setModelo("850");
		car3.setColor("gris");
		car3.avanzar(400);
		car3.setNumPuertas(5);
		//coche 4
		car4.matricular("3456-XS");
		car4.setMarca("VW");
		car4.setModelo("Caddy");
		car4.tunear();
		car4.avanzar(500);
		car4.setNumPuertas(5);
		car4.setNumPlazas(7);
		
		vec.add(car1);
		vec.add(car2);
		vec.add(car3);
		vec.add(car4);
		
		/*arr[0] = car1;
		arr[1] = car2;
		arr[2] = car3;
		arr[3] = car4;*/
		
		//Con vector
		for(int i=0; i<vec.size(); i++) {
			System.out.println("Car" + (i+1) + ")\n " + caracteristicas((Coche) vec.get(i)));
		}
		
		//Con array
		/*for(int i=0; i<arr.length; i++) {
			System.out.println("Car" + (i+1) + ")\n " + caracteristicas2(arr[i]));
		}*/
		
		
	}

	//Con vector
	private static String caracteristicas(Coche car) {
		String _techo;
		if(car.isTechoSolar()) {
			_techo = "Sí.";
		}else {
			_techo = "No.";
		}
		
		return "Matricula: " + car.getMatricula() +
				"\n Marca: " + car.getMarca() + 
				"\n Modelo: " + car.getModelo() +
				"\n Color: " + car.getColor() + 
				"\n Techo Solar: " + _techo +
				"\n Km: " + car.getKilometros() + 
				"\n Nº Puertas: " + car.getNumPuertas() +
				"\n Nº Plazas: " + car.getNumPlazas() + "\n";
				
	}

	//Con array
	/*private static String caracteristicas2(Coche coche) {
		
		String techo;
		if(coche.isTechoSolar()) {
			techo = "Sí.";
		}else {
			techo = "No.";
		}
		
		return "Matricula: " + coche.getMatricula() + 
				"\n Marca: " + coche.getMarca() + 
				"\n Modelo: " + coche.getModelo() +
				"\n Color: " + coche.getColor() + 
				"\n Techo Solar: " + techo +
				"\n Km: " + coche.getKilometros() + 
				"\n Nº Puertas: " + coche.getNumPuertas() +
				"\n Nº Plazas: " +  coche.getNumPlazas()
				;			
	}*/

}
