import java.util.ArrayList; // Import ArrayList Library
import java.util.Date;	// Import Date Library
import java.text.SimpleDateFormat; // Import Date Format Library
/* Name: Jonathan Fink  
Assignment: Project 5
Analysis: 
This program was created as a way for a Car Dealership to manage and view Inventory and Staff.
The program allows the storage of inventory of cars, List of Sales Reps, and Manager in charge of Dealership. 
The program will also print out the Sales Rep who earned the highest Bonus from sales. The program uses
OOP by calling on Methods and includes functionality of Super and Sub Classes
*/
//Create Dealership_Project Class (Main Class)
public class Dealership_Project{
// Create ArrayList for Sales Team, and Car Inventory, and Manager Variable
	 static ArrayList <SalesPerson> sales_team_staff;
	 static ArrayList <Car> car_inventory;
	 Manager manager;
	 
	//Create Dealership Method and associate a Manager
	 public Dealership_Project(Manager manager) {
		this.manager = manager;
		car_inventory = new ArrayList<Car>();
		sales_team_staff = new ArrayList<SalesPerson>();
	 }
	 
	 //Create Add Car Method
	 public void addCar(Car aCar)
	 {
		 car_inventory.add(aCar);
	 
	 }
	 //Create Add SalesPerson Method 
	 public void addSalesPerson(SalesPerson s)
	 {
		 sales_team_staff.add(s);
	 
	 }
	 //Create Remove SalesPerson Method 
	 public void removeSalesPerson(SalesPerson s)
	 {
		 sales_team_staff.remove(s);
	 
	 }
	 //Create Car Sold Method 
	 public void carSold (SalesPerson s, Car c) {
		 if(car_inventory.contains(c))

	       {
		//When car is sold: Get the Price of the Car, Assign Bonus to Sales Rep who Sold Car, 
		//Remove Sold Car from Inventory
	           double amt = c.getPrice() * 0.05;

	           s.setBonus(s.getBonus() + amt );

	           removeCar(c); //remove the car once sold

	       }
	 
	 }
	 //Create Remove Car Method 
	 public void removeCar( Car aCar)
	 {
		 car_inventory.remove(aCar);
	 
	 }
	 //Create Person of the Month Method 
	 public SalesPerson getPersonOfTheMonth() {
		 double max = 0;
		 // Function for calling on the SalesPerson who gets the highest bonus. if bonus exceeds last max bonus, replace bonus
		 SalesPerson stemp = null;
		 for (SalesPerson s: sales_team_staff) {
			 if (s.getBonus()>max) {
				 stemp = s;
				 max = (s.getBonus());
			 }
		 }
		 //Return results
	 return stemp;
	 }
	 
	//Return results as String and append results for Manager Class, SalesPerson Class, and Car Class
	 public String toString()
	 {
		 StringBuilder str=new StringBuilder();
		   	str.append("Manager:");
		   	str.append(this.manager+"\n");//appending Manager 
		   	str.append("\n");
		   	str.append("Sales Reps:\n");
		   	for(SalesPerson s : sales_team_staff){
		   		str.append(s.toString()); //Calling the toString() method of the SalesPerson class
		   		
		   	}
		   	str.append("\n");
		   	str.append("Car Inventory:\n");
		   	for(Car c : car_inventory){
		   		str.append(c.toString());//Calling the toString() method of the Car class
		   	}
		   	
		      //Return Results
		   	return str.toString();
	 
	 }
	 
	 

	 //Create SubClass SalesPerson Class and extend the attributes of the Manager Class to SalesPerson
   static class SalesPerson extends Manager {
	 //Add private class variable Bonus since SalesPerson already has the other fields from Manager Class
	private double Bonus;

	
	SalesPerson() {};
	//Create SalesPerson Method and Create Constructors
	public SalesPerson (String first_Name, String last_Name, String address, Date Date_Of_Hiring, double Bonus){
		//Grab First Name, Last Name, Address, and Date of Hire methods from Manager Class
		super (first_Name, last_Name, address, Date_Of_Hiring);
			
		this.Bonus = Bonus;
		
	}
	//Create Getter & Setter for SalesPerson Class
	public double getBonus() {
		return Bonus;
	}
	public void setBonus(double Bonus) {
		this.Bonus = Bonus;
	}
	//Return results as String and append results
	public String toString() {
		StringBuilder str=new StringBuilder();
	   	str.append(super.toString()+", Bonus: $"); //Calling the toString() method of the Manager class
	   	str.append(this.getBonus()+"\n"); //appending bonus field value to it.
	    //Return Results
	   	return str.toString();

	}


}

//Create SubClass Car Class
   static class Car  {
	   //Private class variables
	private String make;
	private String model;
	private String color;
	private double price;
	private int year;
	private String vinNumber;
	// Initialize Manager
	Car() {};
	//Create Car Method and Create Constructors
	Car (String make, String model, String color, double price, int year, String vinNumber){
		this.make = make;
		this.model = model;
		this.price = price;
		this.year = year;
		this.vinNumber = vinNumber;
		this.color = color;
		
	}
	//Create Getters & Setters for Car Class (Make, Model, Color, Price, Year, and VinNumber)
public String getMake() {
	return make;
}
public void setMake(String make) {
	this.make = make;
}
public String getModel() {
    return model;
}

public void setModel(String model) {
    this.model = model;
}
public String getColor() {
	return color;
}
public void getColor(String color) {
	this.color = color;
}

public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}

public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}

public String getVinNumber() {
	return vinNumber;
}
public void setVinNumber(String vinNumber) {
	this.vinNumber = vinNumber;
}
//Return results as String and append results for year, make, model, color, price, vinNumber
public String toString() {
	StringBuilder str=new StringBuilder();
	str.append(this.getYear()+", ");
   	str.append(this.getMake()+", ");
   	str.append(this.getModel()+", ");
   	str.append(this.getColor()+", ");
   	str.append(this.getPrice()+", ");
   	str.append(this.getVinNumber()+"\n");
    //Return Results
   	return str.toString();

	
	}
}


// Create SubClass Manager Class
	static class Manager {
		//Create private Class Variables
	private String first_Name;
	private String last_Name;
	private String address;
	private String date_of_hiring;
	
	// Initialize Manager
	Manager() {}; 
	//Create Manager Method
	Manager (String first_Name, String last_Name, String address, Date doh){
		//constructors
		this.first_Name=first_Name;
	  	this.last_Name=last_Name;
	   	this.address=address;
	    this.setDate_of_hiring(doh);
		
	}
	//Create Getters & Setters for Manager Class (First Name, Last Name, Address, and Date of hire.
	public String getFirst_name() {
		return first_Name;
	}
	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}
	
	public String getlast_Name() {
		return last_Name;
	}
	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	  public String getDate_of_hiring() {
		   	return date_of_hiring;
		   }
	  //Format Date
		   public void setDate_of_hiring(Date date_of_hiring) {
		   	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		   	this.date_of_hiring = formatter.format(date_of_hiring);
		   }

	//Return results as String and append results
	public String toString() {
		StringBuilder str=new StringBuilder();
	   	str.append(this.getFirst_name()+","+this.getlast_Name()+",");
	   	str.append(this.getAddress()+",");
	   	str.append(this.getDate_of_hiring());
	    //Return Results
	   	return str.toString();

	}
	
}


	public static void main(String[] args) {
	
		
		// Create One Manager
		Manager Jon = new Manager("Jon"," Johnson"," 123,Lawn Street,Los Angeles, California ", new Date());

		 // Create at least 5 SalesPerson
		
		SalesPerson rep_1 = new SalesPerson("John 1 ","Doe 1 ","Address 1 ", new Date(),50);
		SalesPerson rep_2 = new SalesPerson("John 2 ","Doe 2 ","Address 2 ", new Date(),100);
		SalesPerson rep_3 = new SalesPerson("John 3 ","Doe 3 ","Address 3 ", new Date(),50);
		SalesPerson rep_4 = new SalesPerson("John 4 ","Doe 4 ","Address 4 ", new Date(),100);
		SalesPerson rep_5 = new SalesPerson("John 5 ","Doe 5 ","Address 5 ", new Date(),50);
		SalesPerson rep_6 = new SalesPerson("John 6 ","Doe 6 ","Address 6 ", new Date(),100);
		
		 // Create at Least 10 Cars
		
		//String make, String model, String color, double price, int year, String vinNumber
		Car car_1 = new Car("Audi_1 ","TT ", " Blue ",22589, 2017, "JQ425HS ");
		Car car_2 = new Car("Audi_2","TT ", " Blue ",22589, 2017, "JQ425HS ");
		Car car_3 = new Car("Audi_3 ","TT ", " Blue ",22589, 2017, "JQ425HS ");
		Car car_4 = new Car("Audi_4 ","TT ", " Blue ",22589, 2017, "JQ425HS ");
		Car car_5 = new Car("Audi_5 ","TT ", " Blue ",22589, 2017, "JQ425HS ");
		Car car_6 = new Car("Audi_6 ","TT ", " Blue ",22589, 2017, "JQ425HS ");
		Car car_7 = new Car("Audi_7 ","TT ", " Blue ",22589, 2017, "JQ425HS ");
		Car car_8 = new Car("Audi_8 ","TT ", " Blue ",22589, 2017, "JQ425HS ");
		Car car_9 = new Car("Audi_9 ","TT ", " Blue ",22589, 2017, "JQ425HS ");
		Car car_10 = new Car("Audi_10 ","TT ", " Blue ",22589, 2017, "JQ425HS ");
		Car car_11 = new Car("Audi_11 ","TT ", " Blue ",22589, 2017, "JQ425HS ");
		
		 // Create one Dealership and associates manager with it.
		Dealership_Project Santa_Monica_Dealer = new Dealership_Project (Jon);
		
		 // Use Dealership to add SalesPerson and Cars
		Santa_Monica_Dealer.addSalesPerson(rep_1);
		Santa_Monica_Dealer.addSalesPerson(rep_2);
		Santa_Monica_Dealer.addSalesPerson(rep_3);
		Santa_Monica_Dealer.addSalesPerson(rep_4);
		Santa_Monica_Dealer.addSalesPerson(rep_5);
		Santa_Monica_Dealer.addSalesPerson(rep_6);
		
		Santa_Monica_Dealer.addCar(car_1);
		Santa_Monica_Dealer.addCar(car_2);
		Santa_Monica_Dealer.addCar(car_3);
		Santa_Monica_Dealer.addCar(car_4);
		Santa_Monica_Dealer.addCar(car_5);
		Santa_Monica_Dealer.addCar(car_6);
		Santa_Monica_Dealer.addCar(car_7);
		Santa_Monica_Dealer.addCar(car_8);
		Santa_Monica_Dealer.addCar(car_9);
		Santa_Monica_Dealer.addCar(car_10);
		Santa_Monica_Dealer.addCar(car_11); 

		System.out.println(Santa_Monica_Dealer.toString());
		System.out.println("Sales Person of the Month: "+Santa_Monica_Dealer.getPersonOfTheMonth());
		// now test your program for all the method that was given in Dealership
		// Examples of car sold from inventory, remove a car from inventory, Modify Sales Staff
		System.out.print("-------------------------------------- \n");
		System.out.print("Changes Made Through Program: \n");
		
		System.out.println("• Removing Car " + car_4.getVinNumber() + " by Manager " + Jon.getFirst_name() + " " + Jon.getlast_Name() );
		Santa_Monica_Dealer.removeCar(car_1);
		
		System.out.println("• Selling car " + car_4.getVinNumber() + " by Sales Rep " + rep_1.getFirst_name() + " " + rep_1.getlast_Name() );
		Santa_Monica_Dealer.carSold(rep_1, car_4);
		
		System.out.println(" Sold Car" + car_5.getVinNumber() + "by Sales Rep " + rep_2.getFirst_name() + rep_2.getlast_Name());
		Santa_Monica_Dealer.carSold(rep_2, car_4);
		
		SalesPerson rep_7 = new SalesPerson("John 7 ","Doe 7 ","Address 7 ",new Date(),100);
		Santa_Monica_Dealer.addSalesPerson(rep_7);
		System.out.println("• Manager " + Jon.getFirst_name() + " " + Jon.getlast_Name() + " added Sales Rep " + rep_6.getFirst_name());
		
		// Print Modified List of Sales Reps, Car Inventory, and SalesPerson of the Month.
		System.out.println("--------------------------------------\n");
		System.out.println("Modified List: \n");
		
		System.out.println(Santa_Monica_Dealer.toString());
		System.out.println("Sales Person of the Month: "+Santa_Monica_Dealer.getPersonOfTheMonth());

	}

}

