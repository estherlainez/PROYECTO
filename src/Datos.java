import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Scanner;
public class Datos {

	public static Amigo  AñadirAmigo(Scanner teclado,TreeSet <Agenda>c) {
		System.out.println("Introduzca codigo");
		int cod=teclado.nextInt();
		System.out.println("Introduzca nombre");
		teclado.nextLine()
;		String n=teclado.nextLine();
		System.out.println("Introduzca apellido");
		String a=teclado.nextLine();
		System.out.println("Introduzca telefono");
		String t=teclado.nextLine();
		System.out.println("Introduzca fecha nacimiento");
		String f=teclado.nextLine();
		System.out.println("Introduzca su origen, si es afinidad inserte 1, si es infancia inserte 2 y si es trabajo inserte 3");
		int o=teclado.nextInt();
		System.out.println("Valore a su amigo....Introduzca el grado de confianza de 0 a 10");
		int v=teclado.nextInt();
		
		Amigo x= new Amigo(cod,n,a,t,f,o,v);
		c.add(x);
		return x;
			
		
	
	}
	
	public static Familiar añadirFamiliar(Scanner teclado,TreeSet <Agenda>c) {
		teclado.nextLine();
		
		System.out.println("Introduzca nombre");
		String n=teclado.nextLine();
		System.out.println("Introduzca apellido");
		String a=teclado.nextLine();
		System.out.println("Introduzca telefono");
		String t=teclado.nextLine();
		System.out.println("Introduzca fecha nacimiento");
		String f=teclado.nextLine();
		System.out.println("Introduzca su grado de parentesco: 1,2,3 segun cercania familiar");
		int p=teclado.nextInt();
		System.out.println("Inserte codigo");
		int cod=teclado.nextInt();
		
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
