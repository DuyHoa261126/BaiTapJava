package ex2;

public class Invoice {
	private int id;
	private double amount;
	private Customer Customer;
	public Invoice(int id, ex2.Customer customer, double amount) {
		this.id = id;
		this.amount = amount;
		Customer = customer;
	}
	public int getId() {
		
		return id;
	}
	public Customer getCustomer() {
		return Customer;
		
		
		
	}
  public void setCustomer(Customer Customer) {
	  this.Customer=Customer;
	  
	  
  }
  public double getAmount() {
	  return amount;
	  
  }
  public void setAmount(double amount) {
	  this.amount=amount;
	  
	  
  }
  public int getCustomerId() {
	  return Customer.getId();
	  
  }
  public String getCustomerName() {
	  return Customer.getName();
  }
  public int getCustomerDiscount() {
	  return Customer.getDiscount();
	  
  }
  public double getAmountAfterDiscount() {
	  return amount-=amount*(getCustomerDiscount()/100.0);
	  
	  
  }
@Override
public String toString() {
	return "Invoice [id=" + id + ", Customer=" + " name=" + Customer.getName() + "("+id+")(" + Customer.getDiscount() + "%)" + ", amount=" + amount+  "]";
}
public static void main(String[] args) {
	
	   // Test Customer class
    Customer c1 = new Customer(88, "Tan Ah Teck", 10);
    System.out.println(c1);  // Customer's toString()

    c1.setDiscount(8);
    System.out.println(c1);
    System.out.println("id is: " + c1.getId());
    System.out.println("name is: " + c1.getName());
    System.out.println("discount is: " + c1.getDiscount());

    // Test Invoice class
    Invoice inv1 = new Invoice(101, c1, 888.8);
    System.out.println(inv1);

    inv1.setAmount(999.9);
    System.out.println(inv1);
    System.out.println("id is: " + inv1.getId());
    System.out.println("customer is: " + inv1.getCustomer());  // Customer's toString()
    System.out.println("amount is: " + inv1.getAmount());
    System.out.println("customer's id is: " + inv1.getCustomerId());
    System.out.println("customer's name is: " + inv1.getCustomerName());
    System.out.println("customer's discount is: " + inv1.getCustomerDiscount());
    System.out.printf("amount after discount is: %.2f%n", inv1.getAmountAfterDiscount());
 }
  
}























