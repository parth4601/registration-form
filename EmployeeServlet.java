import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmployeeServlet() 
    {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ,NumberFormatException
	{
		
		Employee empObj= new Employee();
		empObj.setEmpid(Integer.parseInt(request.getParameter("empid")));
		empObj.setEmpFirstName(request.getParameter("empFirstName"));
		empObj.setEmpMdName(request.getParameter("empMdName"));
		empObj.setEmpLsName(request.getParameter("empLsName"));
		empObj.setEmpAge(Integer.parseInt(request.getParameter("empAge")));
		empObj.setEmpDept(request.getParameter("empDept"));
		empObj.setEmpAddr(request.getParameter("empAddr"));
		
		EmployeeDAO empDAOObj=new EmployeeDAO();
		if(empDAOObj.insertRecord(empObj))
		{
			response.sendRedirect("Success.html");
		}
		else
		{
			response.sendRedirect("Retry.html");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}