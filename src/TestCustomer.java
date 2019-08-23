/*
 * Program: TestCustomer.java
 * Description: Test the Customer class
 * @author:LiangyuNie
 * @student number:s3716113
 * @version: 1.0
 * @since 2019-08-18
 */

public class TestCustomer {
	public  void testValid() {
		Customer customer1 = new Customer("Matthew","Broderick","42","Pride Avenue","Elwood","1184");
		System.out.println(customer1.getDetails());
		System.out.println(customer1);
		Customer customer2 = new Customer("Rowan","Atkinson","91","Sebastian Street","Carlton","2053");
		System.out.println(customer2.getDetails());
		System.out.println(customer2);
		Customer customer3 = new Customer("Jeremy","Irons","19","John Close","Essendon","3040");
		System.out.println(customer3.getDetails());
		System.out.println(customer3);
		Customer customer4 = new Customer("Whoopi","Goldberg","57","Elaine Court","St Albans","4021");
		System.out.println(customer4.getDetails());
		System.out.println(customer4);
		Customer customer5 = new Customer("James","Jones","11","Earl Road","Melbourne","5000");
		System.out.println(customer5.getDetails());
		System.out.println(customer5);
		Customer customer6 = new Customer("Henry","Cavill","83","Dalgliesh Street","South Yarra","6141");
		System.out.println(customer6.getDetails());
		System.out.println(customer6);
		Customer customer7 = new Customer("Angelina","Jolie","11","Smith Street","Toorak","7142");
		System.out.println(customer7.getDetails());
		System.out.println(customer7);
		Customer customer8 = new Customer("Matt","Bomer","42","Staton Street","South Yarra","8141");
		System.out.println(customer8.getDetails());
		System.out.println(customer8);
	}
	
	public  void testInvalid() {
		Customer customer1 = new Customer("","","","","","");
		System.out.println(customer1.getDetails());
		System.out.println(customer1);
		Customer customer2 = new Customer("Matt","Bomer","42","Staton Street","South Yarra","a123");
		System.out.println(customer2.getDetails());
		System.out.println(customer2);
		Customer customer3 = new Customer("Matt","Bomer","42","Staton Street","South Yarra","123");
		System.out.println(customer3.getDetails());
		System.out.println(customer3);
		Customer customer4 = new Customer("Matt","Bomer","42","Staton Street","South Yarra","12345");
		System.out.println(customer4.getDetails());
		System.out.println(customer4);
		Customer customer5 = new Customer("Matt","Bomer","42","Staton Street","South Yarra","0123");
		System.out.println(customer5.getDetails());
		System.out.println(customer5);
		Customer customer6 = new Customer("Matt","Bomer","42","Staton Street","South Yarra","9123");
		System.out.println(customer6.getDetails());
		System.out.println(customer6);
	}
	
	public static void main(String []args) {
		TestCustomer test = new TestCustomer();
		test.testValid();
		test.testInvalid();
	}
}
