import java.util.ArrayList;

public class Amigo extends Contacto {
	RedesSociales DatosRedes;
	String origen;//sera aficion infancia o trabajo
	int valorAfinidad;//Este sera de 0 a 10 segun la confianza
//	RedesSociales=DatosRedesSociales;
	
	
	public Amigo(String n, String a, String t, String f,String o, int v) {
		super(n, a, t, f);
		this.origen=o;
		this.valorAfinidad=v;
		
		
	}

	@Override
	public int CalcularAfinidad(String origen,int valor) {
		String aficiones = null;
		String infancia = null;
		String trabajo = null;
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

	

}
