package ex7;

import java.util.Date;

public class Visit {
	private Customer customer;
	private Date date;
	private double serviceExpense;
    private double productExpense;
    public Visit(String name,Date date) {
    	this.customer = new Customer(name);
    	this.date= date;
    	
    	
    }
//    public Visit(Customer customer,Date date) {
//    	this.customer=customer;
//    	this.date=date;
//    }
    public String getName() {
    	return customer.getName();
    }
	public double getServiceExpense() {
		return serviceExpense;
	}
	public void setServiceExpense(double serviceExpense) {
		this.serviceExpense = serviceExpense;
	}
	public double getProductExpense() {
		return productExpense;
	}
	public void setProductExpense(double productExpense) {
		this.productExpense = productExpense;
	}
    public double getTotalExpense() {
    	DiscountRate a= new DiscountRate();
    	if(customer.isMember()  && customer.getMemberType() != null) {
    		return  (serviceExpense+productExpense)-(serviceExpense*a.getServiceDiscountRate(customer.getMemberType())+productExpense*a.getProductDiscountRate(customer.getMemberType()));}
    	else return (serviceExpense+productExpense); 
    }
	@Override
	public String toString() {
		return "Visit [customer=" + customer.getName() + ", date=" + date + ", serviceExpense=" + serviceExpense
				+ ", productExpense=" + productExpense + ",TotalExpense="+getTotalExpense()+"]";
	}
    
}
