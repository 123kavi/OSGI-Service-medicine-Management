package managerserviceimpl;

import java.util.List;

import managerservice.ManagerService;
import model.Service;
import servicestore.ServiceStore;

public class ManagerServiceImpl implements ManagerService {

	@Override
	public synchronized int addServices(String serviceName, double serviceWeight, double servicePrice, double serviceDiscount) {
		
		Service newService = new Service(ServiceStore.serviceList.size() + 1, serviceName, serviceWeight, servicePrice, serviceDiscount);
		ServiceStore.serviceList.add(newService);
		
		return 1;
	}
	

	@Override
	public synchronized int updateServices(String updateServiceName,double updateServiceWeight, double updateServicePrice, double updateServiceDiscount) {
		Service serviceToBeUpdate = null;
		boolean invalid = true;
		int count = -1;
		
		for(Service tempService : ServiceStore.serviceList) {
			count ++;
			
			if(tempService.getServiceName().equalsIgnoreCase(updateServiceName)) {
				serviceToBeUpdate = tempService;
				invalid = false;
				break;
			}
		}
		if(!invalid) {
			serviceToBeUpdate.setServiceName(updateServiceName);
			
			serviceToBeUpdate.setServiceWeight(updateServiceWeight);
			
			serviceToBeUpdate.setServicePrice(updateServicePrice);
			serviceToBeUpdate.setDiscount(updateServiceDiscount);
			serviceToBeUpdate.calculateNetPrice();
			
			ServiceStore.serviceList.set(count, serviceToBeUpdate);
			return 1;
		}
		else {
			return -1;
		}
	}
	

	@Override
	public synchronized int removeServices(String serviceName) {
		boolean invalid = true;
		int count = -1;
		
		for(Service tempService : ServiceStore.serviceList) {
			count ++;
			if(tempService.getServiceName().equalsIgnoreCase(serviceName)) {
				invalid = false;
				break;
			}
		}
		if(!invalid) {
			ServiceStore.serviceList.remove(count);
			return 1;
		}
		else {
			return -1;
		}
	}
	

	@Override
	public int searchServices(String serviceName) {
		boolean valid = false;
		
		for(Service tempService : ServiceStore.serviceList) {
			if(tempService.getServiceName().equalsIgnoreCase(serviceName)) {
				valid = true;
				break;
			}
		}
		if(valid) {
			return 1;
		}
		else {
			return -1;
		}
	}
	

	@Override
	public List<Service> listServices() {
		return ServiceStore.serviceList;
	}


	

}