package Practice;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenarios_1 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
	FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\Book1.xlsx");
	Workbook workbook =WorkbookFactory.create(fis);
    String value = workbook.getSheet("Contacts").getRow(1).getCell(2).toString();
    
    FileInputStream fiss= new FileInputStream(".\\\\src\\\\test\\\\resources\\\\CommonData.properties");
	Properties p =new Properties();
    p.load(fiss);
   String url = p.getProperty("url");
    String browser = p.getProperty("chrome");
   String password = p.getProperty("pW");
   String userName = p.getProperty("uN");
   
   //cross browser testing
   WebDriver driver= null;
   if (browser.equalsIgnoreCase("chrome")) {
	   driver= new ChromeDriver();	
}else if (browser.equalsIgnoreCase("firefox")) {
	driver= new FirefoxDriver();
}
    
    
    // Launch Browser
	
	driver.manage().window().maximize();
	driver.get(url);
	
	// Login details
	
	 driver.findElement(By.name("user_name")).sendKeys(userName);
	 driver.findElement(By.name("user_password")).sendKeys(password);
	 driver.findElement(By.id("submitButton")).click();
	 
	// click on contacts
	driver.findElement(By.linkText("Contacts")).click();
	
	// click on +
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	// Fill Mandatory field
	Random random = new Random();
	int ran = random.nextInt(1000);
	driver.findElement(By.name("lastname")).sendKeys("vinay"+ran);

	// save and verify
	driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
    String	text=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
	if (text.contains("vinay"+ran)) {
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
