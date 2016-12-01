

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public SaveServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String name = request.getParameter("stu_name");
		String password = request.getParameter("stu_password");
		String email = request.getParameter("stu_email");
		String country = request.getParameter("stu_country");
	
		int num  = StudentSQL.save(new Student(name, email, password, country));
		
		if(num > 0 ){
			pw.println("<h2>save student successfuly</h2>");
			request.getRequestDispatcher("index.html").include(request, response);
		}else{
			pw.println("student did not save successfuly");
		}
		
		
	}

}
