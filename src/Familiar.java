
public class Familiar extends Agenda{
	int parentesco;
	
	

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



	public int CalcularAfinidad(int gradoParentesco, int valor) {
		
		int afinidad=0;
		if (gradoParentesco==1) {
			afinidad=valor+10;
			}else if(gradoParentesco==3)  {
				afinidad=valor+5;
				}else if(gradoParentesco==3)  {
					afinidad=valor+1;
					}
		
		return afinidad;
	}

	@Override
	public String toString() {
		 return super.toString()+"Familiar [parentesco=" + parentesco + "]";
	}
	
		
	

}
