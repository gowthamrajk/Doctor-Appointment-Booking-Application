package appointmentBooking;

public class Admin 
{
	private String adminID = "ADMIN1234";
	private String password = "admin@123";
	
	Admin(String adminId,String password)
	{
		this.adminID = adminId;
		this.password = password;
	}
	
	public boolean validateAdmin(String adminId,String password)
	{
		if(this.adminID.contentEquals(adminId)&&this.password.equals(password))
			return true;
		else
			return false;
	}
}
