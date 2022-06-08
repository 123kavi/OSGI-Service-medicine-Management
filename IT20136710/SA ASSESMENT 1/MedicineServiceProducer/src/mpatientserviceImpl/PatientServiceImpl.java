package mpatientserviceImpl;

import java.util.List;

import model.Service;
import mpatientservice.PatientService;
import servicestore.ServiceStore;

public class PatientServiceImpl implements PatientService{
	
	private List<Service> serviceList = ServiceStore.serviceList; //SERVICE LIST DETAILS IN SALOON
	private double bill; //STORE BILL VALUE
	private String[][] billDetails = new String[10][4]; //TO STORE TAKEN SERVICE'S DETAILS (ASSUPTION : ONLY 10 DIFFERET SERVICES ALLOWED FOR 1 PERSON)
	private int count = -1; //STORE SERVICES COUNT (STARTING FROM 0)
	

	@Override
	public List<Service> displayServices() {
		return ServiceStore.serviceList;
	}
	
 @Override
	public int generateBill(int Sid, int qty) {
		boolean valid = false;
		Service currentService = null;
		
		for(Service tempService : serviceList) {
			if(Sid == tempService.getServiceId()) {
				currentService = tempService;
				valid = true;
				count ++;
				break;
			}
		}
		if(valid) {
			this.bill = this.bill + (currentService.getNetPrice3() * qty);
			
			billDetails[count][0] = Integer.toString(Sid);
			billDetails[count][1] = currentService.getServiceName();
			
			billDetails[count][2] = Integer.toString(qty);
			billDetails[count][3] = Double.toString((currentService.getNetPrice3() * qty));
			
			return 1;
		}
		else {
			return -1;
		}
	}
	

	@Override
	public double displayTotalBillAmount() {
		double totalBill = this.bill;
		newBill();
		
		return totalBill;
	}
	

	@Override
	public String[][] displayBillDetails() {
		return billDetails;
	}
	
	
	public void newBill() {
		this.bill = 0;
		this.count = -1;
	}

}