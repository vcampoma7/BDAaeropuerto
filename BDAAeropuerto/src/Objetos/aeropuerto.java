package Objetos;

public class aeropuerto {
private Integer id_aeropuerto;
private String nombre;
private String ciudad;
private String codigoInternacional;
private float costeDelHandling;


public aeropuerto() {
	super();
	// TODO Auto-generated constructor stub
}

public aeropuerto(String nombre,
		String ciudad, String codigoInternacional, float costeDelHandling) {
	super();
	this.nombre = nombre;
	this.ciudad = ciudad;
	this.codigoInternacional = codigoInternacional;
	this.costeDelHandling = costeDelHandling;
}

public aeropuerto(Integer id_aeropuerto, String nombre,
		String ciudad, String codigoInternacional, float costeDelHandling) {
	super();
	this.id_aeropuerto = id_aeropuerto;
	this.nombre = nombre;
	this.ciudad = ciudad;
	this.codigoInternacional = codigoInternacional;
	this.costeDelHandling = costeDelHandling;
}

public Integer getId_aeropuerto() {
	return this.id_aeropuerto;
}

public void setId_aeropuerto(Integer id_aeropuerto) {
	this.id_aeropuerto = id_aeropuerto;
}

public String getNombre() {
	return this.nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getCiudad() {
	return this.ciudad;
}

public void setCiudad(String ciudad) {
	this.ciudad = ciudad;
}

public String getcodigoInternacional() {
	return this.codigoInternacional;
}

public void setCodigoInternacional(String codigoInternacional) {
	this.codigoInternacional = codigoInternacional;
}

public Float getCosteDelHandling() {
	return this.costeDelHandling;
}

public void setCosteDelHandling(float costeDelHandling) {
	this.costeDelHandling = costeDelHandling;
}
}
