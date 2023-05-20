package ioutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import vehicle.Vehicle;

public interface Ioutils {
	
	static void Storedetails(String filename,List<Vehicle>vehicles) throws FileNotFoundException, IOException
	{
		try(ObjectOutputStream out=(new ObjectOutputStream(new FileOutputStream(filename))))
		{
			out.writeObject(vehicles);
		}
	}
	
	static List<Vehicle> restoreDetails(String filename)
	{
		try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(filename)))
		{
			return (List<Vehicle>) in.readObject();
		}catch (Exception e) {
			System.out.println("file not found");
			return new ArrayList<>();
		}
	}

}
