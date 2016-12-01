

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("<h1>update student info</h1>");

		int stuId = Integer.parseInt(request.getParameter("stu_id"));
	
		Student stu = StudentSQL.getStudentById(stuId);
		pw.print("<head>");
		pw.print("<link href='css/bootstrap.min.css' rel='stylesheet'>");
		pw.print("</head>");
		pw.print("<form action='UpdateServlet2' method='post'");
		pw.print("<table>");
		pw.print("<tr><td></td><td><input name='stu_id' value='" + stu.getId() + "'/></td></tr>");
		pw.print("<tr><td>Name</td><td><input name='stu_name' type='text' value='" + stu.getName() + "'/></td></tr>");
		pw.print("<tr><td>Password</td><td><input name='stu_password' type='password' value='" + stu.getPassword() + "'/></td></tr>");
		pw.print("<tr><td>Email</td><td><input name='stu_email' type='email' value='" + stu.getEmail() + "'/></td></tr>");
		pw.print("<tr><td>Country</td><td><input name='stu_country' type='text' value='" + stu.getCountry() + "'/></td></tr>");
		pw.print("</td></tr>");
		pw.print("<tr><td colspan='2'><input type='submit' value='submit'/></td></tr>");
		pw.print("</table>");
		pw.print("</form>");
		pw.print("</body");
	}
}
