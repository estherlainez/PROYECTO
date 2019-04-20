import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.TreeSet;


public abstract class Agenda implements Serializable, Comparable{
	
	String nombre;
	String apellidos;
	String telefono;
	String fecha_nacimiento;
	int valorAfinidad;
	int id;
	protected static int indice=1;
	Agenda listacontactos[];
	TreeSet<Agenda> contactos;
	ArrayList<RedesSociales> datosRD;

	
	//constructor de prueba para el codigo
	public Agenda(String n,String a, String t, String f,int v) {		
		this.nombre=n;
		this.apellidos=a;
		this.telefono=t;
		this.fecha_nacimiento=f;
		this.valorAfinidad=v;
		this.id=indice;
		indice++;
		this.datosRD=new ArrayList();
			
	}
	 
	//constructor con todos los atributos
	public Agenda(int i,String n,String a, String t, String f,int v) {
		
		this.nombre=n;
		this.apellidos=a;
		this.telefono=t;
		this.fecha_nacimiento=f;
		this.valorAfinidad=v;
		this.id=indice;
		indice++;
		this.datosRD=new ArrayList();
		
	}

	

	public abstract int CalcularAfinidad(int origen,int valor);
	
	

	public ArrayList<RedesSociales> getDatosRD() {
		return datosRD;
	}

	public void setDatosRD(ArrayList<RedesSociales> datosRD) {
		this.datosRD = datosRD;
	}
	
	public int getValorAfinidad() {
		return valorAfinidad;
	}


	public void setValorAfinidad(int valorAfinidad) {
		this.valorAfinidad = valorAfinidad;
	}

	public TreeSet<Agenda> getContactos() {
		return contactos;
	}

	public void setListacontactos(TreeSet<Agenda> contactos) {
		this.contactos = contactos;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getIndice() {
		return indice;
	}

	public static void setIndice(int indice) {
		Agenda.indice = indice;
	}

	
	@Override
	public String toString() {
		return "Agenda [nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono
				+ ", fecha_nacimiento=" + fecha_nacimiento  + ", Id=" + id 
				 + ", datosRD=" +getDatosRD() + "]";
	}

	
	@Override
	public int compareTo(Object o1) {
		Agenda Ob1 = (Agenda)o1;		
		return this.getNombre().compareTo(Ob1.getNombre());
	}

		
	
}
