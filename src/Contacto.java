
public abstract class Contacto {
	int id;
	String nombre;
	String apellidos;
	String telefono;
	String fecha_nacimiento;
	String origen;
	private int cod=1;
	private static int codigo;

	public Contacto(String n,String a, String t, String f) {
		this.nombre=n;
		this.apellidos=a;
		this.telefono=t;
		this.fecha_nacimiento=f;
		this.cod=codigo;
		codigo++;
	}

	public abstract int CalcularAfinidad(String origen,int valor);
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public static int getCodigo() {
		return codigo;
	}

	public static void setCodigo(int codigo) {
		Contacto.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Contacto [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono
				+ ", fecha_nacimiento=" + fecha_nacimiento + ", cod=" + cod + "]";
	}
	
	
}
