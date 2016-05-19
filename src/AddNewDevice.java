

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddNewDevice
 */
@WebServlet("/AddNewDevice")
public class AddNewDevice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DbConnection db=new DbConnection();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewDevice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.getWriter().append("Served at: ").append(request.getContextPath());
		db.OpenConnection();
		String address;
		int dId=Integer.parseInt(request.getParameter("device_id"));
		String dType=request.getParameter("device_type");
		String labName=request.getParameter("lab_selection");
		int labId = db.GetLabID(labName);
		int uId=Integer.parseInt(request.getParameter("user_id"));		
		String date=request.getParameter("date");
		String mName=request.getParameter("model_name");
		String status=request.getParameter("status");		
		ArrayList<String> allLabs = db.GetAllLabs();
		request.setAttribute("labs", allLabs);
		
	
		if(db.AddNewDevice(dId, dType, labId, uId, date, mName, status))
		{   request.setAttribute("message", "success");
			address="/AddDeviceForm.jsp";
			}
			else
				{request.setAttribute("message", "failure");
				address="/AddDeviceForm.jsp";
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
