package Objetos;

import java.sql.Date;

public class Ruta {
private Integer id;
private Date diasemana;
private String hora_asignada;

private Aeropuerto aeropuerto_origen;
private Aeropuerto aeropuerto_destino;
private Piloto piloto;

private Avion avion;

//Falta añadir el avion

public Ruta() {
	super();
	// TODO Auto-generated constructor stub
}

public Ruta(Aeropuerto aeropuerto_origen,
		Aeropuerto aeropuerto_destino, Date diasemana, String hora_asignada, Piloto piloto, Avion avion) {
	super();
	this.aeropuerto_origen = aeropuerto_origen;
	this.aeropuerto_destino = aeropuerto_destino;
	this.diasemana = diasemana;
	this.hora_asignada = hora_asignada;
	this.piloto = piloto;
	this.avion = avion;
}

public Ruta(Integer id, Aeropuerto aeropuerto_origen,
		Aeropuerto aeropuerto_destino, Date diasemana, String hora_asignada, Piloto piloto, Avion avion) {
	super();
	this.id = id;
	this.aeropuerto_origen = aeropuerto_origen;
	this.aeropuerto_destino = aeropuerto_destino;
	this.diasemana = diasemana;
	this.hora_asignada = hora_asignada;
	this.piloto = piloto;
	this.avion = avion;
}

public Integer getId() {
	return this.id;
}

public void setId(Integer id) {
	this.id = id;
}

public Date getDiasemana() {
	return this.diasemana;
}

public void setDiasemana(Date diasemana) {
	this.diasemana = diasemana;
}

public String getHora_asignada() {
	return this.hora_asignada;
}

public void setHora_asignada(String hora_asignada) {
	this.hora_asignada = hora_asignada;
}

//NOUS GETTERS I SETTERS
public Aeropuerto getAeropuerto_origen() {
	return aeropuerto_origen;
}

public void setAeropuerto_origen(Aeropuerto aeropuerto_origen) {
	this.aeropuerto_origen = aeropuerto_origen;
}

public Aeropuerto getAeropuerto_destino() {
	return aeropuerto_destino;
}

public void setAeropuerto_destino(Aeropuerto aeropuerto_destino) {
	this.aeropuerto_destino = aeropuerto_destino;
}

public Piloto getPiloto() {
	return piloto;
}

public void setPiloto(Piloto piloto) {
	this.piloto = piloto;
}

public Avion getAvion() {
	return avion;
}

public void setAvion(Avion avion) {
	this.avion = avion;
}

}
