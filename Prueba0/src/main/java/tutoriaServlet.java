

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class tutoriaServlet
 */
@WebServlet("/tutoria")
public class tutoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public tutoriaServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String nombre=request.getParameter("nombre");
		String profesor=request.getParameter("profesor");
		String dia=request.getParameter("dia");
		String hora=request.getParameter("hora");
		String asunto=request.getParameter("asunto");
		String [] arrayMateriales=request.getParameterValues("material");
		//String material2=request.getParameter("material2");
		//String material3=request.getParameter("material3");
		
		response.setContentType("text/html");
		PrintWriter salida = response.getWriter();
		salida.println("Datos de la tutoria");
		salida.println("<br>");
		salida.println("Nombre: "+nombre);
		salida.println("<br>");
		salida.println("Profesor: "+profesor);
		salida.println("<br>");
		salida.println("Dia: "+dia);
		salida.println("<br>");
		salida.println("Hora: "+hora);
		salida.println("<br>");
		salida.println("Asunto: "+asunto);
		salida.println("<br>");
		String materiales="";
		for(int i=0;i<arrayMateriales.length;i++) {
			materiales+= arrayMateriales[i]+" ";
		}
		salida.println("Material: " +materiales);
		/*String materiales="";
		if(null!=material1) {
			materiales=material1;
		}
		if(null!=material2) {
			materiales += " "+material2;
		}
		if(null!=material3) {
			materiales += " "+material3;
		}
		salida.println("Material: "+materiales);
		*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
