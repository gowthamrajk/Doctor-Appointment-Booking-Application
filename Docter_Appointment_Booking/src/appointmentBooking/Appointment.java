package appointmentBooking;

import java.util.List;
import java.util.Map;

public class Appointment
{
	public boolean bookAppointemnt(List<Doctor> doctors,String patientName,String doctorType,String day,String time,int numberOfDoctors,List<String> bookingHistory)
	{
		if(checkAvailability(doctors,patientName,doctorType,day,time,numberOfDoctors,bookingHistory))
			return true;
		return false;
	}
	
	public boolean checkAvailability(List<Doctor> doctors,String patientName,String doctorType,String day,String time,int numberOfDoctors,List<String> bookingHistory)
	{
		int flag=0;
		OUTER:for(int index = 0;index < numberOfDoctors;index++) 
		{
			 Doctor doc=doctors.get(index);
		     if(doc.doctorAvailableDay.equalsIgnoreCase(day)&&doc.doctorType.equalsIgnoreCase(doctorType)) 
		     {
				 for(Map.Entry<String, Boolean> m:doc.availabilty.entrySet())
			     {
					 if(time.equalsIgnoreCase(m.getKey())&&(m.getValue()==false)) 
					 {
						doc.availabilty.put(m.getKey(),true);
						String s="Appointment is Booked with the doctor "+doc.doctorName+" on "+day+" at "+time+" PM";
						bookingHistory.add(s);
						System.out.println(s);
						flag=1;
						break OUTER;
					 }
				 }
			  }			
		   }
		   if(flag==0)
		   {
		       System.out.println("Doctor is not available at that time.Kindly check for another slot");
		       return false;
		   }
		   return true;
	}
}
