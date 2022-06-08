package model;

//SERVICE MODEL CLASS
public class Service {
	
	private int serviceId;
	private String serviceName;
	private double serviceWeight;
	private double servicePrice;
	private double discount;
	private double netPrice;
	private double netPrice1;
	

	

	
	
	private double netPrice3;
	

	
	public Service(int serviceId, String serviceName,  double serviceWeight, double servicePrice, double discount) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.serviceWeight= serviceWeight;
		this.servicePrice = servicePrice;
		this.discount = discount;
		calculateNetPrice();
		calculateNetPrice1();
		
		calculateNetPrice3();
		
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
	public double getServiceWeight() {
		return serviceWeight;
	}

	public void setServiceWeight(double serviceWeight) {
		this.serviceWeight = serviceWeight;
	}

	public double getServicePrice() {
		return servicePrice;
	}

	public void setServicePrice(double servicePrice) {
		this.servicePrice = servicePrice;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
/*.................................................................................................*/
	



public double getNetPrice() {
		return netPrice;
	}


	public void setNetPrice(double netPrice) {
		this.netPrice = netPrice;
	}
	
	
	public void calculateNetPrice() {
		this.netPrice = servicePrice * ((100.00 - discount) / 100);
	}
/*............................................................................*/


	private void calculateNetPrice1() {
		this.setNetPrice1(netPrice*2);
		
	}



	public double getNetPrice1() {
		return netPrice1;
	}



	public void setNetPrice1(double netPrice1) {
		this.netPrice1 = netPrice1;
	}
	
	
	/**************************************************************************/	
	


public double getNetPrice3() {
		return netPrice3;
	}


	public void setNetPrice3(double netPrice3) {
		this.netPrice3 = netPrice3;
	}
	
	
	public void calculateNetPrice3() {
		this.netPrice3 = (netPrice  / serviceWeight);
	}





	}




	
	
	
	
	

