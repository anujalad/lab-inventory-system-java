package claases;

import java.util.Date;

public class Device {
private int deviceId;
//private int deviceTypeId;
private String device_type;
//private int serialNum;
private int labId;
private int userId;
private Date startDate;
//private Date endDate;
private String modelName;
private String status;


public Device()
{
}

public Device(int deviceId,  String device_type, int labId, int userId, Date startDate, Date endDate,
		String modelName, String status) {
	super();
	this.deviceId = deviceId;
	//this.deviceTypeId = deviceTypeId;
	this.device_type=device_type;
	this.labId = labId;
	this.userId = userId;
	this.startDate = startDate;
	//this.endDate = endDate;
	this.modelName = modelName;
	this.status = status;
}


public int getDeviceId() {
	return deviceId;
}
public void setDeviceId(int deviceId) {
	this.deviceId = deviceId;
}
//public int getDeviceTypeId() {
//	return deviceTypeId;
//}
//public void setDeviceTypeId(int deviceTypeId) {
//	this.deviceTypeId = deviceTypeId;
//}
public String getDeviceType() {
	return device_type;
}
public void setDeviceType(String device_type) {
	this.device_type = device_type;
}
public int getLabId() {
	return labId;
}
public void setLabId(int labId) {
	this.labId = labId;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public Date getStartDate() {
	return startDate;
}
public void setStartDate(Date string) {
	this.startDate = string;
}
//public Date getEndDate() {
//	return endDate;
//}
//public void setEndDate(Date endDate) {
//	this.endDate = endDate;
//}
public String getModelName() {
	return modelName;
}
public void setModelName(String modelName) {
	this.modelName = modelName;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
	
	
	
}
