

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public DeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		int stuId = Integer.parseInt(request.getParameter("stu_id"));
		int result = StudentSQL.delete(stuId);
		if(result > 0){
			pw.println("<h2>remove student successfuly</h2>");
			response.sendRedirect("ViewServlet");
		}else{
			pw.println("<h2>could not remove student</h2>");
		}
	}


}
