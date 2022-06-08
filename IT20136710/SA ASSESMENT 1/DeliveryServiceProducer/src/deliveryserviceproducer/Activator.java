
package deliveryserviceproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import deliveryservice.DeliveryService;
import deliveryserviceimpl.DeliveryServiceImpl;

public class Activator implements BundleActivator {

	ServiceRegistration producerRegister;
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("\t\t\t\t"+"******************************MEDICINE PRODUCER SERVICE STARTED*******************************");
		
		/*PatientService patientService = new PatientServiceImpl();
		//REGISTER THE CASHIRSERVICE
		producerRegister = context.registerService(PatientService.class.getName().toString(), patientService, null);
		
		*/
		DeliveryServiceImpl managerService = new DeliveryServiceImpl();
		//REGISTER THE MANAGER SERVICE
		producerRegister = context.registerService(DeliveryService.class.getName(), managerService, null);

	
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("*******************************MEDICINE SERVICE STOPPED*******************************");
		producerRegister.unregister();
	}

}
