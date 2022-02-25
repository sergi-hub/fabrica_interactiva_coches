
public class Coche {


	private String matricula;
	private String marca;
	private String modelo;
	private String color;
	private boolean techoSolar;
	private float kilometros;
	private int numPuertas;
	private int numPlazas;
	
	static int numCoches = 0;
	static final int MAX_COCHES = 5;
	
	public void matricular(String matricula) {
		
		this.matricula = matricula;
		
	}
	
	
	public String tunear() {
		
		this.kilometros = 0;
		if(!this.techoSolar) {
			this.techoSolar = true;
			return "Se ha instalado un techo solar";
		}
		return "El vehiculo ya tenia un techo solar";
	}
	
	public String tunear(String color) {
		tunear();
		this.color = color;
		this.kilometros = 0;
		return "Se ha cambiado el color a: " + color;
		
	}
	
	public String avanzar(float kilometros) {
		setKilometros(kilometros);
		return "Se han avanzado " + kilometros + ", km actuales: " + getKilometros();
	}
	
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
		if(kilometros > 0) {
			this.kilometros = this.kilometros + kilometros;		}else {
		}
	}
	
	public int getNumPuertas() {
		return numPuertas;
	}
	public void setNumPuertas(int numPuertas) {
		
		if(numPuertas > 3 && numPuertas < 5) {
			this.numPuertas = numPuertas;
		}
		
	}
	
	public int getNumPlazas() {
		return numPlazas;
	}
	public void setNumPlazas(int numPlazas) {
		
		if(numPlazas > 2 && numPlazas < 7) {
			this.numPlazas = numPlazas;
		}
		
	}
	
}
