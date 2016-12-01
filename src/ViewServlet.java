

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ViewServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		pw.print("<head>");
		pw.print("<link href='css/bootstrap.min.css' rel='stylesheet'>");
		pw.print("</head>");
		pw.print("<body>");
		pw.println("<a href='index.html' class='btn btn-info' role='button'>Add Student</a>");
		pw.println("<h1>Student Table</h1>");
		List<Student> list = StudentSQL.getStudents();
		pw.print("<table border='1' width='100%'>");
		pw.print("<tr><th>ID</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
		for(Student stu: list){
			int stuId = stu.getId();
			pw.print("<tr><td>" + stuId + "</td><td>" + stu.getName() + "</td><td>" + stu.getPassword() + "</td><td>"
					+ stu.getEmail() + "</td><td>" + stu.getCountry() + "</td><td><a href='UpdateServlet?stu_id=" + stuId 
					+ "'>edit</a></td> <td><a href='DeleteServlet?stu_id=" + stuId + "'>delete</a></td></tr>");
		}
		
		pw.print("</table>");
		pw.print("</body>");
	}


}
