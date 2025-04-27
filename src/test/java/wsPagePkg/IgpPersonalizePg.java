package wsPagePkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Personalization Page
public class IgpPersonalizePg {
	WebDriver driver;
	
	
	@FindBy(xpath = "//*[@id='personalize-revamp']/span")  //Locate Personalize button
	WebElement personalizeOptn;
	
	@FindBy(xpath = "//*[@id='steps-container-27655-0']/div/div[1]/div/div[1]/div/div[2]/div/div/div[1]/input")
	WebElement enterTxtBox;	
	
	@FindBy(xpath = "//*[@id=\"steps-container-27655-0\"]/div/div[1]/div/div[1]/div/div[2]/div/div/div[1]/button[2]")
	WebElement saveOptn;	
	
	@FindBy(xpath = "//*[@id=\"steps-container-27655-0\"]/div/div[2]/div/div/a")  //Locate save and review button
	WebElement saveReviewOptn;

	
	
	//Constructor
	public IgpPersonalizePg(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);   //Initialize web elements
	}
	
	
	
	//Method
	public void perslzd() throws Exception
	{
		personalizeOptn.click();
		enterTxtBox.sendKeys("Anjali");
		saveOptn.click();
		Thread.sleep(3000);
		
		saveReviewOptn.click();
		System.out.println("Personalization saved successfully");
		
	}
}


		
		
		
