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
	int origen;
	int cod=1;
	protected static int codigo;
	Agenda contactos[];
	TreeSet<Agenda> listacontactos;
	ArrayList<RedesSociales> datosRD;

	
	//constructor de prueba para el codigo
	public Agenda(String n,String a, String t, String f) {		
		this.nombre=n;
		this.apellidos=a;
		this.telefono=t;
		this.fecha_nacimiento=f;
		this.cod=codigo;
		codigo++;
		this.datosRD=new ArrayList();
			
	}
	 
	
	public Agenda(int cod,String n,String a, String t, String f) {
		
		this.nombre=n;
		this.apellidos=a;
		this.telefono=t;
		this.fecha_nacimiento=f;
		this.cod=codigo;
		codigo++;
		this.datosRD=new ArrayList();
		
	}

	

	public abstract int CalcularAfinidad(int origen,int valor);
	
	

	public ArrayList<RedesSociales> getDatosRD() {
		return datosRD;
	}

	public void setDatosRD(ArrayList<RedesSociales> datosRD) {
		this.datosRD = datosRD;
	}
	
	public Agenda[] getContactos() {
		return contactos;
	}

	public void setContactos(Agenda[] contactos) {
		this.contactos = contactos;
	}

	public TreeSet<Agenda> getListacontactos() {
		return listacontactos;
	}

	public void setListacontactos(TreeSet<Agenda> listacontactos) {
		this.listacontactos = listacontactos;
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

	public int getOrigen() {
		return origen;
	}

	public void setOrigen(int origen) {
		this.origen = origen;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public static int getCodigo() {
		return codigo;
	}

	public static void setCodigo(int codigo) {
		Agenda.codigo = codigo;
	}

	
	

	
	@Override
	public String toString() {
		return "Agenda [nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono
				+ ", fecha_nacimiento=" + fecha_nacimiento + ", origen=" + getOrigen() + ", cod=" + cod 
				 + ", datosRD=" +getDatosRD() + "]";
	}

	@Override
	public int compareTo(Object o1) {
		Agenda Ob1 = (Agenda)o1;		
		return this.getNombre().compareTo(Ob1.getNombre());
	}

	


	

	
	
}
