package Vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
	
	public Home_Page(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(linkText="Organizations")
    private WebElement organizationLink;
	
	
	@FindBy(xpath="//img[@title=\"Create Organization...\"]")
    private WebElement createOrganizationLink;
	
	 @FindBy(name="accountname")
	    private WebElement organizationNameField;

	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getCreateOrganizationLink() {
		return createOrganizationLink;
	}
	
   

	public WebElement getOrganizationNameField() {
		return organizationNameField;
	}
	
	
	 @FindBy(className ="crmbutton small save")
    private WebElement saveButton;

	public WebElement getSaveButton() {
		return saveButton;
	}
	
}
