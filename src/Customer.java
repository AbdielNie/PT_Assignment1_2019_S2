/*
 * Program: Customer.java
 * Description: Build a class represent the customer
 * @author:LiangyuNie
 * @student number: s3716113
 * @version: 1.0
 * @since 2019-08-18
 */
import java.util.regex.*;


public class Customer {
	private String firstName;
	private String lastName;
	private String streetNo;
	private String streetName;
	private String suburb;
	private String postcode;
	
	/**
	 * Constructor for the customer
	 * @param firstName: first name of the customer
	 * @param lastName: last name of the customer
	 * @param streetNumber: street number
	 * @param streetName: street name
	 * @param suburb: suburb
	 * @param postcode: post code
	 */
	public Customer(String firstName, String lastName, String streetNumber, String streetName, String suburb, String postcode) {
		if(firstName==null || "".equals(firstName)) {
			this.firstName = "N/A";
		}else {
			this.firstName = firstName;
		}
		if(lastName==null || "".equals(lastName)) {
			this.lastName = "N/A";
		}else {
			this.lastName = lastName;
		}
		if(streetNumber==null || "".equals(streetNumber)) {
			this.streetNo = "N/A";
		}else {
			this.streetNo = streetNumber;
		}
		if(streetName==null || "".equals(streetName)) {
			this.streetName = "N/A";
		}else {
			this.streetName = streetName;
		}
		if(suburb==null || "".equals(suburb)) {
			this.suburb = "N/A";
		}else {
			this.suburb = suburb;
		}
		if(postcode==null || "".equals(postcode)) {
			this.postcode = "N/A";
		}else {
			String pattern = "^[1-8][0-9]{3}$";
		    if(Pattern.matches(pattern, postcode)) {
		    	this.postcode = postcode;
		    }else {
		    	this.postcode = "N/A";
		    }
		}
	}
	
	public String getDetails() {
		String output = "";
		output += String.format("%-20s%s %s\n", "Name:", this.firstName, this.lastName);
		output += String.format("%-20s%s %s\n", "Address:", this.streetNo, this.streetName);
		output += String.format("%-20s%s %s\n", "", this.suburb, this.postcode);
		return output;
	}
	
	public String toString() {
		String output =  this.firstName + ":" + this.lastName +":" + this.streetNo + ":" + this.firstName + ":"+ this.suburb + ":" + this.postcode;
		return output;
	}
	
	
}
