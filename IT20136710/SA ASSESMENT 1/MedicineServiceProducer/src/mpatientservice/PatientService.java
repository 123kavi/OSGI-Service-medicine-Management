package mpatientservice;

import java.util.List;
import model.Service;

//SERVICES WHICH CASHIER CONSUMER NEEDS
public interface PatientService {
	
	public List<Service> displayServices(); //RETURN THE SERVICE LIST WITH SERVICE DETAILS
	public int generateBill(int Sid, int qty); //CALCULATES BILL
	public double displayTotalBillAmount(); //DISPLAY TOTAL AMOUNT
	public String[][] displayBillDetails(); //DISPLAY GIVEN SERVICES LIST WITH DETAILS

}
