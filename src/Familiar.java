
public class Familiar extends Contacto{
	String parentesco;
	ArrayList  redesSociales;
	String cumpleaños;
	

	public Familiar(String n, String a, String t, String f,String p,String c,String r) {
		super(n, a, t, f);
		this.parentesco=p;
		this.redesSociales=r;
		this.cumpleaños=c;
		
	}

	@Override
	public int CalcularAfinidad(int valor) {
		String grado1 = null;
		String grado2 = null;
		String grado3 = null;
		int afinidad=0;
		if (parentesco==grado1) {
			afinidad=valor*10;
			}else if(parentesco==grado2) {
				afinidad=valor*5;
				}else if(parentesco==grado3) {
					afinidad=valor*1;
					}
		
		return afinidad;
		
	}

}
