package Objetos;

public class Avion {
private Integer id;
private String matricula;

private ModeloAvion modelo;

public Avion() {
	super();
	// TODO Auto-generated constructor stub
}

public Avion(String matricula, ModeloAvion modelo) {
	super();
	this.matricula = matricula;
	this.modelo = modelo;
}

public Avion(Integer id, String matricula, ModeloAvion modelo) {
	super();
	this.id = id;
	this.matricula = matricula;
	this.modelo = modelo;
}

public Integer getId() {
	return this.id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getMatricula() {
	return this.matricula;
}

public void setMatricula(String matricula) {
	this.matricula = matricula;
}

//NOUS GETTERS I SETTERS
public ModeloAvion getModelo() {
	return modelo;
}

public void setModelo(ModeloAvion modelo) {
	this.modelo = modelo;
}
}
