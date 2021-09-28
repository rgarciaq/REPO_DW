package martes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class EmpleadoDAO {
	
	private static String driver = "com.mysql.jdbc.Driver";
	public static Connection obtenerConexion() {
		Connection conexion=null;
		
		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bateriasBD","root", "admin1234");
		}catch(Exception e) {
			System.out.println("error 1");
		}
		return conexion;
	}
	
	public static int guardarEmpleado(EmpleadoVO empleado) {
		
		int estado = 0;
		
		try {
			Connection conexion = EmpleadoDAO.obtenerConexion();
			PreparedStatement ps= conexion.prepareStatement("INSERT INTO empleados(nombre, pass, email, zona) VALUES(?,?,?,?)");
			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getPassword());
			ps.setString(3, empleado.getEmail());
			ps.setString(4, empleado.getZona());
			
			estado=ps.executeUpdate();
			conexion.close();
			
		}catch(Exception e){
			System.out.println("error");
		}
		
		return estado;
	}
	
	public static List<EmpleadoVO> obtenerEmpledos(){
		List<EmpleadoVO> listaEmpleados = new ArrayList<EmpleadoVO>();
		try {
			Connection conexion = EmpleadoDAO.obtenerConexion();
			PreparedStatement ps= conexion.prepareStatement("SELECT * FROM empleados");
			ResultSet resultado=ps.executeQuery();
			
			while(resultado.next()) {
				EmpleadoVO empleado = new EmpleadoVO();
				empleado.setId(resultado.getInt(1));
				empleado.setNombre(resultado.getString(2));
				empleado.setPassword(resultado.getString(3));
				empleado.setEmail(resultado.getString(4));
				empleado.setZona(resultado.getString(5));
				listaEmpleados.add(empleado);
				
			}
	}catch(Exception e){
		System.out.println("error");
		
	}
		
		return listaEmpleados;
	}
	}
