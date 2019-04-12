
public class RedesSociales {

	String nombre;
	String Nick;
	String cumpleaños;
	
	public RedesSociales(String no, String ni,String cu) {
		this.nombre=no;
		this.Nick=ni;
		this.cumpleaños=cu;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNick() {
		return Nick;
	}

	public void setNick(String nick) {
		Nick = nick;
	}
	
	public String getCumpleaños() {
		return cumpleaños;
	}

	public void setCumpleaños(String cumpleaños) {
		this.nombre = cumpleaños;
	}

	
	public String toString() {
		return " \nDatos adicionales de este contacto :\n"+
				" Nombre de la red: "+this.nombre+
				" Nick: "+this.Nick+
				" Cumpleaños: "+this.cumpleaños;
	}
}

