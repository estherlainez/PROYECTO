import java.io.DataInputStream;
	import java.io.DataOutputStream;
	import java.io.EOFException;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.util.Collections;
	import java.util.Scanner;
	import java.util.TreeSet;
	import java.util.Iterator;


public class UsooAgendaMain {
	
		public static void main(String[] args) throws ClassNotFoundException {
			// TODO Auto-generated method stub
			Scanner teclado=new Scanner (System.in);
			
			String nombre="";
			int opcion=0,indice=0,origen=0,valor=0,afinidad,parentesco=0;
			
			
			TreeSet <Agenda> contactos = new TreeSet<>();
			Agenda p = null;
			File file = new File("c:\\archivos\\miAgenda.dat");
			int i=0;
			
			if(file.exists()) {
				try {
					ObjectInputStream stream= new ObjectInputStream(new FileInputStream(file));
					while(true) {
				
						p =(Agenda) stream.readObject();			
						contactos.add(p);
						indice ++;

					}
				}catch(EOFException e) {
					System.out.println("Fin de la agenda. Tenemos en la agenda "+contactos.size()+" contactos");
				}catch(IOException ex) {
					System.out.println("Error");
			
				}

			}else {
			
				Amigo a= new Amigo (1,"Rosa","Jimenez","615388653","14-05-80",1,9);
				contactos.add (a);

				Amigo s= new Amigo(2,"Jorge","Royo","665786512","31-05-76",1,9);
				contactos.add(s);
				
				Agenda f= new Familiar(1,"Maria","Mompel","679453267","18-12-80",3);			
				contactos.add(f);
				
				Familiar g= new Familiar(2,"Roberto","Navarro","669098986","14-04-1974",2);
				contactos.add(g);
				

			}
		
			
			do {
				System.out.println("MENU");
				System.out.println("1.Añadir nuevo amigo");
				System.out.println("2.Añadir nuevo familiar");
				System.out.println("3.Listar Contactos");
				System.out.println("4.Guardar Contactos");
				System.out.println("5.Salir");
				System.out.println("Introduzca la opcion a elegir");
				opcion=teclado.nextInt();
				
				switch(opcion) {
				case 1:
					System.out.println("1.Añadir amigo");
					teclado.nextLine();
					Amigo a=null;
					a=Datos.AñadirAmigo(teclado, contactos);
					System.out.println("Usted añadio "+a);
					
					System.out.println("Valoremos la afinidad de su amigo...");
					origen=a.getOrigen();
					valor=a.getValorAfinidad();
					afinidad=a.CalcularAfinidad(origen, valor);
					System.out.println("La afinidad de su amigo es de "+afinidad);
					break;
				
				case 2:
					System.out.println("2.Añadir familiar");
					Familiar f=null;
					f=Datos.añadirFamiliar(teclado, contactos);
					System.out.println("Usted añadio "+f);
					
					System.out.println("Valoremos la afinidad y el aprecio de familia...");				
					parentesco=f.getParentesco();
					System.out.println("Cual es su grado de confianza familiar?");
					valor=teclado.nextInt();
					afinidad=f.CalcularAfinidad(origen, valor);
					System.out.println("La afinidad de su familia es de "+afinidad);
					break;
					
				
				case 3:
					System.out.println("3.Listar los contactos");
					Datos.mostrtarListaContactos(contactos);
					
					break;
					
				
	   
				case 4:
					System.out.println("4.Guardar los contactos");
					try {
						
						ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("c:\\archivos\\miAgenda.dat"));
							
						for (Agenda m: contactos) {	
								out.writeObject(m);
						} 
						
						out.close();
						
					}catch (IOException x) {
							x.printStackTrace();
					}

						
					
					System.out.println("Hasta pronto!");
					break;
				
				}
			
			}while(opcion!=4);
		}

	}

