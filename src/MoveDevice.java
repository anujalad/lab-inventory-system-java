

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import claases.Device;

/**
 * Servlet implementation class MoveDevice
 */
@WebServlet("/MoveDevice")
public class MoveDevice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String GET_BUTTON = "Get Device Details";

	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoveDevice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		DbConnection db = new DbConnection();
		db.OpenConnection();
		String button=request.getParameter("button");
		String address;
		if(GET_BUTTON.equals(button))
		{	     
				  String id=request.getParameter("device_id");
				  
				  
				 Device device =db.GetDeviceById(Integer.parseInt(id));
		//		  request.setAttribute("device_id", id);
		//		  request.setAttribute("lab_id", device.getLabId());
				  int labId=device.getLabId();
				  String rs= db.GetLabName(labId);
				  request.setAttribute("labName", rs);
				  request.setAttribute("myBean", device);
				  ArrayList<String> allLabs = db.GetAllLabs();
					request.setAttribute("labs", allLabs);
		  
			
		} else {
			ArrayList<String> allLabs = db.GetAllLabs();
			request.setAttribute("labs", allLabs);
			int deviceId=Integer.parseInt(request.getParameter("device_id"));
			String fromlabname=request.getParameter("labs"); 
			String date=request.getParameter("date");
			String tolabname=request.getParameter("lab_selection");
			int newLabId = db.GetLabID(tolabname);
			
			if(db.MoveDevice(deviceId, fromlabname, date, tolabname))
			{
				request.setAttribute("message", "success");
			}
			else { 
				request.setAttribute("message", "failure");
			}
			db.UpdateLabId(deviceId, newLabId);
		}
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("/MoveDeviceForm.jsp");
		dispatcher.forward(request, response);
		
	    
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
