package ProyectoConBaseDeDatos;

import java.io.*;
import java.sql.*;
import java.util.*;

public class Conexion {
	 String servidor;
	 String usuario;
	 String password;
	static Connection conector;
		
	

	public Conexion() {
	
		try {
			try {
		
				Properties propiedades = new Properties ();
				
				propiedades.load(new FileInputStream
				("C:/Users/Esther/git/proyecto-programacion/src/configuration/properties"));
				this.servidor = propiedades.getProperty("dataBaseServer");
				this.usuario = propiedades.getProperty("dataBaseUser");
				this.password = propiedades.getProperty("dataBasePassword");
				
						 					
			}catch (FileNotFoundException e) {
				 System.out.println("Error, El archivo no exiSte");
			} catch (IOException e) {
				 System.out.println("Error, No se puede leer el archivo");
			}
			
			
			conector= DriverManager.getConnection(servidor, usuario, password);
			
			
			
		}catch (Exception e) {
			System.out.println("noConecta");
			e.printStackTrace();
		}
	}
	
	
	public static int CalcularAfinidadAmigo(int origen, int valorAfinidad) {	
		int afinidad=0;
		if (origen==1) {
			afinidad=valorAfinidad*10;
			}else if(origen==2) {
				afinidad=valorAfinidad*5;
				}else if(origen==3) {
					afinidad=valorAfinidad*1;
					}	
		return afinidad;
	}
	
	public static int CalcularAfinidadFamiliar(int gradoParentesco, int valor) {
		
		int afinidad=0;
		if (gradoParentesco==1) {
			afinidad=valor+10;
			}else if(gradoParentesco==2)  {
				afinidad=valor+5;
				}else if(gradoParentesco==3)  {
					afinidad=valor+1;
					}
		
		return afinidad;
	}
	
	public static void Select (String sql) {
		try {
			Statement miStatement = conector.createStatement();
			ResultSet rs = miStatement.executeQuery(sql);
		
			while (rs.next()) {
				for (int i=1;i<=rs.getMetaData().getColumnCount();i++) {
					System.out.print(rs.getString(i)+"\t");
				}
				
				System.out.println("");
			
			}
			miStatement.close();
		}catch (Exception e) {
			System.out.println("noConecta");
			e.printStackTrace();
		}
	}
	

	
	public static void modificarContacto () {
		Scanner teclado=new Scanner(System.in);
		System.out.println("introduce el id del contacto que queremos modificar");
		int codigo=teclado.nextInt();
		int v=0,n=0,afi2=0;
	
		String sql = "UPDATE contactos " +
				"SET Id=?," +
				"Nombre=?," +
				"Apellidos=?," +
				"Telefono=?," +
				"FechaNacimiento=?," +
				"Tipo=?," +
				"Parentesco=?," +
				"Origen=?," +
				"Afinidad=?," +
				"ValorAfinidad=?  WHERE contactos.Id = "+codigo+";"; 
		
		try {
			PreparedStatement sentencia=conector.prepareStatement(sql);
			System.out.println("\n Inserte Id:");
			int id=teclado.nextInt();
			sentencia.setInt(1, id);
			teclado.nextLine();
			System.out.println("\n Inserte Nombre:");
			String nombre=teclado.nextLine();
			sentencia.setString(2, nombre);
			
			System.out.println("\n Inserte Apellidos:");
			String apellido=teclado.nextLine();
			sentencia.setString(3, apellido);
			
			System.out.println("\n Inserte Telefono:");
			String telefono=teclado.nextLine();
			sentencia.setString(4, telefono);
			
			System.out.println("\n Inserte Fecha Nacimiento:");
			String fecha_N=teclado.nextLine();
			sentencia.setString(5, fecha_N);
			
			System.out.println("\n Inserte tipo(amigo o familiar):");
			String tipo=teclado.nextLine();
			sentencia.setString(6, tipo);
			
			System.out.println("\n Inserte parentesco en caso de familiar :");
			String par=teclado.nextLine();
			sentencia.setString(7, par);
			
			if(par.equals("grado1")) {
				 n=1;
				}else if(par.equals("grado2")){
					n=2;
				}else if(par.equals("grado3")){
					n=3;
					}
			System.out.println("\n Inserte origen en caso de amigo (hobbies, infancia,trabajo):");
			String or=teclado.nextLine();
			sentencia.setString(8, or);
			
			if(or.equals("hobbies")) {
				 v=1;
				}else if(or.equals("infancia")){
					v=2;
				}else if(or.equals("trabajo")){
					v=3;
					}
			System.out.println("\n Inserte afinidad(confianza en su amigo o familiar):");
			int afi=teclado.nextInt();
			sentencia.setInt(9, afi);
			
			System.out.println("Vamos a calcular el nivel de afinidad");
			if(tipo.equals("amigo")) {
					afi2=Conexion.CalcularAfinidadAmigo(v, afi);
				}else if(tipo.equals("familiar")) {
					afi2=Conexion.CalcularAfinidadFamiliar(n, afi);
			}
			sentencia.setInt(10, afi2);
			System.out.println("La afinidad es de: "+afi2);
		
			int rsp=sentencia.executeUpdate();
			System.out.println("\n Contacto modificado con exito!!!");
			sentencia.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	public static void añadirContactoAmigo() {
		Scanner teclado=new Scanner(System.in);
		String 	sql="INSERT INTO contactos  VALUES (?,?, ?, ?, ?, ?, ?, ?,?,?);";
		try {
			PreparedStatement sentencia=conector.prepareStatement(sql);
			System.out.println("\n Inserte Id:");
			int id=teclado.nextInt();
			sentencia.setInt(1, id);
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
			
			
			System.out.println("\n Inserte origen en caso de amigo (hobbies, infancia,trabajo):");
			String or=teclado.nextLine();
			sentencia.setString(8, or);
			
			System.out.println("Ahora veremos la afinidad de su amigo");
			int n=0,afi2;
			if(or.equals("hobbies")) {
				 n=1;
				}else if(or.equals("infancia")){
					n=2;
				}else if(or.equals("trabajo")){
					n=3;
					}
			System.out.println("\n Inserte afinidad(confianza en su amigo o familiar):");
			int afi=teclado.nextInt();
			sentencia.setInt(9, afi);
			
			System.out.println("Vamos a calcular el nivel de afinidad");
			afi2=Conexion.CalcularAfinidadAmigo(n, afi);
			
			sentencia.setInt(10, afi2);
			
			
			System.out.println("\n Aqui el programa muestra el valor de afinidad: "+afi2);
			
			
			
			int rsp=sentencia.executeUpdate();
			
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		String respuesta=teclado.nextLine();
		String si="",no="";
		teclado.nextLine();
		System.out.println("\n Tiene a este contacto en las redes sociales???");
	
		respuesta=teclado.nextLine();
		
		if(respuesta.equals("si")) {
			sql="INSERT INTO redessociales  VALUES (?,?,?,?,?);";
			try {
				PreparedStatement sentencia=conector.prepareStatement(sql);
				System.out.println("Inserte el Id del contacto");
				int id=teclado.nextInt();
				sentencia.setInt(1, id);
				teclado.nextLine();
				System.out.println("\n Inserte Nombre red:");
				String nombreRed1=teclado.nextLine();
				sentencia.setString(2, nombreRed1);
				System.out.println("\n Inserte Nick:");
				String nick1=teclado.nextLine();
				sentencia.setString(3, nick1);									
				System.out.println("\n Inserte Nombre red:");
				String nombreRed2=teclado.nextLine();
				sentencia.setString(4, nombreRed2);								
				System.out.println("\n Inserte Nick:");
				String nick2=teclado.nextLine();
				sentencia.setString(5, nick2);
				
				
				int rsp=sentencia.executeUpdate();
				System.out.println("\n Hemos acabado, contacto añadido!!!");
				
				sentencia.close();
			} catch (Exception e) {
			
				e.printStackTrace();
			}
	}
	


	}
	
	public static void añadirContactoFamiliar() {
		Scanner teclado=new Scanner(System.in);
		String 	sql="INSERT INTO contactos  VALUES (?,?, ?, ?, ?, ?, ?, ?,?,?);";
		try {
			PreparedStatement sentencia=conector.prepareStatement(sql);
			System.out.println("\n Inserte Id:");
			int id=teclado.nextInt();
			sentencia.setInt(1, id);
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
			
			
			System.out.println("\n Inserte origen en caso de amigo, si no pulse enter");
			String or=teclado.nextLine();
			sentencia.setString(8, or);
			
			System.out.println("Ahora veremos la afinidad de su familiar");
			int n=0,afi2;
			if(parentesco.equals("grado1")) {
				 n=1;
				}else if(parentesco.equals("grado2")){
					n=2;
				}else if(parentesco.equals("grado3")){
					n=3;
					}
			System.out.println("\n Inserte afinidad(confianza en su familiar):");
			int afi=teclado.nextInt();
			sentencia.setInt(9, afi);
			
			System.out.println("Vamos a calcular el nivel de afinidad");
			afi2=Conexion.CalcularAfinidadFamiliar(n, afi);
			
			sentencia.setInt(10, afi2);
			
			
			System.out.println("\n Aqui el programa muestra el valor de afinidad: "+afi2);
			
			
			
			int rsp=sentencia.executeUpdate();
			
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		String respuesta=teclado.nextLine();
		String si="",no="";
		teclado.nextLine();
		System.out.println("\n Tiene a este contacto en las redes sociales???");
	
		respuesta=teclado.nextLine();
		
		if(respuesta.equals("si")) {
			sql="INSERT INTO redessociales  VALUES (?,?,?,?,?);";
			try {
				PreparedStatement sentencia=conector.prepareStatement(sql);
				System.out.println("Inserte el Id del contacto");
				int id=teclado.nextInt();
				sentencia.setInt(1, id);
				teclado.nextLine();
				System.out.println("\n Inserte Nombre red:");
				String nombreRed1=teclado.nextLine();
				sentencia.setString(2, nombreRed1);
				System.out.println("\n Inserte Nick:");
				String nick1=teclado.nextLine();
				sentencia.setString(3, nick1);									
				System.out.println("\n Inserte Nombre red:");
				String nombreRed2=teclado.nextLine();
				sentencia.setString(4, nombreRed2);								
				System.out.println("\n Inserte Nick:");
				String nick2=teclado.nextLine();
				sentencia.setString(5, nick2);
				
				
				int rsp=sentencia.executeUpdate();
				System.out.println("\n Hemos acabado, contacto añadido!!!");
				
				sentencia.close();
			} catch (Exception e) {
			
				e.printStackTrace();
			}
	}
	


	}
	
	
	public static void buscarContacto() {
		Scanner teclado=new Scanner(System.in);
		System.out.println("Introduce el nombre a buscar");
		
		String nombreBuscar=teclado.nextLine();
		try {
			String sql = "select * from contactos WHERE contactos.Nombre =?";
			PreparedStatement sentencia= conector.prepareStatement (sql);

			sentencia.setString (1, nombreBuscar);
		
		
			 ResultSet rs= sentencia.executeQuery();
			 while (rs.next()) {
					for (int i=1;i<=rs.getMetaData().getColumnCount();i++) {
						System.out.print(rs.getString(i)+"\t");
					}
			 }	
				System.out.println(" ");
			
			sentencia.close();	
		}catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
	}
	
	public static void borrarContacto() {
		Scanner teclado=new Scanner(System.in);
		System.out.println("introduce el id del contacto que queremos eliminar");
		int id=teclado.nextInt();
		String sql="DELETE FROM contactos WHERE contactos.Id = "+id+";"; 
		try {
			
			Statement miStatement = conector.createStatement();
			if(miStatement.executeUpdate(sql)==1) {
				System.out.println("la consulta se ha realizado con éxito");
			}
			miStatement.close();
		}catch (Exception e) {
			System.out.println("noConecta");
			e.printStackTrace();
		}
		
	}
	
	public static void  buscarPorLetra() {
		Scanner teclado=new Scanner(System.in);
		System.out.println("Introduce letra");

		String inicio=teclado.nextLine();
		
		String sql = "select * from contactos WHERE UPPER(contactos.Nombre) LIKE ?";
		try {
			inicio=inicio.toUpperCase();
			PreparedStatement sentencia= conector.prepareStatement (sql);

			sentencia.setString(1,  inicio+"%");
		
		
			 ResultSet rs= sentencia.executeQuery();
			 while (rs.next()) {
					for (int i=1;i<=rs.getMetaData().getColumnCount();i++) {
						System.out.print(rs.getString(i)+"\t");
						
					}
					System.out.println("");
			 }	
			System.out.println(" ");
			
			sentencia.close();
		}catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}    
	}
}