package medicinemanagerconsumer;
import java.util.Scanner;
import java.util.List;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import managerservice.ManagerService;
import model.Service;

public class Activator implements BundleActivator {
	
	ServiceReference serviceReference;
	Scanner input = new Scanner(System.in);
	boolean exit = false;
	

	@Override
	public void start(BundleContext context) throws Exception {
		
		System.out.println(""+"MEDICINE  MANAGER CONSUMER STARTED");
		
		serviceReference = context.getServiceReference(ManagerService.class.getName());
		@SuppressWarnings("unchecked")
		ManagerService managerService = (ManagerService) context.getService(serviceReference);
		
		do {
			int option = 7;
			
			do {
				System.out.println("\t\t"+"\n");

				System.out.println("\t\t\t\t\t\t" + "*****WELCOME TO MEDICINE  SERVICE MANAGEMENT*****");
				System.out.println("\t"+"\n");
				System.out.println("Please select any option to continue >>");
				System.out.println("<< select - option >>");
				System.out.println("(1) Add new medcine details");
				System.out.println("(2) Update an exsisting medicine details");
				System.out.println("(3) Delete an exsisting medicine details");
				System.out.println("(4) List of medicine ");
				System.out.println("(5) Search medicine by name");
				System.out.println("(6) Exist");
				
				System.out.println("\n" + "You can Enter your option >>");
				option = input.nextInt();
				
				input.nextLine();
				
				if(option == 6) {
					exit = true;
				}
				
				if(option !=1 && option !=2 && option !=3 && option !=4 && option !=5 && option !=6) {
					System.out.println("Please enter valid option!!");
				}
			
			}while(option !=1 && option !=2 && option !=3 && option !=4 && option !=5 && option !=6);
			
			String toHome = null;
			
			if(option == 1) { //ADDING PROCESS
				
				do {
					System.out.println("Medicine  Name : ");
					String serviceName = input.nextLine();
					
					System.out.println("Medicine  Weight(mg) : ");
					double serviceWeight = input.nextDouble();
					
					System.out.println("Medicine  Price : ");
					double servicePrice = input.nextDouble();
					
					System.out.println("Medicine Discount  : ");
					double serviceDiscount = input.nextDouble();
					
					input.nextLine();
					
					int output = managerService.addServices(serviceName, serviceWeight, servicePrice, serviceDiscount);
					String message = (output == 1) ? "Successfully added the medicine!!" : "Please enter valid medicine!!";
					System.out.println(message);
					
					System.out.println("press '0' to go back to home OR press 'any key' to continue >>");
					toHome = input.nextLine();
					
				}while(!(toHome.equals("0")));
				
			}
			
			
			else if(option == 2) { //UPDATING PROCESS
				
				do {
					System.out.println("Medicine Name : ");
					String updateServiceName = input.nextLine();
					
					System.out.println("Medicine Weight(mg) : ");
					Double updateServiceWeight = input.nextDouble();
					
					System.out.println("Medicine Price : ");
					double updateServicePrice = input.nextDouble();
					
					System.out.println("Medicine Discount : ");
					double updateServiceDiscount = input.nextDouble();
					
					input.nextLine();
					
				
					int output = managerService.updateServices(updateServiceName, updateServiceWeight, updateServicePrice, updateServiceDiscount);
					String message = (output == 1) ? "Successfully updated the medicine!!" : "Please enter valid madicine name!!";
					System.out.println(message);
					
					System.out.println("press '0' to go back to home OR press 'any key' to continue >>");
					toHome = input.nextLine();
					
				}while(!(toHome.equals("0")));
			}
			
			
			else if(option == 3) { //REMOVING PROCESS
				
				do {
					System.out.println("Enter the medicine name : ");
					String serviceName = input.nextLine();
					
					int output = managerService.removeServices(serviceName);
					String message = (output == 1) ? "Successfully deleted the medicine!!" : "Please enter valid medicine name!!";
					System.out.println(message);
					
					System.out.println("press '0' to go back to home OR press 'any key' to continue >>");
					toHome = input.nextLine();
					
				}while(!(toHome.equals("0")));
				
			}
			
			
			else if(option == 4) { //SERVICE LIST DISPLAY PROCESS
				
				do {
					List<Service> serviceList = managerService.listServices();
					
					System.out.println("\t\t\t\t\t\t\t"+"********MeDiCiNe LiSt********");
					System.out.println("\n");
					
					
					System.out.println( "Medicine ID:"+"\t" +"Medicine Name:"+"\t"+ " Weight(mg):"+"\t" + "Medicine Price:"+"\t\t" + "Discount Percentage:"+"\t" + "Medicine Net Price(Rs):"+"\t");
					
					for(Service tempService : serviceList) {
						
						System.out.println(tempService.getServiceId()+"\t\t "+tempService.getServiceName()+"\t\t"+tempService.getServiceWeight()+"\t\t"+tempService.getServicePrice()+"\t\t "+tempService.getDiscount()+"\t\t                 "+tempService.getNetPrice()+"\t"+"\n");
						
					}
					
					System.out.println(".*.*.*.*.*.*.*..*.*.*.*.*.*.*.****************************************************************************.*.*.*.*.*.*.*..*.*.*.*.*.*.*..*.*");
					
					System.out.println("press '0' to go back to home OR press 'any key' to continue >>");
					toHome = input.nextLine();
					
				}while(!(toHome.equals("0")));
				
			}
			
			
			else if(option == 5) { //SERVICES SEARCHINGG PROCESS
				
				do {
					System.out.println("Enter the medicine name : ");
					String serviceName = input.nextLine();
					
					int output = managerService.searchServices(serviceName);
					String message = (output == 1) ? "Medicine found!!" : "Medicine not found!!";
					System.out.println(message);
					
					System.out.println("press '0' to go back to home OR press 'any key' to continue >>");
					toHome = input.nextLine();
					
				}while(!(toHome.equals("0")));
				
			}
			
			
			else if(option == 6) { //EXIT PROCESS
				return;
			}
			
		
		}while(!exit);
	}
	
	

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("************************MEDICINE MANAGER CONSUMER STOPPED************************");
		context.ungetService(serviceReference);
	}

	
}
