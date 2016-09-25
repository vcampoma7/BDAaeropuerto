package Objetos;

public class ModeloAvion {
private Integer id;
private String nombre;
private String descripcion;
private float peso;
private Integer plazas;


public ModeloAvion() {
	super();
	// TODO Auto-generated constructor stub
}

public ModeloAvion(String nombre,
		String descripcion, float peso, Integer plazas) {
	super();
	this.nombre = nombre;
	this.descripcion = descripcion;
	this.peso = peso;
	this.plazas = plazas;
}

public ModeloAvion(Integer id, String nombre,
		String descripcion, float peso, Integer plazas) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.descripcion = descripcion;
	this.peso = peso;
	this.plazas = plazas;
}

public Integer getId() {
	return this.id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getNombre() {
	return this.nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getDescripcion() {
	return this.descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public Float getPeso() {
	return this.peso;
}

public void setPeso(Float peso) {
	this.peso = peso;
}

public Integer getPlazas() {
	return this.plazas;
}

public void setPlazas(Integer plazas) {
	this.plazas = plazas;
}
}
