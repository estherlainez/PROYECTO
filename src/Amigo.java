import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
public class Amigo extends Agenda {
	
	int origen;//sera aficion infancia o trabajo
	int valorAfinidad;//Este sera de 0 a 10 segun la confianza
		
	
	//Este constructor es de prueba por lo del codigo
	public Amigo(String n,String a, String t, String f,int o,int v) {
		super(n,a,t,f);
		this.origen=o;
		this.valorAfinidad=v;	
	}
	
	
	public Amigo(int cod,String n,String a, String t, String f) {
		super(cod,n,a,t,f);
	}
	
	
	public Amigo(int cod,String n, String a, String t, String f,int o, int v) {
		super(cod,n, a, t, f);
		this.origen=o;
		this.valorAfinidad=v;	
	}

	public int getOrigen() {
		return origen;
	}

	public void setOrigen(int origen) {
		this.origen = origen;
	}

	public int getValorAfinidad() {
		return valorAfinidad;
	}

	public void setValorAfinidad(int valorAfinidad) {
		this.valorAfinidad = valorAfinidad;
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
		return super.toString()+ "Amigo [valorAfinidad=" + getValorAfinidad() + "]";
	}

	
}
