package wsPagePkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Login Page
public class IgpLoginPg {
WebDriver driver;
	
	@FindBy(id = "img-black")   //Locate profile icon
	WebElement profileButn;
		
	@FindBy(id = "email")			//Locate user name field
	WebElement igpEmail;
	
	@FindBy(id = "passwd")			//Locate password field
	WebElement igpPwd;
	
	@FindBy(id = "row-submit")       //locate Sign up Button  
	WebElement signupButn;
	
	

	public IgpLoginPg(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);   //Initialize web elements
	}
	
	public void login() {
		profileButn.click();
		
	}
	
	public void setvalues(String iemail, String ipassword) {
		igpEmail.sendKeys(iemail);
		igpPwd.sendKeys(ipassword);
	}
	
	public void submit() {
		signupButn.click();
	}
	
}
