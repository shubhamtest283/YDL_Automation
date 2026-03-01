package seleniumtest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class adddata {

	public static void main(String[] args) {
        WebDriver driver = testdata.launchbrowser("https://www.yourdigitallift.com/fitness-center/login/");
        
        String[] cred = testdata.credentials();
        driver.findElement(By.xpath("//input[contains(@placeholder,'Mobile')]")).sendKeys(cred[0]);
        driver.findElement(By.xpath("//input[contains(@placeholder,'Password')]")).sendKeys(cred[1]);
        driver.findElement(By.xpath("//input[@type='submit' and @class='btn btn-default submit']")).click();
        
        List<String[]> members = testdata.getallmembersdata("C:\\Users\\patil\\OneDrive\\Desktop\\data uploads pug- Copy.xlsx");
        
        	 for(String[] member : members) {
         try {
           	  String firstname = member[0];
           	  String Lastname = member[1];
           	  String email = member[2];
           	  String phoneno = member[3];
           	  String gender = member[4];
           	  testdata.hover();  
           	  
//           	  System.out.print(firstname+ " ");
//           	  System.out.print(Lastname+ " ");
//           	  System.out.print(email+ " ");
//           	  System.out.print(phoneno+ " ");
//           	  System.out.print(gender);
//           	  System.out.println();
           	  
           	  driver.findElement(By.xpath("//input[contains(@placeholder,'First name')]")).sendKeys(firstname);
           	  driver.findElement(By.xpath("//input[contains(@placeholder,'Last name')]")).sendKeys(Lastname);
           	  driver.findElement(By.xpath("//input[contains(@placeholder,'e.g. abc@gmail.com')]")).sendKeys(email);
           	  driver.findElement(By.xpath("//input[contains(@placeholder,'e.g. 9876543210')]")).sendKeys(phoneno);
           	  
           	  if(gender.equalsIgnoreCase("Male")) {
               	  driver.findElement(By.xpath("//input[@type='radio' and @name='gender' and @value='male']")).click(); 
           	  }
           	  else if(gender.equalsIgnoreCase("Female")) {
               	  driver.findElement(By.xpath("//input[@type='radio' and @name='gender' and @value='female']")).click(); 
           	  }
           	  else {
           		  System.out.println("Unknown Gender Value");
           	  }
           	  testdata.scroll();
           	  
           	  driver.findElement(By.xpath("//input[@type='submit' and @name='customer_save' and @value='Save & Close']")).click();
                 
        }
        	  
        	 catch(Exception e) {
        		 System.out.println("Error filling form for " + member[0] + ": " + e.getMessage());
        		 
        	 }
        }
           
      driver.close();
	}

}
