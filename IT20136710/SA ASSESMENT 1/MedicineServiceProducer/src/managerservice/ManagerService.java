package managerservice;

import java.util.List;

import model.Service;

//SERVICES WHICH MANAGER CONSUMER NEEDS
public interface ManagerService {
	
	public int addServices(String serviceName,double serviceWeight, double servicePrice, double serviceDiscount); //ADD NEW SERVICES TO SERVICE LIST
	public int updateServices(String updateServiceName,double updateServiceWeight, double updateServicePrice, double updateServiceDiscount); //UPDATE SERVICE DETAILS
	public int removeServices(String serviceName); //REMOVE SERVICE FROM LIST BY NAME
	public int searchServices(String serviceName); //SEARCH SERVICES BY NAME
	
	public List<Service> listServices(); //RETUEN SERVICE LIST
	


}