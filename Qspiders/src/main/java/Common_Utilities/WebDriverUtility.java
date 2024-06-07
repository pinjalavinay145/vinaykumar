package Common_Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	/**
	 * this method will maximize the window
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * this method will minimize the window
	 * 
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * this method woill wait untill all web elements gets loaded
	 * 
	 * @param driver
	 */
	public void waitTillElementsToGetLoaded(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
	}

	/**
	 * this method will wait until element is clicable
	 * 
	 * @param driver
	 * @param element
	 */
	public void elementToBeClicable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * this method willl wait untill element is visible
	 * 
	 * @param driver
	 * @param element
	 */

	public void visiblityOfElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * to double click on random variable
	 * 
	 * @param driver
	 */
	public void toDoubleClick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}

	/**
	 * to double click on particular variable
	 * 
	 * @param driver
	 */
	public void toDoubleClickOnWebelement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	/**
	 * to right click on particular variable
	 * 
	 * @param driver
	 */
	public void toRightClickonWebelement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	/**
	 * to right click on random variable
	 * 
	 * @param driver
	 */
	public void toRightClick(WebDriver driver) {
		Actions act = new Actions(driver);
		act.contextClick().perform();

	}

	/**
	 * to double click on random variable
	 * 
	 * @param driver
	 */
	public void toClickandhold(WebDriver driver) {
		Actions act = new Actions(driver);
		act.clickAndHold().perform();
		act.release().perform();
	}

	public void todraganddrop(WebDriver driver) {
		Actions act = new Actions(driver);
		act.dragAndDrop(null, null).perform();
		;
	}

	public void tomovetoelement(WebDriver driver, WebElement elemnet) {
		Actions act = new Actions(driver);
		act.moveToElement(elemnet).perform();

	}

	public void toHandleFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * this method will switch to frame based on index
	 * 
	 * @param driver
	 */
	public void toHandleFramewithIndex(WebDriver driver) {
		driver.switchTo().frame(0);
	}

	/**
	 * this method will switch to frame element
	 * 
	 * @param driver
	 * @param element
	 */
	public void toHandleFramewithElemnt(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	/**
	 * this method will switch back to parent frame
	 * 
	 * @param driver
	 */
	public void toSwitchBackFromFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	/**
	 * this method will switch back to main page
	 * 
	 * @param driver
	 */
	public void toSwitchBacktoMainPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	/**
	 * this method will switch to alert
	 * 
	 * @param driver
	 */
	public void toSwitchToAlert(WebDriver driver) {
		driver.switchTo().alert();
	}

	/***
	 * this method will switch to alert and will send key values
	 * 
	 * @param driver
	 */
	public void toSwitchToAlertandSendingvalues(WebDriver driver) {
		driver.switchTo().alert().sendKeys(null);
	}

	/**
	 * this method will switch to alert and and will print text
	 * 
	 * @param driver
	 */
	public void toSwitchToAlertandprintingtext(WebDriver driver) {
		String value = driver.switchTo().alert().getText();
		System.out.println(value);
	}

	/**
	 * this method will switch driver control to alert and click dismiss
	 * 
	 * @param driver
	 */
	public void todismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * this method will switch driver control to alert and click on accept
	 * 
	 * @param driver
	 */
	public void toAcceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void toSwitchWindow(WebDriver driver) {
		String currentId = driver.getWindowHandle();
		Set<String> allIi = driver.getWindowHandles();
		for (String id : allIi) {
			if (!(currentId.equals(allIi))) {
				driver.switchTo().window(currentId);

			}

		}

	}

	public void takescreenShot(WebDriver driver, String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(".\\ErrorsShot" + name + ".png");

		org.openqa.selenium.io.FileHandler.copy(source, destination);
	}

}
