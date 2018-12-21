package edu.dmacc.coma502;

public class RecordedHours {
	private String employeeId;
	private double hoursWorked;
	public RecordedHours(String employeeId, double hoursWorked) {
		this.employeeId = employeeId;
		this.hoursWorked = hoursWorked;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public double getHoursWorked() {
		return hoursWorked;
	}
	
	
}
