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
	import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
	import java.util.Scanner;
	import java.util.Set;
	import java.util.TreeSet;
	import java.util.Iterator;


public class AgendaContactosMain {
	
		public static void main(String[] args) throws ClassNotFoundException, ClassCastException {
			// TODO Auto-generated method stub
			Scanner teclado=new Scanner (System.in);
			
			
			int opcion=0,indice=0,valor=0,afinidad=0,parentesco=0,contador=0;
			String nombre = null,nick = null,respuesta="";
			
			TreeSet <Agenda> contactos = new TreeSet<>();

			ArrayList Redes=new ArrayList<>();
			
			File file = new File("c:\\archivos\\miAgenda.dat");
			Agenda p = null;
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
				
				Agenda f= new Familiar(3,"Maria","Mompel","679453267","18-12-80",3);			
				contactos.add(f);
				
				Familiar g= new Familiar(4,"Roberto","Navarro","669098986","14-04-1974",2);
				contactos.add(g);
				

			}
		
			
			do {
				System.out.println("MENU");
				System.out.println("1.Añadir nuevo amigo");
				System.out.println("2.Añadir nuevo familiar");
				System.out.println("3.Listar Contactos");
				System.out.println("4.Guardar Contactos y Salir");

				System.out.println("Introduzca la opcion a elegir");
				opcion=teclado.nextInt();
				
				switch(opcion) {
				
				
				
				case 1:
					System.out.println("1.Añadir amigo");
					teclado.nextLine();
					Amigo a=null;
					RedesSociales rd=null;
					a=DatosAgenda.AñadirAmigo(teclado, contactos);
					System.out.println("Usted añadio "+a);
				
					afinidad=a.CalcularAfinidad(a.getOrigen(), a.getValorAfinidad());
					System.out.println("La afinidad de su amigo es de "+afinidad);
					
					Agenda a1=(Amigo) a;
					
						
					System.out.println("¿Tienes a este amigo en las redes sociales?");
					System.out.println("Si lo tienes pulsa 1, si no pulsa 2");
					boolean afirmacion=false;
					int elige=teclado.nextInt();
					if (elige==1) {
						afirmacion=true;
						System.out.println("Si tienes a este amigo en las redes, añadiremos informacion");
					}else if(elige==2) {
						afirmacion=false;
						System.out.println("No tiene redes sociales el contacto+\nYa hemos guardado toda la informacion, ha sido un exito!");
					}
					System.out.println("ha elegido la opcion "+afirmacion);
					
					do {
							rd=DatosAgenda.añadirRedesSociales(teclado);
							Redes.add(rd);
							System.out.println("usted ha añadido esta informacion: \n "+rd);
							a1.setDatosRD(Redes);
								
							System.out.println("Informacion del amigo ---> "+a1);
							
							System.out.println("¿Alguna mas lo tienes?");
							elige=teclado.nextInt();
							System.out.println("ha elegido la opcion "+afirmacion);
					}while(afirmacion=true);
					
					System.out.println("ha elegido la opcion "+afirmacion);
					
					
					break;
					
				case 2:
					System.out.println("2.Añadir familiar");
					Familiar f=null;
					f=DatosAgenda.añadirFamiliar(teclado, contactos);
					System.out.println("Usted añadio "+f);
					
					System.out.println("Valoremos la afinidad y el aprecio de familia...");				
				
					System.out.println("¿Cual es su grado de confianza con este familiar?");
					valor=teclado.nextInt();
					afinidad=f.CalcularAfinidad(f.getParentesco(), valor);
					System.out.println("La afinidad de su familiar es de "+afinidad);
					
					Agenda f1=(Familiar) f;
					
						
					System.out.println("¿Tienes a este familiar en las redes sociales?");
					System.out.println("Si es que si marca 1 si es que no marca 2");
					respuesta=teclado.nextLine();

					/*
					do{
						rd=DatosAgenda.añadirRedesSociales(teclado);
						Redes.add(rd);
						System.out.println("usted ha añadido esta informacion: \n "+rd);
						f1.setDatosRD(Redes);
							
						System.out.println("¿Alguna mas lo tienes?");
						respuesta=teclado.nextLine();
						
						
					}while(respuesta==1) ;
					*/
					System.out.println("Informacion del amigo ---> "+f1);
					
					break;
					
				
				case 3:
					System.out.println("3.Listar los contactos");
					DatosAgenda.mostrtarListaContactos(contactos);
					
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

					try {
						ObjectInputStream ois= new ObjectInputStream(new FileInputStream(file));
						while(true) {
					
							p =(Agenda) ois.readObject();			
							contactos.add(p);
							System.out.println("Hemos guardado "+p);
							indice ++;

						}
					}catch(EOFException e) {
						System.out.println("Fin de la agenda. Tenemos en la agenda "+contactos.size()+" contactos");
					}catch(IOException ex) {
						System.out.println("Error");
				
					}	
					
					System.out.println("Hasta pronto!");
					break;
				
				}
			
			}while(opcion!=4);
		}

	

	}

