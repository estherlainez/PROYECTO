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
						System.out.println("|         1.Añadir nuevo contacto Amigo                        |");
						System.out.println("|         2.Añadir nuevo contacto  Familiar                    |");
						System.out.println("|         3.Mostrar los contactos por nombre                   |");
						System.out.println("|         4.Mostrar los contactos por afinidad                 |");
						System.out.println("|         5.Buscar un contacto por nombre                      |");
						System.out.println("|         6.Buscar  contactos que empiecen por....             |");
						System.out.println("|         7.Modificar un contacto                              |");
						System.out.println("|         8.Borrar un contacto                                 |");
						System.out.println("|         9.Guardar los contactos                              |");
						System.out.println("|                                                              |");
						System.out.println("|______________________________________________________________|");
						System.out.println("");
						System.out.println("Introduzca la opcion a elegir");
						opcion=teclado.nextInt();
						switch (opcion) {
						
						case 1:{
							System.out.println("Añadir Contacto Amigo");
							Conexion.añadirContactoAmigo();
							
							Conexion.Select("select * from contactos");	
							break;
						}
						case 2:{
							System.out.println("Añadir Contacto Familiar");
							Conexion.añadirContactoFamiliar();
							
							Conexion.Select("select * from contactos");	
							break;
						}
					
						case 3:{
							System.out.println("2.Mostrar Contactos ordenados por Nombre");
							sql = "SELECT * FROM contactos ORDER BY Nombre ";
							Conexion.Select(sql);
							
							break;
						}
						case 4:{
							System.out.println("2.Mostrar Contactos ordenados por Afinidad");
							sql = "SELECT * FROM contactos ORDER BY ValorAfinidad DESC ";
							Conexion.Select(sql);
							
							break;
						}
						case 5:{
							System.out.println("Buscar un contacto");
							Conexion.buscarContacto();
						
							break;
						}
							
						case 6:{
							System.out.println("Buscar los contactos que empiecen por...");
							Conexion.buscarPorLetra();
							
							break;
						}
						case 7:{
							System.out.println("Modificar los datos de un contacto");
							Conexion.modificarContacto();
							Conexion.Select("select * from contactos");	

							
							break;
						}
						
						case 8:{
							System.out.println("BorrarContacto");
							Conexion.borrarContacto();
							Conexion.Select("select * from contactos");	
							break;
						}
						
						case 9:{
							System.out.println("Que tengas un buen dia!!!");
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
					}while(opcion!=9);
					
				
			}

	}
