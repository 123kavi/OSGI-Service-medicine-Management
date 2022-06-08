package medicinedeliverymanagerconsumer;
import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import deliveryservice.DeliveryService;
import model1.Service;


public class Activator implements BundleActivator {
	
	ServiceReference serviceReference;
	Scanner input = new Scanner(System.in);
	boolean exit = false;
	

	@Override
	public void start(BundleContext context) throws Exception {
	
		System.out.println(""+"MEDICINE DELIVERY MANAGER CONSUMER STARTED");
		
		serviceReference = context.getServiceReference(DeliveryService.class.getName());
		@SuppressWarnings("unchecked")
		DeliveryService deliveryService = (DeliveryService) context.getService(serviceReference);
		
		do {
			int option = 7;
			
			do {
				System.out.println("\t\t"+"\n");

				System.out.println("\t\t\t\t\t\t" + "*****WELCOME TO MEDICINE DELIVERY SERVICE MANAGEMENT*****");
				System.out.println("\t"+"\n");
				System.out.println("Please select any option to continue >>");
				System.out.println("<< S E L E C T - O P T I O N >>");
				System.out.println("(1) Add new medcine and  delivery details");
				System.out.println("(2) Update an exsisting medicine and delivery details");
				System.out.println("(3) Delete an exsisting medicine delivery details");
				System.out.println("(4) List of medicine delivery list");
				System.out.println("(5) Exit");
				
				System.out.println("\n" + "You can Enter your option >>");
				option = input.nextInt();
				
				input.nextLine();
				
				if(option == 5) {
					exit = true;
				}
				
				if(option !=1 && option !=2 && option !=3 && option !=4 && option!=5 ) {
					System.out.println("Please enter valid option!!");
				}
			
			}while(option !=1 && option !=2 && option !=3 && option !=4&& option!=5 );
			
			String toHome = null;
			
			if(option == 1) { //ADDING PROCESS
				
				do {
					System.out.println("Medicine name Details : ");
					String serviceName = input.nextLine();
					
					System.out.println("delivery address Name : ");
					String serviceAddress = input.nextLine();
					
					System.out.println("Patient  Nic : ");
					double serviceNic = input.nextDouble();
					
					System.out.println("Medicine dosage  : ");
					double serviceDosage = input.nextDouble();
					
					input.nextLine();
					
					int output = deliveryService.addServices(serviceName, serviceAddress, serviceNic, serviceDosage);
					String message = (output == 1) ? "Successfully added the service!!" : "Please enter valid medicine!!";
					System.out.println(message);
					
					System.out.println("press '0' to go back to home OR press 'any key' to continue >>");
					toHome = input.nextLine();
					
				}while(!(toHome.equals("0")));
				
			}
			
			
			else if(option == 2) { //UPDATING PROCESS
				
				do {
					System.out.println("Medicine Name : ");
					String updateServiceName = input.nextLine();
					
					System.out.println("Medicine address : ");
					String updateServiceAddress = input.nextLine();
					
					System.out.println("Medicine Nic : ");
					double updateServiceNic = input.nextDouble();
					
					System.out.println("Medicine dosage : ");
					double updateServiceDosage = input.nextDouble();
					
					input.nextLine();
					
				
					int output = deliveryService.updateServices(updateServiceName, updateServiceAddress, updateServiceNic, updateServiceDosage);
					String message = (output == 1) ? "Successfully updated the service!!" : "Please enter valid name!!";
					System.out.println(message);
					
					System.out.println("press '0' to go back to home OR press 'any key' to continue >>");
					toHome = input.nextLine();
					
				}while(!(toHome.equals("0")));
			}
			
			
			else if(option == 3) { //REMOVING PROCESS
				
				do {
					System.out.println("Enter the medicine name : ");
					String serviceName = input.nextLine();
					
					int output = deliveryService.removeServices(serviceName);
					String message = (output == 1) ? "Successfully deleted the service!!" : "Please enter valid name!!";
					System.out.println(message);
					
					System.out.println("press '0' to go back to home OR press 'any key' to continue >>");
					toHome = input.nextLine();
					
				}while(!(toHome.equals("0")));
				
			}
			
			
			else if(option == 4) { //SERVICE LIST DISPLAY PROCESS
				
				do {
					List<Service> serviceList = deliveryService.listServices();
					
					System.out.println("\t\t\t\t\t\t\t"+"********MeDiCiNe DeLiVeRy LiSt********");
					System.out.println("\n");
					System.out.println("Delivery No:"+"\t" +"Medicine Name:"+"\t"+ "Address:"+"\t\t\t" + "Patient Nic:"+"\t\t" + "Dosage:"+"\t\t\t" + "Medicine Delivery Charge(Rs):"+"\t");
					
					for(Service tempService : serviceList) {
						
						System.out.println(tempService.getServiceId()+""+tempService.getServiceName()+""+tempService.getServiceAddress()+""+tempService.getServiceNic()+""
						
								+tempService.getDosage()+""+tempService.getNetPrice()+"");
						
					}
					


					System.out.println(".*.*.*.*.*.*.*..*.*.*.*.*.*.*.*.*.*.*.*.*.*.*..*.*.*.*.*.*.*..*.*");
					
					System.out.println("press '0' to go back to home OR press 'any key' to continue >>");
					toHome = input.nextLine();
					
				}while(!(toHome.equals("0")));
				
			}
			
			
		
			
			
			else if(option == 5) { //EXIT PROCESS
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
