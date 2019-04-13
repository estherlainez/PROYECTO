import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
public class DatosAgenda {

	public static Amigo  AñadirAmigo(Scanner teclado,TreeSet <Agenda>c) {	
		System.out.println("Introduzca codigo");
		int cod=teclado.nextInt();
		System.out.println("Introduzca nombre");
		teclado.nextLine();
		String n=teclado.nextLine();
		System.out.println("Introduzca apellido");
		String a=teclado.nextLine();
		System.out.println("Introduzca telefono");
		String t=teclado.nextLine();
		System.out.println("Introduzca fecha nacimiento");
		String f=teclado.nextLine();
		System.out.println("Valoremos la afinidad de su amigo...De que lo conocio???");
		System.out.println("Si es amigo de hobbies, elija como origen 1");
		System.out.println("Si es amigo de infancia elija como origen 2");
		System.out.println("Si es amigo por trabajo elija como origen 3");
		int o=teclado.nextInt();
		System.out.println("Cual es su grado de confianza con este amigo?");
		int v=teclado.nextInt();
		
		Amigo x= new Amigo(cod,n,a,t,f,o,v);
		c.add(x);
		return x;
	}	

	public static RedesSociales añadirRedesSociales(TreeSet <Agenda>c ,Scanner teclado) {
		
		System.out.println("¿En que redes tienes a este contacto");
		String nombre=teclado.nextLine();
		System.out.println("¿Con que nombre lo tienes?");
		String nick = teclado.nextLine();	
		
		RedesSociales datos=new RedesSociales(nombre,nick);
		return datos;
		
	}
	
	
	public static Familiar añadirFamiliar(Scanner teclado,TreeSet <Agenda>c) {	
		System.out.println("Inserte codigo");
		int cod=teclado.nextInt();
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
		Familiar fam= new Familiar(cod,n,a,t,f,p);
		c.add(fam);
	
		return fam;
	}
	
	
	
	public static void mostrtarListaContactos(TreeSet<Agenda> c) {
		for(Agenda e:c) {
			System.out.println(e.toString());
		}
	}
	
	
	
	
	
	
}
