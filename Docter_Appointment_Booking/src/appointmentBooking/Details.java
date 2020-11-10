package appointmentBooking;

import java.util.List;
import java.util.Scanner;

public class Details
{
	static int numberOfDoctors = 0;
	public void getDoctorDetails(List<Doctor> doctors)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number Of doctors:");
		numberOfDoctors=sc.nextInt();
		for(int index = 1;index <= numberOfDoctors;index++)
		{
			Doctor doctor=new Doctor();
			System.out.println("Enter Doctor Name: \nAvailability -> Pediatretion:[A / B / C] , ENT:[D / E] , DT:[F / G]");
			String name = sc.next();
			doctor.doctorName=name;
			System.out.println("Enter Type of Doctor Pediatretion / ENT / DT");
			String type=sc.next();
			doctor.doctorType=type;
			System.out.println("Enter the day in which Doctor will be available");
			String day=sc.next();
			doctor.doctorAvailableDay=day;
			System.out.println("Enter the number of slots,the doctor will be available");
			int slotNumber=sc.nextInt();
			for(int start = 1;start <= slotNumber;start++) 
			{
				doctor.availabilty.put(sc.next(),false);
			}			
			doctors.add(doctor);
		}
	}
	public boolean getPatientDetails(List<Doctor> doctors,List<String> bookingHistory)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Patient's Name:");
		String patientName = sc.next();
        System.out.println("Enter the speciality of the doctor:");
    	String doctorType = sc.next();
	    System.out.println("Enter appointment day: "); 
 	    String day = sc.next();
	    System.out.println("Time of appointment: [HH:MM] ");
	    String time = sc.next();
	    Appointment appointment = new Appointment();
	    if(appointment.bookAppointemnt(doctors,patientName,doctorType,day,time,numberOfDoctors,bookingHistory))
	    	return true;
	    return false;
	}
}
