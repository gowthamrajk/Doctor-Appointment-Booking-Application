package appointmentBooking;

import java.util.Scanner;
import java.util.List;
import java.util.Map;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Booking 
{
	static int count = 0;
	static Appointment appointment = new Appointment();
	static Details details = new Details();
	static List<Doctor> doctors=new LinkedList<>();
	static List<String> bookingHistory = new ArrayList<>();
	static Map<String,Integer> doctorTimiSlot = new LinkedHashMap<>();
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to Online Booking Portal.. Have a healthy Life !!! ");
		OUTER:while(true)
		{
		System.out.println("Choose Your Option: A)Admin B)Patient C)BookingHistory");
		char adminOrPatient = sc.next().charAt(0);
		switch(adminOrPatient)
		{
		case 'A':
		{
			System.out.println("Enter Admin ID:");
			String adminId = sc.next();
			System.out.println("Enter Admin Password:");
			String adminPassword = sc.next();
			Admin admin=new Admin(adminId,adminPassword);
			if(admin.validateAdmin(adminId,adminPassword))
			{
				System.out.println("Admin Validated Successfully");
				System.out.println("Please Enter the Details of Doctors Available!!!");
				details.getDoctorDetails(doctors);
			}
			else 
				System.out.println("Admin Credentials are not valid");
		}
		case 'B':
		{
			INNER:while(true)
			{
			    System.out.println("Do you want to book and Appointment? Y / N");
			    char entryOption = sc.next().charAt(0);
			    count = 0;
			    if(entryOption == 'y'||entryOption == 'Y')
			    {
			    	System.out.println("Enter number of Bookings to be done: ");
			    	int numberofBookings = sc.nextInt();
			    	while(numberofBookings-- > 0)
			    	{
			    		System.out.println("Booking Number: "+(count+1));
			    		if(addBooking(sc)==false)
			    		continue INNER;		
			    		count++;
			    	}
			    }
			    else if(entryOption == 'N'||entryOption == 'n')
			    {
				    System.out.println("Thanks for your service!!!. Get well soon..");
				    System.out.println("Your Booking History is Listed Below\n");
				    BookingHistory();
				    break INNER;
			    }
			    else
			    {
			        System.out.println("Your Option is INVALID, Please Enter a valid Option!!!");
			        continue INNER;
			    }
			}
			break OUTER;
		}
		case 'C':
		{
			BookingHistory();
			break OUTER;
		}
		default:
		{
			System.out.println("Your Option is INVALID, Please Enter a valid Option!!!");
			continue OUTER;
		}
		}
		}
	}
	
	public static boolean addBooking(Scanner sc)
	{
		if(details.getPatientDetails(doctors,bookingHistory))
			return true;
		return false;
	}
	
	public static void BookingHistory()
	{
		count = 0;
		for(String history:bookingHistory)
		{
			System.out.println("Booking "+(count+1)+": "+history);
			count++;
		}
	}
}
