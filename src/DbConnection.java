import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import claases.Device;

public class DbConnection {
Connection connection;
Statement st;
ResultSet rs;
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

public Connection OpenConnection() {
	String url = "jdbc:mysql://localhost:3306/project";
        try {
        	Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, "root", "");
			st = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        System.out.println("Connected");
        return connection;
}	

public void CloseConnection()
{
	try {
	connection.close();
	st.close();
    } catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
    }
}


public boolean AdminAuthenticate(String username, String password)
{
	String sql="select * from user_login where user_name='"+username+"' and password='"+password+"'";
	System.out.println(sql);
	try {
		rs=st.executeQuery(sql);
		while(rs.next())
		{
			return true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}

public ArrayList<Device> SearchDevices(int id)
{ 
	ArrayList<Device> devices=new ArrayList<>();
	
	String sql="select * from device_details where lab_id=" + id;
	try {
		rs=st.executeQuery(sql);
		while(rs.next())
		{
			Device device = new Device();
			device.setDeviceId(rs.getInt(1));
			//device.setDeviceTypeId(rs.getInt(2));
			device.setDeviceType(rs.getString(2));
			device.setLabId(rs.getInt(3));
			device.setUserId(rs.getInt(4));
			String startDate = rs.getString(5);
			Date start = sdf.parse(startDate);
			device.setStartDate(start);
//			String endDate = rs.getString(6);
//			Date end = sdf.parse(endDate);
//			device.setEndDate(end);
			device.setModelName(rs.getString(6));
			device.setStatus(rs.getString(7));
			
			devices.add(device);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (ParseException e) {
		e.printStackTrace();
	}
	return devices;
}




public boolean AddNewDevice(int dId, String dType, int labId, int uId,String start,String mName,String status) 
{   
//	Date startDate=sdf.parse(start);
//	Date endDate=sdf.parse(end);
	int res = 0;
	
	String sql= "Insert into device_details values ("+dId+" ,'"+dType+"',"+ labId+","+uId+",'"+start+"','"+mName+"','"+status+"')";
	
	try {
		res = st.executeUpdate(sql);
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return res>0;
}


public boolean EditDeviceDetails(int device_id,  String device_type, int user_id,
									String date_placed, String model_name, String status)
{
	int res = 0;
	String sql="UPDATE device_details SET   device_type = '" + device_type + 
										   "', user_id = " + user_id +
										   ", date_placed = '" + date_placed +
										   "', model_name = '"+ model_name+ 
										   "', status = '"+ status+
										   "' WHERE device_id = " + device_id;
	try {
		res = st.executeUpdate(sql);		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return res > 0;
}

public int GetLabID(String labName) {
	
	String sql="select * from lab where lab_name='"+labName+"'";
	try {
		rs=st.executeQuery(sql);
	while (rs.next())
	{
		return (rs.getInt("lab_id"));
	}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
}

public Device GetDeviceById(int id) 
{
	Device device = new Device();
	String sql = "select * from device_details where device_id = " + id;
	try {
		rs = st.executeQuery(sql);
		while(rs.next()) {
			
			device.setDeviceId(id);
			device.setLabId(Integer.parseInt(rs.getString("lab_id")));
			device.setDeviceType(rs.getString("device_type"));
			Date start = sdf.parse(rs.getString("date_placed"));
			device.setStartDate(start);
			device.setUserId(rs.getInt("user_id"));
			device.setModelName(rs.getString("model_name"));
			device.setStatus(rs.getString("status"));
			
		}
	} catch (SQLException | ParseException e) {
		e.printStackTrace();
	}
	return device;
}
public String GetLabName(int id)
{  	String name=null;	
	String sql="Select lab_name from lab where  lab_id="+id;
		try {
			rs=st.executeQuery(sql);
			while(rs.next())
			{
				name=rs.getString("lab_name");
				return name;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return name;	
}

public ArrayList<String> GetAllLabs()
{ 
	ArrayList<String> all_labs=new ArrayList<>();
	String sql="select * from lab";
	try {
		rs = st.executeQuery(sql);
		
		while(rs.next())
		{
			all_labs.add(rs.getString("lab_name"));
			
		}
	    } catch (SQLException e) {
	    	e.printStackTrace();
	     }
	
		return all_labs;
	}


public boolean AddLab(int labId,String labName )
{
	String sql="insert into lab values ("+labId+", '"+labName+"')";
	try {
		st.executeUpdate(sql);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return true;	
}

public boolean DeleteDevice(int id)
{  
	String sql=" delete  from device_details where device_id="+id;
	 try {
		st.executeUpdate(sql);
		return true;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return false;
}

public boolean MoveDevice(int deviceId, String fromlabname, String date, String tolabname)
	{  	String str=date;
	int res = 0;
		Date d=null;
	  	try {
		 d=sdf.parse(str);
	} 	catch (ParseException e) {
		e.printStackTrace();
	}
		String sql="insert into move_details (device_id, lab_name, move_date, move_location) values("+deviceId+", '"+fromlabname+"','"+date+"','"+tolabname+"')";
		try {
			res = st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res>0;
}

public boolean UpdateLabId(int deviceId, int newLabId) {
	String sql = "update device_details set lab_id = " + newLabId + " where device_id = " + deviceId;
	int res = 0;
	try {
		res = st.executeUpdate(sql);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return res>0;
}


public static void main(String[] args) 
{
	DbConnection db = new DbConnection();
	db.OpenConnection();
	
	if(db.MoveDevice(1, "Lab1", "2016-02-02", "Lab3"))
		System.out.println("Worked");
	
}


}



