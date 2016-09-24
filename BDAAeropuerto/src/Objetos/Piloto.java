package Objetos;

public class Piloto {
private Integer idPiloto;
private String nombre;
private String apellido;
private float horasDeVuelo;
//private int id_aeropuerto;

//afegim l'objecte cataleg en cardinalitat 1
private Aeropuerto aeropuerto;

public Piloto() {
	super();
	// TODO Auto-generated constructor stub
}

public Piloto(String nombre,
		String apellido, float horasDeVuelo, int id_aeropuerto) {
	super();
	this.nombre = nombre;
	this.apellido = apellido;
	this.horasDeVuelo = horasDeVuelo;
}

public Piloto(Integer idPiloto, String nombre,
		String apellido, float horasDeVuelo, int id_aeropuerto) {
	super();
	this.idPiloto = idPiloto;
	this.nombre = nombre;
	this.apellido = apellido;
	this.horasDeVuelo = horasDeVuelo;
}

public Integer getIdPiloto() {
	return this.idPiloto;
}

public void setIdPiloto(Integer idPiloto) {
	this.idPiloto = idPiloto;
}

public String getNombre() {
	return this.nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellido() {
	return this.apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}

public float getHorasDeVuelo() {
	return this.horasDeVuelo;
}

public void setHorasDeVuelo(float horasDeVuelo) {
	this.horasDeVuelo = horasDeVuelo;
}

//NOUS GETTERS I SETTERS
public Aeropuerto getAeropuerto() {
	return aeropuerto;
}

public void setAeropuerto(Aeropuerto aeropuerto) {
	this.aeropuerto = aeropuerto;
}


/*public int getId_aeropuerto() {
	return this.id_aeropuerto;
}

public void setId_aeropuerto(int id_aeropuerto) {
	this.id_aeropuerto = id_aeropuerto;
}*/
}
