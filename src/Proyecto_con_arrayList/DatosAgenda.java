package Proyecto_con_arrayList;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.Set;


public class DatosAgenda {

	public static Amigo  AñadirAmigo(Scanner teclado,ArrayList <Agenda>c) {	
		
		System.out.println("Introduzca nombre");
		String n=teclado.nextLine();
		System.out.println("Introduzca apellido");
		String a=teclado.nextLine();
		System.out.println("Introduzca telefono");
		String t=teclado.nextLine();
		System.out.println("Introduzca fecha nacimiento");
		String f=teclado.nextLine();
		System.out.println("Valoremos la afinidad de su amigo...De que lo conocio???");
		System.out.println("Introduzca su origen, sera hobbies,infancia o trabajo");
		System.out.println("Si es amigo de hobbies, elija como origen 1");
		System.out.println("Si es amigo de infancia elija como origen 2");
		System.out.println("Si es amigo por trabajo elija como origen 3");
		
		int o=teclado.nextInt();
		System.out.println("Cual es su grado de confianza con este amigo?");
		int v=teclado.nextInt();
		
		Amigo x= new Amigo(n,a,t,f,o,v);
		c.add(x);
		
		return x;
	}	
	
	

	public static RedesSociales añadirRedesSociales(Scanner teclado) {
		
		System.out.println("¿En que redes tienes a este contacto?");	
		String nombre=teclado.nextLine();		
		System.out.println("¿Con que nombre lo tienes?");		
		String nick = teclado.nextLine();	
		
		RedesSociales datos=new RedesSociales(nombre,nick);
		
		return datos;		
	}
	
	
	
	public static Familiar añadirFamiliar(Scanner teclado,ArrayList <Agenda>c) {	
	
		System.out.println("Introduzca nombre");
		teclado.nextLine();
		String n=teclado.nextLine();
		System.out.println("Introduzca apellido");
		String a=teclado.nextLine();
		System.out.println("Introduzca telefono");
		String t=teclado.nextLine();
		System.out.println("Introduzca fecha nacimiento");
		String f=teclado.nextLine();
		System.out.println("Introduzca su grado de parentesco: 1,2,3 segun cercania familiar");
		int p=teclado.nextInt();
		System.out.println("¿Cual es su grado de satisfacion o de confianza con este familiar");
		System.out.println("Introduzca valoracion de 1 a 10");
		int v=teclado.nextInt();
		
		Familiar fam= new Familiar(n,a,t,f,p,v);
		c.add(fam);
		
		return fam;
	}
	
	
	
	public static void mostrtarListaContactos(ArrayList<Agenda> c) {
		for(Agenda e:c) {
			System.out.println(e.toString());
		}
	}
	
	public static void listarEnOrdenPorNombre(ArrayList<Agenda> c) {
		
		Collections.sort(c, new Comparator() {
			public int compare(Object o1, Object o2) {
				Agenda a1=(Agenda)o1;
				Agenda a2=(Agenda)o2;
				return a1.nombre.compareTo(a2.nombre);
			}
		});
		
		System.out.println("Contactos ordenados por nombre: "+c.toString());

	}
	
	public static void listarEnOrdenPorAfinidad(ArrayList<Agenda> c) {
		
		Collections.sort(c, new Comparator() {
			public int compare(Object o1, Object o2) {
				Agenda a1=(Agenda)o1;
				Agenda a2=(Agenda)o2;
				return a1.getAfinidad()-(a2.getAfinidad());
			}
		});
		
		System.out.println("Contactos ordenados por Afinidad: "+c.toString());

	}


	public static Agenda buscarContacto(String n,ArrayList <Agenda> t) {
		
		for(Agenda a: t) {
			if(a.getNombre().equals(n)||a.getApellidos().equals(n)) {
				return a;
			}
		}
		return null;
	}
	/*
	public static Agenda buscarContactosPorLetra(String n,ArrayList <Agenda> t) {
		
	
		char[]caracteres=n.toCharArray();
		
		for (int x=0;x<caracteres.length;x++) {
			  System.out.println(" + x + " + caracteres[x]);
		}
		return contactos;
	}
*/
	public static void eliminarContacto(Agenda a, ArrayList <Agenda> t) {
		
		if(t.contains(a)) {
			t.remove(a);
			System.out.println("El contacto fue borrado");
		}
		
		System.out.println("Verificamos que el contacto elegido ya no esta...\n");
		 for (Agenda e:t) {
            System.out.println(e.toString());
		 }
		
	}
	
	
	
	public static Agenda ModificarDatos( Scanner teclado, ArrayList<Agenda>t) {

		System.out.println("Que contacto  va a modificar?");
		teclado.nextLine();
		String nombreModificar=teclado.nextLine();
		System.out.println("Introduzca los nuevos datos.\nNombre");
		String nombreNuevo=teclado.nextLine();
		System.out.println("Apellidos");
		String apellidoNuevo=teclado.nextLine();
		System.out.println("Telefono");
		String telefonoNuevo=teclado.nextLine();
		System.out.println("Fecha Nacimiento");
		String fechaNueva=teclado.nextLine();
		System.out.println("Grado de confianza o afinidad");
		int nuevaAfinidad=teclado.nextInt();
		System.out.println("Tenia informacion de las redes sociales?");
		teclado.nextLine();
		
		String res=teclado.nextLine(),si="";
		ArrayList nuevosDatos=new ArrayList<>();
		
		while(res.equals("si")){
			System.out.println("Nombre Red");
			String red=teclado.nextLine();
			System.out.println("Nick contacto");
			String nick=teclado.nextLine();
			RedesSociales r=new RedesSociales(red,nick);
			nuevosDatos.add(r);
			System.out.println("¿Alguna mas?");
			 res=teclado.nextLine();
		}
		
		String amigo="",familiar="",cercania="";
		System.out.println("¿Que cercania? amigo o familiar");
		cercania=teclado.nextLine();
		int nuevoOrigen=0, nuevoParentesco=0;
		if(cercania.equals("amigo")) {
				System.out.println("Origen:");
				nuevoOrigen=teclado.nextInt();
			}else if(cercania.equals("familiar")) {
				System.out.println("Parentesco:");
				nuevoParentesco=teclado.nextInt();
				}
		
		Agenda contactoModificar=null;
		
			
			for(Agenda d: t) {
				contactoModificar=d;
				if(d.getNombre().equals(nombreModificar)) {		
					d.setNombre(nombreNuevo);
					d.setApellidos(apellidoNuevo);
					d.setTelefono(telefonoNuevo);
					d.setFecha_nacimiento(fechaNueva);
					d.setValorAfinidad(nuevaAfinidad);
					d.setDatosRD(nuevosDatos);
					if(cercania.equals("amigo")) {
						((Amigo) d).setOrigen(nuevoOrigen);
						
						}else if(cercania.equals("familiar")) {
							((Familiar) d).setParentesco(nuevoParentesco);
						
							}
					
				}
			}
		
			return contactoModificar;
		}
	
	
}
