package model1;

//SERVICE MODEL CLASS
public class Service {
	
	private int serviceId;
	private String serviceName;
	private String serviceAddress;
	private double serviceNic;
	private double dosage;
	private double netPrice;
	private double netPrice1;
	

	

	
	
	private double netPrice3;
	

	
	public Service(int serviceId, String serviceName,  String serviceAddress, double serviceNic, double dosage) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.serviceAddress= serviceAddress;
		this.serviceNic = serviceNic;
		this.dosage = dosage;
		calculateNetPrice();
	
	
		
	}



	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServiceAddress() {
		return serviceAddress;
	}

	public void setServiceAddress(String serviceWeight) {
		this.serviceAddress = serviceAddress;
	}

	public double getServiceNic() {
		return serviceNic;
	}

	public void setServiceNic(double serviceNic) {
		this.serviceNic = serviceNic;
	}

	public double getDosage() {
		return dosage;
	}

	public void setDosage(double dosage) {
		this.dosage = dosage;
	}
/*.................................................................................................*/
	



public double getNetPrice() {
		return netPrice;
	}


	public void setNetPrice(double netPrice) {
		this.netPrice = netPrice;
	}
	
	
	public void calculateNetPrice() {
		this.netPrice = dosage * 30;
	}
/*............................................................................*/


	
}
	
	
	








	




	
	
	
	
	

