package Objetos;

public class Piloto {
private Integer idPiloto;
private String nombre;
private String apellidos;
private float horasDeVuelo;
//private int id_aeropuerto;

//afegim l'objecte cataleg en cardinalitat 1
private Aeropuerto aeropuerto;

public Piloto() {
	super();
	// TODO Auto-generated constructor stub
}

public Piloto(String nombre,
		String apellidos, float horasDeVuelo, Aeropuerto aeropuerto) {
	super();
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.horasDeVuelo = horasDeVuelo;
	this.aeropuerto = aeropuerto;
}

public Piloto(Integer idPiloto, String nombre,
		String apellidos, float horasDeVuelo, Aeropuerto aeropuerto) {
	super();
	this.idPiloto = idPiloto;
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.horasDeVuelo = horasDeVuelo;
	this.aeropuerto = aeropuerto;
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

public String getApellidos() {
	return this.apellidos;
}

public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}

public Float getHorasDeVuelo() {
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
