package appointmentBooking;

import java.util.Map;
import java.util.LinkedHashMap;

public class Doctor
{
	public String doctorName;
	public String doctorType;
	public String doctorAvailableDay;
	public Map<String,Boolean> availabilty=new LinkedHashMap<>();
}
