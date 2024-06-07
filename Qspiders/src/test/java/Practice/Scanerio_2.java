package Practice;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scanerio_2 {

	public static void main(String[] args) {
	
		// Launch Browser
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		
		// Login details
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		
		// Navigate to organization link
		driver.findElement(By.linkText("Organizations")).click();
		
		// click on create organization look up image
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		// Fill Mandatory field
		Random random = new Random();
		int r=random.nextInt();
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys("vinay2"+r);

		// save and verify
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
	    String	text=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		if (text.contains("vinay2"+r)) {
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
