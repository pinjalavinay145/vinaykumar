package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Scenario_3 {

	public static void main(String[] args) {
		
		// Launch Browser
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		
		// Login details
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		
		// click on Organizations
		driver.findElement(By.linkText("Contacts")).click();
		
		// click on +
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		// Fill Mandatory field
		driver.findElement(By.name("lastname")).sendKeys("vinay");
		
		//Select chemicals from dropdown
		WebElement ele = driver.findElement(By.cssSelector("[name=\"industry\"]"));
		Select se= new Select(ele);
		se.selectByValue("Chemicals");

		// save and verify
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
	    String	text=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		if (text.contains("vinay")) {
			System.out.println(text+"--passed");
		}
		else {
			System.out.println("XXXXX-----Failed-----XXXX");
		}
		
		// Logout
		Object logout = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
		Actions act = new Actions(driver);
		act.moveToElement((WebElement) logout).perform();
		
		// quit
		driver.quit();
	}

}
