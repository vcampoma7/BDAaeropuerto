package Objetos;

public class Usuario {
private Integer id;
private String username;
private String password;


public Usuario() {
	super();
	// TODO Auto-generated constructor stub
}

public Usuario(String username,	String password) {
	super();
	this.username = username;
	this.password = password;
}

public Usuario(Integer id, String username,	String password) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
}

}
