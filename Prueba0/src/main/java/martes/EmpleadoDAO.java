package martes;
import java.sql.Connection;
import java.sql.DriverManager;

public class EmpleadoDAO {
	
	private static String 
	public static Connection obtenerConexion() {
		Connection conexion=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bateriasBD","root", "admin1234");
		}catch(Exception e) {
			
		}
		return conexion;
	}
	
	public static int guardarEmpleado(String nombre, String pass, String email, String zona) {
		
		int estado = 0;
		
		try {
			Connection conexion = EmpleadoDAO.obtenerConexion();
			PrepareStatement ps= conexion.prepareStatement("INSERT INTO empleados(nombre, password, email, zona)");
			ps.setString(1, empleado.getNombre());
			ps.setString(1, empleado.getPassword());
			ps.setString(1, empleado.getEmail());
			ps.setString(1, empleado.getZona());
			
			estado=ps.executeUpdate();
			conexion.close();
			
		}catch(Exception e){
			System.out.println("error");
		}
		
		return estado;
	}

}
