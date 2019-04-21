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
	import java.util.Arrays;
	import java.util.Collection;
	import java.util.Collections;
	import java.util.Comparator;
	import java.util.Scanner;
	import java.util.Set;
	import java.util.TreeSet;
	import java.util.Iterator;
	import java.util.List;


public class AgendaContactosMain {
	
		public static void main(String[] args) throws ClassNotFoundException, ClassCastException {
			// TODO Auto-generated method stub
			Scanner teclado=new Scanner (System.in);
			
			
			int opcion=0,indice=0,valor=0,afinidad=0,parentesco=0,contador=0;
			String nombre = null,nick = null;
			String elige="si";
			String elige1="no";
			String respuestaRedes="";
			TreeSet <Agenda> contactos = new TreeSet<>();

			
			
			File file = new File("c:\\archivos\\miAgenda.dat");
			Agenda p = null;
		
			
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
					System.out.println("Error. Algo nos ha fallado");
			
				}

			}else {
			
				Amigo a= new Amigo ("Rosa","Jimenez","615345678","14-05-80",9,1);
				contactos.add (a);

				Amigo s= new Amigo("Jorge","Royo","665786512","31-05-76",9,1);
				contactos.add(s);
				
				Agenda f= new Familiar("Maria","Mompel","679453267","18-12-80",3,8);			
				contactos.add(f);
				
				Familiar g= new Familiar("Roberto","Navarro","669098986","14-04-1974",2,8);
				contactos.add(g);
			}
		
			
			
			do {
				System.out.println(" ______________________________________________________________");
				System.out.println("|                                                              |");
				System.out.println("|                                                              |");
				System.out.println("|               AGENDA DE CONTACTOS                            |");
				System.out.println("|                    MENU                                      |");
				System.out.println("|         1.Añadir nuevo amigo                                 |");
				System.out.println("|         2.Añadir nuevo familiar                              |");
				System.out.println("|         3.Mostrar la lista de contactos                      |");
				System.out.println("|         4.Buscar un contacto                                 |");
				System.out.println("|         5.Borrar un contacto                                 |");
				System.out.println("|         6.Modificar un contacto                              |");
				System.out.println("|         7.Guardar los contactos                              |");
				System.out.println("|                                                              |");
				System.out.println("|______________________________________________________________|");
				System.out.println("");
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
					
					Agenda a1=(Amigo) a;
											
					System.out.println("¿Tienes a este amigo en las redes sociales?");
					System.out.println("Si tienes a este amigo en las redes, añadiremos informacion");
					teclado.nextLine();
					respuestaRedes=teclado.nextLine();
					
					ArrayList RedesA=new ArrayList<>();
					
					while(respuestaRedes.equals("si")) {
							rd=DatosAgenda.añadirRedesSociales(teclado);
							
							RedesA.add(rd);
							System.out.println("usted ha añadido esta informacion: \n "+rd);
							a1.setDatosRD(RedesA);	
					
							System.out.println("¿Tienes al contacto en alguna red mas?");	
							respuestaRedes=teclado.nextLine();							
						
					}
				
					System.out.println("Conatacto añadido!!!\n Informacion del amigo ---> "+a1+"\n");
					
					
					System.out.println("Verifiquemos que ha sido añadido correctamente \n");
					 for (Agenda e:contactos) {
                         System.out.println(e.toString());
					 }
					
					
					break;

					case 2:
					System.out.println("2.Añadir familiar");
					Familiar f=null;
					f=DatosAgenda.añadirFamiliar(teclado, contactos);
					System.out.println("Usted añadio "+f);
					
					Agenda f1=(Familiar) f;
						
					System.out.println("¿Tienes a este familiar en las redes sociales?");
					System.out.println("Si tienes a este amigo en las redes, añadiremos informacion");
					teclado.nextLine();
					respuestaRedes=teclado.nextLine();
					
					ArrayList RedesF=new ArrayList<>();
					
					while(respuestaRedes.equals("si")) {
						rd=DatosAgenda.añadirRedesSociales(teclado);
							
							RedesF.add(rd);
							System.out.println("usted ha añadido esta informacion: \n "+rd);
							f1.setDatosRD(RedesF);							
						
							System.out.println("¿Tienes al contacto en alguna red mas?");							
							respuestaRedes=teclado.nextLine();												
					}
				
					
					System.out.println("Conatacto añadido!!!\n Informacion del familiar ---> "+f1+"\n");
					System.out.println("Verifiquemos que ha sido añadido correctamente \n");
					 for (Agenda e:contactos) {
                         System.out.println(e.toString());
					 }
					
					break;
					
				case 3:
					System.out.println("3.Mostrar la lista de contactos");
					//El compareTo que yo añado al TreeSet es orden por nombre
					DatosAgenda.mostrtarListaContactos(contactos);
					
					break;
				
				case 4:
					System.out.println("5.Buscar un contacto");
					System.out.println("Introduzca datos a buscar (Nombre o Apellido):");
					teclado.nextLine();
					String nom=teclado.nextLine();
					Agenda busqueda=DatosAgenda.buscarContacto(nom, contactos); 
					System.out.println("Ha buscado: "+busqueda);
					break;
					
				case 5:
					System.out.println("6.Eliminar un contacto");
					System.out.println("Introduzca datos del contacto que quiere eliminar:");
					teclado.nextLine();
					nom=teclado.nextLine();
					Agenda contactoEliminar=null;
					contactoEliminar = DatosAgenda.buscarContacto(nom, contactos);
					DatosAgenda.eliminarContacto(contactoEliminar, contactos);
					 
					break;
					
				case 6:
					System.out.println("7.Modificar un contacto");
					Agenda mod= DatosAgenda.ModificarDatos(teclado, contactos);
					
					break;
					
				case 7:
					System.out.println("7.Guardar los contactos");
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
							System.out.println("Guardado: "+p);
							indice ++;

						}
					}catch(EOFException e) {
						System.out.println("Fin de la agenda. Tenemos en la agenda "+contactos.size()+" contactos");
					}catch(IOException ex) {
						System.out.println("Error");
				
					}	
					
					System.out.println("Hasta pronto!");
					break;
					
				
					default:
						System.out.println("La opcion elegida es incorrecta");
					
						
				}
			
			}while(opcion!=8);
		}

	

	}

