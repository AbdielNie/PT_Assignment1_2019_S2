/*
 * Program: Delivery.java
 * Description: build the delivery class
 * @author:LiangyuNie
 * @student number: s3716113
 * @version: 1.0
 * @since 2019-08-18
 */
public class Delivery {
	private Customer customer;
	private Meal[] meals;
	DateTime deliveryDate;
	public Delivery(Customer customer) {
		this.customer = customer;
		this.meals = new Meal[0];
	}
	
	public void addMeal(Meal meal) {
		Meal[] temp = new Meal[meals.length+1];
		for(int i=0; i<meals.length; i++) {
			temp[i] = meals[i];
		}
		temp[meals.length] = meal;
		this.meals = temp;
	}
	
	public boolean setDeliveryDate(int day, int month, int year) {
		if(year<0) {
			return false;
		}
		if(month<=0 || month > 12) {
			return false;
		}
		DateTime date = new DateTime(day, month, year);
		this.deliveryDate = date;
		return true;
	}
	
	public String getDetails() {
		String output = "";
		output += this.customer.getDetails()+ "\n";
		for(int i=0; i<meals.length; i++) {
			output += this.meals[i].getDetails()+"\n";
		}
		if(this.deliveryDate!=null) {
			output += String.format("%-20s%s\n", "Delivery Date:", this.deliveryDate) + "\n";
		}
		return output;
	}
	
	public String toString() {
		String output = "";
		output += this.customer+"\n";
		for(int i=0; i<meals.length; i++) {
			output+= meals[i].toString() +"\n";
		}
		if(this.deliveryDate!=null) {
			output += this.deliveryDate+"\n";
		}else {
			output += "N/A";
		}
		return output;
	}
}
