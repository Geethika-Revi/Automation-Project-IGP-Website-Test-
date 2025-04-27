package wsPagePkg;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//Aim: To allow the user to select personalized birthday gifts for his/her girlfriend

//Home Page 
public class IgpHomePg {
	WebDriver driver;
	
	@FindBy(xpath = "//*[@id='selection-panel']/div[2]/a[4]")
	WebElement personalized;
	
	@FindBy(xpath = "//*[@id='site-wrapper']/div/div[2]/div/div/ul/li[1]/div[1]")     //Locate Occasions tab
	WebElement occasionDropDwn;
	
	@FindBy(xpath = "//*[@id=\"202722-items\"]/div/div/div/ul/li[1]/a/p")
	WebElement birthdayGiftsOption;
	
	@FindBy(xpath = "//*[@id='site-wrapper']/div/div[2]/div/div/ul/li[2]/div[1]")    //Locate SameDayDelivery tab
	WebElement sameDayDelvryButn;
	
	@FindBy(xpath = "//*[@id='207477-items']/div/div/div/ul/li[2]/a/p")
	WebElement giftsForHerButn;
	                    
	@FindBy(xpath = "//*[@id='site-wrapper']/div/div[2]/div/div/ul/li[3]/div[1]")    //Locate Recipients tab
	WebElement recepntButn;
	
	@FindBy(xpath = "//*[@id=\"202723-items\"]/div/div/div/ul/li[2]/a/p")
	WebElement forHerOptn;
	
	@FindBy(xpath = "//*[@id=\"site-wrapper\"]/div/div[2]/div/div/ul/li[4]/div[1]")
	WebElement photoGiftsOptn;
	
	@FindBy(xpath = "//*[@id=\"202717-items\"]/div/div/div/ul/li[2]/a/p")
	WebElement photoFrms;		
	
	//-----
	@FindBy(xpath = "//*[@id=\"site-wrapper\"]/div/div[2]/div/div/ul/li[5]/div[1]")
	WebElement nameGifts;
	
	@FindBy(xpath = "//*[@id=\"202718-items\"]/div/div/div/ul/li[1]/a/p")
	WebElement namePrint;
	
	
	
	@FindBy (xpath = "//*[@id='header']/div[1]/div[1]/section/div[1]/span")	 	//Locate location area to give pincode
	WebElement location;
	
	@FindBy (xpath = "//*[@id='pincode_city_field']")
	WebElement pincode;
	
	
    @FindBy(xpath = "//button[text()='Apply']")
	WebElement applyButn;
	       
	@FindBy(xpath = "//div[@class = 'image-holder']")    //Locate the product 
    List<WebElement> productList;
	
		
	//Constructor
		public IgpHomePg(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);   //Initialize web elements
		}
		
	//Method	
		public void persnlItem() {
			personalized.click();
			System.out.println("Personalized gifts option selected");
		}
		
		//public void optnSel(String occasn, String sdelvry, String recpnt) 
		public void optnSel() {
			occasionDropDwn.click();
			birthdayGiftsOption.click();
			
			sameDayDelvryButn.click();
			giftsForHerButn.click();
			
			recepntButn.click();
			forHerOptn.click();			
			
			photoGiftsOptn.click();
			photoFrms.click();
			
			nameGifts.click();
			namePrint.click();
			
			
		}
	
		public void locatnButn(String pin) {
			location.click();
			pincode.sendKeys(pin);
			
			//driver.switchTo().alert().accept();
		}
		
		
		public void sbmtButn() {
			applyButn.click();
			System.out.println("Delivery location pincode selected successfully");
			
		}
		
		public void prodctButn() {
			
			//Actions actions = new Actions(driver);
	        //actions.moveToElement(product).perform();
	        //	product.click();
			//
			
			if (!productList.isEmpty()) {
	            productList.get(0).click();
	            System.out.println("Product selected successfully");
		    }
			else
			{
				System.out.println("Product not found");
			}
		}
	

}
