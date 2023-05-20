package validationrules;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;

import customeException.VehicleCustomeException;
import vehicle.Color;
import vehicle.Vehicle;

public class ValidationRules {
	
	public static Vehicle ValidateAll(String chasisNo, String color, double netPrice, String mfgDate, String company,List<Vehicle>vehicles) throws VehicleCustomeException
	{
		checkForDuplicate(chasisNo, vehicles);
		Color Vcolor=ValidateColor(color);
		LocalDate date=parseNvalidateDate(mfgDate);
		return new Vehicle(chasisNo, Vcolor, netPrice, date, company);
		
	}
	
	public static Color ValidateColor(String clr) throws IllegalArgumentException
	{
		return Color.valueOf(clr.toUpperCase());
	}
	
	public static LocalDate parseNvalidateDate(String date) throws DateTimeException,VehicleCustomeException
	{
		LocalDate d1=LocalDate.parse(date);
		
		LocalDate BeginYear=LocalDate.of(LocalDate.now().getYear(), 1, 1);
		
		if(d1.isAfter(BeginYear))
			return d1;
		throw new VehicleCustomeException("The manufacturing date must be in this year");
	}
	//for this have to override the equals method 
	public static void checkForDuplicate(String NewchasiNo,List<Vehicle>vehicles) throws VehicleCustomeException
	{
		Vehicle newVehicle=new Vehicle(NewchasiNo);
		if(vehicles.contains(newVehicle))
			throw new VehicleCustomeException("duplicate chssis number found");
		System.out.println("no duplicate found");
	}

}
