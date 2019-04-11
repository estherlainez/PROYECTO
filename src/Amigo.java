import java.util.ArrayList;

public class Amigo extends Agenda {
	RedesSociales DatosRedes;
	int origen;//sera aficion infancia o trabajo
	int valorAfinidad;//Este sera de 0 a 10 segun la confianza
//	RedesSociales=DatosRedesSociales;
	
	
	public Amigo(int cod,String n, String a, String t, String f,int o, int v) {
		super(cod,n, a, t, f);
		this.origen=o;
		this.valorAfinidad=v;
		
		
	}



	public RedesSociales getDatosRedes() {
		return DatosRedes;
	}



	public void setDatosRedes(RedesSociales datosRedes) {
		DatosRedes = datosRedes;
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



	public int CalcularAfinidad(int origen, int valor) {
		int aficiones = 1;
		int infancia = 2;
		int trabajo = 3;
		int afinidad=0;
		if (origen==aficiones) {
			afinidad=valor*10;
			}else if(origen==infancia) {
				afinidad=valor*5;
				}else if(origen==trabajo) {
					afinidad=valor*1;
					}
		
		return afinidad;
	}



	@Override
	public String toString() {
		return super.toString()+ "Amigo [origen=" + origen + ", valorAfinidad=" + valorAfinidad + "]";
	}


	


	

}
