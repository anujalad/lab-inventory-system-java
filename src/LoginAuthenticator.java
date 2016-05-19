

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginAuthenticator
 */
@WebServlet("/LoginAuthenticator")
public class LoginAuthenticator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	DbConnection db=new DbConnection();
    public LoginAuthenticator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String address;
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		db.OpenConnection();
		if(db.AdminAuthenticate(username, password))
		{
			request.setAttribute("user_name", username);
			ArrayList<String> allLabs = db.GetAllLabs();
			request.setAttribute("labs", allLabs);
			address="/AdminHome.jsp";
		}
		else { 
			request.setAttribute("ErrorMsg", "Error");
			address="/index.jsp";
			}
		
		RequestDispatcher dispatcher= request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
		db.CloseConnection();
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
