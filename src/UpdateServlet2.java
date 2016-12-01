

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateServlet2")
public class UpdateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     public UpdateServlet2() {
        super();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		int stuId = Integer.parseInt(request.getParameter("stu_id"));
		String name = request.getParameter("stu_name");
		String password = request.getParameter("stu_password");
		String email = request.getParameter("stu_email");
		String country = request.getParameter("stu_country");
		
		Student stu = new Student(name, email, password, country);
		stu.setId(stuId);
			
		
		int num = StudentSQL.update(stu);
		if(num > 0 ){ 
			pw.println("<h2>update student successfuly</h2>");
			response.sendRedirect("ViewServlet");
		}else{
			pw.println("<h2>could not update student</h2>");
		}
		
    }


}
