/*
 * Program: TestDelivery.java
 * Description: Test the Meal class
 * @author:LiangyuNie
 * @student number:s3716113
 * @version: 1.0
 * @since 2019-08-18
 */

import java.util.Scanner;

public class TestDelivery {
	public void testAddMeal() {
		Customer customer = new Customer("Matthew","Broderick","42","Pride Avenue","Elwood","1184");
		String[] ingredients = {"apple", "orange"};
		Meal meal = new Meal("A", MealCategory.INDIAN, ingredients, 12);
		Delivery delivery = new Delivery(customer);
		delivery.addMeal(meal);
		System.out.println(delivery);
	}
	
	public void testSetDeliveryDate() {
		Customer customer = new Customer("Matthew","Broderick","42","Pride Avenue","Elwood","1184");
		String[] ingredients = {"apple", "orange"};
		Meal meal = new Meal("A", MealCategory.INDIAN, ingredients, 12);
		Delivery delivery = new Delivery(customer);
		delivery.addMeal(meal);
		delivery.setDeliveryDate(12, 8, 2019);
		System.out.println(delivery);
	}
	
	public void dynamicTest() {
		Scanner scan = new Scanner(System.in);
		String firstname, lastname, suburb, postcode, streetNo, streetName;
		System.out.println("Enter the customer");
		System.out.print("Firstname: ");
		firstname = scan.nextLine();
		System.out.print("Lastname: ");
		lastname = scan.nextLine();
		System.out.print("Street Number: ");
		streetNo = scan.nextLine();
		System.out.print("Suburb: "); 
		suburb = scan.nextLine();
		System.out.print("Street Name: ");
		streetName = scan.nextLine();
		System.out.print("PostCode: ");
		postcode = scan.nextLine();
		Customer customer = new Customer(firstname, lastname, streetNo, streetName, suburb, postcode);
		String[] ingredients = {"apple", "orange"};
		Meal meal = new Meal("A", MealCategory.INDIAN, ingredients, 12);
		Delivery delivery = new Delivery(customer);
		delivery.addMeal(meal);
		delivery.setDeliveryDate(12, 8, 2019);
		System.out.println(delivery);
	}
	
	public static void main(String []args) {
		TestDelivery test = new TestDelivery();
		test.testAddMeal();
		test.testSetDeliveryDate();
		test.dynamicTest();
	}
}
