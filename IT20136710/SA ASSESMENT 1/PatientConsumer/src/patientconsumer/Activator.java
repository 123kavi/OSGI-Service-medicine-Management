package patientconsumer;

import java.security.Provider.Service;
import java.util.List;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import mpatientservice.PatientService;


public class Activator implements BundleActivator {
	
	ServiceReference serviceReference;
	private boolean exit = false;
	Scanner input = new Scanner(System.in);


	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("MEDICINE BILLING CONSUMER STARTED");
		
		serviceReference = context.getServiceReference(PatientService.class.getName());
		@SuppressWarnings("unchecked")
		PatientService patientService = (PatientService) context.getService(serviceReference); //INSTANCE OF CASHIER SERVICE
		
		do {
			int option = 4;
			
			do {
				System.out.println( "\t\t\t\t\t\t"+"*****WELCOME TO PRESCRIPTION BILLING*****");
				
				System.out.println("Please select your option for continue >>");
				System.out.println("Select-OPTION");
				System.out.println("(1) Available Medicine List");
				System.out.println("(2) Calculate Patient Medicine Bills");
				System.out.println("(3) Enter Delivery Details");
				
				System.out.println("\n" + "Input selected option >> ");
				option = input.nextInt();
				
				input.nextLine();
				if(option == 3) { //TO EXIT PROGRAMME
					exit = true;
				}
				
				if(option !=1 && option !=2 && option !=3) {
					System.out.println("Please select vallid option!!");
				}
				
			}while (option !=1 && option !=2 && option !=3);
			
			String toHome = null;
			String calculateNetBill = null;
			int serviceCount = -1;
			
			if(option == 1) { //SERVICE LIST VIEW PROCESS
				do {
					List<model.Service> serviceList = patientService.displayServices();
					
					System.out.println("\t\t\t\t\t\t\t"+"********MeDiCiNe LiSt********");
					System.out.println("\n");
					
					
					System.out.println( "Medicine ID:"+"\t" +"Medicine Name:"+"\t"+ " Weight(mg):"+"\t" + "Medicine Price:"+"\t\t" + "Discount Percentage:"+"\t" + "Medicine Net Price(Rs):"+"\t");
					
					
					
					
					for(model.Service tempService : serviceList) {
						System.out.println(tempService.getServiceId()+"\t\t "+tempService.getServiceName()+"\t\t"+tempService.getServiceWeight()+"\t\t"+tempService.getServicePrice()+"\t\t "+tempService.getDiscount()+"\t\t                 "+tempService.getNetPrice()+"\t"+"\n");
						
						System.out.println("**********************************************************************************************************************");
					}
					
	/*System.out.println( "Medicine ID:"+"\t" +"Medicine Name:"+"\t"+ " Weight(mg):"+"\t" + "Medicine Price:"+"\t\t" + "Discount Percentage:"+"\t" + "Medicine Net Price(Rs):"+"\t");
					
					for(Service tempService : serviceList) {
						
						System.out.println(tempService.getServiceId()+"\t\t "+tempService.getServiceName()+"\t\t"+tempService.getServiceWeight()+"\t\t"+tempService.getServicePrice()+"\t\t "+tempService.getDiscount()+"\t\t                 "+tempService.getNetPrice()+"\t"+"\n");
						
					}*/
					
					System.out.println(".*.*.*.*.*.*.*..*.*.*.*.*.*.*.****************************************************************************.*.*.*.*.*.*.*..*.*.*.*.*.*.*..*.*");
					
					
					
					
					
					System.out.println("press '0' to go home OR press 'any key' to contonue >>");
					
					toHome = input.nextLine();
					
				}while(!(toHome.equals("0")));
				
			}
			
			else if(option == 2) {  //BILLING VIEW AND PROCESS
				do {
					
					do {
						System.out.println("\t\t\t\t\t\t"+"*****WELCOME TO PATIENT'S BILLING*****");
						System.out.println("\n");
						System.out.println("Enter the medicine service Id : ");
						int id = input.nextInt();
						
						System.out.println("Enter frequency of medicine obtained : ");
						int qty = input.nextInt();
						
						int output = patientService.generateBill(id, qty); //CONSUMES THE CASHIERSERVICE generateBill()
						if(output == -1) {
							System.out.println("Please enter valid service ID!!");
						}
						else {
							serviceCount ++;
						}
						
						input.nextLine();
						System.out.println("press 'y' to calculate net bill OR press 'any key' to continue billing >>");
						calculateNetBill = input.nextLine();
						
					}while(!(calculateNetBill.equals("y")));
					
					System.out.println("::::::::::::::::::::::::::::****************************RECEIPT::::::::::::::::::::::::::::****************************");
					
					String[][] billDetails = patientService.displayBillDetails();
					
					String format = "%-20s";
					System.out.printf(format, "Medicine ID:");
					System.out.printf(format, "Medicine Name:");
					System.out.printf(format, "Medicine Weight(mg):");

					System.out.printf(format,"\t\t"+ "Medicine Price:");
					System.out.printf(format, "Total :");
					System.out.printf("");
					
					for(int i = 0; i <= serviceCount; i++) {
						
						for(int j = 0; j < billDetails[i].length; j++) {
							System.out.printf(format, billDetails[i][j]);
						}
						
						System.out.println("\n");
						
					}
					
					System.out.println("                                                          ----------");
					System.out.println("Subtotal:                                                   " + patientService.displayTotalBillAmount());
					System.out.println("                                                          ----------");
					System.out.println("                                                          ----------");
					System.out.println("                                                          ----------");
					System.out.println("-------------------------------------------------------------------------------------------");
					
					serviceCount =- 1;
					
					System.out.println("press '0' to go to home OR press 'any key' to continue >>");
					
					toHome = input.nextLine();
					
				}while(!(toHome.equals("0")));
			}
			
			else if(option == 3) {
				return;
			}
			
		}while(!exit);
	}
	
	

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+************************MEDICINE BILLING CONSUMER STOPPED+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+_+************************");
		context.ungetService(serviceReference);
	}

	
}
