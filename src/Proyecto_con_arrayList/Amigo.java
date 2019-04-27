package Proyecto_con_arrayList;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
public class Amigo extends Agenda {
	
	int origen;//sera aficion infancia o trabajo
	int afinidad=CalcularAfinidad(getOrigen(), getValorAfinidad());
	
	//Este constructor es de prueba para no poner numero de codigo
	public Amigo(String n,String a, String t, String f,int o,int v) {
		super(n,a,t,f,v);
		this.origen=o;
		this.afinidad=CalcularAfinidad(getOrigen(), getValorAfinidad());
	}
	
	
	//Este constructor es solo lo que hereda de agenda
	public Amigo(int cod,String n,String a, String t, String f,int v) {
		super(cod,n,a,t,f,v);
	}
	
	
	//Constructor con todos los campos incluidos los que pedimos al usuario
	public Amigo(int cod,String n, String a, String t, String f,int o, int v) {
		super(cod,n, a, t, f,v);
		this.origen=o;	
	}
	
	
	public int getOrigen() {
		return origen;
	}

	public void setOrigen(int origen) {
		this.origen = origen;
	}

	public int getAfinidad() {
		return afinidad;
	}


	public void setAfinidad(int afinidad) {
		this.afinidad = afinidad;
	}

	public int CalcularAfinidad(int origen, int valorAfinidad) {	
		int afinidad=0;
		if (origen==1) {
			afinidad=valorAfinidad*10;
			}else if(origen==2) {
				afinidad=valorAfinidad*5;
				}else if(origen==3) {
					afinidad=valorAfinidad*1;
					}	
		return afinidad;
	}

	

	@Override
	public String toString() {
		//calculo aqui la afinidad para que me lo muestre en el to string
		int afinidad=CalcularAfinidad(getOrigen(), getValorAfinidad());
		return "Amigo [Nombre=" + nombre + ", Apellidos=" + apellidos + ",\n Telefono=" + telefono
				+ ", Fecha Nacimiento=" + fecha_nacimiento + ",\n Numero de indice =" + id  + ", Origen=" + getOrigen()
				 + ", Confianza en su amigo=" + getValorAfinidad() +", Afinidad del amigo=" + afinidad 
				 + ",\n Redes Sociales del contacto=" +getDatosRD()  +"]\n"+"\n";
	}
	
	

	
}
