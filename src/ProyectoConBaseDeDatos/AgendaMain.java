package ProyectoConBaseDeDatos;


import java.sql.*;
import java.util.*;

public class AgendaMain {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
				
				Conexion cn = new Conexion();
				String sql,amigo="",familiar="",respuesta="";
					
					Scanner teclado = new Scanner (System.in);
					int opcion;
					do {
						System.out.println(" ______________________________________________________________");
						System.out.println("|                                                              |");
						System.out.println("|                                                              |");
						System.out.println("|               AGENDA DE CONTACTOS                            |");
						System.out.println("|                    MENU                                      |");
						System.out.println("|         1.Añadir nuevo contacto                              |");
						System.out.println("|         2.Mostrar los contactos por nombre                   |");
						System.out.println("|         3.Mostrar los contactos por afinidad                 |");
						System.out.println("|         4.Buscar un contacto por nombre                      |");
						System.out.println("|         5.Buscar  contactos que empiecen por....             |");
						System.out.println("|         6.Modificar un contacto                              |");
						System.out.println("|         7.Borrar un contacto                                 |");
						System.out.println("|         8.Guardar los contactos                              |");
						System.out.println("|                                                              |");
						System.out.println("|______________________________________________________________|");
						System.out.println("");
						System.out.println("Introduzca la opcion a elegir");
						opcion=teclado.nextInt();
						switch (opcion) {
						
						case 1:{
							System.out.println("Añadir Contacto");
							Conexion.añadirContacto();
							System.out.println("Vamos a calcular el nivel de afinidad");
							System.out.println("El contacto es amigo o familiar???");
							respuesta=teclado.nextLine();
							if(respuesta=="amigo") {
								System.out.println("Si es de hobbies inserte 1, si es de infancia inserte 2 y si es de trabajo inserte 3");
								int n=teclado.nextInt();
								System.out.println("Recuerde el grado de confianza que habia con este amigo para calcular la afinidad");
								int g=teclado.nextInt();
								int v=Conexion.CalcularAfinidadAmigo(n, g);
								System.out.println("su afinidad es de "+v);
							}else if(respuesta=="familiar");
							
							Conexion.Select("select * from contactos");	
							break;
						}
					
						case 2:{
							System.out.println("2.Mostrar Contactos ordenados por Nombre");
							sql = "SELECT * FROM contactos ORDER BY Nombre ";
							Conexion.Select(sql);
							
							break;
						}
						case 3:{
							
							
							break;
						}
						case 4:{
							System.out.println("Buscar un contacto");
							Conexion.buscarContacto();
						
							break;
						}
							
						case 5:{
							System.out.println("Buscar los contactos que empiecen por...");
							Conexion.buscarPorLetra();
							
							break;
						}
						case 6:{
							System.out.println("Modificar los datos de un contacto");
							Conexion.modificarContacto();
							Conexion.Select("select * from contactos");	

							
							break;
						}
						
						case 7:{
							System.out.println("7.BorrarContacto");
							Conexion.borrarContacto();
							//------corregir el problema del valor de afinidadddddd!!!!!!!
							Conexion.Select("select * from contactos");	
							break;
						}
						
						case 8:{
							try {
								cn.conector.close();
							}catch (Exception e) {
								e.printStackTrace();
							}
						break;
						}
						
						default: {
							System.out.println("Opcion no valida. Vuelva a leer");
						}
						}
					}while(opcion!=7);
					
				
			}

	}
