package wsPagePkg;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Cart Page
public class IgpCartPg {

	WebDriver driver;
	
	
	@FindBy(xpath = "//*[@id='add-cart']/span")
	WebElement addToCart;
	
	@FindBy(xpath= "//*[@id='add-cart']")
	WebElement continueWoAddOn;
	
	@FindBy(id = "enabled-button")
	WebElement checkOut;
	
	@FindBy(xpath = "//*[@id=\"user-menu\"]/div")
	WebElement profileButn;
	
	@FindBy(xpath = "//*[@id=\"acc-menu\"]/a/span")
	WebElement signOut;
			
	
	//Constructor
	public IgpCartPg(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);   //Initialize web elements
	}
	
	//Method
	public void cart() throws Exception {
		addToCart.click();
		Thread.sleep(1000);
		
		continueWoAddOn.click();
		checkOut.click();
	}
	
	public void loginDisplay() throws Exception
	{
		
		//To take screenshot in a location in the computer
		File screenst = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//casting the driver object to the TakesScreenshot interface to take screenshot
		
		FileHandler.copy(screenst,  new File("C://Users//geeth//OneDrive//Desktop//Selenium_Works//IgpWebsiteTestData//ScrnshotImg.png"));
		//FileHandler is used to copy/save files
		
		System.out.println("Screenshot saved successfully");
				
	}
	
	public void logOut()
	{
		driver.navigate().back();
		profileButn.click();
		signOut.click();
		System.out.println("Logged Out Successfully");
	}
}
