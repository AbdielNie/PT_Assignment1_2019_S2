/*
 * Program: TestMeal.java
 * Description: Test the Meal class
 * @author:LiangyuNie
 * @student number: s3716113
 * @version: 1.0
 * @since 2019-08-18
 */
public class TestMeal {
	public void testPassInstantiation() {
		String[] ingredients = {"apple", "orange"};
		Meal meal = new Meal("A", MealCategory.INDIAN, ingredients, 12);
		System.out.println(meal);
		System.out.println(meal.getDetails());
		Meal meal2 = new Meal("B", MealCategory.EUROPEAN, ingredients, 3);
		System.out.println(meal2);
		System.out.println(meal2.getDetails());
	}
	
	public void testFailInstantiation() {
		String[] ingredients = {"apple"};
		Meal meal = new Meal("", MealCategory.INDIAN, ingredients, 2);
		System.out.println(meal);
		System.out.println(meal.getDetails());
	}
	
	
	public void testPassAddIngredient() {
		String[] ingredients = {"apple", "orange"};
		Meal meal = new Meal("A", MealCategory.INDIAN, ingredients, 12);
		meal.addIngredients("banana");
		System.out.println(meal);
		System.out.println(meal.getDetails());
	}


	public void testFailAddIngredient() {
		String[] ingredients = {"apple", "orange"};
		Meal meal = new Meal("A", MealCategory.INDIAN, ingredients, 12);
		meal.addIngredients("apple");
		System.out.println(meal);
		System.out.println(meal.getDetails());
	}
	
	
	
	public void testFailRemoveIngredient() {
		String[] ingredients = {"apple", "orange"};
		Meal meal = new Meal("A", MealCategory.INDIAN, ingredients, 12);
		meal.addIngredients("banana");
		System.out.println(meal);
		System.out.println(meal.getDetails());
		meal.removeIngredient("apple");
		System.out.println(meal);
		System.out.println(meal.getDetails());
		meal.removeIngredient("banana");
		System.out.println(meal);
		System.out.println(meal.getDetails());
	}
	
	public static void main(String []args) {
		TestMeal test = new TestMeal();
		//test.testPassInstantiation();
		//test.testFailInstantiation();
		//test.testPassAddIngredient();
		test.testFailAddIngredient();
		test.testFailRemoveIngredient();
	}
}
