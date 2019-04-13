import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class RedesSociales {

	String nombreRed;
	String nickContacto;

	public RedesSociales(String no, String ni) {
		this.nombreRed=no;
		this.nickContacto=ni;
	
	}


	public String getNombreRed() {
		return nombreRed;
	}


	public void setNombreRed(String nombreRed) {
		this.nombreRed = nombreRed;
	}


	public String getNickContacto() {
		return nickContacto;
	}


	public void setNickContacto(String nickContacto) {
		this.nickContacto = nickContacto;
	}


	@Override
	public String toString() {
		return "RedesSociales [nombreRed=" + nombreRed + ",\n nickContacto=" + nickContacto + "]";
	}



	
}

