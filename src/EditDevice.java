

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import claases.Device;

/**
 * Servlet implementation class EditDevice
 */
@WebServlet("/EditDevice")
public class EditDevice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String GET_BUTTON = "Get Device Details";
	private static final String GET_BUTTONEDIT = "Edit Device";
	DbConnection db=new DbConnection();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDevice() {
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
		String button = request.getParameter("button");
		
		
		if(GET_BUTTON.equals(button))
		{
			String id = request.getParameter("device_id");
			Device device = db.GetDeviceById(Integer.parseInt(id));
//			ArrayList<String> allLabs= new ArrayList<>();
//			allLabs=db.GetAllLabs();
//			request.setAttribute("labs", allLabs);
//			request.setAttribute("device-id", id);
//			request.setAttribute("device-type", device.getDeviceType());
//			request.setAttribute("user-id", device.getUserId());
			String date = sdf.format(device.getStartDate());
			request.setAttribute("date", date);
//			request.setAttribute("model", device.getModelName());
//			request.setAttribute("status", device.getStatus());
			request.setAttribute("myBean", device);
			address="/EditDeviceForm.jsp";
			
		} else  if(GET_BUTTONEDIT.equals(button)){
			int dId=Integer.parseInt(request.getParameter("device_id"));
			String dType=request.getParameter("device_type");
			int uId=Integer.parseInt(request.getParameter("user_id"));		
			String date=request.getParameter("date");
			String mName=request.getParameter("model_name");
			String status=request.getParameter("status");
			if(db.EditDeviceDetails(dId, dType, uId, date, mName, status)) {   
				request.setAttribute("message", "success");
				address="/EditDeviceForm.jsp";
			}
			else {
				request.setAttribute("message", "failure");
				address="/EditDeviceForm.jsp";
			}
		}
		else {
			int dId=Integer.parseInt(request.getParameter("device_id"));

			db.DeleteDevice(dId);
			request.setAttribute("message", "deleted");
			address="/EditDeviceForm.jsp";
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
