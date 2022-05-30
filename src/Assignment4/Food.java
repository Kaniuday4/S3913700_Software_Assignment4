package Assignment4;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Food {
	private String foodID;

    private String foodName;

    private String foodDescription;

    private double foodPrice;

    private int foodCalorie;

    private String foodType;
    
	static String filename= "file.txt";

	// Constructor to initialize Food instance details
    public Food(String id, String name, String description, double price, int calorie, String type)
    {
    	this.foodID = id;
		this.foodName = name;
		this.foodDescription = description;
		this.foodPrice = price;
		this.foodCalorie = calorie;
		this.foodType = type;
    }
    // Function to check if food details are correct
    public boolean checkCondition()
    {
    	// if length of food name is more than 30 or less than 5,then return false
    	if(this.foodName.length() > 30 || this.foodName.length() < 5)
    		return false;
    	// if length of food description is more than 50 or less than 5,then return false
    	if(this.foodDescription.length() > 50 || this.foodDescription.length() < 5)
    		return false;
    	// if food type not Kid Food or Adult Food or Healthy Food or elderly Food, then return false
    	if(!this.foodType.equals("Kid Food") && !this.foodType.equals("Adult Food") && !this.foodType.equals("Healthy Food") && !this.foodType.equals("Elderly Food"))
    		return false;
    	// if food price is less than 5 or more than 150, then return false
    	if(this.foodPrice < 5 || this.foodPrice > 150)
    		return false;
    	// if food calorie is more than 1500 or if food type is kid food and calorie more than 800, then return false
    	if(this.foodCalorie > 1500 || (this.foodType.equals("Kid Food") && this.foodCalorie>800))
    		return false;
    	// if food calorie more than 1000 and food price more than 100, then return false
    	if(this.foodCalorie > 1000 && this.foodPrice > 100)
    		return false;
    	// return true if all condition passes
    	return true;
    }
    // write add food data to file
    public void write_file()
    {
    	FileWriter fw = null; 
    	BufferedWriter bw = null; 
    	PrintWriter pw = null; 
    	try 
    	{ 
    		fw = new FileWriter(filename, true);
    		bw = new BufferedWriter(fw); 
    		pw = new PrintWriter(bw); 
    		pw.println(this.foodID+" "+this.foodName+" "+this.foodDescription+" "+this.foodPrice+" "+this.foodCalorie+" "+this.foodType);
    		pw.flush(); 
			pw.close(); 
			bw.close(); 
			fw.close(); 
    	} 
    	// If file write has error, throw exception
    	catch (java.io.IOException e) {
			System.out.println("write to file failed:" + e);
    	}
    }
    // To add food, check all criteria and write to file
    // If written to file successfully, return true, else return false
    public boolean AddFood()
    {
    	boolean result = checkCondition();
    	if(result)
    	{
    		write_file();
    		return true;
    	}
    	else
    		return false;
    }
    
    public boolean UpdateFood()
    {
    	// Check all conditions of add food before updating food
    	boolean result = checkCondition();
    	if(result)
    	{
    		int count = 0;
    		try 
    		{
    			// Read lines from file and update food details in file
    			Path path = Paths.get(filename);
    	        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
    	        for(String s: lines)
    			{
    				String[] word = s.split(" ");
    				if(word[0].equals(this.foodID))
    				{
    					int length = word.length-1;
    					// if new food calorie is different, details cannot be updated,then return false and cannot update
    					if(Integer.parseInt(word[length-2])!=this.foodCalorie)
    						return false;
    					// if food type is changed to kid food from a different food type, then return false and cannot update
    					if(this.foodType.equals("Kid Food") && !word[length-1].equals("Kid"))
    						return false;
    					// if price is food is updated by more than 10%, then return false and cannot update
    					if(this.foodPrice >Double.parseDouble(word[length-3])+(Double.parseDouble(word[length-3])*0.1))
    						return false;
    					// if all condition passes, write updated values to file and return true
    	    	        lines.set(count,this.foodID+" "+this.foodName+" "+this.foodDescription+" "+this.foodPrice+" "+this.foodCalorie+" "+this.foodType);
    	    	        Files.write(path, lines, StandardCharsets.UTF_8);
    					return true;
    				}
    				count += 1;
    			}
    		}
        	// If file read has error, throw exception
    		catch(java.io.IOException e)
    		{
    			System.out.println("Read file failed:" + e);
    		}	
    	}
    	return true;
    }

};
