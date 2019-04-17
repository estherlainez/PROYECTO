
public class Familiar extends Agenda{
	int parentesco;
	int confianza;
	//Este constructor es de prueba por el codigo
	public Familiar(String n, String a, String t, String f,int p,int v) {
		super(n, a, t, f);
		this.parentesco=p;
		this.confianza=v;
	}
	
	
	public Familiar(int cod,String n,String a, String t, String f) {
		super(cod,n,a,t,f);
	}

	public Familiar(int cod,String n, String a, String t, String f,int p) {
		super(cod,n, a, t, f);
		this.parentesco=p;
	}

	

	public int getParentesco() {
		return parentesco;
	}


	public void setParentesco(int parentesco) {
		this.parentesco = parentesco;
	}


	public int getConfianza() {
		return confianza;
	}


	public void setConfianza(int confianza) {
		this.confianza = confianza;
	}


	public int CalcularAfinidad(int gradoParentesco, int valor) {
		
		int afinidad=0;
		if (gradoParentesco==1) {
			afinidad=valor+10;
			}else if(gradoParentesco==2)  {
				afinidad=valor+5;
				}else if(gradoParentesco==3)  {
					afinidad=valor+1;
					}
		
		return afinidad;
	}



	@Override
	public String toString() {
		int afinidad=CalcularAfinidad(getParentesco(), getConfianza());
		return "Familiar [Nombre=" + nombre + ", Apellidos=" + apellidos + ",\n Telefono=" + telefono
				+ ", Fecha Nacimiento=" + fecha_nacimiento + ",\n Numero de codigo =" + id  + ", Parentesco=" + getParentesco()+
				  ", Valoracion del familiar=" + confianza + ", Afinidad del familiar=" + afinidad +
				  ", \n Redes sociales del contacto=" +getDatosRD() +"]\n";
	}


	

		
	

}
