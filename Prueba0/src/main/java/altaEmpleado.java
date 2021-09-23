

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import martes.EmpleadoDAO;
import martes.EmpleadoVO;


/**
 * Servlet implementation class altaEmpleado
 */
@WebServlet("/altaEmpleado")
public class altaEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public altaEmpleado() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre=request.getParameter("nombre");
		String password=request.getParameter("pass");
		String email=request.getParameter("email");
		String zona=request.getParameter("zona");
		
		EmpleadoVO empleado= new EmpleadoVO (0,nombre,password,email,zona);
		EmpleadoDAO.guardarEmpleado(empleado);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
