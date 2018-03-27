package Julian;
import Julian.Dickens.*;
import java.util.*;
import java.io.*;
public class VehicleClient
{
	public static void main (String [] args)
	{
		Vehicle[] vehicleArray=null;
		double[] velocityArray=null;
		double[] distanceArray=null;
		int size=0;
		int index=0;
		try
		{
			File ifile=new File("Vehicles.txt");
			Scanner scan=new Scanner(ifile);
			while(scan.hasNextLine())
			{ 
				scan.nextLine();
				size++;
			}
			vehicleArray= new Vehicle[size];
			velocityArray=new double[size];
			distanceArray=new double[size];
		
			Scanner scan1=new Scanner(ifile);
			while(scan1.hasNextLine())
			{
				String line=scan1.nextLine();
				StringTokenizer str=new StringTokenizer(line, ",");
				while(str.hasMoreTokens())
				{
					String stringAcceleration=str.nextToken();
					double acceleration=Double.parseDouble(stringAcceleration);
					String stringTime=str.nextToken();
					int time=Integer.parseInt(stringTime);
					String owner_name=str.nextToken();
					String vehicleEngine=str.nextToken();
					VehicleEngine veng=null;
					if(vehicleEngine.equals("TwoPointFourLiters"))
					{
						veng=VehicleEngine.TwoPointFourLiters;
					}
					else if(vehicleEngine.equals("ThreePointFiveLiters"))
					{
						veng=VehicleEngine.ThreePointFiveLiters;
					}
					else if(vehicleEngine.equals("FivePointZeroLiters"))
					{
						veng=VehicleEngine.FivePointZeroLiters;
					}
					else if(vehicleEngine.equals("SixPointZeroLiters"))
					{
						veng=VehicleEngine.SixPointZeroLiters;
					}
					Vehicle car=new Vehicle(acceleration, time, owner_name, veng);
					vehicleArray[index]=car;
			
					double velocity=car.calculateVelocity(0.0);
					velocityArray[index]=velocity;
				
					double distance=car.calculateDistance(0.0, 0.0);
					distanceArray[index]=distance;
		
					index++;	
				}
				
			}
			
			Scanner scan2=new Scanner(System.in);
			System.out.println("Would you like the information to be displayed (please type yes or Yes)?");
			String input=scan2.nextLine();
			double velocityLength=velocityArray.length;
			double distanceLength=distanceArray.length;
			if(input.equals("yes")||input.equals("Yes"))
			{
				for(int i=0;i<vehicleArray.length;i++)
				{
					System.out.println("The vehicle with id:" + " " + vehicleArray[i].getCurrentID() + " " + "has the values:" + " " + vehicleArray[i].toString() + " " +
										"The velocity is:" + " " + velocityArray[i] + " " +
										"and the distance travelled is:" + " " + distanceArray[i] + " "); 					
				}
						
			}
			else
			{
					System.out.println("Thank-you");
			}			
		}
		catch (IOException ioe)
		{
			System.out.println("There is in error when attempting to read the file.");
		}
	}
}	