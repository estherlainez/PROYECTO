package ProyectoConBaseDeDatos;


import java.sql.*;
import java.util.*;

public class AgendaMain {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente
				
				Conexion cn = new Conexion();
				String sql;
					
					Scanner teclado = new Scanner (System.in);
					int opcion;
					do {
						System.out.println(" ______________________________________________________________");
						System.out.println("|                                                              |");
						System.out.println("|                                                              |");
						System.out.println("|               AGENDA DE CONTACTOS                            |");
						System.out.println("|                    MENU                                      |");
						System.out.println("|         1.Añadir nuevo amigo                                 |");
						System.out.println("|         2.Añadir nuevo familiar                              |");
						System.out.println("|         3.Mostrar los contactos por nombre                   |");
						System.out.println("|         4.Mostrar los contactos por afinidad                 |");
						System.out.println("|         5.Buscar un contacto                                 |");
						System.out.println("|         6.Buscar  contactos que empiecen por....             |");
						System.out.println("|         7.Borrar un contacto                                 |");
						System.out.println("|         8.Modificar un contacto                              |");
						System.out.println("|         9.Guardar los contactos                              |");
						System.out.println("|                                                              |");
						System.out.println("|______________________________________________________________|");
						System.out.println("");
						System.out.println("Introduzca la opcion a elegir");
						opcion=teclado.nextInt();
						switch (opcion) {
						
						case 1:{
							sql="INSERT INTO contactos  VALUES (?,?, ?, ?, ?, ?, ?, ?,?);";
							try {
								PreparedStatement sentencia=cn.conector.prepareStatement(sql);
								teclado.nextLine();
								System.out.println("\n Inserte Nombre:");
								String nombre=teclado.nextLine();
								sentencia.setString(2, nombre);
								
								System.out.println("\n Inserte Apellidos:");
								String apellidos=teclado.nextLine();
								sentencia.setString(3, apellidos);
								
								System.out.println("\n Inserte telefono:");
								String telefono=teclado.nextLine();
								sentencia.setString(4, telefono);
								
								System.out.println("\n Inserte fecha nacimiento:");
								String fechaN=teclado.nextLine();
								sentencia.setString(5, fechaN);
								
								System.out.println("\n Inserte tipo:");
								System.out.println("Aqui elegimos si es amigo o familiar");
								String tipo=teclado.nextLine();
								sentencia.setString(6, tipo);
								
								System.out.println("\n Inserte Parentesco:");
								System.out.println(" Solo para los contactos familiares");
								System.out.println("El parentesco sera: grado1, grado2, grado3");
								String parentesco=teclado.nextLine();
								sentencia.setString(7, parentesco);
								
								System.out.println("\n Inserte origen :");
								System.out.println("Solo para amigos. Podra ser: Infancia, hobbies, trabajo");
								String origen=teclado.nextLine();
								sentencia.setString(8, origen);
								
								System.out.println("\n Inserte afinidad de 0 a 10:");
								System.out.println("Aqui mostramos la confianza con su contacto");
								int afi=teclado.nextInt();
								sentencia.setInt(9, afi);
								
								
								
							
								int rsp=sentencia.executeUpdate();
								
								
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
							
							break;
						}
						case 2:{
							
							
							break;
						}
						case 3:{
							sql = "SELECT * FROM contactos ORDER BY Nombre ";
							Conexion.Select(sql);
							
							break;
						}
						case 4:{
							
							break;
						}
							
						case 5:{
							System.out.println("introduce el id del contacto que queremos modificar");
							int codigo=teclado.nextInt();
							sql="UPDATE contactos SET NombreCliente = 'pruebamodificada' WHERE clientes.CodigoCliente = "+codigo+";"; 
							Conexion.Insert(sql);
							Conexion.Select("select * from contactos");	
							
							
							
							/*
							  	
							//-------por teclado-------//
							
						
							sql = "UPDATE clientes " +
									"SET CodigoCliente=?," +
									"NombreCliente=?," +
									"NombreContacto=?," +
									"ApellidoContacto=?," +
									"Telefono=?," +
									"Fax=?," +
									"LineaDireccion1=?," +
									"LineaDireccion2=?," +
									"Ciudad=?," +
									"Region=?," +
									"Pais=?," +
									"CodigoPostal=?," +
									"CodigoEmpleadoRepVentas=?," +
									"LimiteCredito=?  WHERE clientes.CodigoCliente = "+codigo+";"; 
							
							try {
								PreparedStatement sentencia=cn.conector.prepareStatement(sql);
								System.out.println("\n Inserte codigoCliente:");
								
								int codigoCliente=teclado.nextInt();
								sentencia.setInt(1, codigoCliente);
								teclado.nextLine();
								System.out.println("\n Inserte nombreCliente:");
								String nombreCliente=teclado.nextLine();
								sentencia.setString(2, nombreCliente);
								
								System.out.println("\n Inserte nombreContacto:");
								String nombreCon=teclado.nextLine();
								sentencia.setString(3, nombreCon);
								
								System.out.println("\n Inserte apellido:");
								String apellido=teclado.nextLine();
								sentencia.setString(4, apellido);
								
								System.out.println("\n Inserte telefono:");
								String telefono=teclado.nextLine();
								sentencia.setString(5, telefono);
								
								System.out.println("\n Inserte fax:");
								String fax=teclado.nextLine();
								sentencia.setString(6, fax);
								
								System.out.println("\n Inserte direccion 1:");
								String dir1=teclado.nextLine();
								sentencia.setString(7, dir1);
								
								System.out.println("\n Inserte direccion 2:");
								String dir2=teclado.nextLine();
								sentencia.setString(8, dir2);
								
								System.out.println("\n Inserte ciudad:");
								String ciudad=teclado.nextLine();
								sentencia.setString(9, ciudad);
								
								System.out.println("\n Inserte region:");
								String region=teclado.nextLine();
								sentencia.setString(10, region);
								
								System.out.println("\n Inserte pais:");
								String pais=teclado.nextLine();
								sentencia.setString(11, pais);
								
								System.out.println("\n Inserte codigo Postal:");
								String cp=teclado.nextLine();
								sentencia.setString(12, cp);
								
								System.out.println("\n Inserte codigoResponsable:");
								int resVentas=teclado.nextInt();
								sentencia.setInt(13, resVentas);
								
								System.out.println("\n Inserte limite:");
								double limite=teclado.nextDouble();
								sentencia.setDouble(14, limite);
								
								//ejecuto la sentencia preparada
								int rsp=sentencia.executeUpdate();
								
								
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							 */
							break;
						}
						
						case 7:{
							System.out.println("introduce el id del contacto que queremos eliminar");
							int id=teclado.nextInt();
							sql="DELETE FROM contacto WHERE contactos.Id = "+id+";"; 
							Conexion.Insert(sql);
							Conexion.Select("select * from contactos");	
							break;
						}
						
						case 9:{
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
