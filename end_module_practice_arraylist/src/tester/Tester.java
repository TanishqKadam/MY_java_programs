package tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import static validationrules.ValidationRules.ValidateColor;
import customeException.VehicleCustomeException;
import custome_ordering.PriceComparator;

import static validationrules.ValidationRules.ValidateAll;
import static ioutils.Ioutils.restoreDetails;
import static ioutils.Ioutils.Storedetails; 
import vehicle.Color;
import vehicle.Vehicle;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Scanner sc=new Scanner(System.in))
		{
			System.out.println("enter file name");
			String filename=sc.next();
			List<Vehicle>vehicles=restoreDetails(filename);
		//List<Vehicle>vehicles=new ArrayList<>();//empty array list 
		boolean exit=false;
		while(!exit)
		{
			System.out.println("1.add vehicle to the showroom\n2.display the vehicles inside the showroom\n3.get specific vehicle details"
					+ "4.apply discount\n5.romove the vehicle\n6.delete vehicle by color\n"
					+ "7.sort the vehicles on the basis of chasis number\n"
					+ "8.sort the vehicle as per the price\n0.Store details/exit");
			
			System.out.println("enter choice");
			try
			{
				switch (sc.nextInt())
				{
				case 1:
					System.out.println("adding vehicle into the showroom");
					System.out.println("chasisNo,color,netPrice,mfgDate,company");
					Vehicle v=ValidateAll(sc.next(), sc.next(), sc.nextDouble(), sc.next(), sc.next(), vehicles);
					vehicles.add(v);
					System.out.println("vehicle is added");
					break;
				case 2:
					System.out.println("show the vehicle in showroom");
					for(Vehicle v1:vehicles)
					{
						System.out.println(v1);
					}
					break;
					case 3:
						System.out.println("enter the chasis number");
						Vehicle vehicle=new Vehicle(sc.next());
						int index=vehicles.indexOf(vehicle);//give you the index of that matching chasis number
						if(index==-1)//if not fount then it will return -1
							throw new VehicleCustomeException("enter the valid chasis number");
						  System.out.println(vehicles.get(index));//this will give you the value of that index number
						break;
					case 4:
						System.out.println("enter date and discout amount");
						LocalDate date=LocalDate.parse(sc.next());
						double discount=sc.nextDouble();
						for(Vehicle V:vehicles)
						{
							if(V.getMfgDate().isBefore(date))
								V.setNetPrice(V.getNetPrice()-discount);
						}
						System.out.println("discount applied");
						break;
					case 5:
						System.out.println("enter chasis number to delete the vehicle");
						Vehicle V1=new Vehicle(sc.next());
						int Index=vehicles.indexOf(V1);
						vehicles.remove(Index);
						System.out.println("vehcle removed from showroom");
						break;
					case 6:
						System.out.println("enter the colour to remove");
						//Color Vcolor=Color.valueOf(sc.next().toUpperCase());
						//the removal is based on non primary key so if we try to remove it 
						// it will give you concurrent modification exception
						//so we have to use the iterator
						Color Vcolor=ValidateColor(sc.next());
						Iterator<Vehicle> itr=vehicles.iterator();
						while(itr.hasNext())
						if(itr.next().getColor()==Vcolor)
							itr.remove();
						break;
//						for(Vehicle v1:vehicles)
//						{
//						if(v1.getColor()==Vcolor);
//						vehicles.remove(v1);	
//						}
						
//						for(int i=0;i<vehicles.size();i++)
//						{
//							//int i=0;
//							//if(i<vehicles.size())					
//							int index1=vehicles.indexOf(Vcolor);
//							vehicles.remove(index1);
//						}
						
					case 7:
						//sorting on the basis of chasis number
						//primary key therefor use natural ordering
						//have to use the comparable<T> interface
						//and have to override the compareTo() method
						Collections.sort(vehicles);
						break;
					case 8:
						//sorting based on non-primary key 
						//have to use comaprator<T>'s compare method 
						//for that we have to create seperate class
						Collections.sort(vehicles, new PriceComparator());
						break;					
				case 0:
					System.out.println("Storing the details");
					//System.out.println("enter the file name");
					Storedetails(filename, vehicles);
					exit=true;
					break;
				}//end of switch case
				
			}catch (Exception e) {
				//e.printStackTrace();
				e.printStackTrace();
				sc.nextLine();
			}//end of try catch block
		}//end of while
		}//try with resources 

	}

}
