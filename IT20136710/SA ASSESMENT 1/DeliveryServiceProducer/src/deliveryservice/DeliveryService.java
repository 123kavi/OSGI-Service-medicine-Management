package deliveryservice;

import java.util.List;

import model1.Service;

//SERVICES WHICH MANAGER CONSUMER NEEDS
public interface DeliveryService {
	
	public int addServices(String serviceName,String serviceWeight, double servicePrice, double serviceDiscount); //ADD NEW SERVICES TO SERVICE LIST
	public int updateServices(String updateServiceName,String updateServiceWeight, double updateServicePrice, double updateServiceDiscount); //UPDATE SERVICE DETAILS
	public int removeServices(String serviceName); //REMOVE SERVICE FROM LIST BY NAME
	public int searchServices(String serviceName); //SEARCH SERVICES BY NAME
	
	public List<Service> listServices(); //RETUEN SERVICE LIST
	int updateServices(String updateServiceName, double updateServiceWeight, double updateServicePrice,
			double updateServiceDiscount);
	int addServices(String serviceName, double serviceWeight, double servicePrice, double serviceDiscount);
	int updateServices(String updateServiceName, String updateServiceAddress, int updateServiceNic,
			double updateServiceDosage);
	int addServices(String serviceName, String serviceAddress, int serviceNic, double serviceDosage);
	


}