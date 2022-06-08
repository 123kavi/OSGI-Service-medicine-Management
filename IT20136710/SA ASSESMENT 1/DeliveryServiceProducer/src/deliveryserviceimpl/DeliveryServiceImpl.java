
package deliveryserviceimpl;

import java.util.List;

import deliveryservice.DeliveryService;
import model1.Service;
import servicestore1.ServiceStore;

public class DeliveryServiceImpl implements DeliveryService {


	@Override
	public synchronized int addServices(String serviceName, String serviceAddress, double serviceNic, double serviceDosage) {
		
		Service newService = new Service(ServiceStore.serviceList.size() + 1, serviceName, serviceAddress, serviceNic, serviceDosage);
		ServiceStore.serviceList.add(newService);
		
		return 1;
	}
	


	@Override
	public synchronized int updateServices(String updateServiceName,String updateServiceAddress, double updateServiceNic, double updateServiceDosage) {
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
			
			serviceToBeUpdate.setServiceAddress(updateServiceAddress);
			
			serviceToBeUpdate.setServiceNic(updateServiceNic);
			serviceToBeUpdate.setDosage(updateServiceDosage);
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



	@Override
	public int updateServices(String updateServiceName, double updateServiceWeight, double updateServicePrice,
			double updateServiceDiscount) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int addServices(String serviceName, double serviceWeight, double servicePrice, double serviceDiscount) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int updateServices(String updateServiceName, String updateServiceAddress, int updateServiceNic,
			double updateServiceDosage) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int addServices(String serviceName, String serviceAddress, int serviceNic, double serviceDosage) {
		// TODO Auto-generated method stub
		return 0;
	}


	

}