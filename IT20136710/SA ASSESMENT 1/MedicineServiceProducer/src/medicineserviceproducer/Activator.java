
package medicineserviceproducer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import managerservice.ManagerService;
import managerserviceimpl.ManagerServiceImpl;
import mpatientservice.PatientService;
import mpatientserviceImpl.PatientServiceImpl;

public class Activator implements BundleActivator {

	ServiceRegistration producerRegister;
	
	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println(""+"MEDICINE PRODUCER SERVICE STARTED");
		
		PatientService patientService = new PatientServiceImpl();
		//REGISTER THE CASHIRSERVICE
		producerRegister = context.registerService(PatientService.class.getName().toString(), patientService, null);
		
		
		ManagerServiceImpl managerService = new ManagerServiceImpl();
		//REGISTER THE MANAGER SERVICE
		producerRegister = context.registerService(ManagerService.class.getName(), managerService, null);

	
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		System.out.println("=====================================================MEDICINE SERVICE STOPPED================================================================");
		producerRegister.unregister();
	}

}
