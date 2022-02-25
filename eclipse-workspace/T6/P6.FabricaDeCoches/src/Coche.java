public class Coche {

	private String matricula;
	private String marca;
	private String modelo;
	private String color;
	private boolean techoSolar;
	private float kilometros;
	private int numPuertas;
	private int numPlazas;
	
public Coche() {
		
		this.marca = "SEAT";
		this.modelo = "ALTEA";
		this.color = "blanco";
		this.numPuertas = 3;
		this.numPlazas = 5;
	}
	public Coche(String m) {
		
		this.matricula = m;
		this.marca = "SEAT";
		this.modelo = "ALTEA";
		this.color = "blanco";
		this.numPuertas = 3;
		this.numPlazas = 5;
		
	}
	
	public Coche(int numPuer, int numPla) {
		
		this.marca = "SEAT";
		this.modelo = "ALTEA";
		this.color = "blanco";
		setNumPuertas(numPuer);
		setNumPlazas(numPla);
		
	}
	
	public Coche(String marca, String model, String col) {
		
		this.marca = marca;
		this.modelo = model;
		this.color = col;
		this.numPuertas = 3;
		this.numPlazas = 5;
	}
	
	public void matricular(String matricula) {
		
		this.matricula = matricula;
		System.out.println("Se le ha asignado una matricula a su vehiculo.");
		
	}
	
	
	public void tunear() {
		
		this.kilometros = 0;
		if(!this.techoSolar) {
			this.techoSolar = true;
			System.out.println("Se ha instalado un techo solar correctamente.");
		}else {
			System.out.println("El techo solar ya estaba instalado.");
		}
	}
	
	public void tunear(String color) {
		tunear();
		this.color = color;
		this.kilometros = 0;
		System.out.println("Se ha cambiado el color a: " + this.color);
		
	}
	
	public void avanzar(int kilometros) {
		setKilometros(kilometros);
	}
	
	
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isTechoSolar() {
		return techoSolar;
	}
	public void setTechoSolar(boolean techoSolar) {
		this.techoSolar = techoSolar;
	}
	public float getKilometros() {
		return kilometros;
	}
	public void setKilometros(float kilometros) {
		if(kilometros < 0) {
			System.out.println("No se pueden establecer valores negativos al kilometraje.");
		}else {
			this.kilometros = this.kilometros + kilometros;
			System.out.println("Se han sumado " +  kilometros + "km, y el total de km es: " + this.kilometros);
		}
	}
	
	public int getNumPuertas() {
		return numPuertas;
	}
	public void setNumPuertas(int numPuertas) {
		
		if(numPuertas < 3 || numPuertas > 5) {
			System.out.println("El nº de puertas es incorrecto.");
		}else {
			this.numPuertas = numPuertas;
		}
	}
	
	public int getNumPlazas() {
		return numPlazas;
	}
	public void setNumPlazas(int numPlazas) {
		
		if(numPlazas < 2 || numPlazas > 7) {
			System.out.println("El nº de plazas es incorrecto.");
		} else {
			this.numPlazas = numPlazas;
		}
	}
	
}
