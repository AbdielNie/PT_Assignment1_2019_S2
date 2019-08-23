/*
 * Program: Meal.java
 * Description: build the Meal class
 * @author:LiangyuNie
 * @student number: s3716113
 * @version: 1.0
 * @since 2019-08-18
 */
enum MealCategory{
	INDIAN, VIETNAMESE, CHINESE, KOREAN, JAPANESE, EUROPEAN,  MIDDLE_EASTERN
}

public class Meal {
	private String name;  // meal name
	private MealCategory category; // the meal category
	private String[] basicIngredients; // the basic ingredients
	private String[] additionalIngredients; // additional ingredients
	private double cost;  // the cost of the meal
	
	/**
	 * constructor for the class Meal
	 * @param name: name of the meal
	 * @param category: the meal category
	 * @param ingredients: basic ingredients
	 * @param cost: cost of the meal
	 */
	public Meal(String name, MealCategory category, String[] ingredients, double cost) {
		if("".equals(name)) {
			// empty string
			this.name = "N/A";
		}else {
			// not empty
			this.name = name;
		}
		this.category = category;
		int size = 0; // the number of ingredients
		for(int i=0; i<ingredients.length;i++) {
			if(ingredients[i]!=null) {
				size++;
			}
		}
		String []temp = new String[size]; // create a new array to store the not null ingredients
		int index = 0;
		for(int i=0; i<ingredients.length;i++) {
			if(ingredients[i]!=null) {
				temp[index++] = ingredients[i];
			}
		}
		// check duplication
		boolean duplicated = false;
		for(int i=0; i<temp.length-1;i++) {
			for(int j=i+1; j<temp.length; j++) {
				if(temp[i].equals(temp[j])) {
					duplicated = true;
					break;
				}
			}
		}
		if(duplicated) {
			// if duplicate ingredients exist
			this.basicIngredients = null;
		}else {
			// if the number of ingredients is less than 2, set to null
			if(temp.length<2) {
				this.basicIngredients = null;
			}else {
				this.basicIngredients = temp;
			}	
		}
		
		this.basicIngredients = ingredients;
		this.additionalIngredients =  new String[0];
		if(cost < 5) {
			this.cost = -1;
		}else {
			this.cost = cost;
		}	
	}
	
	/**
	 * add ingredients to the meal, if add successful, return true
	 * @param ingredient
	 * @return true or false
	 */
	public boolean addIngredients(String ingredient) {
		// if found in the basic ingredients, return 
		for(int i=0; i<this.basicIngredients.length; i++) {
			if(this.basicIngredients[i].equals(ingredient)) {
				return false;
			}
		}
		// if found in the additional ingredients 
		for(int i=0; i<this.additionalIngredients.length; i++) {
			if(this.additionalIngredients[i].equals(ingredient)) {
				return false;
			}
		}
		// not found, add to the additional ingredients 
		String[] temp = new String[this.additionalIngredients.length+1]; 
		for(int i=0; i<this.additionalIngredients.length; i++) {
			temp[i] = this.additionalIngredients[i];
		}
		temp[this.additionalIngredients.length] = ingredient;
		this.additionalIngredients = temp;
		this.cost += 0.5; // add cost 
		return true;
	}
	
	/**
	 * remove a ingredient from the meal
	 * @param ingredient: the ingredient to remove
	 * @return true or false
	 */
	public boolean removeIngredient(String ingredient) {
		boolean found = false;
		// if found in the basic ingredients
		for(int i=0; i<this.basicIngredients.length; i++) {
			if(this.basicIngredients[i].equals(ingredient)) {
				found = true;
				break;
			}
		}
		String []temp;
		int index;
		if(found) {
			// remove from the basic ingredients
			temp = new String[this.basicIngredients.length-1];
			index = 0;
			for(int i=0; i<this.basicIngredients.length; i++) {
				if(!this.basicIngredients[i].equals(ingredient)) {
					temp[index++] = this.basicIngredients[i];
				}
			}
			this.basicIngredients = temp;
			return true;
		}
		found = false;
		// check if found in the additional ingredients
		for(int i=0; i<this.additionalIngredients.length; i++) {
			if(this.additionalIngredients[i].equals(ingredient)) {
				found = true;
				break;
			}
		}
		if(found) {
			// found in the additional ingredients
			temp = new String[this.additionalIngredients.length-1];
			index = 0;
			for(int i=0; i<this.additionalIngredients.length; i++) {
				if(!this.additionalIngredients[i].equals(ingredient)) {
					temp[index++] = this.additionalIngredients[i];
				}
			}
			this.additionalIngredients = temp;
			this.cost -= 0.5; // update the cost
			return true;
		}
		return false;
	}
	
	/**
	 * Return the details of the meal
	 * @return
	 */
	public String getDetails() {
		String output = "";
		output += String.format("%-20s%s\n", "Name:", this.name);
		String cate = "";
		switch(category) {
			case INDIAN:
				cate = "INDIAN";
				break;
			case VIETNAMESE:
				cate = "VIETNAMESE";
				break;
			case CHINESE:
				cate = "CHINESE";
				break;
			case KOREAN:
				cate = "KOREAN";
				break;
			case JAPANESE:
				cate= "JAPANESE";
				break;
			case EUROPEAN:
				cate = "EUROPEAN";
				break;
			case MIDDLE_EASTERN:
				cate = "MIDDLE_EASTERN";
				break;
		}
		output += String.format("%-20s%s\n", "Category:", cate);
		String temp = "N/A";
		if(this.basicIngredients==null) {
			temp = "N/A";
		}
		else if(this.basicIngredients.length==1) {
			temp = this.basicIngredients[0];
		}else if(this.basicIngredients.length==0){
			temp = "N/A";
		}else {
			temp = "";
			for(int i=0; i<this.basicIngredients.length-1; i++) {
				temp += this.basicIngredients[i] + ", ";
			}
			temp += this.basicIngredients[this.basicIngredients.length-1];
		}
		output += String.format("%-20s%s\n", "Ingredients:", temp);
		// format additional ingredients
		temp = "N/A";
		if(this.additionalIngredients.length==0) {
			temp = "N/A";
		}
		else if(this.additionalIngredients.length==1) {
			temp = this.additionalIngredients[0];
		}else {
			temp = "";
			for(int i=0; i<this.additionalIngredients.length-1; i++) {
				temp += this.additionalIngredients[i] + ", ";
			}
			temp += this.additionalIngredients[this.additionalIngredients.length-1];
		}
		output += String.format("%-20s%s\n", "Additions:", temp);
		output += String.format("%-20s%s%.2f\n", "Cost:", "$", this.cost);
		return output;
	}
	
	/**
	 * over load the toString method.
	 */
	public String toString() {
		String cate = "";
		switch(category) {
			case INDIAN:
				cate = "INDIAN";
				break;
			case VIETNAMESE:
				cate = "VIETNAMESE";
				break;
			case CHINESE:
				cate = "CHINESE";
				break;
			case KOREAN:
				cate = "KOREAN";
				break;
			case JAPANESE:
				cate= "JAPANESE";
				break;
			case EUROPEAN:
				cate = "EUROPEAN";
				break;
			case MIDDLE_EASTERN:
				cate = "MIDDLE_EASTERN";
				break;
		}
		String temp1 = "N/A";
		if(this.basicIngredients==null) {
			temp1 = "N/A";
		}
		else if(this.basicIngredients.length==1) {
			temp1 = this.basicIngredients[0];
		}else if(this.basicIngredients.length==0){
			temp1 = "N/A";
		}else {
			temp1 = "";
			for(int i=0; i<this.basicIngredients.length-1; i++) {
				temp1 += this.basicIngredients[i] + ", ";
			}
			temp1 += this.basicIngredients[this.basicIngredients.length-1];
		}
		// format additional ingredients
		String temp2 = "N/A";
		
		if(this.additionalIngredients.length==0) {
			temp2 = "N/A";
		}
		else if(this.additionalIngredients.length==1) {
			temp2 = this.additionalIngredients[0];
		}else {
			temp2 = "";
			for(int i=0; i<this.additionalIngredients.length-1; i++) {
				temp2 += this.additionalIngredients[i] + ", ";
			}
			temp2 += this.additionalIngredients[this.additionalIngredients.length-1];
		}
		return this.name + ":" + cate + ":" + temp1 + ":" + temp2 + ":" + "$" + String.format("%.2f", this.cost);	 
	}
}
