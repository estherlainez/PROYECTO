package Proyecto_con_treeSet;

public class Familiar extends Agenda{
	int parentesco;
	int afinidad=CalcularAfinidad(getParentesco(), getValorAfinidad());
	
	//Este constructor es de prueba por el codigo
	public Familiar(String n, String a, String t, String f,int p,int v) {
		super(n, a, t, f,v);
		this.parentesco=p;
		this.afinidad=CalcularAfinidad(getParentesco(), getValorAfinidad());
	}
	 
	public Familiar(int cod,String n,String a, String t, String f,int v) {
		super(cod,n,a,t,f,v);
	}

	//constructor con todos los campos incluidos valores que pedimos al usuario
	public Familiar(int cod,String n, String a, String t, String f,int p,int v) {
		super(cod,n, a, t, f, v);
		this.parentesco=p;
	}

	

	public int getParentesco() {
		return parentesco;
	}


	public void setParentesco(int parentesco) {
		this.parentesco = parentesco;
	}

	public int getAfinidad() {
		return afinidad;
	}

	public void setAfinidad(int afinidad) {
		this.afinidad = afinidad;
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
		//calculo aqui la afinidad
		int afinidad=CalcularAfinidad(getParentesco(), getValorAfinidad());
		return "Familiar [Nombre=" + nombre + ", Apellidos=" + apellidos + ",\n Telefono=" + telefono
				+ ", Fecha Nacimiento=" + fecha_nacimiento + ",\n Numero de indice =" + getId()  + ", Parentesco=" + getParentesco()+
				  ", Valoracion del familiar=" + getValorAfinidad() + ", Afinidad del familiar=" + afinidad +
				  ", \n Redes sociales del contacto=" +getDatosRD() +"]\n";
	}


	

		
	

}
