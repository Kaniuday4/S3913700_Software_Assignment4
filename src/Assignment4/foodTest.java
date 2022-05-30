package Assignment4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class foodTest {

	// Success test case with correct values for add food
	@Test
	@Order(1)
	void testAddfood1() {
		Food f = new Food("1","Margarita Pizza","yummy",17,200,"Kid Food");
		boolean result = f.AddFood();
		assertEquals(result,true);
	}
	// Success test case with correct values for add food
	@Test
	@Order(2)
	void testAddfood2() {
		Food f = new Food("2","Mutton Biryani","spicy",18,600,"Adult Food");
		boolean result = f.AddFood();
		assertEquals(result,true);
	}
	// Success test case with correct values for add food
	@Test
	@Order(3)
	void testAddfood3() {
		Food f = new Food("3","Fruit salad","very delicious",15,80,"Elderly Food");
		boolean result = f.AddFood();
		assertEquals(result,true);
	}
	// Success test case with correct values for add food
	@Test
	@Order(4)
	void testAddfood4() {
		Food f = new Food("4","Garden salad","Nutritious",23,100,"Healthy Food");
		boolean result = f.AddFood();
		assertEquals(result,true);
	}
	// Test name of food with more than 30 characters
	@Test
	@Order(5)
	void testAddfood5() {
		Food f = new Food("5","Crispy fried mayo chicken sandwich","amazing taste",22,300,"Adult Food");
		boolean result = f.AddFood();
		assertEquals(result,true);
	}	
	// Test description of food with less than 5 characters
	@Test
	@Order(6)
	void testAddfood6() {
		Food f = new Food("6","Pizza","good",20,200,"Kid Food");
		boolean result = f.AddFood();
		assertEquals(result,true);
	}	
	// Test food with calorie more than 1500
	@Test
	@Order(7)
	void testAddfood7() {
		Food f = new Food("7","Burger","very yummy",20,1600,"Adult Food");
		boolean result = f.AddFood();
		assertEquals(result,true);
	}	
	// Test Kid food with calorie more than 800
	@Test
	@Order(8)
	void testAddfood8() {
		Food f = new Food("8","French fries","very yummy",20,900,"Kid Food");
		boolean result = f.AddFood();
		assertEquals(result,true);
	}
	// Test Price of food less than $5
	@Test
	@Order(9)
	void testAddfood9() {
		Food f = new Food("9","Fried rice","very yummy",4,200,"Adult Food");
		boolean result = f.AddFood();
		assertEquals(result,true);
	}
	// Test price of food with calorie more than 1000 and price more than 100
	@Test
	@Order(10)
	void testAddfood10() {
		Food f = new Food("10","French fries","very yummy",150,1200,"Kid Food");
		boolean result = f.AddFood();
		assertEquals(result,true);
	}
	// Success test case with correct values for update food
	@Test
	@Order(11)
	void testUpdatefood1() {
		Food f = new Food("1","Margarita Pizza","tasty",17,200,"Kid Food");
		boolean result = f.UpdateFood();
		assertEquals(result,true);
	}
	// Success test case with correct values for update food
	@Test
	@Order(12)
	void testUpdatefood2() {
		Food f = new Food("2","Mutton Biryani","spicy",19,600,"Adult Food");
		boolean result = f.UpdateFood();
		assertEquals(result,true);
	}
	// Success test case with correct values for update food
	@Test
	@Order(13)
	void testUpdatefood3() {
		Food f = new Food("3","Fruit salad","very delicious",15,80,"Healthy Food");
		boolean result = f.UpdateFood();
		assertEquals(result,true);
	}
	// Test updating calorie of the food
	@Test
	@Order(14)
	void testUpdatefood4() {
		Food f = new Food("4","Garden salad","Nutritious",23,200,"Healthy Food");
		boolean result = f.UpdateFood();
		assertEquals(result,true);
	}
	// Test increasing price of food by more than 10%
	@Test
	@Order(15)
	void testUpdatefood5() {
		Food f = new Food("3","Fruit salad","very delicious",20,80,"Healthy Food");
		boolean result = f.UpdateFood();
		assertEquals(result,true);
	}
	// Test changing Adult food to Kid Food
	@Test
	@Order(16)
	void testUpdatefood6() {
		Food f = new Food("2","Mutton Biryani","spicy",18,600,"Kid Food");
		boolean result = f.UpdateFood();
		assertEquals(result,true);
	}

}
