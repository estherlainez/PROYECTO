
public class RedesSociales {

	String nombre;
	String Nick;
	String cumplea�os;
	
	public RedesSociales(String no, String ni,String cu) {
		this.nombre=no;
		this.Nick=ni;
		this.cumplea�os=cu;
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
	
	public String getCumplea�os() {
		return cumplea�os;
	}

	public void setCumplea�os(String cumplea�os) {
		this.nombre = cumplea�os;
	}

	
	public String toString() {
		return " \nDatos adicionales de este contacto :\n"+
				" Nombre de la red: "+this.nombre+
				" Nick: "+this.Nick+
				" Cumplea�os: "+this.cumplea�os;
	}
}

