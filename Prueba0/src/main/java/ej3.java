

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ej3
 */
@WebServlet("/ej3")
public class ej3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ej3() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre=request.getParameter("nombre");
		String fav_language=request.getParameter("fav_language");
		String ide1=request.getParameter("ide1");
		String ide2=request.getParameter("ide2");
		String ide3=request.getParameter("ide3");
		String [] arrayEstudio=request.getParameterValues("estudio");
		
		response.setContentType("text/html");
		PrintWriter salida = response.getWriter();
		
		/**salida.println("Datos del Servlet");
		salida.println("<br>");
		salida.println("Nombre: "+nombre);
		salida.println("<br>");
		salida.println("Lenguaje Favorito: "+fav_language);
		salida.println("<br>");
		
		
		String ides="";
		if(null!=ide1) {
			ides=ide1;
		}
		if(null!=ide2) {
			ides += " "+ide2;
		}
		if(null!=ide3) {
			ides += " "+ide3;
		}
		salida.println("IDE: "+ides);
		
		
		String estudio="";
		for(int i=0;i<arrayEstudio.length;i++) {
			estudio+= arrayEstudio[i]+" ";
		}
		salida.println("<br>");
		salida.println("Lugar de trabajo: " +estudio);
		**/
		
		
		String mensajeError="";
		
		if("".equals(nombre)) {
			mensajeError+="Error, rellena el campo nombre!";
		}
		
		
		if(ide1==null && ide2==null && ide3==null) {
			mensajeError+="Error, rellena el campo ide!<br>";		
		}
		
		
		if(fav_language==null) {
			mensajeError+="Error, rellena el campo lenguaje favorito!<br>";
		}
		
		if(arrayEstudio==null) {
			mensajeError+="Error, rellena el campo lugar de trabajo!<br>";			
		}
		
		if(!"".equals(mensajeError)) {
			salida.println(mensajeError);
			RequestDispatcher rd = request.getRequestDispatcher("ejercicio3.html");
			rd.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
